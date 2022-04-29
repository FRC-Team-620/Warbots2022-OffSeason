package org.jmhsrobotics.offseason2022.subsystems.flywheels;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface FlywheelsIO {
    public static class FlywheelsHardwareOutputs implements LoggableInputs {
        public double leftFlywheelRPM = 0.0;
        public double rightFlywheelRPM = 0.0;

        public void toLog(LogTable table) {
            table.put("LeftFlywheelRPM", leftFlywheelRPM);
            table.put("RightFlywheelRPM", rightFlywheelRPM);
        }

        public void fromLog(LogTable table) {
            leftFlywheelRPM = table.getDouble("LeftFlywheelRPM", leftFlywheelRPM);
            rightFlywheelRPM = table.getDouble("RightFlywheelRPM", rightFlywheelRPM);
        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(FlywheelsHardwareOutputs outputs);

    public void setRPM(double rpm);

    public void set(double speed);
}
