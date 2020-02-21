package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

public final class Constants {
    public static final class BarSlideConstants {
        public static final boolean kInversion = false;
        public static final int kMotorPort = 0;
        public static final double kSlideSpeed = 0;
    }

    public static final class ClimberConstants {
        public static final boolean kExtendInversion = false;
        public static final int kExtendPort = 0;
        public static final double kExtendSpeed = 0;
        public static final boolean kRetractInversion = false;
        public static final int kRetractPort = 0;
        public static final double kRetractSpeed = 0;
    }

    public static final class ControllerConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        public static final double kDeadzone = 0.1;
    }

    public static final class ColorWheelConstants {
        public static final int kForwardChannel = 0;
        public static final int kReverseChannel = 0;
        public static final int kMotorPort = 0;
        public static final boolean kInversion = false;
    }

    public static final class DriveConstants {
        public static final int kMasterLeftPort = 10;
        public static final InvertType kMasterLeftInvert = InvertType.None;
        public static final int kFollowerLeftPort = 9;
        public static final InvertType kFollowerLeftInvert = InvertType.None;

        public static final int kMasterRightPort = 4;
        public static final InvertType kMasterRightInvert = InvertType.None;
        public static final int kFollowerRightPort = 3;
        public static final InvertType kFollowerRightInvert = InvertType.None;
    }

    public static final class HopperConstants {
        public static final int kDoorForwardPort = 0;
        public static final int kDoorReversePort = 1;
        public static final int kBasketForwardPort = 2;
        public static final int kBasketReversePort = 3;
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
}
