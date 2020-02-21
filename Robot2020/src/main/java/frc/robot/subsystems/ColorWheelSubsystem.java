package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ColorWheelConstants;

public class ColorWheelSubsystem extends SubsystemBase {
    private final DoubleSolenoid m_solenoid = new DoubleSolenoid(Constants.kPCMID, ColorWheelConstants.kForwardChannel,
            ColorWheelConstants.kReverseChannel);

    public ColorWheelSubsystem() {
    }

    public void extend() {
        m_solenoid.set(Value.kForward);
    }

    public void retract() {
        m_solenoid.set(Value.kReverse);
    }
}
