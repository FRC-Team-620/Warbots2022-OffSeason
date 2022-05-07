package org.jmhsrobotics.offseason2022.subsystems.turret;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface TurretIO {
    public static class TurretHardwareOutputs implements LoggableInputs {
        public double rotationDegrees = 0;
        public boolean isCalibrationSwitch = false;
        public double velocityRPM = 0.0; // TODO: Change to DegreesPerSec or RadPerSec
        public double appliedDutyCycle = 0.0;
        public double[] currentAmps = new double[] {};
        public double[] tempCelcius = new double[] {};

        public void toLog(LogTable table) {
            table.put("RotationDegrees", rotationDegrees);
            table.put("IsCalibrationSwitch", isCalibrationSwitch);
            table.put("VelocityRPM", velocityRPM);
            table.put("AppliedDutyCycle", appliedDutyCycle);
            table.put("CurrentAmps", currentAmps);
            table.put("TempCelcius", tempCelcius);
        }

        public void fromLog(LogTable table) {
            rotationDegrees = table.getDouble("RotationDegrees", rotationDegrees);
            isCalibrationSwitch = table.getBoolean("IsCalibrationSwitch", isCalibrationSwitch);
            velocityRPM = table.getDouble("VelocityRPM", velocityRPM);
            appliedDutyCycle = table.getDouble("AppliedDutyCycle", appliedDutyCycle);
            currentAmps = table.getDoubleArray("CurrentAmps", currentAmps);
            tempCelcius = table.getDoubleArray("TempCelcius", tempCelcius);
        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(TurretHardwareOutputs outputs);

    public void set(double speed);

    public void setBrakeMode(boolean enable);

    public void setSetpoint(double degrees);

    public void setPID(double kP, double kI, double kD);

    public void setMaxIntegrator(double maxI);

    public void setEncoderPositionDegrees(double degrees);

}
