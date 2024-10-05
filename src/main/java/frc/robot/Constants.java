// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

  public static final class kControllers {
    public static final int PRIMARY_CONTROLLER = 0;
    public static final int SECONDARY_CONTROLLER = 1;
  }
  
  // Most values from Constants or TunerConstantsComp on Stormont
  public static final class kDrivetrain {
    public static final double MAX_DRIVE_VELOCITY = 4.56; // meters per second

    public static final double DRIVE_KS = 0;
    public static final double DRIVE_KV = 0;
    public static final double DRIVE_KA = 0;
  }
}
