

TODOs:

- ~~Settle on naming Convention/Lint~~
- Install Spotless
- Figure out how we want to pass controls into commands (Providers or a gobal controlBoard class)
- Move core package to different repo
- Decide if we keep the reverse domain package convention with jmhsrobotics.org
- Figure out the structure for unit tests
- ~~Fine tune git ignore~~
- Think hard into how dependant subsystems would pass data/be structured together.
- Fix log output directory not working in sim
- Find a way to switch between replay mode and Sim realtime mode without code changes
- Decide on naming scheme for motor contolers vice ports (Front left right right) voice left folower left leader 

Cons:
- This Framework prevents the use of Motor controlers within classes like DifferentalDriveTrain This may end up being an issue for sqwerve
- IO layers for sensors may be a pain for getting data out for things like the navx on the drivetrain. IE you have to get the sensor data from the drivetrain for the system to work also within sim.


Ideas:
- Should we just build IO layers for sensor and hardware interfaces vice at a subsystem level? IE MotorcontrolerIO and have the thing extend a motor controler or sparkmax for backwards compatability?
- Plugin/addon to create subsystem boilerplates?


Rename Class names and input/out //TODO: we may want to undo this. Talk to students later and try to gauge the response
- 


https://github.com/team401/2022-Robot-Logged --Same IO structure
https://github.com/Mechanical-Advantage/RobotCode2022 --Creator of advantage kit
https://github.com/team581/frc-2022-rapid-react/ --Sorta Same IO structure
https://github.com/jonahsnider/LoggingDevelopment -- Fork of logging dev repo
https://github.com/hopkinstechnocrats/Robot2022/
https://github.com/team4099/RapidReact-2022

Framework rewrite by blair robot project
https://github.com/blair-robot-project/framework2022
http://team449.shoutwiki.com/wiki/Information_hiding


List of all public repos with advantage kit:
https://github.com/search?p=1&q=d820cc26-74e3-11ec-90d6-0242ac120003&type=Code
Seems like 13 other repos exist right now. (Pretty cutting edge/new)


Software Training
https://github.com/technocrats-programming-training/technocrats-programming-training.github.io/blob/main/summer2021/part1schedule.md
https://github.com/TexasTorque/TorqueLearn


Notes: Having a different hardware interface for simulation is kinda bad because it means that there is no way to test out
the hardware layer in simulation. It also makes it way harder to write unit tests for hardware as wpi's documentation assumes 
that you are simulated Sim devices.

One Fix to this may be to extend a physical Hardware IO layer and add a simulation periodic that sets values using the simulation device api
This would also cause glass to record outputs within simulation tab as well.
For this to work well we would have to develop a library to add wpi simulation support to fully emulate a spark max.



Notes:
Plugins we may want to have students install: Java extention pack and Test Runner for Java

After Release:
Per Robot/IO pin assighments


Levels of testing:
Unit tests:
- Test utility classes and helper methods on their own.
- Test Subsystems and verifiy robot works as intended
- Simulate whole robot and test all control inputs?
- Simulate whole robot while running though a log file, then validate the log??

Preflight checks:
- Hardware Checks. Attempt to use the sensors on the robot to validate that all hardware is functional.
- Functionality/software checks?? Make sure drivers can control the robot. (Im not sure we need any formal code outside of a checklist for the students)

## Progress
Subystem Status Skelton and IO Done and implmeneted:
- [X] winch
- [X] Turret
- [ ] Inake
- [ ] flywheels
- [ ] firingPins
- [ ] Drive
- [ ] Climber Arms
- [ ] LEDs

Subsystem Simulations:
Subystem Status Skelton and IO Done and implmeneted:
- [ ] winch
- [ ] Turret
- [ ] Inake
- [ ] flywheels
- [ ] firingPins
- [ ] Drive
- [ ] Climber Arms
- [ ] LEDs

# Project Units:
All sensor outputs should follow the following style when defining base units.

Distance: Meters
Power: Watts
Current: Amps
Rotational Position: Rotations -- TODO: may want to change to Radians
Rotation Velocity: RPM --TODO: May want to change to Rads per second
Temprature: Celcius


# Can bus notes:
https://www.hi-im.kim/canbus