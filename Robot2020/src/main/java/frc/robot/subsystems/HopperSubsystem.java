package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.HopperConstants;

public class HopperSubsystem extends CommandBase {
    private final DoubleSolenoid m_door = new DoubleSolenoid(HopperConstants.kDoorForwardPort,
            HopperConstants.kDoorReversePort);
    private final DoubleSolenoid m_basket = new DoubleSolenoid(HopperConstants.kBasketForwardPort,
            HopperConstants.kBasketReversePort);

    public HopperSubsystem() {
    }

    public void raiseBasket() {
        m_basket.set(Value.kForward);
    }

    public void lowerBasket() {
        m_basket.set(Value.kReverse);
    }

    public void openDoor() {
        m_door.set(Value.kForward);
    }

    public void closeDoor() {
        m_door.set(Value.kReverse);
    }
}
