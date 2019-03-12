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
import frc.robot.commands.wrist.MoveWrist;
import frc.robot.utilities.TalonDebug;

/**
 * Rotates to score Cargo and Hatch Covers
 */
public class Wrist extends Subsystem {  
  

  /****************** CONSTANT VALUES *****************/
  public final double STOP_SPEED = 0.00;

  // public final double PID_WRIST_SPEED = 0.50;
  
  // private final int PID_SLOT_ID = 1;
  // private final double kP = 0;
  // private final double kI = 0;
  // private final double kD = 0;
  // private final double kF = 0;
  /****************************************************/

  // wrist motor controller
  WPI_TalonSRX wristTalon = new WPI_TalonSRX(RobotMap.wristPort);

  public Wrist() {

    // set the encoder to a TalonSRX Quadrature Encoder
    // wristTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    // wristTalon.config_kP(PID_SLOT_ID, kP);
    // wristTalon.config_kI(PID_SLOT_ID, kI);
    // wristTalon.config_kD(PID_SLOT_ID, kD);
    // wristTalon.config_kF(PID_SLOT_ID, kF);

    wristTalon.setNeutralMode(NeutralMode.Brake);
    
    // wristTalon.configNominalOutputForward(PID_WRIST_SPEED);
    // wristTalon.configNominalOutputReverse(-PID_WRIST_SPEED);
  }

  public void debugPrint() {
    TalonDebug.printSrxClosedLoopValues(wristTalon, "Wrist");
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveWrist());
  }

  // allows the wrist to be moved based on joystick input
  public void moveWrist(double speed) {
    wristTalon.set(ControlMode.PercentOutput, speed);
  }

  // // allows the wrist to be set to different positions based on
  // // sensor values
  // public void setWristSetpoint(int setpoint) {
  //   wristTalon.setSelectedSensorPosition(setpoint);
  // }
  
  // stops the elevator
  public void stopWristMotor() {
    wristTalon.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
