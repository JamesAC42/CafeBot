package org.usfirst.frc.team5181.robot;

public interface StaticVars {
	
	//Wheels 
	public static final int LEFTPort1 = 0;
	public static final int LEFTPort2= 1;
	public static final int RIGHTPort1 = 2;
	public static final int RIGHTPort2 = 3;
	
	public static final double binHeight = 29; //in inches
	public static final double typi = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;//100 digits after "."
	public static final double LiftTop = binHeight + 1; //minimum height to lift tote off of the ground in auto period
	public static final double DistanceToAutoZone = 146; //in inches
	public static final double ToteHeight = 12.1; //in inches
	public static final double ScoringPlatformHeight = 2; // in inches
	public static final double minHeight = 10; //inches The lowest height that the robot's forklift can be 
	public static final double maxHeight = 67.25; //inches The maximum height of the robot's forklift
	public static final double ForkLiftSpeed = 8;//8.61686391; //inches per seconds
	public static final double WheelSpeed = 121.904762; //inches per second
	public static final double WheelDistancePerPulse = 6*typi/12; //12-1 gear ratio with 6 inch diameter
	public static final double LiftDistancePerPulse = 0;
	//ports
	public static final int BOTTOM_LIMITSWITCH_PORT = 11; //not used
	public static final int LIFT_MOTOR_PORT = 1; //Port 0 does not work 
	public static final int Encoder_PortA = 0; //the forklift encoder
	public static final int Encoder_PortB = 1; //the forklift's second encoder
	public static final int Encoder_PortC = 2; //the wheel's encoder
	public static final int Encoder_PortD = 3; //the wheel's second encoder
	
	public static final int JOYSTICK_PORT = 0;
	
	public static final int SolePort1 = 0;
	public static final int SolePort2 = 1;
}