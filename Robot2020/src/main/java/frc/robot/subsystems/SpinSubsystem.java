package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpinConstants;

public class SpinSubsystem extends SubsystemBase {

    private final VictorSPX m_motor = new VictorSPX(SpinConstants.kMotorPort);

    public SpinSubsystem() {
        m_motor.setInverted(SpinConstants.kInversion);
    }

    public void spin() {
        m_motor.set(ControlMode.PercentOutput, SpinConstants.kSpeed);
    }

    public void stopSpin() {
        m_motor.set(ControlMode.PercentOutput, 0);
    }
}
