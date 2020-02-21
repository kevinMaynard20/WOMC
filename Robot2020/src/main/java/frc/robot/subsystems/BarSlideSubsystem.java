package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.BarSlideConstants;

/**
 * Add your docs here.
 */
public class BarSlideSubsystem extends SubsystemBase {
    private final VictorSPX m_motor = new VictorSPX(BarSlideConstants.kMotorPort);

    public BarSlideSubsystem() {
        m_motor.setInverted(BarSlideConstants.kInversion);
    }
    public void slideLeft(){
        m_motor.set(ControlMode.PercentOutput, BarSlideConstants.kSlideSpeed);
    }
    public void slideRight(){
        m_motor.set(ControlMode.PercentOutput, -BarSlideConstants.kSlideSpeed);
    }

    public void stop(){
        m_motor.set(ControlMode.PercentOutput, 0);
    }
    
}
