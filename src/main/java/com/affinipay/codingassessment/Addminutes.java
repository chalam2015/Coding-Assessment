package com.affinipay.codingassessment;

import java.util.Scanner;

public class Addminutes {

    public static void main(String[] args) {

        DateCalculator dateCalculator = new DateCalculator();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a 12-hour time string (HH:MM AM/PM) : ");
        String time = input.nextLine();
        System.out.print("Enter signed integer for minutes : ");
        int minutes = input.nextInt();

        String result = dateCalculator.addMinutes(time,minutes);
        System.out.println("Time is " + result);
    }



}
