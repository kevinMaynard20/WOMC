/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climbcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class RetractCommand extends CommandBase {
  /**OpenDoorCommand
   * Creates a new LowerTruckCommand.
   */
  private final ClimberSubsystem m_climberSubsystem;
  public RetractCommand(ClimberSubsystem climberSubsystem) {
    m_climberSubsystem = climberSubsystem;
    addRequirements(climberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      m_climberSubsystem.retract();
  }

  public void end(boolean interrputed){
    m_climberSubsystem.stop();
  }
}