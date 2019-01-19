/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.CurvatureDriveFullSpeed;
import frc.robot.utilities.Gamepad;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
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

  // drivetrain motor controllers
  public Spark driveLeftMotor = new Spark(RobotMap.driveLeftPort);
  public Spark driveRightMotor = new Spark(RobotMap.driveRightPort);

  // elevator motor controller
  public WPI_VictorSPX elevatorMotor = new WPI_VictorSPX(RobotMap.elevatorPort);

  // cargo manipulator motor controllers
  public WPI_TalonSRX cargoManipulatorMotor = new WPI_TalonSRX(RobotMap.cargoManipulatorPort);

  // wrist motor controller
  public WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.wristPort);

  // four-bar motor controller
  public WPI_TalonSRX fourBarMotor = new WPI_TalonSRX(RobotMap.fourBarPort);

  // solenoids
  public DoubleSolenoid hatchSolenoid = new DoubleSolenoid(RobotMap.hatchSolenoidForwardPort,
                                                           RobotMap.hatchSolenoidReversePort);
  public DoubleSolenoid climbSolenoidFront = new DoubleSolenoid(RobotMap.climbFrontSolenoidForwardPort, 
                                                                RobotMap.climbFrontSolenoidReversePort);
  public DoubleSolenoid climbSolenoidRear = new DoubleSolenoid(RobotMap.climbRearSolenoidForwardPort, 
                                                               RobotMap.climbRearSolenoidReversePort);

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

  public double getRightY() {
    double y = rightJoystick.getY();
    return y;
  }

  public double getLeftX() {
    double x = leftJoystick.getX();
    return x;
  }

  public void bindControls() {
    rightJoystickButtonOne.whileHeld(new CurvatureDriveFullSpeed());
  }
}
