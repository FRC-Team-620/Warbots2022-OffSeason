package org.jmhsrobotics.offseason2022.subsystems.intake;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface IntakeIO {
    public static class IntakeHardwareOutputs implements LoggableInputs {
        public boolean intakeSwitch = false;

        public double intakeVelocityRPM = 0.0;
        public double intakeAppliedDutyCycle = 0.0;

        public double innerIntakeVelocityRPM = 0.0;
        public double innerIntakeAppliedDutyCycle = 0.0;
        public double[] currentAmps = new double[] {}; // TODO: Look into if we should not have these in arrays
        public double[] tempCelcius = new double[] {};
        //TODO Add feedback for intake arm state/position

        public void toLog(LogTable table) {
            table.put("IntakeSwitch", intakeSwitch);
            table.put("IntakeVelocityRPM", intakeVelocityRPM);
            table.put("IntakeAppliedDutyCycle", intakeAppliedDutyCycle);
            table.put("InnerIntakeVelocityRPM", innerIntakeVelocityRPM);
            table.put("InnerIntakeAppliedDutyCycle", innerIntakeAppliedDutyCycle);
            table.put("CurrentAmps", currentAmps);
            table.put("TempCelcius", tempCelcius);
        }

        public void fromLog(LogTable table) {

            intakeSwitch = table.getBoolean("IntakeSwitch", intakeSwitch);
            intakeVelocityRPM = table.getDouble("IntakeVelocityRPM", intakeVelocityRPM);
            intakeAppliedDutyCycle = table.getDouble("IntakeAppliedDutyCycle", intakeAppliedDutyCycle);
            innerIntakeVelocityRPM = table.getDouble("InnerIntakeVelocityRPM", innerIntakeVelocityRPM);
            innerIntakeAppliedDutyCycle = table.getDouble("InnerIntakeAppliedDutyCycle", innerIntakeAppliedDutyCycle);
            currentAmps = table.getDoubleArray("CurrentAmps", currentAmps);
            tempCelcius = table.getDoubleArray("TempCelcius", tempCelcius);
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
