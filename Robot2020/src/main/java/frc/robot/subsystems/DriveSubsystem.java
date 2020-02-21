package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
    private final WPI_VictorSPX m_masterLeft = new WPI_VictorSPX(DriveConstants.kMasterLeftPort);
    private final WPI_VictorSPX m_followerLeft = new WPI_VictorSPX(DriveConstants.kFollowerLeftPort);
    private final WPI_VictorSPX m_masterRight = new WPI_VictorSPX(DriveConstants.kMasterRightPort);
    private final WPI_VictorSPX m_followerRight = new WPI_VictorSPX(DriveConstants.kFollowerRightPort);

    public DriveSubsystem() {
        m_masterLeft.setInverted(DriveConstants.kMasterLeftInvert);
        m_masterLeft.setNeutralMode(NeutralMode.Brake);
        m_followerLeft.setInverted(DriveConstants.kFollowerLeftInvert);
        m_followerLeft.setNeutralMode(NeutralMode.Brake);
        m_followerLeft.follow(m_masterLeft);

        m_masterRight.setInverted(DriveConstants.kMasterRightInvert);
        m_masterRight.setNeutralMode(NeutralMode.Brake);
        m_followerRight.setInverted(DriveConstants.kFollowerRightInvert);
        m_followerRight.setNeutralMode(NeutralMode.Brake);
        m_followerRight.follow(m_masterRight);
    }

    public void arcadeDrive(double straight, double rot) {
        tankDrive(straight + rot, straight - rot);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        m_masterLeft.set(leftSpeed);
        m_masterRight.set(rightSpeed);
        m_masterLeft.feed();
        m_masterRight.feed();
    }
}
