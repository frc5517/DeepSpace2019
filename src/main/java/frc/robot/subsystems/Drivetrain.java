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
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.drivetrain.CurvatureDrive;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {

   // drivetrain motor controllers
  Spark driveLeftMotor = new Spark(RobotMap.driveLeftPort);
  Spark driveRightMotor = new Spark(RobotMap.driveRightPort);

  public DifferentialDrive drive = new DifferentialDrive(driveLeftMotor, 
                                                         driveRightMotor);

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new ArcadeDrive());
    setDefaultCommand(new CurvatureDrive());
  }

  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  public void curvatureDrive(double speed, double rotation) {
    drive.curvatureDrive(speed, rotation, true);
  }

  public void stopDriveMotors() {
    drive.stopMotor();
  }
}
