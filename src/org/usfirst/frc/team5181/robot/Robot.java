//2015
package org.usfirst.frc.team5181.robot;

import java.io.IOException;
import java.net.UnknownHostException;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick.ButtonType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directoLy.
 */
public class Robot extends IterativeRobot implements StaticVars {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	//speed limit
	public static double speedLimit = 1.00;
	
	DriveTrain driveTrain;
	Joystick gamePad;
	Actuators actuators;
	DriverStation driverStation;
	
    public void robotInit() {
    	gamePad = new Joystick(2);
    	actuators = new Actuators();
    	driveTrain = new DriveTrain(actuators);
    	driverStation = DriverStation.getInstance();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    
    	setSpeedLimit();
    	drive(); //trigger drive 
    } 
    
    /**                                                                          
     * Drives the robot using trigger drive	
     */
    public void drive() {
    	double rightAxisValue = speedLimit * gamePad.getRawAxis(CustomJoystick.LEFT_Stick_X); //twist
    	double leftTrigger =  speedLimit * gamePad.getRawAxis(CustomJoystick.LEFT_Trigger); //forwards
    	double rightTrigger = speedLimit *  gamePad.getRawAxis(CustomJoystick.RIGHT_Trigger); //backwards

    	if (rightTrigger > 0 || leftTrigger > 0) {
    		if(rightTrigger > 0 && leftTrigger == 0) {
    			driveTrain.triggerDrive(1, rightTrigger, rightAxisValue);
    		}
    		else if(leftTrigger > 0 && rightTrigger == 0) {
    			driveTrain.triggerDrive(-1, leftTrigger, rightAxisValue);
    		} 
    	}
    	else {
    		
    		driveTrain.tankDrive(rightAxisValue, -rightAxisValue);
    	}
    	
    	if (gamePad.getRawButton(CustomJoystick.Y_Button)) {
    		
    	}
    }
    
    

    /**
     * sets the speed limit   
     */
    public void setSpeedLimit() {
    	if (gamePad.getRawButton(CustomJoystick.RIGHT_Bumper)) {
    		speedLimit += .08;
    	}
    	else if (gamePad.getRawButton(CustomJoystick.LEFT_Bumper) && (speedLimit > 0.24)) {
    		speedLimit -= .08;
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	//DriverStation.reportError("Value:\t" + gamePad.getRawAxis(CustomJoystick.RIGHT_Trigger) + "\n", false);
    }
}
