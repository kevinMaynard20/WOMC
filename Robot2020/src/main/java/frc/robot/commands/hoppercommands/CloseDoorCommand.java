package frc.robot.commands.hoppercommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;

public class CloseDoorCommand extends CommandBase{
    private final HopperSubsystem m_hopperSubsystem;

    public CloseDoorCommand(HopperSubsystem hopperSubsystem){
        m_hopperSubsystem = hopperSubsystem;
        addRequirements(hopperSubsystem);
    }

    public void initialize(){
        m_hopperSubsystem.closeDoor();
    }
}