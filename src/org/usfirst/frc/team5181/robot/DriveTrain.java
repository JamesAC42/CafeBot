 //2015
package org.usfirst.frc.team5181.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;


public class DriveTrain implements StaticVars {
	
	private final RobotDrive rd;
	/*
	 * @param Allows DriveTrain to contain wheel values
	 * */
	public DriveTrain(Actuators actuators){ 
		rd = new RobotDrive(actuators.getWheel(LEFTPort1), 
							actuators.getWheel(LEFTPort2),
							actuators.getWheel(RIGHTPort1),
							actuators.getWheel(RIGHTPort2));
		
	}
	
	/**
	 * Tank drive to control two sets of two motors
	 * 
	 * @param rightAxisValue value from [-1, 1] to control speed of right side of the robot
	 * @param leftAxisValue value from [-1, 1] to control speed of left side of the robot
	 */
	public void tankDrive(double leftValue, double rightValue) {
		rd.tankDrive(leftValue, rightValue, true); //third param == square values
	}
	
	
	/**
	 * The right trigger moves the robot straight forward
	 * The left trigger moves the robot straight backwards
	 * The right stick controls twist
	 * 
	 * @param direction the direction to drive in
	 * @param magnitude how quickly to drive
	 */
	public void triggerDrive(int direction, double magnitude, double twist) {
		if(twist > .1) {
			rd.tankDrive(direction * Math.min((magnitude + (0.2 * magnitude)), 1), direction * magnitude * (1 - twist));
		}
		else if(twist < -.1) {
			rd.tankDrive(direction * magnitude * (1 + twist), direction * Math.min((magnitude  + (0.2 * magnitude)), 1));
		}
		else {
			rd.tankDrive(direction * magnitude, direction * magnitude);
			//DriverStation.reportError("tankdrive", false);
		}
	}
}