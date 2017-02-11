/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3610.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3610.robot.commands.Autonomous;
import org.usfirst.frc.team3610.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command autonomousCommand;
    public static DriveTrain drivetrain;
    public static SpeedController intake;
    public static SpeedController hopper;
    public static SpeedController lowshot;
    public static SpeedController highshot;
    public static Servo exampleServo;
	public static DigitalInput upcontact;
	public static DigitalInput downcontact;
    public static OI oi;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public Robot() {
    }

    public void robotInit() {
        // Initialize all subsystems
        oi = new OI();
        setDrivetrain(new DriveTrain());
        setIntake(new Talon(2));
        setServo(new Servo(6));
        setHopper(new Talon(3));
        setHighShot(new Talon(4));
        setLowShot(new Talon(5));
        setUpContact(new DigitalInput(7));
        setDownContact(new DigitalInput(8));
        // instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
    }

	private void setDownContact(DigitalInput downcontact) {
		Robot.downcontact = downcontact;
	}
	private void setUpContact(DigitalInput upcontact) {
		Robot.upcontact = upcontact;
	}
	public static DigitalInput getUpContact() {
		return upcontact;
	}

	private void setServo(Servo servo) {
		Robot.exampleServo = servo;
	}

	public void autonomousInit() {
        autonomousCommand.start(); // schedule the autonomous command (example)
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
    	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
    private void log() {
    }

	public static DriveTrain getDrivetrain() {
		return drivetrain;
	}

	public static void setDrivetrain(DriveTrain drivetrain) {
		Robot.drivetrain = drivetrain;
	}
	public static SpeedController getIntake() {
		return intake;
	}
	public static Servo getServo() {
		return Robot.exampleServo;
	}

	public static void setIntake(SpeedController intake) {
		Robot.intake = intake;
	}
	public static void setLowShot(SpeedController lowshot) {
		Robot.lowshot = lowshot;
	}
	public static void setHighShot(SpeedController highshot) {
		Robot.highshot = highshot;
	}

	public static void setHopper(SpeedController hopper) {
		Robot.hopper = hopper;
	}
	
	public static SpeedController getHopper() {
		return hopper;
	}
	public static SpeedController getHighShot() {
		return highshot;
	}
	public static SpeedController getLowShot() {
		return lowshot;
	}

	public static DigitalInput getDownContact() {
		// TODO Auto-generated method stub
		return downcontact;
	}
}
