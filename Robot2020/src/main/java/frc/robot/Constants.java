/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
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

    }

    public static final class HopperConstants {

    }
}
