/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
    
}
