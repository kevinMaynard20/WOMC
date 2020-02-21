/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ColorWheelConstants;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.SpinSubsystem;

public class SpinCommand extends CommandBase {
  /**OpenDoorCommand
   * Creates a new LowerTruckCommand.
   */
  private final SpinSubsystem m_spinSubsystem;
  public SpinCommand(SpinSubsystem colorWheelSubsystem) {
    m_spinSubsystem = colorWheelSubsystem;
    addRequirements(colorWheelSubsystem);
  }

  public void execute(){
    m_spinSubsystem.spin(ColorWheelConstants.kSpeed);
  }
  public void end(boolean interruped){
    m_spinSubsystem.spin(0.0);
  }
  
}