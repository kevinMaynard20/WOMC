package frc.robot.commands.intakecommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    private final IntakeSubsystem m_intakeSubsystem;

    public IntakeCommand(IntakeSubsystem intakeSubsystem) {
        m_intakeSubsystem = intakeSubsystem;
        addRequirements(m_intakeSubsystem);
    }

    public void initialize() {
        m_intakeSubsystem.run(0);
    }

    public void execute(double speed) {
        m_intakeSubsystem.run(speed);
    }

    public void end(boolean interrputed) {
        m_intakeSubsystem.run(0);
    }

}