package com.example.geektrust.utitlity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {

    private final String filePath;

    public ReadFile(String filePath) {
        this.filePath = filePath;
    }


    public Map<String, String> getTrainOrder() {
        Map<String, String> bogieOrder = new HashMap<>();
        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] train = line.trim().split("ENGINE");
                bogieOrder.put(train[0].trim(), train[1].trim());
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bogieOrder;
    }


}

