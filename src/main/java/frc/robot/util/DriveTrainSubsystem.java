package frc.robot.util;

import edu.wpi.first.wpilibj.command.Subsystem;

abstract public class DriveTrainSubsystem extends Subsystem {

    abstract public void tankDrive(double leftSpeed, double rightSpeed);
    abstract public int getLeftEncoder();
    abstract public int getRightEncoder();
}