package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveControllerConfiguration;
import swervelib.parser.SwerveDriveConfiguration;

// 5409: The Chargers
// http://github.com/FRC5409

public class Drivetrain extends SwerveDrive implements Subsystem {

    public Drivetrain(SwerveDriveConfiguration config, SwerveControllerConfiguration controllerConfig, double maxSpeedMPS) {
        super(config, controllerConfig, maxSpeedMPS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
        
    }

}