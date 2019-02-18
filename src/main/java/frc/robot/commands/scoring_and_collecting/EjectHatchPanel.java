/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.scoring_and_collecting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.hatchManipulator.ExtendHatchManipulatorSolenoid;
import frc.robot.commands.hatchManipulator.RetractHatchSolenoid;

public class EjectHatchPanel extends CommandGroup {
  /**
   * Scoring the Hatch Panels by extending and then retracting the Solenoid
   */
  public EjectHatchPanel() {
    
    addSequential(new ExtendHatchManipulatorSolenoid());
    addSequential(new RetractHatchSolenoid());
  }
}
