/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // motor controller ports
  public static int driveLeftPort = 0;
  public static int driveRightPort = 1;
  public static int wristPort = 2;
  public static int elevatorPort = 3;
  public static int cargoManipulatorPort = 4; 
  public static int armLeftPort = 0;
  public static int armRightPort = 1;

  // solenoid ports
  public static int hatchSolenoidPort = 0;
  public static int climbFrontSolenoidForwardPort = 1;
  public static int climbFrontSolenoidReversePort = 2;
  public static int climbRearSolenoidForwardPort = 3;
  public static int climbRearSolenoidReversePort = 4;

  // joystick ports
  public static int leftJoystickPort = 0;
  public static int rightJoystickPort = 1;
}
