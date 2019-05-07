/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.fourbar.MoveFourbar;
import frc.robot.utilities.TalonDebug;

/**
 * Fourbar that is used to score Cargo and Hatch Covers
 */
public class Fourbar extends Subsystem {

  public final double STOP_SPEED = 0.00;

  // four-bar motor controller
  WPI_TalonSRX fourbarLeftTalon = new WPI_TalonSRX(RobotMap.fourbarLeftPort);
  WPI_TalonSRX fourbarRightTalon = new WPI_TalonSRX(RobotMap.fourbarRightPort);

  public Fourbar() {

    // putting the fourbar in Brake mode
    fourbarLeftTalon.setNeutralMode(NeutralMode.Brake);
    fourbarRightTalon.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveFourbar());
  }

  public void debugPrint() {

    // print values of each TalonSRX
    TalonDebug.printSrxClosedLoopValues(fourbarLeftTalon, "Left Fourbar");
    TalonDebug.printSrxClosedLoopValues(fourbarRightTalon, "Right Fourbar");
  }

  // moves the fourbar motor
  public void moveFourbar(double speed) {
    fourbarLeftTalon.set(ControlMode.PercentOutput, speed);
    fourbarRightTalon.set(ControlMode.PercentOutput, -speed);
  }  
  
  // stops the fourbar
  public void stopFourbarMotor() {
    fourbarLeftTalon.set(ControlMode.PercentOutput, STOP_SPEED);
    fourbarRightTalon.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}