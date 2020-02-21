/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climbcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BarSlideSubsystem;

public class SlideRightCommand extends CommandBase {
  /**
   * OpenDoorCommand Creates a new LowerTruckCommand.
   */
  private final BarSlideSubsystem m_barSlideSubsystem;

  public SlideRightCommand(BarSlideSubsystem barSlideSubsystem) {
    m_barSlideSubsystem = barSlideSubsystem;
    addRequirements(barSlideSubsystem);
  }

  public void execute() {
    m_barSlideSubsystem.slideRight();
  }

  public void end(boolean interrupted) {
    m_barSlideSubsystem.stop();
  }
}