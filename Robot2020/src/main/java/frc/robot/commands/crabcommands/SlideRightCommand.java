package frc.robot.commands.crabcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.CrabConstants;
import frc.robot.subsystems.CrabSubsystem;

public class SlideRightCommand extends CommandBase {

  private final CrabSubsystem m_crabSubsystem;

  public SlideRightCommand(CrabSubsystem crabSubsystem) {
    m_crabSubsystem = crabSubsystem;
    addRequirements(crabSubsystem);
  }

  public void execute() {
    m_crabSubsystem.slide(-CrabConstants.kSlideSpeed);
  }

  public void end(boolean interrupted) {
    m_crabSubsystem.stop();
  }

}