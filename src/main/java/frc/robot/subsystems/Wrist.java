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

  public Wrist() {

    // setting the encoder to a TalonSRX Quadrature Encoder
    wristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    /****************** PID VALUES ******************/
    wristMotor.config_kP(/*slotIdx, value*/ 0, 0);
    wristMotor.config_kI(/*slotIdx, value*/ 0, 0);
    wristMotor.config_kD(/*slotIdx, value*/ 0, 0);
    wristMotor.config_kF(/*slotIdx, value*/ 0, 0);
    /***********************************************/

    // putting the wrist in Brake mode
    wristMotor.setNeutralMode(NeutralMode.Brake);

    // inverting the wrist motor's output
    // wristMotor.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allows the wrist to raise
  public void raiseWrist() {
    wristMotor.set(ControlMode.PercentOutput, WRIST_SPEED);
  }

  // allows the wrist to lower
  public void lowerWrist() {
    wristMotor.set(ControlMode.PercentOutput, -WRIST_SPEED);
  }
  
  // stops the elevator
  public void stopWrist() {
    wristMotor.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
