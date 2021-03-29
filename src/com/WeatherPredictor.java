package com;

import javax.swing.*;
import java.util.ArrayList;


/**
 * Represents a weather predictor
 * @author Kriti - C0776212
 *
 */
public class WeatherPredictor {
    int temperature;
    Day day;
    int windSpeed;
    int feelsLikeTemperature;
    static ArrayList<Integer> dayWindSpeedRecords;

    // initializes default wind speed records based on a day
    static{
        dayWindSpeedRecords = new ArrayList<Integer>();
        dayWindSpeedRecords.add(Day.SUNDAY.getIndex(),23);
        dayWindSpeedRecords.add(Day.MONDAY.getIndex(),15);
        dayWindSpeedRecords.add(Day.TUESDAY.getIndex(),20);
        dayWindSpeedRecords.add(Day.WEDNESDAY.getIndex(),10);
        dayWindSpeedRecords.add(Day.THURSDAY.getIndex(),17);
        dayWindSpeedRecords.add(Day.FRIDAY.getIndex(),11);
        dayWindSpeedRecords.add(Day.SATURDAY.getIndex(), 21);
    }

    /**
     * Initializes WeatherPredictor class with temperature and day.
     * Sets windspeed based on temperature and day values from dayWindSpeedRecords.
     * @param temperature
     * @param day
     */
    public WeatherPredictor(int temperature, Day day){
        this.temperature = temperature;
        this.day = day;
        this.windSpeed = dayWindSpeedRecords.get(this.day.getIndex());
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(int feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    /**
     * Calculates feels like temperature based on windspeed and current temperature.
     */
    public void calculateFeelsLikeTemperature(){
        this.feelsLikeTemperature = (int)Math.round(35.74 + 0.6215 * this.temperature
                - 35.75 * Math.pow(this.windSpeed,0.16) + 0.4275 * this.temperature
                * Math.pow(this.windSpeed,0.16));
    }


    /**
     * Displays day of the week, windspeed in mph, temperature in F and Feels like temperature in F.
     * Uses various methods of StringBuilder class to display the message.
     */
    public void displayTemperature(){
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("Day: \nWind Speed: mph\nTemperature: \u00B0F\nFeels Like Temperature: \u00B0F");
        sbuilder.insert(sbuilder.indexOf("Day")+5,this.day.toString().toLowerCase());
        sbuilder.setCharAt(sbuilder.indexOf(" ")+1, Character.toUpperCase(sbuilder.charAt(sbuilder.indexOf(" ")+1)));
        sbuilder.insert(sbuilder.indexOf("Temperature")+"Temperature: ".length(),this.temperature);
        sbuilder.insert(sbuilder.lastIndexOf("Temperature")+"Temperature: ".length(),this.feelsLikeTemperature);
        sbuilder.insert(sbuilder.indexOf("Speed")+"Speed: ".length(),this.windSpeed);
        JOptionPane.showMessageDialog(null, sbuilder);
    }
}
