// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;

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

    public static final class kPhotonVision {
        public static final String APRILTAG_LAYOUT = AprilTagFields.k2024Crescendo.m_resourceFile;
        
        public static final double CALIBRATION_DISTANCE_TO_TRAP = 0;
        public static final double TARGET_MAX_RANGE = 0.4;

        public static final class kCameras {
            public static final String CAMERA_FRONT_ID = "OV2311_FrontCamera";
            public static final Transform3d CAMERA_FRONT_OFFSET = new Transform3d(
                new Translation3d(0.418846, 0, 0.2234184),
                new Rotation3d(0, Math.toRadians(-30), 0)
            );
            public static final boolean CAMERA_FRONT_ENABLED = true;

            public static final String CAMERA_TOP_ID = "OV2311_ClimberCamera";
            public static final Transform3d CAMERA_TOP_OFFSET = new Transform3d(
                new Translation3d(0.1003965253, 0, 0.6490857384),
                new Rotation3d(0, Math.toRadians(-35), Math.toRadians(181.5))
            );
            public static final boolean CAMERA_TOP_EABLED = false;

            public static final String CAMERA_REAR_ID = "OV2311_BackCamera";
            public static final Transform3d CAMERA_REAR_OFFSET = new Transform3d(
                new Translation3d(-0.2941828, 0.1674622, 0.2117598),
                new Rotation3d(0, Math.toRadians(-42), Math.toRadians(180))
            );
            public static final boolean CAMERA_REAR_ENABLED = true;
        }
    }
}
