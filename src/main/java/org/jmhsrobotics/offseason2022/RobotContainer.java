// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.jmhsrobotics.offseason2022;


import org.jmhsrobotics.offseason2022.commands.drivetrain.OpenLoopDrive;
import org.jmhsrobotics.offseason2022.subsystems.drivetrain.DrivetrainIOSim;
import org.jmhsrobotics.offseason2022.subsystems.drivetrain.DrivetrainIOSparkMAX;
import org.jmhsrobotics.offseason2022.subsystems.drivetrain.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  DrivetrainSubsystem driveTrain;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    if(RobotBase.isReal()){
      driveTrain = new DrivetrainSubsystem(new DrivetrainIOSparkMAX());
    }else{
      driveTrain = new DrivetrainSubsystem(new DrivetrainIOSim());
    }


    driveTrain.setDefaultCommand(new OpenLoopDrive(driveTrain));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null; //TODO: Remove
  }
}
