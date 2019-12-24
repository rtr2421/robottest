/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
abstract public class BaseDriveTrain extends Subsystem{
    public abstract int getLeftEncoder();
    public abstract int getRightEncoder();
    public abstract void tankDrive(double leftSpeed, double rightSpeed);
}
