package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DoorConstants;

public class DoorSubsystem extends SubsystemBase {
    private final DoubleSolenoid m_door = new DoubleSolenoid(Constants.kPCMID, DoorConstants.kForwardPort,
            DoorConstants.kReversePort);

    public DoorSubsystem() {
    }

    public void openDoor() {
        m_door.set(Value.kForward);
    }

    public void closeDoor() {
        m_door.set(Value.kReverse);
    }
}
