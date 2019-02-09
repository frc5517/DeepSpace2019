/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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

  // creating the encoder object 
  ErrorCode fourBarEncoder = fourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  // allowing the fourbar to raise
  public void raiseFourBar() {
    fourBarMotor.set(-FOUR_BAR_SPEED);
  }


  // allowing the fourbar to lower
  public void lowerFourBar() {
    fourBarMotor.set(FOUR_BAR_SPEED);
  }
  

  // stops the fourbar
  public void stopFourBar() {
    fourBarMotor.set(STOP_SPEED);
  }
}