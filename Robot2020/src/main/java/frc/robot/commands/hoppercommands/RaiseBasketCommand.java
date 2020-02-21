package frc.robot.commands.hoppercommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;

public class RaiseBasketCommand extends CommandBase {
    private final HopperSubsystem m_hopperSubsystem;

    public RaiseBasketCommand(HopperSubsystem hopperSubsystem) {
        m_hopperSubsystem = hopperSubsystem;
        addRequirements(hopperSubsystem);
    }

    public void initialize() {
        m_hopperSubsystem.raiseBasket();
    }

    public void end(boolean interruped){
        m_hopperSubsystem.lowerBasket();
    }
}