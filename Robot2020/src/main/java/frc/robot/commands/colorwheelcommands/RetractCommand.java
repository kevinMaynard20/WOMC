/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;

public class RetractCommand extends CommandBase {
  /**OpenDoorCommand
   * Creates a new LowerTruckCommand.
   */
  private final ColorWheelSubsystem m_colorWheelSubsystem;
  public RetractCommand(ColorWheelSubsystem colorWheelSubsystem) {
    m_colorWheelSubsystem = colorWheelSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      m_colorWheelSubsystem.retract();
  }

  
}