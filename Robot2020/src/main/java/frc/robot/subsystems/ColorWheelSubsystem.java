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
import frc.robot.Constants.ColorWheelConstants;

/**
 * Add your docs here.
 */
public class ColorWheelSubsystem extends SubsystemBase  {
    private final DoubleSolenoid m_colorPiston = new DoubleSolenoid(ColorWheelConstants.kForwardChannel,
            ColorWheelConstants.kReverseChannel);
    private final VictorSPX m_motor = new VictorSPX(ColorWheelConstants.kMotorPort);

    public ColorWheelSubsystem() {
        m_motor.setInverted(ColorWheelConstants.kInversion);
    }
    public void extend(){
        m_colorPiston.set(Value.kForward);
    }
    public void retract(){
        m_colorPiston.set(Value.kReverse);
    }
    public void spin(Double speed){
        m_motor.set(ControlMode.PercentOutput, speed);
    }
}
