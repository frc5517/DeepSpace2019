/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Elevator that lifts the four-bar arm system to scoring height
 */
public class Elevator extends Subsystem {

  public final double ELEVATOR_SPEED = 0.75;
  public final double STOP_SPEED = 0;

  
  // elevator motor controller
  WPI_VictorSPX elevatorMotor = new WPI_VictorSPX(RobotMap.elevatorPort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseElevator() {
    elevatorMotor.set(ELEVATOR_SPEED);
  }

  public void lowerElevator() {
    elevatorMotor.set(-ELEVATOR_SPEED);
  }
  
  public void stopElevator() {
    elevatorMotor.set(STOP_SPEED);
  }
}
