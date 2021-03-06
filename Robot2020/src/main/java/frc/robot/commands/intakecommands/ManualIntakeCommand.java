package frc.robot.commands.intakecommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.IntakeSubsystem;

public class ManualIntakeCommand extends CommandBase {
    private final IntakeSubsystem m_intakeSubsystem;
    private Supplier<Double> m_rightAxis;
    private Supplier<Double> m_leftAxis;

    public ManualIntakeCommand(IntakeSubsystem intakeSubsystem, Supplier<Double> rightAxis, Supplier<Double> leftAxis) {
        m_intakeSubsystem = intakeSubsystem;
        m_rightAxis = rightAxis;
        m_leftAxis = leftAxis;
        addRequirements(m_intakeSubsystem);
    }

    public void execute() {
        m_intakeSubsystem
                .run((Math.abs(m_rightAxis.get()) > ControllerConstants.kTriggerDeadzone ? m_rightAxis.get() : 0)
                        - (Math.abs(m_leftAxis.get()) > ControllerConstants.kTriggerDeadzone ? m_leftAxis.get() : 0));
    }

}