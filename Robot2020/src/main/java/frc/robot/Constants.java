package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

public final class Constants {
    public static final class BarSlideConstants {
        public static final boolean kInversion = true;
        public static final int kMotorPort = 8;
        public static final double kSlideSpeed = .5;
    }

    public static final class ClimberConstants {
        public static final boolean kExtendInversion = false;
        public static final int kExtendPort = 5;
        public static final double kExtendSpeed = 1;
        public static final boolean kRetractInversion = false;
        public static final int kRetractPort = 2;
        public static final double kRetractSpeed = 1;
    }

    public static final class ControllerConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        public static final double kDeadzone = 0.15;
        public static final double kTriggerDeadzone = .05;
        public static final double kSlowMultplier = .2;//Change this to be faster or slower. Value from 0-1 with 1 being full speed

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

    public static final class ColorWheelConstants {
        public static final int kForwardChannel = 4;
        public static final int kReverseChannel = 5;
        public static final int kMotorPort = 1;
        public static final boolean kInversion = false;
        public static final double kSpeed = 1;
    }

    public static final class DriveConstants {
        public static final int kMasterLeftPort = 4;
        public static final InvertType kMasterLeftInvert = InvertType.None;
        public static final int kFollowerLeftPort = 6;
        public static final InvertType kFollowerLeftInvert = InvertType.None;

        public static final int kMasterRightPort = 3;
        public static final InvertType kMasterRightInvert = InvertType.InvertMotorOutput;
        public static final int kFollowerRightPort = 7;
        public static final InvertType kFollowerRightInvert = InvertType.InvertMotorOutput;
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
