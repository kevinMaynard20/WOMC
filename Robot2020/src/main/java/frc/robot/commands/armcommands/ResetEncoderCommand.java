package frc.robot.commands.armcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;


public class ResetEncoderCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;

    public ResetEncoderCommand(ArmSubsystem armSubsystem) {
        m_armSubsystem = armSubsystem;

        addRequirements(armSubsystem);
    }

    public void initialize() {
        m_armSubsystem.resetEncoder();;
    }
    
    public void end(boolean interrputed) {
        //?
      }
}