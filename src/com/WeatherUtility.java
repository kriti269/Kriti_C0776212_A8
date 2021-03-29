package com;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a utility class for weather predictor with main function.
 * @author Kriti - C0776212
 */
public class WeatherUtility {

    public static void main(String[] args){
        String inputDay = "";
        String welcomeMessage = "";

        //using wrapper class Float
        Float temperature = 0f;
        ArrayList<String> daysOfWeek = new ArrayList<String>(Arrays.asList("MONDAY",
                "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"));

        //set welcomeMessage using various string methods
        welcomeMessage = welcomeMessage.concat("Welcome to Weather Predictor!");
        String substringMessage = welcomeMessage.substring(welcomeMessage.indexOf("t"),welcomeMessage.indexOf("t")+2);
        welcomeMessage = welcomeMessage.concat("\nIt's a beautiful day "+substringMessage+"day!");

        // display welcome message
        JOptionPane.showMessageDialog(null, welcomeMessage);

        // get input day from user
        do{
            inputDay = JOptionPane.showInputDialog("Please enter the day of the week!");
        }while (inputDay==null||daysOfWeek.indexOf(inputDay.toUpperCase())==-1);

        //get temperature of the day from user
        do{
            try{
                temperature = Float.parseFloat(JOptionPane.showInputDialog("Please enter today's temperature in F"));
            }
            catch (Exception ex){
                temperature = null;
            }

        }while (temperature==null || temperature<-40 || temperature>104);

        // set input day and temperature, calculate and display feels like temperature.
        WeatherPredictor predictor = new WeatherPredictor((Integer) Math.round(temperature), Day.valueOf(inputDay.toUpperCase()));
        predictor.calculateFeelsLikeTemperature();
        predictor.displayTemperature();

    }
}
