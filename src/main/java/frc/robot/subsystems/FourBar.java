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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Fourbar that is used to score Cargo and Hatch Covers
 */
public class Fourbar extends Subsystem {

  public final double FOUR_BAR_LIFT_SPEED = 0.6;
  public final double FOUR_BAR_LOWER_SPEED = 0.4;
  public final double STOP_SPEED = 0.00;

  private final int PID_SLOT_ID = 0;
  private final double kP = 0;
  private final double kI = 0;
  private final double kD = 0;
  private final double kF = 0;

  // four-bar motor controller
  WPI_TalonSRX fourbarMotor = new WPI_TalonSRX(RobotMap.fourBarPort);

  public Fourbar() {

    // setting the encoder to a TalonSRX Quadrature Encoder
    fourbarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    /****************** PID VALUES ******************/
    fourbarMotor.config_kP(PID_SLOT_ID, kP);
    fourbarMotor.config_kI(PID_SLOT_ID, kI);
    fourbarMotor.config_kD(PID_SLOT_ID, kD);
    fourbarMotor.config_kF(PID_SLOT_ID, kF);
    /***********************************************/

    // putting the fourbar in Brake mode
    fourbarMotor.setNeutralMode(NeutralMode.Brake);
    
    // inverting the fourbar motor's output
    fourbarMotor.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allowing the fourbar to raise
  public void raiseFourbar() {
    fourbarMotor.set(ControlMode.PercentOutput, FOUR_BAR_LIFT_SPEED);
  }

  // allowing the fourbar to lower
  public void lowerFourbar() {
    fourbarMotor.set(ControlMode.PercentOutput, FOUR_BAR_LOWER_SPEED);
  }
  
  // stops the fourbar
  public void stopFourbarMotor() {
    fourbarMotor.set(ControlMode.PercentOutput, STOP_SPEED);
  }

  // allows the fourbar to be set to different positions based on
  // sensor values
  public void setFourbarSetpoint(int setpoint) {
    fourbarMotor.setSelectedSensorPosition(setpoint);
  }
}