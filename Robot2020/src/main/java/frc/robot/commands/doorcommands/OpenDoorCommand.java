package frc.robot.commands.doorcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DoorSubsystem;

public class OpenDoorCommand extends CommandBase {
    private final DoorSubsystem m_doorSubsystem;

    public OpenDoorCommand(DoorSubsystem doorSubsystem) {
        m_doorSubsystem = doorSubsystem;
        addRequirements(doorSubsystem);
    }

    public void initialize() {
        m_doorSubsystem.openDoor();
    }

    public void end(boolean interruped) {
        m_doorSubsystem.closeDoor();
    }
}