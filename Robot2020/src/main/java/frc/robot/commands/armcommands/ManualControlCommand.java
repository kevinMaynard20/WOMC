package frc.robot.commands.armcommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;


public class ManualControlCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;
    private Supplier<Double> m_speed;

    public ManualControlCommand(ArmSubsystem armSubsystem, Supplier<Double> speed) {
        m_armSubsystem = armSubsystem;
        m_speed = speed;
        addRequirements(armSubsystem);
    }

    public void execute() {
        m_armSubsystem.override(m_speed.get());
    }
    
}