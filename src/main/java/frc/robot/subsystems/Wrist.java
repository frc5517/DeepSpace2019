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
  public final double PID_WRIST_SPEED = 0.50;
  
  private final int PID_SLOT_ID = 0;
  private final int ALLOWABLE_ERROR = 0;
  private final int TIMEOUT_MS = 30;

  private final double kP = 0.10438776;
  private final double kI = 0.0;
  private final double kD = 0.0;
  /****************************************************/
  
  // wrist motor controller
  WPI_TalonSRX wristTalon = new WPI_TalonSRX(RobotMap.wristPort);

  public Wrist() {
    wristTalon.setNeutralMode(NeutralMode.Brake);
    wristTalon.setSensorPhase(true);

    wristTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                            PID_SLOT_ID, 
                                            TIMEOUT_MS);

    wristTalon.configNominalOutputForward(STOP_SPEED, TIMEOUT_MS);
    wristTalon.configNominalOutputReverse(STOP_SPEED, TIMEOUT_MS);
    wristTalon.configPeakOutputForward(PID_WRIST_SPEED, TIMEOUT_MS);
    wristTalon.configPeakOutputReverse(-PID_WRIST_SPEED, TIMEOUT_MS);

    wristTalon.configAllowableClosedloopError(PID_SLOT_ID, ALLOWABLE_ERROR, TIMEOUT_MS);

    wristTalon.config_kP(PID_SLOT_ID, kP);
    wristTalon.config_kI(PID_SLOT_ID, kI);
    wristTalon.config_kD(PID_SLOT_ID, kD);
    
    int absolutePosition = wristTalon.getSensorCollection().getPulseWidthPosition();
    absolutePosition &= 0xFFF;

    wristTalon.setSelectedSensorPosition(absolutePosition, PID_SLOT_ID, TIMEOUT_MS);
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

  // allows the wrist to be set to different positions based on
  // sensor values
  public void setWristSetpoint(double setpoint) {
    wristTalon.set(ControlMode.Position, setpoint);
  }
  
  // stops the elevator
  public void stopWristMotor() {
    wristTalon.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
