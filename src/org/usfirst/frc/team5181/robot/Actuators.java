package org.usfirst.frc.team5181.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Relay;

public class Actuators implements StaticVars {
	
	public final Victor Left1;
	public final Victor Left2;
	public final Victor Right1;
	public final Victor Right2;
	
	public final Relay liftMotor;
	
	public Actuators() {
		 Left1 = new Victor(LEFTPort1); 
		 Left2 = new Victor(LEFTPort2); 
		 Right1 = new Victor(RIGHTPort1); 
		 Right2 = new Victor(RIGHTPort2);
		 liftMotor = new Relay(LIFT_MOTOR_PORT);
	}
	
	public Victor getWheel(int choice) {
		switch (choice){
			case LEFTPort1:
				return Left1;
			case LEFTPort2:
				return Right1;
			case RIGHTPort1:
				return Left2;
			case RIGHTPort2:
				return Right2;
			default:
				return null;
		}
	}
}
