package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.ControllerConstants.Button;
import frc.robot.commands.armcommands.LowerArmCommand;
import frc.robot.commands.armcommands.RaiseArmCommand;
import frc.robot.commands.autocommands.LevelZeroCommand;
import frc.robot.commands.climbercommands.ExtendCommand;
import frc.robot.commands.climbercommands.RetractCommand;
import frc.robot.commands.colorwheelcommands.ExtendBarCommand;
import frc.robot.commands.crabcommands.SlideLeftCommand;
import frc.robot.commands.crabcommands.SlideRightCommand;
import frc.robot.commands.drivecommands.ArcadeDriveCommand;
import frc.robot.commands.intakecommands.ManualIntakeCommand;
import frc.robot.commands.spincommands.SpinCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.CrabSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.SpinSubsystem;

public class RobotContainer {
  // Subsystems
  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  private final ColorWheelSubsystem m_colorWheelSubsystem = new ColorWheelSubsystem();
  private final CrabSubsystem m_crabSubsystem = new CrabSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final LimelightSubsystem m_limelightSubsystem = new LimelightSubsystem();
  private final SpinSubsystem m_spinSubsystem = new SpinSubsystem();
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final Compressor m_compressor = new Compressor(Constants.kPCMID);

  // Controllers
  private final XboxController m_driverController = new XboxController(ControllerConstants.kDriverControllerPort);
  private final XboxController m_operatorController = new XboxController(ControllerConstants.kOperatorControllerPort);

  // Auto chooser
  private final SendableChooser<Command> m_autoChooser = new SendableChooser<>();

  public RobotContainer() {
    m_compressor.start();
    configureButtonBindings();
    generateTrajectoryCommands();

    m_driveSubsystem.setDefaultCommand(new ArcadeDriveCommand(m_driveSubsystem,
        () -> m_driverController.getTriggerAxis(Hand.kRight) - m_driverController.getTriggerAxis(Hand.kLeft),
        () -> m_driverController.getX(Hand.kLeft), () -> m_driverController.getX(Hand.kRight), false));
  }

  private void configureButtonBindings() {
    // Driver
    // Drive fast or slow buttons
    new POVButton(m_driverController, 0).whenPressed(new ArcadeDriveCommand(m_driveSubsystem,
        () -> m_driverController.getTriggerAxis(Hand.kRight) - m_driverController.getTriggerAxis(Hand.kLeft),
        () -> m_driverController.getX(Hand.kLeft), () -> m_driverController.getX(Hand.kRight), false));

    new POVButton(m_driverController, 180).whenPressed(new ArcadeDriveCommand(m_driveSubsystem,
        () -> m_driverController.getTriggerAxis(Hand.kRight) - m_driverController.getTriggerAxis(Hand.kLeft),
        () -> m_driverController.getX(Hand.kLeft), () -> m_driverController.getX(Hand.kRight), true));

    new JoystickButton(m_driverController, Button.kBumperLeft).whenHeld(new SlideLeftCommand(m_crabSubsystem));
    new JoystickButton(m_driverController, Button.kBumperRight).whenHeld(new SlideRightCommand(m_crabSubsystem));

    // Operator
    new JoystickButton(m_operatorController, Button.kX).whenHeld(new RaiseArmCommand(m_armSubsystem));
    new JoystickButton(m_operatorController, Button.kA).whenHeld(new LowerArmCommand(m_armSubsystem));

    m_intakeSubsystem.setDefaultCommand(new ManualIntakeCommand(m_intakeSubsystem,
        () -> m_operatorController.getTriggerAxis(Hand.kRight), () -> m_operatorController.getTriggerAxis(Hand.kLeft)));
    new JoystickButton(m_operatorController, Button.kBumperLeft).whenHeld(new ExtendCommand(m_climberSubsystem));
    new JoystickButton(m_operatorController, Button.kBumperRight).whenHeld(new RetractCommand(m_climberSubsystem));
    new JoystickButton(m_operatorController, Button.kStickLeft)
        .toggleWhenPressed(new ExtendBarCommand(m_colorWheelSubsystem));
    new JoystickButton(m_operatorController, Button.kB).whenHeld(new SpinCommand(m_spinSubsystem, false));
    new JoystickButton(m_operatorController, Button.kY).whenHeld(new SpinCommand(m_spinSubsystem, true));
  }

  public Command getAutonomousCommand() {
    return m_autoChooser.getSelected();
  }

  private void generateTrajectoryCommands() {
    m_autoChooser.addOption("Level Zero", new LevelZeroCommand(m_driveSubsystem));
    SmartDashboard.putData(m_autoChooser);
  }
}
