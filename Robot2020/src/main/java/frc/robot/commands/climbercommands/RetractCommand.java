package frc.robot.commands.climbercommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class RetractCommand extends CommandBase {
  private final ClimberSubsystem m_climberSubsystem;

  public RetractCommand(ClimberSubsystem climberSubsystem) {
    m_climberSubsystem = climberSubsystem;
    addRequirements(climberSubsystem);
  }

  public void initialize() {
    m_climberSubsystem.retract();
  }

  public void end(boolean interrputed) {
    m_climberSubsystem.stopRetract();
  }
}