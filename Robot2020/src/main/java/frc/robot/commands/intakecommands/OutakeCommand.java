package frc.robot.commands.intakecommands;



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class OutakeCommand extends CommandBase {
  private final IntakeSubsystem m_intakeSubsystem;
 
  public OutakeCommand(IntakeSubsystem intakeSubsystem) {
    m_intakeSubsystem = intakeSubsystem;
   
    addRequirements(m_intakeSubsystem);
  }

  public void initialize() {
    m_intakeSubsystem.run(-1);
}

  public void end(boolean interrputed) {
    m_intakeSubsystem.run(0);
  }

}