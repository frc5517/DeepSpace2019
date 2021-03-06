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

  // PWM motor controller ports
  public static int driveLeftPort = 0;
  public static int driveRightPort = 1;
  
  // CAN motor controller ports
  public static int fourbarLeftPort = 0;
  public static int wristPort = 1;
  public static int fourbarRightPort = 2;
  public static int cargoManipulatorPort = 3;

  // solenoid ports
  public static int hatchPanelSolenoidPort = 0;
  public static int climberSolenoidPort = 1;

  // joystick ports
  public static int leftJoystickPort = 0;
  public static int rightJoystickPort = 1;

  // gamepad port
  public static int operatorGamepadPort = 2;
  public static int driverGamepadPort = 3;
}
