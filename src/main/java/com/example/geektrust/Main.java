package com.example.geektrust;

import com.example.geektrust.constants.AvailableInfo;
import com.example.geektrust.trainbogies.Train;
import com.example.geektrust.utitlity.ReadFile;

import java.util.Map;
import java.util.Set;

import static com.example.geektrust.constants.AvailableInfo.*;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        ReadFile readFile = new ReadFile(filePath);
        Map<String, String> bogieOrders = readFile.getTrainOrder();
        String bogieOrderForTrainA = bogieOrders.get("TRAIN_A");
        String bogieOrderForTrainB = bogieOrders.get("TRAIN_B");

        Set<String> bogiesUptoHydForTrainA = stationsTillHYDForTrainA;
        Set<String> bogiesUptoHydForTrainB = stationsTillHYDForTrainB;

        Map<String, Integer> stationCodeToDistanceMapForTrainA = getSCToDistMapForTrainA();
        Map<String, Integer> stationCodeToDistanceMapForTrainB = getSCToDistMapForTrainB();

        Train train = new Train();

        String arrivalOrderTrainA = train.getOrderOfArrivalAtHYD(bogieOrderForTrainA, bogiesUptoHydForTrainA, "TRAIN_A").toString();
        System.out.println(arrivalOrderTrainA);
        String arrivalOrderTrainB = train.getOrderOfArrivalAtHYD(bogieOrderForTrainB, bogiesUptoHydForTrainB, "TRAIN_B").toString();
        System.out.println(arrivalOrderTrainB);


        if (arrivalOrderTrainA.trim().length() == 0 && arrivalOrderTrainB.trim().length() == 0) {
            System.out.println("JOURNEY_ENDED");
            return;
        }

        int distOfHybFromSourceA = AvailableInfo.distOfHybFromSourceA;
        int distOfHybFromSourceB = AvailableInfo.distOfHybFromSourceB;

        String arrivalOrderOfBogiesA = train.getBogieOrderAfterRemovingEngine(arrivalOrderTrainA);
        String arrivalOrderOfBogiesB = train.getBogieOrderAfterRemovingEngine(arrivalOrderTrainB);

        Train trainA = train.buildTrainFromBogieInfo(arrivalOrderOfBogiesA, stationCodeToDistanceMapForTrainA, distOfHybFromSourceA);
        Train trainB = train.buildTrainFromBogieInfo(arrivalOrderOfBogiesB, stationCodeToDistanceMapForTrainB, distOfHybFromSourceB);

        String departureOrderForCombinedTrains = trainA.getDepartureOrderForCombinedTrain(trainA, trainB);
        System.out.println("DEPARTURE " + departureOrderForCombinedTrains);

    }


}
