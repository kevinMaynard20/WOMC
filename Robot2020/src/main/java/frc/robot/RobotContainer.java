package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.ControllerConstants.Button;
import frc.robot.commands.climbcommands.ExtendCommand;
import frc.robot.commands.climbcommands.RetractCommand;
import frc.robot.commands.climbcommands.SlideLeftCommand;
import frc.robot.commands.climbcommands.SlideRightCommand;
import frc.robot.commands.colorwheelcommands.ExtendBarCommand;
import frc.robot.commands.colorwheelcommands.SpinCommand;
import frc.robot.commands.drivecommands.ArcadeDriveCommand;
import frc.robot.commands.hoppercommands.OpenDoorCommand;
import frc.robot.commands.hoppercommands.RaiseBasketCommand;
import frc.robot.subsystems.BarSlideSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.SpinSubsystem;

public class RobotContainer {
  // Subsystems
  private final BarSlideSubsystem m_barSlideSubsystem = new BarSlideSubsystem();
  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  private final ColorWheelSubsystem m_colorWheelSubsystem = new ColorWheelSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final HopperSubsystem m_hopperSubsystem = new HopperSubsystem();
  private final LimelightSubsystem m_limelightSubsystem = new LimelightSubsystem();
  private final SpinSubsystem m_spinSubsystem = new SpinSubsystem();
  private final Compressor m_compressor = new Compressor(50);

  // Controllers
  private final XboxController m_driverController = new XboxController(ControllerConstants.kDriverControllerPort);
  private final XboxController m_operatorController = new XboxController(ControllerConstants.kOperatorControllerPort);

  public RobotContainer() {
    m_compressor.start();
    configureButtonBindings();

    m_driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(m_driveSubsystem,
        () -> m_driverController.getTriggerAxis(Hand.kRight) - m_driverController.getTriggerAxis(Hand.kLeft),
        () -> m_driverController.getX(Hand.kLeft), () -> m_driverController.getX(Hand.kRight)));
  }

  private void configureButtonBindings() {
    // Driver
    new JoystickButton(m_driverController, Button.kBumperLeft).whenHeld(new SlideLeftCommand(m_barSlideSubsystem));
    new JoystickButton(m_driverController, Button.kBumperRight).whenHeld(new SlideRightCommand(m_barSlideSubsystem));

    // Operator
    new JoystickButton(m_operatorController, Button.kX).toggleWhenPressed(new RaiseBasketCommand(m_hopperSubsystem));
    new JoystickButton(m_operatorController, Button.kA).toggleWhenPressed(new OpenDoorCommand(m_hopperSubsystem));

    new JoystickButton(m_operatorController, Button.kBumperLeft).whenHeld(new ExtendCommand(m_climberSubsystem));
    new JoystickButton(m_operatorController, Button.kBumperRight).whenHeld(new RetractCommand(m_climberSubsystem));

    new JoystickButton(m_operatorController, Button.kY).toggleWhenPressed(new ExtendBarCommand(m_colorWheelSubsystem));
    new JoystickButton(m_operatorController, Button.kB).whenHeld(new SpinCommand(m_spinSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
