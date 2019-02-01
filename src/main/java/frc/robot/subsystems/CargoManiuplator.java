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
 * Used for intaking and scoring Cargo
 */
public class CargoManiuplator extends Subsystem {

  public final double SPIN_SPEED = 0.75;
  public final double STOP_SPEED = 0;

  
  // cargo manipulator motor controllers
  public WPI_TalonSRX cargoManipulatorMotor = new WPI_TalonSRX(RobotMap.cargoManipulatorPort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allows the robot to intake cargo
  public void spinIntakeIn() {
    cargoManipulatorMotor.set(SPIN_SPEED);
  }

  // allows the robot to score cargo
  public void spinIntakeOut() {
    cargoManipulatorMotor.set(-SPIN_SPEED);
  }
  
  // stops the intake 
  public void stopIntake() {
    cargoManipulatorMotor.set(STOP_SPEED);
  }
}
