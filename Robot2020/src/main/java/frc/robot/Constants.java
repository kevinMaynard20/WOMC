package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;

public final class Constants {
    public static final int kPCMID = 50;

    public static final class ArmConstants {
        public static final int kMotorPort = 6;
        public static final boolean kInvert = false;
        public static final double kP = 0;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final TrapezoidProfile.Constraints kConstraint = new TrapezoidProfile.Constraints(3, 3);
    }

    public static final class ClimberConstants {
        public static final boolean kExtendInversion = false;
        public static final int kExtendPort = 5;
        public static final boolean kRetractInversion = false;
        public static final int kRetractPort = 2;
        // Change the values below to vary speed climbing and retracting, from 0-1 with
        // 0 not moving at all
        public static final double kExtendSpeed = 1;
        public static final double kRetractSpeed = 1;
    }

    public static final class ColorWheelConstants {
        public static final int kForwardChannel = 4;
        public static final int kReverseChannel = 5;
    }

    public static final class ControllerConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        public static final double kDeadzone = 0.15;
        public static final double kTriggerDeadzone = .05;
        // Change the values below to vary the turning sensitivity, from 0-1 with 0 not
        // moving at all
        public static final double kSlowMultiplier = .2;
        public static final double kFastMultiplier = .8;

        public static final class Button {
            public static final int kBumperLeft = 5;
            public static final int kBumperRight = 6;
            public static final int kStickLeft = 9;
            public static final int kStickRight = 10;
            public static final int kA = 1;
            public static final int kB = 2;
            public static final int kX = 3;
            public static final int kY = 4;
            public static final int kBack = 7;
            public static final int kStart = 8;
        }
    }

    public static final class CrabConstants {
        public static final boolean kInversion = true;
        public static final int kMotorPort = 8;
        // Change the value below to vary crabbing speed, from 0-1 with 0 not moving at
        // all
        public static final double kSlideSpeed = .5;
    }

    public static final class DriveConstants {
        public static final int kMasterLeftPort = 3;
        public static final InvertType kMasterLeftInvert = InvertType.None;
        public static final int kFollowerLeftPort = 10;
        public static final InvertType kFollowerLeftInvert = InvertType.None;

        public static final int kMasterRightPort = 7;
        public static final InvertType kMasterRightInvert = InvertType.InvertMotorOutput;
        public static final int kFollowerRightPort = 9;
        public static final InvertType kFollowerRightInvert = InvertType.InvertMotorOutput;

        public static final SPI.Port kGyroPort = SPI.Port.kMXP;
        public static final boolean kGyroReversed = true;

        public static final double ksVolts = .77;
        public static final double kvVoltSecondsPerMeter = 5.84;
        public static final double kaVoltSecondsSquaredPerMeter = .627;
        public static final double kPDriveVel = 1.69;
        public static final double kTrackwidthMeters = 0.713288;
        public static final double kMaxSpeedMetersPerSecond = 2;
        public static final double kMaxAccelerationMetersPerSecondSquared = .6;
        public static final double kMaxRotSpeedMetersPerSecond = 2;
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = .7;
        public static final double kWheelDiameterMeters = .1524;
        public static final double kEncoderEdgesPerRotation = 4106;

        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
                kTrackwidthMeters);
        public static final SimpleMotorFeedforward kFeedForward = new SimpleMotorFeedforward(DriveConstants.ksVolts,
                DriveConstants.kvVoltSecondsPerMeter, DriveConstants.kaVoltSecondsSquaredPerMeter);
        public static final DifferentialDriveVoltageConstraint kVoltageConstraint = new DifferentialDriveVoltageConstraint(
                DriveConstants.kFeedForward, DriveConstants.kDriveKinematics, 10);
        public static final TrajectoryConfig kTrajectoryConfig = new TrajectoryConfig(
                DriveConstants.kMaxSpeedMetersPerSecond, DriveConstants.kMaxAccelerationMetersPerSecondSquared)
                        .setKinematics(DriveConstants.kDriveKinematics)
                        .addConstraint(DriveConstants.kVoltageConstraint);

    }

    public static final class IntakeConstants {
        public static final int kMotorPort = 4;
        public static final boolean kInvert = false;
    }

    public static final class LimelightConstants {
        public static final double kDisP = .016;
        public static final double kDisI = 0;
        public static final double kDisD = 0;
        public static final double kTurnP = 0.022;
        public static final double kTurnI = 0.00001;
        public static final double kTurnD = 0;
        public static final double kTurnTolerance = .1;
        public static final double kDistanceTolerance = .1;
        public static final double kCameraHeight = 27.6;
        public static final double kCameraAngle = 18.43;
        public static final double kTargetHeight = 89.75;
    }

    public static final class SpinConstants {
        public static final int kMotorPort = 1;
        public static final boolean kInversion = false;
        // Change the value below to vary the control panel motor speed, from 0-1 with 0
        // not moving at all
        public static final double kSpeed = 1;
    }
}
