package org.jmhsrobotics.offseason2022.subsystems.firingPins;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface FiringPinsIO {
    public static class FiringPinsHardwareOutputs implements LoggableInputs {
        // public double leftFlywheelRPM = 0.0;
        // public double rightFlywheelRPM = 0.0;

        public void toLog(LogTable table) {
            // table.put("LeftFlywheelRPM", leftFlywheelRPM);
            // table.put("RightFlywheelRPM", rightFlywheelRPM);
        }

        public void fromLog(LogTable table) {
            // leftFlywheelRPM = table.getDouble("LeftFlywheelRPM", leftFlywheelRPM);
            // rightFlywheelRPM = table.getDouble("RightFlywheelRPM", rightFlywheelRPM);
        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(FiringPinsHardwareOutputs outputs);


}
