package org.jmhsrobotics.offseason2022.subsystems.climberArms;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface ClimberArmsIO {
    public static class ClimberArmsHardwareOutputs implements LoggableInputs {
        public double intakeRPM = 0.0;
        public double innerIntakeRPM = 0.0;
        public boolean intakeSwitch = false;

        public void toLog(LogTable table) {
            table.put("IntakeRPM", intakeRPM);
            table.put("InnerIntakeRPM", innerIntakeRPM);
            table.put("IntakeSwitch", intakeSwitch);
        }

        public void fromLog(LogTable table) {
            intakeRPM = table.getDouble("IntakeRPM", intakeRPM);
            innerIntakeRPM = table.getDouble("InnerIntakeRPM", innerIntakeRPM);
            intakeSwitch = table.getBoolean("IntakeSwitch", intakeSwitch);
        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(ClimberArmsHardwareOutputs outputs);

   
}
