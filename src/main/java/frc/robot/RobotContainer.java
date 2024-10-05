// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.kControllers;
import frc.robot.Constants.kDrivetrain;
import frc.robot.subsystems.Drivetrain;
import swervelib.parser.SwerveControllerConfiguration;
import swervelib.parser.SwerveDriveConfiguration;
import swervelib.parser.SwerveModuleConfiguration;
import swervelib.parser.SwerveParser;

public class RobotContainer {

    // Controllers
    private final CommandXboxController m_primaryController;
    private final CommandXboxController m_secondaryController;

    // Drivetrain
    private final SwerveParser yagsl_parser;
    private final SwerveDriveConfiguration yagsl_config;
    private final SwerveControllerConfiguration yagsl_controller_config;
    private final Drivetrain sys_drivetrain;

    public RobotContainer() {
        // Controllers
        m_primaryController = new CommandXboxController(kControllers.PRIMARY_CONTROLLER);
        m_secondaryController = new CommandXboxController(kControllers.SECONDARY_CONTROLLER);

        // Drivetrain
        yagsl_parser = new SwerveParser(new File(Filesystem.getDeployDirectory(), "swerve"));
        yagsl_config = new SwerveDriveConfiguration(new SwerveModuleConfiguration[] {
                    SwerveParser.moduleJsons[0].createModuleConfiguration(
                        SwerveParser.pidfPropertiesJson.angle,
                        SwerveParser.pidfPropertiesJson.drive,
                        SwerveParser.physicalPropertiesJson.createPhysicalProperties(),
                        SwerveParser.swerveDriveJson.modules[0]
                    ),
                    SwerveParser.moduleJsons[1].createModuleConfiguration(
                        SwerveParser.pidfPropertiesJson.angle,
                        SwerveParser.pidfPropertiesJson.drive,
                        SwerveParser.physicalPropertiesJson.createPhysicalProperties(),
                        SwerveParser.swerveDriveJson.modules[1]
                    ),
                    SwerveParser.moduleJsons[2].createModuleConfiguration(
                        SwerveParser.pidfPropertiesJson.angle,
                        SwerveParser.pidfPropertiesJson.drive,
                        SwerveParser.physicalPropertiesJson.createPhysicalProperties(),
                        SwerveParser.swerveDriveJson.modules[2]
                    ),
                    SwerveParser.moduleJsons[3].createModuleConfiguration(
                        SwerveParser.pidfPropertiesJson.angle,
                        SwerveParser.pidfPropertiesJson.drive,
                        SwerveParser.physicalPropertiesJson.createPhysicalProperties(),
                        SwerveParser.swerveDriveJson.modules[3]
                    )
                },
            SwerveParser.swerveDriveJson.imu.createIMU(),
            SwerveParser.swerveDriveJson.invertedIMU,
            new SimpleMotorFeedforward(kDrivetrain.DRIVE_KS, kDrivetrain.DRIVE_KV, kDrivetrain.DRIVE_KA),
            SwerveParser.physicalPropertiesJson.createPhysicalProperties()
        );
        yagsl_controller_config = new SwerveControllerConfiguration(yagsl_config, SwerveParser.pidfPropertiesJson.angle, kDrivetrain.MAX_DRIVE_VELOCITY);
        sys_drivetrain = new Drivetrain(yagsl_config, yagsl_controller_config, kDrivetrain.MAX_DRIVE_VELOCITY);

        configureBindings();
    }

    private void configureBindings() {}

    public Command getAutonomousCommand() {
        return null;
    }
}
