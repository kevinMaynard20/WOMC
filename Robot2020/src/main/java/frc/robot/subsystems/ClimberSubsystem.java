package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase {
    private final VictorSPX m_extendMotor = new VictorSPX(ClimberConstants.kExtendPort);
    private final VictorSPX m_retractMotor = new VictorSPX(ClimberConstants.kRetractPort);

    public ClimberSubsystem() {
        m_extendMotor.setInverted(ClimberConstants.kExtendInversion);
        m_extendMotor.setNeutralMode(NeutralMode.Coast);

        m_retractMotor.setInverted(ClimberConstants.kRetractInversion);
        m_retractMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void extend(double speed) {
        m_extendMotor.set(ControlMode.PercentOutput, speed);
    }

    public void retract(double speed) {
        m_retractMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopExtend() {
        m_extendMotor.set(ControlMode.PercentOutput, 0);
    }

    public void stopRetract() {
        m_retractMotor.set(ControlMode.PercentOutput, 0);
    }
}
