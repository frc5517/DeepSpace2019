/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Pneumatic cyliders that will allow the robot to climb to Hab Level two
 */
public class Climber extends Subsystem  {

  DoubleSolenoid climbSolenoidFront = new DoubleSolenoid(RobotMap.climbFrontSolenoidForwardPort, 
                                                         RobotMap.climbFrontSolenoidReversePort);
  DoubleSolenoid climbSolenoidRear = new DoubleSolenoid(RobotMap.climbRearSolenoidForwardPort, 
                                                        RobotMap.climbRearSolenoidReversePort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseClimbSolenoids() {
    climbSolenoidFront.set(DoubleSolenoid.Value.kForward);
    climbSolenoidRear.set(DoubleSolenoid.Value.kForward);
  }

  public void lowerFrontClimbSolenoids() {
    climbSolenoidFront.set(DoubleSolenoid.Value.kReverse);
  }

  public void lowerRearClimbSolenoids() {
    climbSolenoidRear.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopClimbSolenoids() {
    climbSolenoidFront.set(DoubleSolenoid.Value.kOff);
    climbSolenoidRear.set(DoubleSolenoid.Value.kOff);
  }
}
