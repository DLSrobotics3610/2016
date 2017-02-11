package org.usfirst.frc.team3610.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3610.robot.Robot;
import org.usfirst.frc.team3610.robot.commands.TankDriveWithJoystick;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class DriveTrain extends Subsystem {
	private SpeedController left_motor, right_motor;
	public SpeedController intake_motor;
	private RobotDrive drive;
	private Encoder left_encoder, right_encoder;
	private AnalogInput rangefinder;
	private AnalogGyro gyro;

	public DriveTrain() {
		super();
		left_motor = new Talon(0);
		right_motor = new Talon(1);
		drive = new RobotDrive(left_motor, right_motor);
		left_encoder = new Encoder(1, 2);
		right_encoder = new Encoder(3, 4);

		// Encoders may measure differently in the real world and in
		// simulation. In this example the robot moves 0.042 barleycorns
		// per tick in the real world, but the simulated encoders
		// simulate 360 tick encoders. This if statement allows for the
		// real robot to handle this difference in devices.
		if (Robot.isReal()) {
			left_encoder.setDistancePerPulse(0.042);
			right_encoder.setDistancePerPulse(0.042);
		} else {
			// Circumference in ft = 4in/12(in/ft)*PI
			left_encoder.setDistancePerPulse((4.0/12.0*Math.PI) / 360.0);
			right_encoder.setDistancePerPulse((4.0/12.0*Math.PI) / 360.0);
		}

		rangefinder = new AnalogInput(6);
		gyro = new AnalogGyro(1);

		// Let's show everything on the LiveWindow
	}

	/**
	 * When no other command is running let the operator drive around
	 * using the PS3 joystick.
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
	}
	/**
	 * Tank style driving for the DriveTrain.
	 * @param leftstick Speed in range [-1,1]
	 * @param rightstick Speed in range [-1,1]
	 */
	public void drive(Joystick leftstick, Joystick rightstick) {
		drive.tankDrive(leftstick, rightstick);
	}

	/**
	 * @param joy The ps3 style joystick to use to drive tank style.
	 */
	//public void drive(Joystick joy) {
	//	drive(-joy.getY(), -joy.getAxis(AxisType.kThrottle));
	//}

	/**
	 * @return The robots heading in degrees.
	 */
	public double getHeading() {
		System.out.println(gyro.getAngle());
		return gyro.getAngle();
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		gyro.reset();
		left_encoder.reset();
		right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (left_encoder.getDistance() + right_encoder.getDistance())/2;
	}

	/**
	 * @return The distance to the obstacle detected by the rangefinder.
	 */
	public double getDistanceToObstacle() {
		// Really meters in simulation since it's a rangefinder...
		return rangefinder.getAverageVoltage();
	}
}
