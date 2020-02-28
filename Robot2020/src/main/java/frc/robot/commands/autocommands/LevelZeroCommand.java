package frc.robot.commands.autocommands;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class LevelZeroCommand extends SequentialCommandGroup {

    public LevelZeroCommand(DriveSubsystem driveSubsystem) {
        // Generate trajectories that will be strung into auto commands before putting
        // them onto shuffleboard to be selected
        String trajectoryJSON = "paths/LevelZeroLowGoal.wpilib.json";
        CommandBase levelOne = null;
        try {
            Path trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
            Trajectory trajectory = TrajectoryUtil.fromPathweaverJson(trajectoryPath);
            levelOne = new TrajectoryFollow(driveSubsystem, trajectory);
        } catch (IOException ex) {
            Shuffleboard.getTab("Errors").add("Trajectory Error", ex.getStackTrace().toString()).withSize(4, 4)
                    .withPosition(0, 0).withWidget(BuiltInWidgets.kTextView);
        }
        addCommands(levelOne);
    }
}