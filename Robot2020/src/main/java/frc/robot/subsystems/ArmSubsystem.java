package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private final VictorSPX m_motor = new VictorSPX(ArmConstants.kMotorPort);

    public ArmSubsystem() {
        m_motor.setInverted(ArmConstants.kInvert);
        m_motor.setNeutralMode(NeutralMode.Brake);
    }

    public void setPercentOutput(double speed) {
        m_motor.set(ControlMode.PercentOutput, speed);
    }
}
