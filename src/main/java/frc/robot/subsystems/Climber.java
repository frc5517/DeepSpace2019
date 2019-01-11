/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Pneumatic cyliders that will allow the robot to climb to Hab Level two
 */
public class Climber extends Subsystem {

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void raiseClimbSolenoids() {
    Robot.oi.climbSolenoidFront.set(DoubleSolenoid.Value.kForward);
    Robot.oi.climbSolenoidRear.set(DoubleSolenoid.Value.kForward);
  }

  public void lowerClimbSolenoids() {
    Robot.oi.climbSolenoidFront.set(DoubleSolenoid.Value.kReverse);
    Robot.oi.climbSolenoidRear.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopClimbSolenoids() {
    Robot.oi.climbSolenoidFront.set(DoubleSolenoid.Value.kOff);
    Robot.oi.climbSolenoidRear.set(DoubleSolenoid.Value.kOff);
  }
}
