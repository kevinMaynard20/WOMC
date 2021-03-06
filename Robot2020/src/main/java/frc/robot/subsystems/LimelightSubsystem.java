package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {

    private final NetworkTable m_limelightTable = NetworkTableInstance.getDefault().getTable("limelight");;
    private boolean isTargetVisible;
    private double xAngle, yAngle;

    public LimelightSubsystem() {
    }

    public void periodic() {
        isTargetVisible = m_limelightTable.getEntry("tv").getDouble(0) == 1;
        xAngle = m_limelightTable.getEntry("tx").getDouble(0);
        yAngle = m_limelightTable.getEntry("ty").getDouble(0);
    }

    public boolean isTargetVisible() {
        return isTargetVisible;
    }

    public double getXAngle() {
        return xAngle;
    }

    public double getYAngle() {
        return yAngle;
    }

    public void turnOnLight() {
        m_limelightTable.getEntry("ledmode").setNumber(1);
    }

    public void turnOffLight() {
        m_limelightTable.getEntry("ledmode").setNumber(0);
    }
}