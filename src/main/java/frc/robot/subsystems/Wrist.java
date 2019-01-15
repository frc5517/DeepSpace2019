/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Rotates to score Cargo and Hatch Covers
 */
public class Wrist extends Subsystem {

  public final double WRIST_SPEED = 0.30;
  public final double STOP_SPEED = 0.0;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseWrist() {
    Robot.oi.wristMotor.set(WRIST_SPEED);
  }

  public void lowerWrist() {
    Robot.oi.wristMotor.set(-WRIST_SPEED);
  }
  
  public void stopWrist() {
    Robot.oi.wristMotor.set(STOP_SPEED);
  }
}
