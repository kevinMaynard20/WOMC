package frc.robot.commands.armcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.Constants.ArmConstants;

public class RaiseArmCommand extends CommandBase {
    private final ArmSubsystem m_armSubsystem;

    public RaiseArmCommand(ArmSubsystem armSubsystem) {
        m_armSubsystem = armSubsystem;

        addRequirements(armSubsystem);
    }

    public void initialize() {
        m_armSubsystem.setPosition(ArmConstants.kUpperArmSetPoint);
    }
    
    public void end(boolean interrputed) {
        //?
      }
}