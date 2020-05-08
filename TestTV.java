/*
 *  Lab 9
 *  Description: In this lab we will be extending our knowledge on objects
 *  Name: Shauhin Pourshayegan
 *  ID: 920447681
 *  Class: CSC 211-1
 *  Semester: Spring 2020
 */
public class TestTV {
    public static void main(String[]args){
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(30);
        tv1.setVolume(3);

        TV tv2 = new TV();
        tv2.turnOn();
        tv2.channelUp();
        tv2.channelUp();
        tv2.volumeUp();
        System.out.println("TV 1's channel is " + tv1.channel + " and volume level is " + tv1.volume);
        System.out.println("TV 2's channel is " + tv2.channel + " and volume level is " + tv2.volume);
    }

}

//making the TV class
class TV{
    //A default tv's channel is set to 1, volume is set to 1 and is off.
    //these values are initialized for all TV's no matter what, but they can be changed.
    int channel = 1, volume = 1;
    boolean on = false;

    //when called, changes the boolean on to true
    public void turnOn(){
        on = true;
    }

    //when called, changes the boolean on to false
    public void turnOff(){
        on = false;
    }

    //if the tv is on and the channel provided is within range of 1-120, the channel can change to the new channel int x
    public void setChannel(int x){
        if (on && x >= 1 && x <= 120){
            channel = x;
        }
    }

    //if the tv is on and the volume provided is within range of 1-7, the volume can change to the new volume int x
    public void setVolume(int x){
        if (on && x >= 1 && x <= 7){
            volume = x;
        }
    }

    //if the tv is on and the channel provided is less than 120 you can change the channel one up
    public void channelUp(){
        if (on && channel < 120){
            channel++;
        }
    }

    //if the tv is on and the channel provided is greater than 1 you can change the channel one down
    public void channelDown(){
        if (on && channel > 1){
            channel--;
        }
    }

    //if the tv is on and the volume is less than 7 you can change the volume one up
    public void volumeUp(){
        if(on && volume < 7){
            volume++;
        }
    }

    //if the tv is on and the volume is greater than 1 you can change the volume one down
    public void volumeDown(){
        if(on && volume > 1){
            volume--;
        }
    }
}
