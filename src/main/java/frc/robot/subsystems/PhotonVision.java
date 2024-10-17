// package frc.robot.subsystems;

// import java.util.List;
// import java.util.Optional;

// import org.photonvision.EstimatedRobotPose;
// import org.photonvision.PhotonCamera;
// import org.photonvision.PhotonPoseEstimator;
// import org.photonvision.PhotonPoseEstimator.PoseStrategy;
// import org.photonvision.targeting.PhotonTrackedTarget;

// import edu.wpi.first.apriltag.AprilTagFieldLayout;
// import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

// // 5409: The Chargers
// // http://github.com/FRC5409

// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.kPhotonVision;
// import frc.robot.Constants.kPhotonVision.kCameras;

// public class PhotonVision extends SubsystemBase {

//     private static PhotonVision instance = null;

//     // Objects
//     PhotonCamera camFront, camTop, camRear;
//     AprilTagFieldLayout aprilTagLayout;
//     PhotonPoseEstimator poseEstFront, poseEstTop, poseEstRear;

//     // Values
//     private boolean camFrontEnabled, camTopEnabled, camRearEnabled;
//     private double calibrationTrapDistance;
//     private double lastRespFront, lastRespTop, lastRespRear;

//     // Shuffleboard
//     private ShuffleboardTab sb_photonvisionDebug, sb_driveTeam;

//     private PhotonVision() {
        
//         // Objects
//         try {
//                 aprilTagLayout = AprilTagFieldLayout.loadFromResource(kPhotonVision.APRILTAG_LAYOUT);
//         } catch (Exception ignored) {}

//         camFront = new PhotonCamera(kCameras.CAMERA_FRONT_ID);
//         poseEstFront = new PhotonPoseEstimator(
//             aprilTagLayout,
//             PoseStrategy.MULTI_TAG_PNP_ON_COPROCESSOR,
//             camFront,
//             kCameras.CAMERA_FRONT_OFFSET
//         );

//         camTop = new PhotonCamera(kCameras.CAMERA_TOP_ID);
//         poseEstTop = new PhotonPoseEstimator(
//             aprilTagLayout,
//             PoseStrategy.MULTI_TAG_PNP_ON_COPROCESSOR,
//             camTop,
//             kCameras.CAMERA_TOP_OFFSET
//         );

//         camRear = new PhotonCamera(kCameras.CAMERA_REAR_ID);
//         poseEstRear = new PhotonPoseEstimator(
//             aprilTagLayout,
//             PoseStrategy.MULTI_TAG_PNP_ON_COPROCESSOR,
//             camRear,
//             kCameras.CAMERA_REAR_OFFSET
//         );

//         // Values
//         camFrontEnabled = kCameras.CAMERA_FRONT_ENABLED;
//         camTopEnabled = kCameras.CAMERA_TOP_EABLED;
//         camRearEnabled = kCameras.CAMERA_REAR_ENABLED;

//         calibrationTrapDistance = kPhotonVision.CALIBRATION_DISTANCE_TO_TRAP;

//         // Shuffleboard
//         sb_driveTeam = Shuffleboard.getTab("Drive Team");
//         sb_driveTeam.addBoolean("Front Camera Connected?", () -> camFront.isConnected()).withPosition(3, 0);
//         sb_driveTeam.addBoolean("Top Camera Connected?", () -> camTop.isConnected()).withPosition(3, 1);
//         sb_driveTeam.addBoolean("Rear Camera Connected?", () -> camRear.isConnected()).withPosition(4, 1);

//         sb_photonvisionDebug = Shuffleboard.getTab("Photonvision Debug");
//         sb_photonvisionDebug.addBoolean("Front Camera Enabled?", () -> camFrontEnabled).withPosition(3, 0);
//         sb_photonvisionDebug.addBoolean("Top Camera Enabled?", () -> camTopEnabled).withPosition(3, 1);
//         sb_photonvisionDebug.addBoolean("Rear Camera Enabled?", () -> camRearEnabled).withPosition(4, 1);
//     }

//     // Get subsystem
//     public static PhotonVision getInstance() {
//         if (instance == null) instance = new PhotonVision();

//         return instance;
//     }

//     /**
//      * Returns whether all AprilTag targets are within an accepted range
//      * @param targets
//      * @param threshold
//      * @return True if yes to all, false if any are outside of range
//      */
//     public boolean areTargetsWithinRange(List<PhotonTrackedTarget> targets, double range) {
//         for (PhotonTrackedTarget target : targets) {
//             if (target.getPoseAmbiguity() >= range) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     /**
//      * Return a pose estimate if camera is connected
//      * @param currentPose
//      * @param camera
//      * @param poseEstimator
//      * @param isEnabled
//      * @return Pose estimate if exists, else null
//      */
//     private Optional<EstimatedRobotPose> getUpdatedPoseEstimator(
//         SwerveDrivePoseEstimator currentPose,
//         PhotonCamera camera,
//         PhotonPoseEstimator poseEstimator,
//         boolean isEnabled
//     ) {
//         if (camera.isConnected()) {
//             Optional<EstimatedRobotPose> photonData = poseEstimator.update();

//             if (
//                 photonData.isPresent() &&
//                 areTargetsWithinRange(photonData.get().targetsUsed, kPhotonVision.TARGET_MAX_RANGE) &&
//                 isEnabled
//             ) {
//                 return photonData;
//             }
//         }
//         return Optional.empty();
//     }

//     /**
//      * Get an Optional of the robot position based on AprilTags.
//      * 
//      * @return An Optional EstimatedRobotPose. If AprilTag layout didn't load, returns null
//      */
//     public Optional<EstimatedRobotPose> getEstimatedGlobalPose(SwerveDrivePoseEstimator currentPose) {
//         Optional<EstimatedRobotPose>[] poseEstimates = new Optional[3];
//         poseEstimates[0] = getUpdatedPoseEstimator(currentPose, camFront, poseEstFront, camFrontEnabled);
//         poseEstimates[1] = getUpdatedPoseEstimator(currentPose, camTop, poseEstTop, camTopEnabled);
//         poseEstimates[2] = getUpdatedPoseEstimator(currentPose, camRear, poseEstRear, camRearEnabled);

//         // set things
//         boolean foundMultiTagReading = false;
//         double lowestRange = 1;
//         Optional<EstimatedRobotPose> poseEstimateOut = Optional.empty();

//         // iterate through things
//         for (Optional<EstimatedRobotPose> poseEstimate : poseEstimates) {
            
//         }
//     }

//     @Override
//     public void periodic() {
//         // This method will be called once per scheduler run
        
//     }

//     @Override
//     public void simulationPeriodic() {
//         // This method will be called once per scheduler run during simulation
        
//     }

// }