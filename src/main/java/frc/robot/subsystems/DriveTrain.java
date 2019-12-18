/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX talonL1;
  public WPI_TalonSRX talonL2;
  public WPI_TalonSRX talonR1;
  public WPI_TalonSRX talonR2;
  
  
  //public Spark sparkL1;
  //public Spark sparkL2;
  //public Spark sparkR1;
  //public Spark sparkR2;
  

  SpeedControllerGroup leftGroup;
  SpeedControllerGroup rightGroup;

  public DifferentialDrive diffDrive;

  public DriveTrain() {
    //sparkL1 = new Spark(RobotMap.LEFTMOTOR_1);
    //sparkL2 = new Spark(RobotMap.LEFTMOTOR_2);
    //sparkR1 = new Spark(RobotMap.RIGHTMOTOR_1);
    //sparkR2 = new Spark(RobotMap.RIGHTMOTOR_2);
    talonL1 = new WPI_TalonSRX(RobotMap.LEFTMOTOR_1);
    talonL2 = new WPI_TalonSRX(RobotMap.LEFTMOTOR_2);
    talonR1 = new WPI_TalonSRX(RobotMap.RIGHTMOTOR_1);
    talonR2 = new WPI_TalonSRX(RobotMap.RIGHTMOTOR_2);

    
    leftGroup = new SpeedControllerGroup(talonL1, talonL2);
    rightGroup = new SpeedControllerGroup(talonR1, talonR2);

    diffDrive = new DifferentialDrive(leftGroup, rightGroup);
  }

  //maybe change back to static (broken code?)
  public void tankDrive(double leftSpeed, double rightSpeed){
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }
  

  

  @Override
  public void initDefaultCommand() { 
    // Set the default command for a subsystem here.
    setDefaultCommand(new JoystickDrive());
  }
  
}
