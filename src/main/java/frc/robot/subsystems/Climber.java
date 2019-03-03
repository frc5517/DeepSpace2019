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
 * Pneumatic cyliders that will allow the robot to climb to Hab Level two
 */
public class Climber extends Subsystem  {

  Solenoid climberSolenoid = new Solenoid(RobotMap.climberSolenoidPort);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }

  public void extendClimberSolenoid() {
    climberSolenoid.set(true);
  }

  public void stopClimberSolenoid() {
    climberSolenoid.set(false);
  }
}
