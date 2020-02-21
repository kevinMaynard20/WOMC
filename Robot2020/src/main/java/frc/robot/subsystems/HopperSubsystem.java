package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.HopperConstants;

public class HopperSubsystem extends SubsystemBase {
    private final DoubleSolenoid m_basket = new DoubleSolenoid(Constants.kPCMID, HopperConstants.kForwardPort,
            HopperConstants.kReversePort);

    public HopperSubsystem() {
    }

    public void raiseBasket() {
        m_basket.set(Value.kForward);
    }

    public void lowerBasket() {
        m_basket.set(Value.kReverse);
    }

}
