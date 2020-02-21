package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinSubsystem;

public class SpinCommand extends CommandBase {

  private final SpinSubsystem m_spinSubsystem;

  public SpinCommand(SpinSubsystem spinSubsystem) {
    m_spinSubsystem = spinSubsystem;
    addRequirements(spinSubsystem);
  }

  public void execute() {
    m_spinSubsystem.spin();
  }

  public void end(boolean interruped) {
    m_spinSubsystem.stopSpin();
  }

}