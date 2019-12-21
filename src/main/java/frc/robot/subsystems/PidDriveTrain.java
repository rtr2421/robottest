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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDrive;
import frc.robot.util.DifferentialPidDrive;

/**
 * Drive train for the robot, currently 4 Talons driving CIM motors, 2 per side
 * in a tank drive configuration.
 */
public class PidDriveTrain extends Subsystem {

  WPI_TalonSRX talonL1;
  WPI_TalonSRX talonL2;
  WPI_TalonSRX talonR1;
  WPI_TalonSRX talonR2;

  DigitalInput frontSensor;
  DifferentialPidDrive diffDrive;

  public PidDriveTrain() {
    talonL1 = new WPI_TalonSRX(RobotMap.LEFTMOTOR_1);
    talonR1 = new WPI_TalonSRX(RobotMap.RIGHTMOTOR_1);
    // When it comes time to add the second talons, do something like
    // talonL2 = new ...
    // talonL2.follow(talonL1);
    frontSensor = new DigitalInput(RobotMap.FRONT_SENSOR);
    configureTalonPid(talonL1);
    configureTalonPid(talonR1);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    SmartDashboard.putBoolean(("Front Sensor"), frontSensor.get());

    // If the sensor indicates we will hit something, prevent forward motion
    if (frontSensor.get()) {
      leftSpeed = Math.max(leftSpeed, 0);
      rightSpeed = Math.max(rightSpeed, 0);
    }
    SmartDashboard.putData(diffDrive);
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    if (RobotMap.USE_EXPERIMENTAL_PID_DRIVE) {
      setDefaultCommand(new JoystickDrive());
    }
  }

  public int getLeftEncoder() {
    return talonL1.getSelectedSensorPosition(0);
  }

  public int getRightEncoder() {
    return talonR1.getSelectedSensorPosition(0);
  }

  private void configureTalonPid(WPI_TalonSRX _talon) {
    _talon.setSensorPhase(true);

    /* Config the peak and nominal outputs */
    _talon.configNominalOutputForward(0, RobotMap.kTimeoutMs);
    _talon.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
    _talon.configPeakOutputForward(1, RobotMap.kTimeoutMs);
    _talon.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

    /* Config the Velocity closed loop gains in slot0 */
    _talon.config_kF(RobotMap.kPIDLoopIdx, RobotMap.kGains_Velocit.kF, RobotMap.kTimeoutMs);
    _talon.config_kP(RobotMap.kPIDLoopIdx, RobotMap.kGains_Velocit.kP, RobotMap.kTimeoutMs);
    _talon.config_kI(RobotMap.kPIDLoopIdx, RobotMap.kGains_Velocit.kI, RobotMap.kTimeoutMs);
    _talon.config_kD(RobotMap.kPIDLoopIdx, RobotMap.kGains_Velocit.kD, RobotMap.kTimeoutMs);
  }

}
