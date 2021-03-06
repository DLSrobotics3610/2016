package org.usfirst.frc.team3610.robot.commands;

import org.usfirst.frc.team3610.robot.Robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OffShot extends Command {
	private SpeedController motor;
	private SpeedController motor2;
    public OffShot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	motor = Robot.getHighShot();
    	motor2 = Robot.getLowShot();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	motor.set(0);
    	motor2.set(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
