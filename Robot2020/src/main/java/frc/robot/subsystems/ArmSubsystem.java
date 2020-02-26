package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private final VictorSPX m_motor = new VictorSPX(ArmConstants.kMotorPort);
    private final ProfiledPIDController m_pidController = new ProfiledPIDController(ArmConstants.kP, ArmConstants.kI,
            ArmConstants.kD, ArmConstants.kConstraint);

    public ArmSubsystem() {
        m_motor.setInverted(ArmConstants.kInvert);
        m_motor.setNeutralMode(NeutralMode.Brake);
    }

    public void periodic() {
        m_motor.set(ControlMode.PercentOutput, m_pidController.calculate(m_motor.getSelectedSensorPosition()));
    }

    public void setPosition(double setPoint) {
        m_pidController.setGoal(setPoint);
    }
    public void override(double speed){
        m_motor.set(ControlMode.PercentOutput, speed);
    }

    public void resetEncoder() {
        m_motor.setSelectedSensorPosition(0);
    }
}
