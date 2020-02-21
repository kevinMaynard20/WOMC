package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelSubsystem;

public class ExtendBarCommand extends CommandBase {

  private final ColorWheelSubsystem m_colorWheelSubsystem;

  public ExtendBarCommand(ColorWheelSubsystem colorWheelSubsystem) {
    m_colorWheelSubsystem = colorWheelSubsystem;
    addRequirements(colorWheelSubsystem);
  }

  public void initialize() {
    m_colorWheelSubsystem.extend();
  }

  public void end(boolean interruped) {
    m_colorWheelSubsystem.retract();
  }
}