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
import frc.robot.commands.drivetrain.CurvatureDrive;
import frc.robot.commands.drivetrain.CurvatureDriveFullSpeed;
import frc.robot.commands.elevator.LowerElevator;
import frc.robot.commands.elevator.RaiseElevator;
import frc.robot.commands.fourbar.LowerFourbar;
import frc.robot.commands.fourbar.RaiseFourbar;
import frc.robot.commands.scoring_and_collecting.ExtendAndRetractHatchManipulatorSolenoid;
import frc.robot.commands.scoring_and_collecting.SetAllCargoCollectingPosition;
import frc.robot.commands.scoring_and_collecting.SetAllHatchCollectingPosition;
import frc.robot.commands.scoring_and_collecting.SetAllHighRocketPosition;
import frc.robot.commands.scoring_and_collecting.SetAllLowRocketPosition;
import frc.robot.commands.scoring_and_collecting.SetAllMiddleRocketPosition;
import frc.robot.utilities.Gamepad;
import frc.robot.utilities.JoystickAnalogButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // joysticks + gamepad
  public Joystick leftJoystick = new Joystick(RobotMap.leftJoystickPort);
  public Joystick rightJoystick = new Joystick(RobotMap.rightJoystickPort);
  public Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepadPort);

  // joystick buttons
  public Button leftJoystickButtonOne, leftJoystickButtonTwo, 
                rightJoystickButtonOne, rightJoystickButtonTwo;

  // gamepad triggers as buttons
  public JoystickAnalogButton leftOperatorTrigger, rightOperatorTrigger;
  
  public OI() {

    leftJoystickButtonOne = new JoystickButton(leftJoystick, 1);
    leftJoystickButtonTwo = new JoystickButton(leftJoystick, 2);
    rightJoystickButtonOne = new JoystickButton(rightJoystick, 1);
    rightJoystickButtonTwo = new JoystickButton(rightJoystick, 2);

    leftOperatorTrigger = new JoystickAnalogButton(operatorGamepad, Gamepad.AXIS_LEFT_TRIGGER, 0.5);
    rightOperatorTrigger = new JoystickAnalogButton(operatorGamepad, Gamepad.AXIS_RIGHT_TRIGGER, 0.5);
    bindControls();
  }
  
  public void bindControls() {

    // commands on driver joysticks
    leftJoystickButtonOne.whileHeld(new SpinIntakeOut());
    leftJoystickButtonTwo.whenPressed(new ExtendAndRetractHatchManipulatorSolenoid());
    rightJoystickButtonOne.whileHeld(new SpinIntakeIn());
    rightJoystickButtonTwo.toggleWhenActive(new CurvatureDriveFullSpeed());

    // commands on operator gamepad
    operatorGamepad.getRightShoulder().whileHeld(new RaiseElevator());
    operatorGamepad.getLeftShoulder().whileHeld(new LowerElevator());
    operatorGamepad.getButtonA().whileHeld(new RaiseFourbar());
    operatorGamepad.getButtonB().whileHeld(new LowerFourbar());

    // operatorGamepad.getButtonY().whenPressed(new SetAllLowRocketPosition());
    // operatorGamepad.getRightShoulder().whenPressed(new SetAllMiddleRocketPosition());
    // rightOperatorTrigger.whenPressed(new SetAllHighRocketPosition());
    // operatorGamepad.getLeftShoulder().whenPressed(new SetAllHatchCollectingPosition());
    // leftOperatorTrigger.whenPressed(new SetAllCargoCollectingPosition());
  }

  // controlling joysticks
  public Joystick getLeftJoystick() {
    return leftJoystick;
  }

  public Joystick getRightJoystick() {
    return rightJoystick;
  }

  public Gamepad getOperatorGamepad() {
    return operatorGamepad;
  }

  public double getRightJoystickY() {
    double y = rightJoystick.getY();
    return y;
  }

  public double getLeftJoystickX() {
    double x = leftJoystick.getX();
    return x;
  }

  public double getOperatorGamepadRightY() {
    double y = operatorGamepad.getRightY();
    return y;
  }

  public double getOperatorGamepadLeftY() {
    double y = operatorGamepad.getLeftY();
    return y;
  }
}
