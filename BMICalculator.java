/*
Assignment 4
Description:A program that can calculate BMI based on user inputs
Name: Shauhin Pourshayegan
ID: 920411681
Class: CSC 210-03
Semester: Spring 2020
*/

//importing scanner utility
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args){
        //Creating Scanner
        Scanner input = new Scanner(System.in);

        //Request user's first name
        System.out.println("Please input your first name.");
        //store first name as variable
        String firstName = input.nextLine();
        //Request user's last name
        System.out.println("Please input your last name.");
        //store last name as variable
        String lastName = input.nextLine();

        //Request user's height in feet
        System.out.println("Please input your height in whole feet only");
        //store feet and inches of user's height as 2 distinct variables
        int feet = input.nextInt();
        //Request user's height in inches
        System.out.println("Please input the remaining whole inches of your height.");
        int inches = input.nextInt();

        //Request user's weight
        System.out.println("Please input your weight in pounds.");
        //store weight as variable
        double weight = input.nextDouble();

        //totaling height as inches to make later steps easier
        int totalInches = (12*feet)+inches;

        //calculating bmi as a double
        double bmi = (703*weight)/(totalInches*totalInches);
        //rounding bmi
        double roundedBMI = Math.round(bmi * 100.0) / 100.0;

        //printing name, height, weight & BMI
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Height: " + feet + "ft," + inches + "in = " + totalInches + "in");
        System.out.println("Weight: " + weight + "Lbs");
        System.out.println("BMI: " + roundedBMI);

        //create the string for BMI category output
        String bmiCategory;

        //decide which category BMI falls under
        if(roundedBMI <= 18.5){
            bmiCategory = ("Underweight");
        } else if (roundedBMI <= 24.9){
            bmiCategory = ("Average Weight");
        }else if (roundedBMI < 30){
            bmiCategory = ("Overweight");
        }else {
            bmiCategory = ("Obesity");
        }

        //printing user's BMI category
        System.out.println();
        System.out.println("Your BMI category is " + bmiCategory + ".");
        System.out.println();

        //printing reference table of BMI categories
        System.out.println("BMI Categories: ");
        System.out.println("Underweight <= 18.5 ");
        System.out.println("Normal Weight = 18.5 to 24.9 ");
        System.out.println("Overweight = 25 to 29.9 ");
        System.out.println("Obesity = 30 or greater ");

    }
}
