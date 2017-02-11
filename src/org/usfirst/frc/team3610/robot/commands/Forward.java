package org.usfirst.frc.team3610.robot.commands;

import org.usfirst.frc.team3610.robot.Robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Forward extends Command {
	private Servo exampleServo;
    public Forward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	exampleServo = Robot.getServo();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	exampleServo.set(0.01);
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
