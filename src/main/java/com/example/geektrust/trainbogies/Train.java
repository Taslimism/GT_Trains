package com.example.geektrust.trainbogies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Train {
    private List<Bogie> train;

    public Train() {
    }

    public List<Bogie> getTrain() {
        return train;
    }

    public void setTrain(List<Bogie> train) {
        this.train = train;
    }

    public Train(List<Bogie> bogies) {
        train = bogies;
    }

    public StringBuilder getOrderOfArrivalAtHYD(String bogieOrder, Set<String> bogiesUptoHyd, String train) {
        StringBuilder bogieOrderOfArrival = new StringBuilder("ARRIVAL " + train + " ENGINE ");
        String[] bogieOrderArray = bogieOrder.split(" ");
        for (String bogie : bogieOrderArray) {
            if (!bogiesUptoHyd.contains(bogie.trim())) {
                bogieOrderOfArrival.append(bogie).append(" ");
            }
        }
        return bogieOrderOfArrival;
    }


    public Train buildTrainFromBogieInfo(String bogieOrder, Map<String, Integer> stationCodeToDistanceMap, int distOfHybFromSource) {
        String[] stationCodeArray = bogieOrder.split(" ");

        List<Bogie> bogieList = new ArrayList<>();
        for (String stationCode : stationCodeArray) {
            if (stationCodeToDistanceMap.containsKey(stationCode)) {
                int distFromSource = stationCodeToDistanceMap.get(stationCode);
                int relativeDistFromHyd = distFromSource - distOfHybFromSource;
                Bogie bogie = new Bogie(stationCode, distFromSource, relativeDistFromHyd);
                bogieList.add(bogie);
            }
        }

        return new Train(bogieList);

    }

    public String getDepartureOrderForCombinedTrain(Train trainA, Train trainB) {
        List<Bogie> departureTrain = new ArrayList<>();
        if (trainA.getTrain() != null && trainB.getTrain() != null) {
            departureTrain = trainA.getTrain();
            departureTrain.addAll(trainB.getTrain());
        } else if (trainA.getTrain() != null) {
            departureTrain = trainA.getTrain();
        } else if (trainB.getTrain() != null) {
            departureTrain = trainB.getTrain();
        }
        departureTrain.sort((a, b) -> b.getRelativeDistFromHyd() - a.getRelativeDistFromHyd());

        StringBuilder departureOrder = new StringBuilder("TRAIN_AB ENGINE ENGINE ");
        for (Bogie bogie : departureTrain) {
            if (bogie.getStationCode().equals("HYB")) {
                continue;
            }
            departureOrder.append(bogie.getStationCode()).append(" ");
        }

        return departureOrder.toString();
    }

    public String getBogieOrderAfterRemovingEngine(String bogieOrder) {
        String[] bogiesArray = bogieOrder.split("ENGINE ");
        if (bogiesArray.length > 1) {
            return bogiesArray[1];
        } else {
            return "";
        }
    }
}
