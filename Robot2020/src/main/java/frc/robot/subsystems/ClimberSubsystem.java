/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

/**
 * Add your docs here.
 */
public class ClimberSubsystem extends SubsystemBase {
    private final VictorSPX m_extendMotor = new VictorSPX(ClimberConstants.kExtendPort);
    private final VictorSPX m_retractMotor = new VictorSPX(ClimberConstants.kRetractPort);

    public ClimberSubsystem() {
        m_extendMotor.setInverted(ClimberConstants.kExtendInversion);
        m_retractMotor.setInverted(ClimberConstants.kRetractInversion);
    }

    public void extend() {
        m_extendMotor.set(ControlMode.PercentOutput, ClimberConstants.kExtendSpeed);
    }

    public void retract() {
        m_retractMotor.set(ControlMode.PercentOutput, ClimberConstants.kRetractSpeed);
    }

}
