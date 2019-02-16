/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Elevator that lifts the four-bar arm system to scoring height
 */
public class Elevator extends Subsystem {

  public final double ELEVATOR_LIFT_SPEED = 0.65;
  public final double ELEVATOR_LOWER_SPEED = -0.40;
  public final double STOP_SPEED = 0.00;

  public final double PID_ELEVATOR_LIFT_SPEED = 0.80;
  public final double PID_ELEVATOR_LOWER_SPEED = -0.50;

  private final int PID_SLOT_ID = 1;
  private final double kP = 0;
  private final double kI = 0;
  private final double kD = 0;
  private final double kF = 0;

  // elevator motor controller2
  WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(RobotMap.elevatorPort);

  public Elevator() {

    // setting the encoder to a TalonSRX Quadrature Encoder
    elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    /****************** PID VALUES ******************/
    elevatorMotor.config_kP(PID_SLOT_ID, kP);
    elevatorMotor.config_kI(PID_SLOT_ID, kI);
    elevatorMotor.config_kD(PID_SLOT_ID, kD);
    elevatorMotor.config_kF(PID_SLOT_ID, kF);
    /***********************************************/

    elevatorMotor.configNominalOutputForward(PID_ELEVATOR_LIFT_SPEED);
    elevatorMotor.configNominalOutputReverse(PID_ELEVATOR_LOWER_SPEED);

    // putting the elevator in Brake mode
    elevatorMotor.setNeutralMode(NeutralMode.Brake);

    // inverting the elevator motor's output
    elevatorMotor.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allows the elevator to be raised
  public void raiseElevator() {
    elevatorMotor.set(ControlMode.PercentOutput, ELEVATOR_LIFT_SPEED);
  }

  // allows the elevator to be lowered
  public void lowerElevator() {
    elevatorMotor.set(ControlMode.PercentOutput, ELEVATOR_LOWER_SPEED);
  }

  // allows the wrist to be set to different positions based on
  // sensor values
  public void setElevatorSetpoint(int setpoint) {
    elevatorMotor.setSelectedSensorPosition(setpoint);
  }
  
  // stops the elevator
  public void stopElevatorMotor() {
    elevatorMotor.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
