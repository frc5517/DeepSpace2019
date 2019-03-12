/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CurvatureDrive extends Command {

  private final double REGULAR_SPEED_MULTIPLIER = 0.75;
  private final double FULL_SPEED_MULTIPLIER = 1; 
  private final double ROTATION_MULTIPLIER = 0.5;

  public CurvatureDrive() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
    Robot.drivetrain.stop();
  }
 
  @Override
  protected void execute() {

    double speed = -Robot.oi.getRightJoystickY() * 
      (Robot.oi.isFullSpeedActivated() ? FULL_SPEED_MULTIPLIER : REGULAR_SPEED_MULTIPLIER);

    double rotation = Robot.oi.getLeftJoystickX() * ROTATION_MULTIPLIER;

    // double speed = -Robot.oi.getDriverGamepadLeftY() * 
    //   (Robot.oi.isFullSpeedActivated() ? FULL_SPEED_MULTIPLIER : REGULAR_SPEED_MULTIPLIER);

    // double rotation = Robot.oi.getDriverGamepadRightX() * ROTATION_MULTIPLIER;
    
    Robot.drivetrain.curvatureDrive(speed, rotation);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.drivetrain.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
