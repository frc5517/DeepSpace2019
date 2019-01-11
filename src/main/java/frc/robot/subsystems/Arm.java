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
 * Four-bar arm that is used to score Cargo and Hatch Covers
 */
public class Arm extends Subsystem {

  public final double ARM_SPEED = 0.5;
  public final double STOP_SPEED = 0;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseArm() {
    Robot.oi.armLeftMotor.set(ARM_SPEED);
    Robot.oi.armRightMotor.set(-ARM_SPEED);
  }

  public void lowerArm() {
    Robot.oi.armLeftMotor.set(-ARM_SPEED);
    Robot.oi.armRightMotor.set(ARM_SPEED);
  }
  
  public void stopArm() {
    Robot.oi.armLeftMotor.set(STOP_SPEED);
    Robot.oi.armRightMotor.set(STOP_SPEED);
  }
  
}
