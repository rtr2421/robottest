/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

// An autonomous command to drive forward for 3 seconds
public class DriveForward extends Command {
  int maxLeft, maxRight;

  public DriveForward(int howFar) {
    requires(Robot.driveTrain);
   
    maxLeft = Robot.driveTrain.getLeftEncoder() + howFar;
    maxRight = Robot.driveTrain.getRightEncoder() + howFar;
  }

  public DriveForward() {
    this(200); // default to 200
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(3); // Safety so we don't drive for more than 3 seconds
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.driveTrain.tankDrive(0.5, 0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    int currentLeft = Robot.driveTrain.getLeftEncoder();
    int currentRight = Robot.driveTrain.getRightEncoder();
    return (currentLeft > maxLeft || currentRight > maxRight);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.tankDrive(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}