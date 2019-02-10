/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Elevator that lifts the four-bar arm system to scoring height
 */
public class Elevator extends Subsystem {

  public final double ELEVATOR_LIFT_SPEED = 0.65;
  public final double ELEVATOR_LOWER_SPEED = 0.40;
  public final double ELEVATOR_CLIMB_SPEED = 1.00;
  public final double STOP_SPEED = 0.00;

  // elevator motor controller2
  WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(RobotMap.elevatorPort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allows the elevator to be raised
  public void raiseElevator() {
    elevatorMotor.set(ControlMode.PercentOutput, -ELEVATOR_LIFT_SPEED);
  }

  // allows the elevator to be lowered
  public void lowerElevator() {
    elevatorMotor.set(ControlMode.PercentOutput, ELEVATOR_LOWER_SPEED);
  }

  public void lowerElevatorMaxSpeed() {
    elevatorMotor.set(ControlMode.PercentOutput, ELEVATOR_LOWER_SPEED);
  }
  
  // stops the elevator
  public void stopElevator() {
    elevatorMotor.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
