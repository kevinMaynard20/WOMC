package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.ControllerConstants.Button;
import frc.robot.commands.climbercommands.ExtendCommand;
import frc.robot.commands.climbercommands.RetractCommand;
import frc.robot.commands.colorwheelcommands.ExtendBarCommand;
import frc.robot.commands.colorwheelcommands.SpinCommand;
import frc.robot.commands.crabcommands.SlideLeftCommand;
import frc.robot.commands.crabcommands.SlideRightCommand;
import frc.robot.commands.doorcommands.OpenDoorCommand;
import frc.robot.commands.drivecommands.ArcadeDriveCommand;
import frc.robot.commands.hoppercommands.RaiseBasketCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.CrabSubsystem;
import frc.robot.subsystems.DoorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.SpinSubsystem;

public class RobotContainer {
  // Subsystems
  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  private final ColorWheelSubsystem m_colorWheelSubsystem = new ColorWheelSubsystem();
  private final CrabSubsystem m_crabSubsystem = new CrabSubsystem();
  private final DoorSubsystem m_doorSubsystem = new DoorSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final HopperSubsystem m_hopperSubsystem = new HopperSubsystem();
  private final LimelightSubsystem m_limelightSubsystem = new LimelightSubsystem();
  private final SpinSubsystem m_spinSubsystem = new SpinSubsystem();
  private final Compressor m_compressor = new Compressor(Constants.kPCMID);

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
    new JoystickButton(m_driverController, Button.kBumperLeft).whenHeld(new SlideLeftCommand(m_crabSubsystem));
    new JoystickButton(m_driverController, Button.kBumperRight).whenHeld(new SlideRightCommand(m_crabSubsystem));

    // Operator
    new JoystickButton(m_operatorController, Button.kX).toggleWhenPressed(new RaiseBasketCommand(m_hopperSubsystem));
    new JoystickButton(m_operatorController, Button.kA).toggleWhenPressed(new OpenDoorCommand(m_doorSubsystem));

    new JoystickButton(m_operatorController, Button.kBumperLeft).whenHeld(new ExtendCommand(m_climberSubsystem));
    new JoystickButton(m_operatorController, Button.kBumperRight).whenHeld(new RetractCommand(m_climberSubsystem));

    new JoystickButton(m_operatorController, Button.kY).toggleWhenPressed(new ExtendBarCommand(m_colorWheelSubsystem));
    new JoystickButton(m_operatorController, Button.kB).whenHeld(new SpinCommand(m_spinSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
