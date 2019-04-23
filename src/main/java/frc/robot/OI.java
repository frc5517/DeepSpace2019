/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;
import frc.robot.commands.cargoManipulator.SpinIntakeIn;
import frc.robot.commands.cargoManipulator.SpinIntakeOut;
import frc.robot.commands.hatchManipulator.ExtendHatchManipulatorSolenoid;
import frc.robot.utilities.Gamepad;
import frc.robot.utilities.LogitechJoystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private final static double JOYSTICK_DEADZONE = 0.1;

  public LogitechJoystick leftJoystick = new LogitechJoystick(RobotMap.leftJoystickPort);
  public LogitechJoystick rightJoystick = new LogitechJoystick(RobotMap.rightJoystickPort);
  public Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepadPort);
  public Gamepad driverGamepad = new Gamepad(RobotMap.driverGamepadPort);

  public OI() {
    bindControls();
  }
  
  public void bindControls() {

    // Driver Commands
    leftJoystick.getJoystickButton(LogitechJoystick.BUTTON_2).whileHeld(new ExtendHatchManipulatorSolenoid());
    leftJoystick.getJoystickTrigger().whileHeld(new SpinIntakeOut());
    rightJoystick.getJoystickTrigger().whileHeld(new SpinIntakeIn());
  }

  public boolean isFullSpeedActivated() {
    return rightJoystick.isBoostButtonPressed();
  }

  public LogitechJoystick getLeftJoystick() {
    return leftJoystick;
  }

  public LogitechJoystick getRightJoystick() {
    return rightJoystick;
  }

  public Gamepad getOperatorGamepad() {
    return operatorGamepad;
  }

  public Gamepad getDriverGamepad() {
    return driverGamepad;
  }

  public double getLeftJoystickX() {
    double x = leftJoystick.getX();
    return x;
  }

  public double getRightJoystickY() {
    double y = rightJoystick.getY();
    return y;
  }

  public double getDriverGamepadRightX() {
    double x = driverGamepad.getRightX();
    return x;
  }

  public double getDriverGamepadLeftY() {
    double y = driverGamepad.getLeftY();
    return -y;
  }

  public double getOperatorGamepadLeftY() {
    double y = operatorGamepad.getLeftY();

    if(Math.abs(y) < JOYSTICK_DEADZONE) {

      return 0;
    }

    return y;
  }

  public double getOperatorGamepadRightY() {  
    double y = operatorGamepad.getRightY();

    if(Math.abs(y) < JOYSTICK_DEADZONE) {

      return 0;
    }

    return y;
  }

}
