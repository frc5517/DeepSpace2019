/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Rotates to score Cargo and Hatch Covers
 */
public class Wrist extends Subsystem {

  public final double WRIST_SPEED = 0.30;
  public final double STOP_SPEED = 0.0;

  
  // wrist motor controller
  WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.wristPort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseWrist() {
    wristMotor.set(WRIST_SPEED);
  }

  public void lowerWrist() {
    wristMotor.set(-WRIST_SPEED);
  }
  
  public void stopWrist() {
    wristMotor.set(STOP_SPEED);
  }
}
