/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.drivetrain.CurvatureDrive;
import frc.robot.RobotMap;

/**
 * Allows the robot to drive with Arcade drive or Curvature drive
 */
public class Drivetrain extends Subsystem {

   // drivetrain motor controllers
  Spark driveLeft = new Spark(RobotMap.driveLeftPort);
  Spark driveRight = new Spark(RobotMap.driveRightPort);

  DifferentialDrive drive = new DifferentialDrive(driveLeft, driveRight);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CurvatureDrive());
  }

  // allowing the drivetrain to be controlled by Curvature drive controls
  public void curvatureDrive(double speed, double rotation) {
    drive.curvatureDrive(speed, rotation, true);
  }

  // stops the drivetrain
  public void stop() {
    drive.stopMotor();
  }
}
