package org.jmhsrobotics.offseason2022.subsystems.winch;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface WinchIO {
    public static class WinchHardwareOutputs implements LoggableInputs {
        public double positionRot = 0;
        public boolean atRearLimit = false;
        public boolean climberSensor = false; // TODO: Rename
        public double velocityRPM = 0.0;
        public double appliedDutyCycle = 0.0;
        public double[] currentAmps = new double[] {};
        public double[] tempCelcius = new double[] {};

        public void toLog(LogTable table) {
            table.put("PositionRot", positionRot);
            table.put("AtRearLimit", atRearLimit);
            table.put("ClimberSensor", climberSensor);
            table.put("VelocityRPM", velocityRPM);
            table.put("AppliedDutyCycle", appliedDutyCycle);
            table.put("CurrentAmps", currentAmps);
            table.put("TempCelcius", tempCelcius);

        }

        public void fromLog(LogTable table) {
            positionRot = table.getDouble("PositionRot", positionRot);
            atRearLimit = table.getBoolean("AtRearLimit", atRearLimit);
            climberSensor = table.getBoolean("ClimberSensor", climberSensor);
            velocityRPM = table.getDouble("VelocityRPM", velocityRPM);
            appliedDutyCycle = table.getDouble("AppliedDutyCycle", appliedDutyCycle);
            currentAmps = table.getDoubleArray("CurrentAmps", currentAmps);
            tempCelcius = table.getDoubleArray("TempCelcius", tempCelcius);

        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(WinchHardwareOutputs outputs);

    public void set(double speed);

    public void setEncoderPostion(double rotations); //TODO: Decide if we want to handle this at a IO layer or a layer up

}
