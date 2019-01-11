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
 * Elevator that lifts the four-bar arm system to scoring height
 */
public class Elevator extends Subsystem {

  public final double ELEVATOR_SPEED = 0.75;
  public final double STOP_SPEED = 0;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseElevator() {
    Robot.oi.elevatorMotor.set(ELEVATOR_SPEED);
  }

  public void lowerElevator() {
    Robot.oi.elevatorMotor.set(-ELEVATOR_SPEED);
  }
  
  public void stopElevator() {
    Robot.oi.elevatorMotor.set(STOP_SPEED);
  }
}
