package org.jmhsrobotics.offseason2022.subsystems.turret;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface TurretIO {
    public static class TurretHardwareOutputs implements LoggableInputs {
        private double rotationDegrees = 0;
        private boolean isCalibrationSwitch = false;

        public void toLog(LogTable table) {
            // table.put("IntakeRPM", intakeRPM);
            // table.put("InnerIntakeRPM", innerIntakeRPM);
            // table.put("IntakeSwitch", intakeSwitch);
        }

        public void fromLog(LogTable table) {
            // intakeRPM = table.getDouble("IntakeRPM", intakeRPM);
            // innerIntakeRPM = table.getDouble("InnerIntakeRPM", innerIntakeRPM);
            // intakeSwitch = table.getBoolean("IntakeSwitch", intakeSwitch);
        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(TurretHardwareOutputs outputs);

    public void set(double speed);

    public void setSetpoint(double degrees);

    public void setPID(double kP, double kI, double kD);

    public void setMaxIntegrator(double maxI);

}
