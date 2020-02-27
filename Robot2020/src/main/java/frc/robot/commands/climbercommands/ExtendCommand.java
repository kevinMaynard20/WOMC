package frc.robot.commands.climbercommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimberConstants;
import frc.robot.subsystems.ClimberSubsystem;

public class ExtendCommand extends CommandBase {
  private final ClimberSubsystem m_climberSubsystem;

  public ExtendCommand(ClimberSubsystem climberSubsystem) {
    m_climberSubsystem = climberSubsystem;
    addRequirements(climberSubsystem);
  }

  public void initialize() {
    m_climberSubsystem.extend(ClimberConstants.kExtendSpeed);
  }

  public void end(boolean interrputed) {
    m_climberSubsystem.stopExtend();
  }
}