/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // drivetrain motor controllers
  public Spark driveLeftMotor = new Spark(RobotMap.driveLeftPort);
  public Spark driveRightMotor = new Spark(RobotMap.driveRightPort);

  // elevator motor controller
  public Talon elevatorMotor = new Talon(RobotMap.elevatorPort);

  // cargo manipulator motor controllers
  public Talon cargoManipulatorMotor = new Talon(RobotMap.cargoManipulatorPort);

  // wrist motor controller
  public Talon wristMotor = new Talon(RobotMap.wristPort);

  // arm motor controllers
  public WPI_VictorSPX armLeftMotor = new WPI_VictorSPX(RobotMap.armLeftPort);
  public WPI_VictorSPX armRightMotor = new WPI_VictorSPX(RobotMap.armRightPort);

  // solenoids
  public Solenoid hatchSolenoid = new Solenoid(RobotMap.hatchSolenoidPort);
  public DoubleSolenoid climbSolenoidFront = new DoubleSolenoid(RobotMap.climbFrontSolenoidForwardPort, 
                                                                RobotMap.climbFrontSolenoidReversePort);
  public DoubleSolenoid climbSolenoidRear = new DoubleSolenoid(RobotMap.climbRearSolenoidForwardPort, 
                                                               RobotMap.climbRearSolenoidReversePort);

  // joysticks
  public Joystick leftJoystick = new Joystick(RobotMap.leftJoystickPort);
  public Joystick rightJoystick = new Joystick(RobotMap.rightJoystickPort);

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
}
