package frc.robot.commands.armcommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.ArmSubsystem;

public class ManualArmCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;
    private final Supplier<Double> m_speed;

    public ManualArmCommand(ArmSubsystem armSubsystem, Supplier<Double> speed) {
        m_armSubsystem = armSubsystem;
        m_speed = speed;
        addRequirements(armSubsystem);
    }

    public void execute() {
        m_armSubsystem.setPercentOutput(Math.abs(m_speed.get()) > ControllerConstants.kDeadzone ? m_speed.get() : 0);
    }

    public void end(boolean interrputed) {
        m_armSubsystem.setPercentOutput(0);
    }
}