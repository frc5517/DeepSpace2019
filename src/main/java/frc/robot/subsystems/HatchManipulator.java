/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Allows the scoring of Hatch Panels
 */
public class HatchManipulator extends Subsystem {
  
  // creating solenoid for scoring 
  Solenoid hatchPanelSolenoid = new Solenoid(RobotMap.hatchPanelSolenoidPort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void extendHatchPanelSolenoid() {
    hatchPanelSolenoid.set(true);
  }

  public void stopHatchPanelSolenoid() {
    hatchPanelSolenoid.set(false);
  }
}
