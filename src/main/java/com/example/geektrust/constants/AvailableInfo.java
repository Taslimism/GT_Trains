package com.example.geektrust.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AvailableInfo {
    public static final int distOfHybFromSourceA = 1200;
    public static final int distOfHybFromSourceB = 2000;
    private static final List<String> stationCodesForTrainA = List.of("CHN", "SLM", "BLR", "KRN", "HYB", "NGP", "ITJ", "BPL", "AGA", "NDL", "PTA", "NJP", "GHY");
    private static final List<Integer> distanceFromSourceForTrainA = List.of(0, 350, 550, 900, 1200, 1600, 1900, 2000, 2500, 2700, 3000, 3400, 3900);
    private static final List<String> stationCodesForTrainB = List.of("TVC", "SRR", "MAQ", "MAO", "PNE", "HYB", "NGP", "ITJ", "BPL", "AGA", "NDL", "PTA", "NJP", "GHY");
    private static final List<Integer> distanceFromSourceForTrainB = List.of(0, 300, 600, 1000, 1400, 2000, 2400, 2700, 2800, 3300, 3500, 3800, 4200, 4700);
    public static Set<String> stationsTillHYDForTrainA = Set.of("CHN", "SLM", "BLR", "KRN");
    public static Set<String> stationsTillHYDForTrainB = Set.of("TVC", "SRR", "MAQ", "MAO", "PNE");

    public static Map<String, Integer> getSCToDistMapForTrainA() {
        return getSCToDistMap(stationCodesForTrainA, distanceFromSourceForTrainA);
    }

    public static Map<String, Integer> getSCToDistMapForTrainB() {
        return getSCToDistMap(stationCodesForTrainB, distanceFromSourceForTrainB);
    }

    private static Map<String, Integer> getSCToDistMap(List<String> stationCodes, List<Integer> distanceFromSource) {
        Map<String, Integer> stationCodeToDistanceFromSource = new HashMap<>();
        for (int i = 0; i < stationCodes.size(); i++) {
            String stationCode = stationCodes.get(i);
            Integer dist = distanceFromSource.get(i);
            stationCodeToDistanceFromSource.put(stationCode, dist);
        }
        return stationCodeToDistanceFromSource;
    }


}
