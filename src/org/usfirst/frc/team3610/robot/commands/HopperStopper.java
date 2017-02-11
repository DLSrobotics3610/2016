package org.usfirst.frc.team3610.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3610.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;

public class HopperStopper extends Command {
	private SpeedController motor;
    public HopperStopper() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	motor = Robot.getHopper();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	motor.set(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
    }

	// Called once after isFinished returns true
    protected void end() {
    	motor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
