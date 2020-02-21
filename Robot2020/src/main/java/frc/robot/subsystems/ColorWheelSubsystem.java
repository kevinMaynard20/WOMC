package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ColorWheelConstants;

/**
 * Add your docs here.
 */
public class ColorWheelSubsystem extends SubsystemBase  {
    private final DoubleSolenoid m_colorPiston = new DoubleSolenoid(50, ColorWheelConstants.kForwardChannel,
            ColorWheelConstants.kReverseChannel);

    public ColorWheelSubsystem() {
    }
    public void extend(){
        m_colorPiston.set(Value.kForward);
    }
    public void retract(){
        m_colorPiston.set(Value.kReverse);
    }
}
