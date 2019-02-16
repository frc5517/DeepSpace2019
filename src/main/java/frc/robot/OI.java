/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.CurvatureDriveFullSpeed;
// import frc.robot.commands.drivetrain.CurvatureDriveFullSpeed;
// import frc.robot.commands.elevator.LowerElevatorMaxSpeed;
import frc.robot.commands.elevator.LowerElevator;
import frc.robot.commands.elevator.RaiseElevator;
import frc.robot.commands.fourbar.LowerFourbar;
import frc.robot.commands.fourbar.RaiseFourbar;
import frc.robot.commands.scoring_and_collecting.SetAllCargoCollectingPosition;
import frc.robot.commands.scoring_and_collecting.SetAllHatchCollectingPosition;
import frc.robot.commands.scoring_and_collecting.SetAllHighRocketPosition;
import frc.robot.commands.scoring_and_collecting.SetAllLowRocketPosition;
import frc.robot.commands.scoring_and_collecting.SetAllMiddleRocketPosition;
import frc.robot.utilities.Gamepad;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public OI() {
    bindControls();
  }

  // joysticks + gamepad
  public Joystick leftJoystick = new Joystick(RobotMap.leftJoystickPort);
  public Joystick rightJoystick = new Joystick(RobotMap.rightJoystickPort);
  public Gamepad operatorGamepad = new Gamepad(RobotMap.operatorGamepadPort);

  // joystick buttons
  public Button rightJoystickButtonOne = new JoystickButton(rightJoystick, 1),
                leftJoystickButtonTwo = new JoystickButton(leftJoystick, 1);

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

  public double getOperatorGamepadLeftX() {
    double x = operatorGamepad.getLeftX();
    return x;
  }

  public void bindControls() {
    rightJoystickButtonOne.whileHeld(new CurvatureDriveFullSpeed());

    operatorGamepad.getRightShoulder().whileHeld(new RaiseElevator());
    operatorGamepad.getLeftShoulder().whileHeld(new LowerElevator());
    operatorGamepad.getButtonA().whileHeld(new RaiseFourbar());
    operatorGamepad.getButtonB().whileHeld(new LowerFourbar());

    // operatorGamepad.getButtonY().whenPressed(new SetAllCargoCollectingPosition());
    // operatorGamepad.getButtonX().whenPressed(new SetAllHatchCollectingPosition());
    // operatorGamepad.getRightShoulder().whenPressed(new SetAllLowRocketPosition());
    // operatorGamepad.getLeftBumper().whenPressed(new SetAllMiddleRocketPosition());
    // operatorGamepad.getButtonA().whenPressed(new SetAllHighRocketPosition());
    
  }
}
