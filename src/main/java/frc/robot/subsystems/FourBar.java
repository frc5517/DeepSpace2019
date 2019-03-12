/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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

  /****************** PID VALUES ******************/
  // private final int PID_SLOT_ID = 0;
  // private final double kP = 0;
  // private final double kI = 0;
  // private final double kD = 0;
  // private final double kF = 0;
  /***********************************************/

  // four-bar motor controller
  WPI_TalonSRX fourbarTalon = new WPI_TalonSRX(RobotMap.fourBarPort);

  public Fourbar() {

    // // setting the encoder to a TalonSRX Quadrature Encoder
    // fourbarTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    // fourbarTalon.config_kP(PID_SLOT_ID, kP);
    // fourbarTalon.config_kI(PID_SLOT_ID, kI);
    // fourbarTalon.config_kD(PID_SLOT_ID, kD);
    // fourbarTalon.config_kF(PID_SLOT_ID, kF);

    // putting the fourbar in Brake mode
    fourbarTalon.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveFourbar());
  }

  public void debugPrint() {
    TalonDebug.printSrxClosedLoopValues(fourbarTalon, "Fourbar");
  }

  // moves the fourbar motor
  public void moveFourbar(double speed) {
    fourbarTalon.set(ControlMode.PercentOutput, speed);
  }  
  // stops the fourbar
  public void stopFourbarMotor() {
    fourbarTalon.set(ControlMode.PercentOutput, STOP_SPEED);
  }

  // allows the fourbar to be set to different positions based on
  // sensor values
  // public void setFourbarSetpoint(int setpoint) {
  //   fourbarTalon.setSelectedSensorPosition(setpoint);
  // }
}