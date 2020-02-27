package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    private final VictorSPX m_motor = new VictorSPX(IntakeConstants.kMotorPort);

    public IntakeSubsystem() {
        m_motor.setInverted(IntakeConstants.kInvert);
        m_motor.setNeutralMode(NeutralMode.Brake);
    }

    public void run(double speed) {
        m_motor.set(ControlMode.PercentOutput, speed);
    }

    public void stop() {
        m_motor.set(ControlMode.PercentOutput, 0);
    }
}
