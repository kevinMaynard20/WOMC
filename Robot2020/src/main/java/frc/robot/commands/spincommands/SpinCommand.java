package frc.robot.commands.spincommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.SpinConstants;
import frc.robot.subsystems.SpinSubsystem;

public class SpinCommand extends CommandBase {
    private final SpinSubsystem m_spinSubsystem;
    private final boolean m_slow;

    public SpinCommand(SpinSubsystem spinSubsystem, boolean slow) {
        m_spinSubsystem = spinSubsystem;
        m_slow = slow;
        addRequirements(spinSubsystem);
    }

    public void initialize() {
        m_spinSubsystem.spin(m_slow ? SpinConstants.kSlowSpeed : SpinConstants.kSpeed);
    }

    public void end(boolean interruped) {
        m_spinSubsystem.stopSpin();
    }
}