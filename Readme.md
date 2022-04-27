

TODOs:

- Settle on naming Convention/Lint
- Figure out how we want to pass controls into commands (Providers or a gobal controlBoard class)
- Move core package to different repo
- Decide if we keep the reverse domain package convention with jmhsrobotics.org
- Figure out the structure for unit tests
- Fine tune git ignore
- Think hard into how dependant subsystems would pass data/be structured together.
- Fix log output directory not working in sim
- Find a way to switch between replay mode and Sim realtime mode without code changes

Cons:
- This Framework prevents the use of Motor controlers within classes like DifferentalDriveTrain This may end up being an issue for sqwerve
- IO layers for sensors may be a pain for getting data out for things like the navx on the drivetrain. IE you have to get the sensor data from the drivetrain for the system to work also within sim.


Ideas:
- Should we just build IO layers for sensor and hardware interfaces vice at a subsystem level? IE MotorcontrolerIO and have the thing extend a motor controler or sparkmax for backwards compatability?