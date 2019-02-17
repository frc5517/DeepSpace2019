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
 * Rotates to score Cargo and Hatch Covers
 */
public class Wrist extends Subsystem {

  public final double WRIST_SPEED = 0.30;
  public final double STOP_SPEED = 0.0;
  
  // wrist motor controller
  WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.wristPort);

  /****************** PID VALUES ******************/
  private final int PID_SLOT_ID = 1;
  private final double kP = 0;
  private final double kI = 0;
  private final double kD = 0;
  private final double kF = 0;
  /***********************************************/

  public Wrist() {

    // set the encoder to a TalonSRX Quadrature Encoder
    wristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    wristMotor.config_kP(PID_SLOT_ID, kP);
    wristMotor.config_kI(PID_SLOT_ID, kI);
    wristMotor.config_kD(PID_SLOT_ID, kD);
    wristMotor.config_kF(PID_SLOT_ID, kF);

    wristMotor.setNeutralMode(NeutralMode.Brake);

    // wristMotor.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allows the wrist to be moved based on joystick input
  public void moveWrist(double speed) {
    wristMotor.set(ControlMode.PercentOutput, speed);
  }

  // allows the wrist to be set to different positions based on
  // sensor values
  public void setWristSetpoint(int setpoint) {
    wristMotor.setSelectedSensorPosition(setpoint);
  }
  
  // stops the elevator
  public void stopWristMotor() {
    wristMotor.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
