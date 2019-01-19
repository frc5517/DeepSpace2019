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
 * Four-bar FourBar that is used to score Cargo and Hatch Covers
 */
public class FourBar extends Subsystem {

  public final double FOUR_BAR_SPEED = 0.5;
  public final double STOP_SPEED = 0;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseFourBar() {
    Robot.oi.fourBarMotor.set(FOUR_BAR_SPEED);
  }

  public void lowerFourBar() {
    Robot.oi.fourBarMotor.set(-FOUR_BAR_SPEED);
  }
  
  public void stopFourBar() {
    Robot.oi.fourBarMotor.set(STOP_SPEED);
  }
}