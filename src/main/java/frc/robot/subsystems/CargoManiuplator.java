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
 * Used for intaking and scoring Cargo
 */
public class CargoManiuplator extends Subsystem {

  public final double SPIN_SPEED = 0.75;
  public final double STOP_SPEED = 0;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void spinIntakeIn() {
    Robot.oi.cargoManipulatorMotor.set(SPIN_SPEED);
  }

  public void spinIntakeOut() {
    Robot.oi.cargoManipulatorMotor.set(-SPIN_SPEED);
  }
  
  public void stopIntake() {
    Robot.oi.cargoManipulatorMotor.set(STOP_SPEED);
  }
}
