package org.jmhsrobotics.offseason2022.subsystems.intake;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface IntakeIO {
    public static class IntakeHardwareOutputs implements LoggableInputs {
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
    public void updateHardwareOutputs(IntakeHardwareOutputs outputs);

    public void extendIntake();

    public void retractIntake();

    public void floatIntake();

    public void setIntakeMotor(double speed);

    public void setInnerIntakeMotor(double speed);
}
