package com.affinipay.codingassessment;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DateCalculator {

    String result = null;
    int calculatedMins = 0;
    int calculatedHours = 0;
    String formattedMins = null;
    String formattedHours = null;

    public String addMinutes(String time, int minutes) {

        String dateFormatRegex = "\\b((1[0-2]|0?[1-9]):([0-5][0-9]) ([AaPp][Mm]))";
        final Pattern pattern = Pattern.compile(dateFormatRegex);
        if (pattern.matcher(time).matches()){
            String[] tokens = time.split(":|\\ ");
            int hours = Integer.parseInt(tokens[0]);
            int mins = Integer.parseInt(tokens[1]);
            String meridianIndicator = tokens[2];
            int maxMins = mins + minutes;
            if(maxMins < 60){
                if(maxMins<0){
                    Map map = addTime(maxMins,60 );
                    hours = hours + (int) map.get("Hour") - 1;
                    Map hourMap = addTime(hours,12);
                    calculatedHours = (int) hourMap.get("Mins");
                    if (calculatedHours < 0) {
                        calculatedHours = 12 + calculatedHours;
                        meridianIndicator = getMeridianValue(meridianIndicator);
                    }
                    if((int) hourMap.get("Hour") % 2 != 0){
                        meridianIndicator = getMeridianValue(meridianIndicator);
                    }
                    if(Integer.parseInt(tokens[0]) ==12 && maxMins >-600) {
                        meridianIndicator = getMeridianValue(meridianIndicator);
                    }
                    calculatedMins = (60 + (int)(map.get("Mins")));
                    if(calculatedMins == 60){
                        calculatedHours = ++calculatedHours;
                        calculatedMins = 0;
                    }
                    formattedHours = String.format("%02d", calculatedHours);
                    formattedMins = String.format("%02d", calculatedMins);
                    result = formattedHours + ":" + formattedMins + " " + meridianIndicator;
                } else {
                    formattedHours = String.format("%02d", hours);
                    formattedMins = String.format("%02d", maxMins);
                    result = formattedHours + ":" + formattedMins + " " + meridianIndicator;
                }
            } else{
                Map map = addTime(maxMins,60 );
                hours = hours + (int) map.get("Hour");
                formattedMins = String.format("%02d", (int) map.get("Mins"));
                Map hourMap = addTime(hours,12);
                calculatedHours = (int) hourMap.get("Mins");
                formattedHours = String.format("%02d", calculatedHours);
                if(formattedHours.equalsIgnoreCase("00")){
                    formattedHours = "12";
                }
                if(Integer.parseInt(tokens[0]) !=12){
                    if((int)hourMap.get("Hour")%2 != 0) {
                        meridianIndicator = getMeridianValue(meridianIndicator);
                    }
                } else {
                    if((int)hourMap.get("Hour")%2 == 0) {
                        meridianIndicator = getMeridianValue(meridianIndicator);
                    }
                }
            }
            return result = formattedHours + ":" + formattedMins + " " + meridianIndicator;
        } else {
            throw new IllegalArgumentException("Invalid Time Format");
        }
    }

    private Map addTime(int minutes, int i) {
        Map map = new HashMap();
        int hour = minutes / i;
        int remainingMins = minutes % i;
        map.put("Hour", hour);
        map.put("Mins", remainingMins);
        return map;
    }

    private String getMeridianValue(String meridianValue){
        if(meridianValue.equalsIgnoreCase("AM")){
            meridianValue = "PM";
        } else {
            meridianValue = "AM";
        }
        return meridianValue;
    }

}
