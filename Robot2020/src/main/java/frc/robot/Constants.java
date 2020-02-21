package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

public final class Constants {
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
    
    public static final class HopperConstants{
        public static final int kDoorForwardPort = 0;
        public static final int kDoorReversePort = 1;
        public static final int kBasketForwardPort = 2;
        public static final int kBasketDoorReversePort = 3;
    }

}
