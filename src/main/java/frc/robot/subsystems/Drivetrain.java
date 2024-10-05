package frc.robot.subsystems;

import java.io.File;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Subsystem;

// 5409: The Chargers
// http://github.com/FRC5409

import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

public class Drivetrain extends SwerveDrive implements Subsystem {

    private static Drivetrain instance = null;

    // YAGSL
    private final SwerveDrive swerve = new SwerveParser(new File(Filesystem.getDeployDirectory(), "swerve")).createSwerveDrive(4.56);

    private Drivetrain() {
        super();
    }

    // Get subsystem
    public static Drivetrain getInstance() {
        if (instance == null) instance = new Drivetrain();

        return instance;
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