package frc.robot.commands.autocommands;

import java.util.List;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.armcommands.LowerArmCommand;
import frc.robot.commands.armcommands.RaiseArmCommand;
import frc.robot.commands.intakecommands.OuttakeCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class LevelZeroCommand extends SequentialCommandGroup {

    public LevelZeroCommand(DriveSubsystem driveSubsystem, ArmSubsystem armSubsystem, IntakeSubsystem intakeSubsystem) {
        Trajectory forward = TrajectoryGenerator.generateTrajectory(new Pose2d(0, 0, new Rotation2d(0)), List.of(),
                new Pose2d(3, 0, new Rotation2d(0)), DriveConstants.kTrajectoryConfig);
        Command forwardCommand = new RamseteCommand(forward, driveSubsystem::getPose, new RamseteController(),
                DriveConstants.kFeedForward, DriveConstants.kDriveKinematics, driveSubsystem::getWheelSpeeds,
                new PIDController(DriveConstants.kPDriveVel, 0, 0), new PIDController(DriveConstants.kPDriveVel, 0, 0),
                driveSubsystem::tankDriveVolts, driveSubsystem).andThen(() -> driveSubsystem.tankDriveVolts(0, 0));
        addCommands(new LowerArmCommand(armSubsystem), new RaiseArmCommand(armSubsystem), forwardCommand,
                new ParallelRaceGroup(new OuttakeCommand(intakeSubsystem), new WaitCommand(3)));
    }
}