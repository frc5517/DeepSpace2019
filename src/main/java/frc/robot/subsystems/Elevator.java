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
import frc.robot.utilities.TalonDebug;

/**
 * Elevator that lifts the four-bar arm system to scoring height
 */
public class Elevator extends Subsystem {

  /****************** CONSTANT VALUES *****************/
  public final double ELEVATOR_LIFT_SPEED = 0.65;
  public final double ELEVATOR_LOWER_SPEED = -0.25;
  public final double STOP_SPEED = 0.00;

  public final double PID_ELEVATOR_LIFT_SPEED = 0.80;
  public final double PID_ELEVATOR_LOWER_SPEED = -0.50;
  
  private final int PID_SLOT_ID = 2;
  private final double kP = 0;
  private final double kI = 0;
  private final double kD = 0;
  private final double kF = 0;
  /****************************************************/

  // elevator motor controller
  private WPI_TalonSRX elevatorTalon = new WPI_TalonSRX(RobotMap.elevatorPort);

  public Elevator() {

    // Set the encoder to a TalonSRX Quadrature Encoder
    elevatorTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    elevatorTalon.config_kP(PID_SLOT_ID, kP);
    elevatorTalon.config_kI(PID_SLOT_ID, kI);
    elevatorTalon.config_kD(PID_SLOT_ID, kD);
    elevatorTalon.config_kF(PID_SLOT_ID, kF);

    elevatorTalon.configNominalOutputForward(PID_ELEVATOR_LIFT_SPEED);
    elevatorTalon.configNominalOutputReverse(PID_ELEVATOR_LOWER_SPEED);

    elevatorTalon.setNeutralMode(NeutralMode.Brake);

    elevatorTalon.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void debugPrint() {
    TalonDebug.printSrxClosedLoopValues(elevatorTalon, "Elevator");
  }

  public void raiseElevator() {
    elevatorTalon.set(ControlMode.PercentOutput, ELEVATOR_LIFT_SPEED);
  }

  public void lowerElevator() {
    elevatorTalon.set(ControlMode.PercentOutput, ELEVATOR_LOWER_SPEED);
  }

  // allows the wrist to be set to different positions based on
  // sensor values
  public void setElevatorSetpoint(int setpoint) {
    elevatorTalon.setSelectedSensorPosition(setpoint);
  }
  
  // stops the elevator
  public void stopElevatorMotor() {
    elevatorTalon.set(ControlMode.PercentOutput, STOP_SPEED);
  }
}
