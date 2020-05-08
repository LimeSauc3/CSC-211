/*
 *  Assignment 6
 *  Description: develop and implement a routing algorithm for the elevator system in Gator Hall
 *  Name: Shauhin Pourshayegan
 *  ID: 920447681
 *  Class: CSC 210-3
 *  Semester: Spring 2019
 */

//import scanner utility
import java.util.Scanner;
public class GatorHallElevators {
    public static void main(String[] args){
        //assigning/initializing scanner
        Scanner input = new Scanner(System.in);



        //PART 1
        //creating array for each elevator's number and initial position
        int [] el = new int [4];
        //elevator 1 starting at floor 1
        el[0]=1;
        //elevator 2 starting at floor 3
        el[1]=3;
        //elevator 3 starting at floor 5
        el[2]=5;
        //elevator 4 starting at floor 9
        el[3]=9;


        //loop completes PART 6
        while(1 == 1){
            //PART 2
            System.out.println("Please input the floor you would like to board the elevator at.");
            int board;
            do {
                board = input.nextInt();
                if ((board >= 1) && (board <= 9)){
                    System.out.println("You board the elevator at valid floor " + board);
                    break;
                } else {
                    System.out.println("Please input a valid floor number from floors 1-9.");
                }
            } while (!((board >= 1) && (board <= 9)));



            //PART 3
            //creating an absolute value difference from the boarding floor to the elevator 1
            int dif = Math.abs(el[0] - board);
            //arrele is any array element for the el array element closest to board and it's initialized to 0
            int arrele = 0;
            for(int i = 1; i < el.length; i++){
                int nDif = Math.abs(el[i] - board);
                //if the new difference is closer to the boarding floor...
                if(nDif < dif){
                    //set the new el array element closest to
                    // (sets the lowest numbered elevator by default if more than one elevator have the same difference value)
                    arrele = i;
                    dif = nDif;
                }
            }
            int elNum = arrele + 1;
            int elFloor = el[arrele];
            System.out.println("Your elevator will be elevator number " + elNum + ", currently on floor number " + elFloor);
            //
            if(el[arrele] > board){
                System.out.print("Your elevator must pass the following floor(s): ");
                for(int i = el[arrele]; i > board; i--){
                    System.out.print(i + " ");
                }
                System.out.println();
            } if (el[arrele] < board) {
                System.out.print("Your elevator must pass the following floor(s): ");
                for(int i = el[arrele]; i < board; i++){
                    System.out.print(i + " ");
                }
                System.out.println();
            } else{
                System.out.println("Your elevator is currently at your boarding floor and must pass no other floors.");
            }


            //PART 4
            System.out.println("Please input your destination floor number.");
            int dest;
            do {
                dest = input.nextInt();
                if ((dest >= 1) && (dest <= 9)){
                    System.out.println("Your destination is floor " + dest);
                    break;
                } else {
                    System.out.println("Please input a valid floor number from floors 1-9.");
                }
            } while (!((dest >= 1) && (dest <= 9)));


            //PART 5
            //when the destination is lower than the boarding floor
            if(board > dest){
                System.out.print("Your elevator must pass the following floor(s): ");
                for(int i = board; i > dest; i--){
                    System.out.print(i + " ");
                }
                System.out.println();
            } if (board < dest) { //when the boarding floor is lower than the destination
                System.out.print("Your elevator must pass the following floor(s): ");
                for(int i = board; i < dest; i++){
                    System.out.print(i + " ");
                }
                System.out.println();
            } else { //when the boarding floor is the same as the destination
                System.out.println("Your elevator is currently at your destination and must pass no other floors.");
            }
            el[arrele] = dest;

        }
    }
}
