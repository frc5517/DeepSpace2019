/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.scoring_and_collecting;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.elevator.SetElevatorSetpoint;
import frc.robot.commands.wrist.SetWristSetpoint;

public class SetAllHighRocketPosition extends CommandGroup {
  /**
   * Setting all mechanisms to score in the highest Rocket position   
   */
  public SetAllHighRocketPosition() {

    addSequential(new SetElevatorSetpoint(0));
    addParallel(new SetWristSetpoint(0));
  }
}
