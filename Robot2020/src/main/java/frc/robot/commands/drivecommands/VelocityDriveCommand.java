package frc.robot.commands.drivecommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class VelocityDriveCommand extends CommandBase {
    private final DriveSubsystem m_driveSubsystem;
    private final Supplier<Double> m_speedStraight, m_speedRot, m_slowerRot;

    public VelocityDriveCommand(DriveSubsystem driveSubsystem, Supplier<Double> speedStraight,
            Supplier<Double> speedRot, Supplier<Double> slowerRot) {
        m_driveSubsystem = driveSubsystem;
        m_speedStraight = speedStraight;
        m_speedRot = speedRot;
        m_slowerRot = slowerRot;
        addRequirements(driveSubsystem);
    }

    public void execute() {
        double speedStraight = Math.abs(m_speedStraight.get()) > ControllerConstants.kDeadzone ? m_speedStraight.get()
                : 0;
        double speedRot = Math.abs(m_speedRot.get()) > ControllerConstants.kTriggerDeadzone
                ? m_speedRot.get() * ControllerConstants.kFastMultiplier
                : Math.abs(m_slowerRot.get()) > ControllerConstants.kTriggerDeadzone
                        ? m_slowerRot.get() * ControllerConstants.kSlowMultiplier
                        : 0;

        DifferentialDriveWheelSpeeds wheelSpeeds = DriveConstants.kDriveKinematics
                .toWheelSpeeds(new ChassisSpeeds(speedStraight * DriveConstants.kMaxSpeedMetersPerSecond, 0,
                        speedRot * DriveConstants.kMaxRotSpeedMetersPerSecond));

        // Use the feedforward to calculate motor voltages to achieve desired wheel
        // speeds
        double leftVoltage = DriveConstants.kFeedForward.calculate(wheelSpeeds.leftMetersPerSecond);
        double rightVoltage = DriveConstants.kFeedForward.calculate(wheelSpeeds.rightMetersPerSecond);
        m_driveSubsystem.tankDriveVolts(leftVoltage, rightVoltage);
    }
}