package labbonus;

import java.util.Scanner;
import java.text.DecimalFormat;

/*  Program Name:   Laboratory Exercise - Trajectory
 *  Programmer:     Marcus Ross
 *  Date Due:       6 September 2013
 *  Description:	This program will calculate the altitude and distance traveled by a missile at a given time for a given initial velocity and departure angle (assuming there is no air resistance and that the terrain is flat).
 */

public class Trajectory {
    public static void main(String[] args) {
        final double GRAVITY = 32.16; //did you actually calculate the gravity at our latitude?
        final double COEFFICIENT = Math.PI / 180.0; //more precise pi!
        
        double velocity, degree, time, distance, height, xVelocity, yVelocity, radian,  timetoground, distancetoground; //reduced to one line

        //Establish keyboard availability
        Scanner keyboard = new Scanner(System.in);
        
        //Set up formatting for output
        DecimalFormat formatter = new DecimalFormat("#0.0");
        
        //Get Missile Data
        System.out.println("Please enter the INITIAL VELOCITY:");
        velocity = keyboard.nextDouble();
        System.out.println("Please enter the DEPARTURE ANGLE:");
        degree = keyboard.nextDouble();
        System.out.println("Please enter the FLIGHT DURATION:");
        time = keyboard.nextDouble();
        System.out.println();
        
        //Calculate Distance and Height
        radian = degree * COEFFICIENT;
        xVelocity = velocity * Math.cos(radian);
        yVelocity = velocity * Math.sin(radian);
        distance = xVelocity * time;
        height = yVelocity * time - 0.5 * GRAVITY * Math.pow(time,2.0); //used method instead
		//superfluous stuff
		timetoground = Math.sqrt((yVelocity * time) / (GRAVITY * 0.5));
		distancetoground = xVelocity * timetoground;
        
        //Display Missile Telemetry Results
        System.out.println("After " + formatter.format(time) + " seconds in the air, the missile will have covered " + formatter.format(distance) + "\nfeet with an altitude of " + formatter.format(height) + " feet.   (Assuming FLAT terrain and NO air\nresistance.)"); //reduced to one line
		if (height > 0) { //more superfluity
			System.out.println("The missile will hit ground after " + formatter.format(timetoground) + " seconds and\ntraveling a horizontal distance of " + formatter.format(distancetoground) + " feet.");
		}
    }   //END main
}   //END Trajectory class