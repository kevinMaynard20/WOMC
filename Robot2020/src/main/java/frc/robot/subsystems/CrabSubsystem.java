package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CrabConstants;

public class CrabSubsystem extends SubsystemBase {
    private final VictorSPX m_motor = new VictorSPX(CrabConstants.kMotorPort);

    public CrabSubsystem() {
        m_motor.setInverted(CrabConstants.kInversion);
        m_motor.setNeutralMode(NeutralMode.Brake);
    }

    public void slide(double speed) {
        m_motor.set(ControlMode.PercentOutput, speed);
    }

    public void stop() {
        m_motor.set(ControlMode.PercentOutput, 0);
    }
}
