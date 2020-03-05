package frc.robot.commands.drivecommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends CommandBase {
	private final DriveSubsystem m_driveSubsystem;
	private final Supplier<Double> m_speedForward, m_speedReverse, m_speedRot, m_slowerRot;
	private final boolean m_slow;
	private double m_quickStopThreshold = .2;
	private double m_quickStopAlpha = .1;
	private double m_quickStopAccumulator = 0;

	public ArcadeDriveCommand(DriveSubsystem driveSubsystem, Supplier<Double> speedForward,
			Supplier<Double> speedReverse, Supplier<Double> speedRot, Supplier<Double> slowerRot, boolean slow) {
		m_driveSubsystem = driveSubsystem;
		m_speedForward = speedForward;
		m_speedReverse = speedReverse;
		m_speedRot = speedRot;
		m_slowerRot = slowerRot;
		m_slow = slow;
		addRequirements(driveSubsystem);
	}

	public void execute() {
		double speedForward = Math.abs(m_speedForward.get()) > ControllerConstants.kTriggerDeadzone
				? m_speedForward.get()
				: 0;
		double speedReverse = Math.abs(m_speedReverse.get()) > ControllerConstants.kTriggerDeadzone
				? m_speedReverse.get()
				: 0;
		double speedStraight = speedForward - speedReverse;
		double speedRot = Math.abs(m_speedRot.get()) > ControllerConstants.kDeadzone
				? m_speedRot.get() * ControllerConstants.kFastMultiplier
				: 0;
		double slowerRot = Math.abs(m_slowerRot.get()) > ControllerConstants.kDeadzone
				? m_slowerRot.get() * ControllerConstants.kSlowMultiplier
				: 0;
		curvatureDrive(speedStraight, Math.abs(speedRot) > 0 ? speedRot : slowerRot,
				Math.abs(speedRot) > 0 || speedStraight == 0);
	}

	public void curvatureDrive(double xSpeed, double zRotation, boolean isQuickTurn) {
		xSpeed = MathUtil.clamp(xSpeed, -1.0, 1.0);
		zRotation = MathUtil.clamp(zRotation, -1.0, 1.0);

		double angularPower;
		boolean overPower;

		if (isQuickTurn) {
			if (Math.abs(xSpeed) < m_quickStopThreshold) {
				m_quickStopAccumulator = (1 - m_quickStopAlpha) * m_quickStopAccumulator
						+ m_quickStopAlpha * MathUtil.clamp(zRotation, -1.0, 1.0) * 2;
			}
			overPower = true;
			angularPower = zRotation;
		} else {
			overPower = false;
			angularPower = Math.abs(xSpeed) * zRotation - m_quickStopAccumulator;

			if (m_quickStopAccumulator > 1) {
				m_quickStopAccumulator -= 1;
			} else if (m_quickStopAccumulator < -1) {
				m_quickStopAccumulator += 1;
			} else {
				m_quickStopAccumulator = 0.0;
			}
		}

		double leftMotorOutput = xSpeed + angularPower;
		double rightMotorOutput = xSpeed - angularPower;

		// If rotation is overpowered, reduce both outputs to within acceptable range
		if (overPower) {
			if (leftMotorOutput > 1.0) {
				rightMotorOutput -= leftMotorOutput - 1.0;
				leftMotorOutput = 1.0;
			} else if (rightMotorOutput > 1.0) {
				leftMotorOutput -= rightMotorOutput - 1.0;
				rightMotorOutput = 1.0;
			} else if (leftMotorOutput < -1.0) {
				rightMotorOutput -= leftMotorOutput + 1.0;
				leftMotorOutput = -1.0;
			} else if (rightMotorOutput < -1.0) {
				leftMotorOutput -= rightMotorOutput + 1.0;
				rightMotorOutput = -1.0;
			}
		}
		double maxMagnitude = Math.max(Math.abs(leftMotorOutput), Math.abs(rightMotorOutput));
		if (maxMagnitude > 1.0) {
			leftMotorOutput /= maxMagnitude;
			rightMotorOutput /= maxMagnitude;
		}
		m_driveSubsystem.tankDrive(m_slow ? leftMotorOutput * DriveConstants.kSlowMultiplier : leftMotorOutput,
				m_slow ? rightMotorOutput * DriveConstants.kSlowMultiplier : rightMotorOutput);
	}

}