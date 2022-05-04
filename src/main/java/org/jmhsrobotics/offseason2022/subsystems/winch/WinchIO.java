package org.jmhsrobotics.offseason2022.subsystems.winch;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface WinchIO {
    public static class WinchHardwareOutputs implements LoggableInputs {
        public double winchRotations = 0;
        public boolean atRearLimit = false;
        public boolean climberSensor = false; // TODO: Rename

        public void toLog(LogTable table) {
            table.put("WinchRotations", winchRotations);
            table.put("AtRearLimit", atRearLimit);
            table.put("ClimberSensor", climberSensor);

        }

        public void fromLog(LogTable table) {
            winchRotations = table.getDouble("WinchRotations", winchRotations);
            atRearLimit = table.getBoolean("AtRearLimit", atRearLimit);
            climberSensor = table.getBoolean("climberSensor", climberSensor);

        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(WinchHardwareOutputs outputs);


    public void set(double speed);

}
