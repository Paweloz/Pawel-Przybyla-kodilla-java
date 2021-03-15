package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double averageTemp(){
        double sum=0;

        for(Map.Entry<String,Double> entry : temperatures.getTemperatures().entrySet()){
            sum += entry.getValue();
        }
        return sum/temperatures.getTemperatures().size();
    }

    public double medianTemp(){
        Double[] temps = temperatures.getTemperatures().values().toArray(new Double[0]);
        double median;
        Arrays.sort(temps);
        if(temps.length%2 == 1){
            median = temps[temps.length/2];
        }else{
            median = (temps[temps.length/2-1]+temps[temps.length/2])/2;
        }
        return median;
    }
}