package frc.robot.commands.armcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.Constants.ArmConstants;

public class LowerArmCommand extends CommandBase {
  private final ArmSubsystem m_armSubsystem;

  public LowerArmCommand(ArmSubsystem armSubsystem) {
    m_armSubsystem = armSubsystem;
    addRequirements(armSubsystem);
  }

  public void initialize() {
    m_armSubsystem.setPercentOutput(ArmConstants.kDownSpeed);
  }

  public void end(boolean interrputed) {
    m_armSubsystem.setPercentOutput(0);
  }

  public boolean isFinished() {
    return m_armSubsystem.atBottom();
  }
}