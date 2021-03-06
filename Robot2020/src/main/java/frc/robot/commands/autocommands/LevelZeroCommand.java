package frc.robot.commands.autocommands;

import java.util.List;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class LevelZeroCommand extends SequentialCommandGroup {

        public LevelZeroCommand(DriveSubsystem driveSubsystem) {
                Trajectory forward = TrajectoryGenerator.generateTrajectory(new Pose2d(0, 0, new Rotation2d(0)),
                                List.of(), new Pose2d(1, 0, new Rotation2d(0)),
                                DriveConstants.kTrajectoryConfig);
                Command forwardCommand = new RamseteCommand(forward, driveSubsystem::getPose, new RamseteController(),
                                DriveConstants.kFeedForward, DriveConstants.kDriveKinematics,
                                driveSubsystem::getWheelSpeeds, new PIDController(DriveConstants.kPDriveVel, 0, 0),
                                new PIDController(DriveConstants.kPDriveVel, 0, 0), driveSubsystem::tankDriveVolts,
                                driveSubsystem).andThen(() -> driveSubsystem.tankDriveVolts(0, 0));
                addCommands(forwardCommand);
        }
}