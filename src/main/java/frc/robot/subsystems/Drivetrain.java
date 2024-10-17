package frc.robot.subsystems;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.Subsystem;
import swervelib.SwerveDrive;
import swervelib.SwerveModule;
import swervelib.parser.SwerveControllerConfiguration;
import swervelib.parser.SwerveDriveConfiguration;

// 5409: The Chargers
// http://github.com/FRC5409

public class Drivetrain extends SwerveDrive implements Subsystem {

    // Subsystems
    // private final PhotonVision sys_photonvision;
    private final Limelight sys_limelight;

    // Shuffleboard & sim
    private final Field2d m_field;
    private final ShuffleboardTab sb_drivetrainDebug;

    private final SwerveDrivePoseEstimator m_poseEstimator;

    public Drivetrain(SwerveDriveConfiguration config, SwerveControllerConfiguration controllerConfig, double maxSpeedMPS) {
        super(config, controllerConfig, maxSpeedMPS);

        m_poseEstimator = this.swerveDrivePoseEstimator;

        // Subsystems
        // sys_photonvision = PhotonVision.getInstance();
        sys_limelight = Limelight.getInstance();

        // Shuffleboard & sim
        m_field = new Field2d();
        sb_drivetrainDebug = Shuffleboard.getTab("Drivetrain Debug");
        sb_drivetrainDebug.add("Field", m_field).withPosition(0, 0).withSize(5, 3);

        setDriveMotorBrakeMode(true);
        setAngleMotorBrakeMode(true);
    }

    /**
     * Set all drive Spark Flex to either coast or brake
     * @param isBrakeMode True if setting brake, false if coast
     */
    public void setDriveMotorBrakeMode(boolean isBrakeMode) {
        for (SwerveModule module : getModules()) {
            module.getDriveMotor().setMotorBrake(isBrakeMode);
        }
    }

    /**
     * Set all angle Spark Flex to either coast or brake
     * @param isBrakeMode True if setting brake, false if coast
     */
    public void setAngleMotorBrakeMode(boolean isBrakeMode) {
        for (SwerveModule module : getModules()) {
            module.getAngleMotor().setMotorBrake(isBrakeMode);
        }
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