/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int FRONT_SENSOR = 0; // Optical sensor mounted on the front of the frame

public static final int TALON_ENCODER_PER_REV = 4096;

  // 4 Talons run the drive train
  public static int LEFTMOTOR_1 = 7;
  public static int LEFTMOTOR_2 = 2;
  public static int RIGHTMOTOR_1 = 8;
  public static int RIGHTMOTOR_2 = 4;

}
