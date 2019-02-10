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
 * Four-bar FourBar that is used to score Cargo and Hatch Covers
 */
public class FourBar extends Subsystem {

  public final double FOUR_BAR_SPEED = 0.65;
  public final double STOP_SPEED = 0.00;

  // four-bar motor controller
  WPI_TalonSRX fourBarMotor = new WPI_TalonSRX(RobotMap.fourBarPort);

  public FourBar() {

    // setting the encoder to a TalonSRX Quadrature Encoder
    fourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    /****************** PID VALUES ******************/
    fourBarMotor.config_kP(/*slotIdx, value*/ 0, 0);
    fourBarMotor.config_kI(/*slotIdx, value*/ 0, 0);
    fourBarMotor.config_kD(/*slotIdx, value*/ 0, 0);
    fourBarMotor.config_kF(/*slotIdx, value*/ 0, 0);
    /***********************************************/

    // putting the fourbar in Brake mode
    fourBarMotor.setNeutralMode(NeutralMode.Brake);

    double test = fourBarMotor.getSelectedSensorPosition();
    System.out.println(test);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allowing the fourbar to raise
  public void raiseFourBar() {
    fourBarMotor.set(ControlMode.PercentOutput, -FOUR_BAR_SPEED);
  }

  // allowing the fourbar to lower
  public void lowerFourBar() {
    fourBarMotor.set(ControlMode.PercentOutput, FOUR_BAR_SPEED);
  }
  
  // stops the fourbar
  public void stopFourBar() {
    fourBarMotor.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}