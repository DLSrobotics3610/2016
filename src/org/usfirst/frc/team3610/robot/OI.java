
package org.usfirst.frc.team3610.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3610.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick leftStick = new Joystick(0);
    public Joystick rightStick = new Joystick(1);

    public OI() {
    	// Put Some buttons on the SmartDashboard// Create some buttons
        JoystickButton stop= new JoystickButton(leftStick, 2);
        JoystickButton highSpeed= new JoystickButton(leftStick, 3);
        JoystickButton loSpeed= new JoystickButton(leftStick, 4);
        JoystickButton reverse= new JoystickButton(leftStick, 5);
        JoystickButton faceForward= new JoystickButton(rightStick, 4);
        JoystickButton faceBackward= new JoystickButton(rightStick, 5);
        JoystickButton hopperUp= new JoystickButton(rightStick, 6);
        JoystickButton shooterOff = new JoystickButton(leftStick, 1);
        JoystickButton shooterHigh = new JoystickButton(rightStick, 1);
        JoystickButton hopperDown= new JoystickButton(rightStick, 7);
        JoystickButton hopperStop= new JoystickButton(rightStick, 8);


        // Connect the buttons to commands
        stop.whenPressed(new Stop());
        highSpeed.whenPressed(new High());
        reverse.whenPressed(new Reverse());
        loSpeed.whenPressed(new Low());
        faceForward.whenPressed(new Forward());
        faceBackward.whenPressed(new Backward());
        hopperUp.whenPressed(new HopperUp());
        shooterOff.whenPressed(new OffShot());
        shooterHigh.whenPressed(new HighShot());
        hopperDown.whenPressed(new HopperDown());
        hopperStop.whenPressed(new HopperStopper());
    }
    
    public Joystick getLeftStick() {
        return leftStick;
    }
    public Joystick getRightStick() {
        return rightStick;
    }
}

