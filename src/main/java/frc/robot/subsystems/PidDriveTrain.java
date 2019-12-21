/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDrive;

/**
 * Drive train for the robot, currently 4 Talons driving CIM motors, 2 per side
 * in a tank drive configuration.
 */
public class PidDriveTrain extends Subsystem {

  WPI_TalonSRX talonL1;
  WPI_TalonSRX talonL2;
  WPI_TalonSRX talonR1;
  WPI_TalonSRX talonR2;

  // SpeedControllerGroup leftGroup;
  // SpeedControllerGroup rightGroup;
  DigitalInput frontSensor;
  DifferentialDrive diffDrive;

  public PidDriveTrain() {
    talonL1 = new WPI_TalonSRX(RobotMap.LEFTMOTOR_1);
    talonR1 = new WPI_TalonSRX(RobotMap.RIGHTMOTOR_1);
    frontSensor = new DigitalInput(RobotMap.FRONT_SENSOR);
    diffDrive = new DifferentialDrive(talonL1, talonR1);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    SmartDashboard.putBoolean(("Front Sensor"), frontSensor.get());

    // If the sensor indicates we will hit something, prevent forward motion
    if (frontSensor.get()) {
      leftSpeed = Math.max(leftSpeed, 0);
      rightSpeed = Math.max(rightSpeed, 0);
    }
    SmartDashboard.putNumber("Left Speed", leftSpeed);
    SmartDashboard.putNumber("Right Speed", rightSpeed);

    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new JoystickDrive());
  }

  public int getLeftEncoder() {
    return talonL1.getSensorCollection().getQuadraturePosition();
  }

  public int getRightEncoder() {
    return talonR1.getSensorCollection().getQuadraturePosition();
  }
}