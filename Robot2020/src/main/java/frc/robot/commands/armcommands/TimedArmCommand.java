package frc.robot.commands.armcommands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.Constants.ArmConstants;

public class TimedArmCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;
    private final Supplier<Double> m_speed;
    private int numIterations = 0;

    public TimedArmCommand(ArmSubsystem armSubsystem, Supplier<Double> speed) {
        m_armSubsystem = armSubsystem;
        m_speed = speed;
        addRequirements(armSubsystem);
    }

    public void initialize() {
        m_armSubsystem.setPercentOutput(m_speed.get());
    }

    public void execute() {
        numIterations++;
    }

    public boolean isFinished() {
        return numIterations >= ArmConstants.kAutoNumIterations;
    }
}