/*
 *  Assignment 7
 *  Description: develop and implement an Inventory Management Program for the Gator Bookstore.
 *  Name: Shauhin Pourshayegan
 *  ID: 920447681
 *  Class: CSC 210-3
 *  Semester: Spring 2019
 */
import java.awt.datatransfer.DataFlavor;
import java.util.Arrays;
import java.util.Scanner;
public class GatorBookstore {
    public static void main (String [] args){
        //Assigning/initializing scanner with name input
        Scanner input = new Scanner(System.in);

        //PART ONE:
        //Assigning/initializing String array with the inventory items
        String[] items = {"notepad","pen","pencil","eraser","marker"};
        //Assigning/initializing int array to have 5 elements
        int[] quantity = new int[5];
        //Request user input
        System.out.println("Please enter the quantities for the items in inventory.");
        //For loop allows the assignment of each element value
        for(int i = 0; i < quantity.length; i++){
            //Assigning temporary input variable
            int x;
            do {
                //Requests specific item's quantity
                System.out.println("Please enter the quantity of " + items[i] + "s:");
                x = input.nextInt();
                if (x>=0) {
                    quantity[i] = x;
                } else {
                    System.out.println("Please enter a value of 0 or greater.");
                }
            } while (x < 0);
        }
        double[] price = new double[5];
        //Request user input
        System.out.println("Please enter the prices for the items in inventory.");
        //For loop allows the assignment of each element value
        for(int i = 0; i < price.length; i++){
            //Assigning temporary input variable
            int x;
            do {
                //Requests specific item's price
                System.out.println("Please enter the price for a " + items[i] + ":");
                x = input.nextInt();
                if (x>=0) {
                    price[i] = x;
                } else {
                    System.out.println("Please enter a value of 0 or greater.");
                }
            } while (x < 0);
        }

        //PART TWO
        String operation = "t";
        while (!operation.equals("e")){
            System.out.println();
            System.out.println("Please enter the operation you would like to perform.");
            System.out.println("Enter: p to Print Inventory, c to Check for Low Inventory, h for Highest/Lowest Value Inventory Items, v for Total Inventory Value or e to Exit");
            operation = input.nextLine();

            //double multiplies the item's quantity and price to find it's total value
            double[] totalVal = new double[5];
            for (int i = 0; i < items.length; i++) {
                totalVal[i] = quantity[i] * price[i];
            }

            switch (operation) {
                case "p":
                    //Print inventory
                    System.out.println("Item, Quantity, Price, Total Inventory Value");
                    for (int i = 0; i < items.length; i++){
                        //double multiplies the item's quantity and price to find it's total value
                        //string concatenation of all of the values for each array
                        System.out.println(items[i] + ", " + quantity[i] + ", $" + price[i] + ", $" + totalVal[i]);
                    }
                    break;
                case "c":
                    //Check for low inventory
                    for (int i = 0; i < items.length; i++){
                        if (quantity[i] < 5){
                            System.out.println("Item: " + items[i] + " Units: " + quantity[i]);
                        }
                    }
                    //default to make this statement in both cases of there being or not being low inventory
                    System.out.println("No more low inventory.");
                    break;
                case "h":
                    // Highest/Lowest Inventory Items
                    System.out.println("Item, Quantity, Price, Total Inventory Value");
                    int maxVal = 0, minVal = 0;
                    for (int i = 1; i < items.length; i++){
                        //this loop sets a maximum value and checks for higher values for each iteration.
                        if (totalVal[i] > totalVal[i-1] ) maxVal = i;
                        if(i == items.length - 1){
                            System.out.println("Highest inventory: " + items[maxVal] + ", " + quantity[maxVal] + ", $" + price[maxVal] + ", $" + totalVal[maxVal]);
                        }
                    }

                    for (int i = 1; i < items.length; i++){
                        //this loop sets a minimum value and checks for lower values for each iteration.
                        if (totalVal[i] < totalVal[i-1] ){
                            minVal = i;
                        }
                        if(i == items.length - 1){
                            System.out.println("Lowest inventory: " + items[minVal] + ", " + quantity[minVal] + ", $" + price[minVal] + ", $" + totalVal[minVal]);
                        }
                    }
                    break;
                case "v":
                    //Total Inventory Value
                    System.out.println("Grand total inventory value: $" + Arrays.stream(totalVal).sum());
                    break;
                case "e":
                    //Exit program
                    /* no code needed here, because next iteration "e" will trigger
                        loop termination,causing the program to end */
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }
}
