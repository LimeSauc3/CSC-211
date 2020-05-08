/*
Assignment 5
Description: Program provides basic functions of simple ATM interface for the Bank of Gators.
Name: Shauhin Pourshayegan
ID: 920411681
Class: CSC 210-03
Semester: Spring 2020
*/

//import scanner utility
import java.util.Scanner;

public class GatorATMSwitch {

    public static void main(String[] args){
        //Assign/initialize scanner called input
        Scanner input = new Scanner(System.in);

        //Assign/initialize double variables for both starting account balances.
        double checkingBal = 500;
        double savingsBal = 1000;

        //Assign variables to be used as the counter and if conditional
        String account, y;
        do {
            //instruct user to enter account type
            System.out.println("Enter the account that you would like to access.");
            System.out.println("For Savings enter S and for Checking enter C");
            do {
                account = input.nextLine();
                if (account.equals("S")) {
                    //enter savings method
                    savingsBal = savings(savingsBal);
                    System.out.println("Your Savings balance is $" +savingsBal);
                } else if (account.equals("C")) {
                    checkingBal = checking(checkingBal);
                    System.out.println("Your Checking balance is $" +checkingBal);
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } while (!account.equals("S") && !account.equals("C"));
            //Loop allows user to do another transaction or restart if they reached the minimum balance
            System.out.println("For another transaction, input Y. Otherwise input nothing.");
            y = input.nextLine();
        } while ( y.equals("Y"));

    }

    public static double savings(double savingsBal){
        //Assign/initialize scanner called input that's only used in this method
        Scanner input = new Scanner(System.in);


        System.out.println("Enter the type of transaction you would like to perform.");
        System.out.println("For Check Balance enter c, for Deposit enter d, for Withdrawal enter w");
        String transaction;
        double userInput;
        do{
            transaction = input.nextLine();
            switch (transaction) {
                case "c":
                    //balance is displayed regardless, so nothing has to happen here
                    break;
                case "d":
                    System.out.println("Please input the amount you would like to deposit in dollars.");
                    savingsBal += (Math.round(input.nextDouble() * 100.0) / 100.0);
                    break;
                case "w":
                    System.out.println("Please input the amount you would like to withdraw in dollars.");
                    userInput = (Math.round(input.nextDouble() * 100.0) / 100.0);
                    savingsBal -= userInput;
                    //if statement to check if the balance is at or above minimum
                    if (savingsBal < 100) {
                        System.out.println("The minimum balance is $100 for Savings. The imputed amount causes the balance to drop below $100. Please try again.");
                        savingsBal += userInput;
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while(!transaction.equals("c") && !transaction.equals("d") && !transaction.equals("w"));
        return savingsBal;
    }

    public static double checking(double checkingBal){
        //Assign/initialize scanner called input that's only used in this method
        Scanner input = new Scanner(System.in);


        System.out.println("Enter the type of transaction you would like to perform.");
        System.out.println("For Check Balance enter c, for Deposit enter d, for Withdrawal enter w");
        String transaction;
        double userInput;

        do{
            transaction = input.nextLine();
            switch (transaction) {
                case "c":
                    //balance is displayed regardless, so nothing has to happen here
                    break;
                case "d":
                    System.out.println("Please input the amount you would like to deposit in dollars.");
                    checkingBal += (Math.round(input.nextDouble() * 100.0) / 100.0);
                    break;
                case "w":
                    System.out.println("Please input the amount you would like to withdraw in dollars.");
                    userInput = (Math.round(input.nextDouble() * 100.0) / 100.0);
                    checkingBal -= userInput;
                    //if statement to check if the balance is at or above minimum
                    if (checkingBal < 10) {
                        System.out.println("The minimum balance is $10 for checking. The imputed amount causes the balance to drop below $10. Please try again.");
                        checkingBal += userInput;
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while(!transaction.equals("c") && !transaction.equals("d") && !transaction.equals("w"));
        return checkingBal;
    }
}
