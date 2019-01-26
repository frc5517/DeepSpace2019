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
 * Add your docs here.
 */
public class HatchManipulator extends Subsystem {
  
  
  // solenoids
  DoubleSolenoid hatchSolenoid = new DoubleSolenoid(RobotMap.hatchSolenoidForwardPort,
                                                    RobotMap.hatchSolenoidReversePort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void hatchSolenoidForward() {
    hatchSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void hatchSolenoidReverse() {
    hatchSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopHatchSolenoid() {
    hatchSolenoid.set(DoubleSolenoid.Value.kOff);
  }
}
