package frc.robot.commands.armcommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
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
        double speed = Math.abs(m_speed.get()) > ControllerConstants.kDeadzone ? m_speed.get() : 0;
        System.out.println(speed);
        m_armSubsystem.override(speed);
    }

}