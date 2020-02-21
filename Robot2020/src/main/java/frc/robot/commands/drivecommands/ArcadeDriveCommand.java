package frc.robot.commands.drivecommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends CommandBase {
	private final DriveSubsystem m_driveSubsystem;
	private final Supplier<Double> m_speedStraight, m_speedRot, m_slowerRot;

	public ArcadeDriveCommand(DriveSubsystem driveSubsystem, Supplier<Double> speedStraight, Supplier<Double> speedRot,
			Supplier<Double> slowerRot) {
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
		m_driveSubsystem.arcadeDrive(speedStraight, speedRot);
	}
}