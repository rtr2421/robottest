/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.util.Gains;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final boolean USE_EXPERIMENTAL_PID_DRIVE = false;
  public static final int FRONT_SENSOR = 0; // Optical sensor mounted on the front of the frame

  public static final int TALON_ENCODER_PER_REV = 4096;

  // 4 Talons run the drive train
  public static int LEFTMOTOR_1 = 7;
  public static int LEFTMOTOR_2 = 2;
  public static int RIGHTMOTOR_1 = 8;
  public static int RIGHTMOTOR_2 = 4;

  public static final double TARGET_VELOCITY = 500.0; // target velocity of talons in rev/sec at 100%

  /**
   * Which PID slot to pull gains from. Starting 2018, you can choose from 0,1,2
   * or 3. Only the first two (0,1) are visible in web-based configuration.
   */
  public static final int kSlotIdx = 0;

  /**
   * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For now
   * we just want the primary one.
   */
  public static final int kPIDLoopIdx = 0;

  /**
   * Set to zero to skip waiting for confirmation, set to nonzero to wait and
   * report to DS if action fails.
   */
  public static final int kTimeoutMs = 30;

  /**
   * PID Gains may have to be adjusted based on the responsiveness of control
   * loop. kF: 1023 represents output value to Talon at 100%, 7200 represents
   * Velocity units at 100% output
   * 
  * kP kI kD kF Iz PeakOut
   */
  public final static Gains kGains_Velocit = new Gains(0.25, 0.001, 20, 1023.0 / 7200.0, 300, 1.00);
}
