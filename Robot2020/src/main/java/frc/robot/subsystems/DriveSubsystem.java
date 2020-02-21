package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

    private final WPI_VictorSPX m_masterLeft = new WPI_VictorSPX(DriveConstants.kMasterLeftPort);
    private final WPI_VictorSPX m_followerLeft = new WPI_VictorSPX(DriveConstants.kFollowerLeftPort);
    private final WPI_VictorSPX m_masterRight = new WPI_VictorSPX(DriveConstants.kMasterRightPort);
    private final WPI_VictorSPX m_followerRight = new WPI_VictorSPX(DriveConstants.kFollowerRightPort);

    /**
     * Initializes a new instance of the {@link DriveSubsystem} class.
     */
    public DriveSubsystem() {
        m_masterLeft.setInverted(DriveConstants.kMasterLeftInvert);
        m_followerLeft.setInverted(DriveConstants.kFollowerLeftInvert);
        m_followerLeft.follow(m_masterLeft);

        m_masterRight.setInverted(DriveConstants.kMasterRightInvert);
        m_followerRight.setInverted(DriveConstants.kFollowerRightInvert);
        m_followerRight.follow(m_masterRight);
    }

    /**
     * @param straight Straight percent output
     * @param left     Left percent output
     * @param right    Right percent output
     */
    public void arcadeDrive(double straight, double left, double right) {
        tankDrive(straight - left + right, straight + left - right);
    }

    /**
     * @param leftSpeed  Left motors percent output
     * @param rightSpeed Right motors percent output
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_masterLeft.set(leftSpeed);
        m_masterRight.set(rightSpeed);
        m_masterLeft.feed();
        m_masterRight.feed();
    }
}
