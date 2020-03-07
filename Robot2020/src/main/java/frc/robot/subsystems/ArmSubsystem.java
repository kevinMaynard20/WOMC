package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private final VictorSPX m_motor = new VictorSPX(ArmConstants.kMotorPort);
    private final DigitalInput m_topLimitSwitch = new DigitalInput(ArmConstants.kTopLimitSwitchPort);
    private final DigitalInput m_bottomLimitSwitch = new DigitalInput(ArmConstants.kBottomLimitSwitchPort);

    public ArmSubsystem() {
        m_motor.setInverted(ArmConstants.kInvert);
        m_motor.setNeutralMode(NeutralMode.Brake);
    }

    public void setPercentOutput(double speed) {
        if ((atTop() && speed > 0) || (atBottom() && speed < 0)) {
            speed = 0;
        }
        m_motor.set(ControlMode.PercentOutput, speed);
    }

    public boolean atTop() {
        return !m_topLimitSwitch.get();
    }

    public boolean atBottom() {
        return !m_bottomLimitSwitch.get();
    }
}
