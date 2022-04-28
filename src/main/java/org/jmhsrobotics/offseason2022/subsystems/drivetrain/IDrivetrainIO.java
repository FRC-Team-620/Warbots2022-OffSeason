package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface IDrivetrainIO {
    /** The set of loggable inputs for the drive subsystem. */
    public static class DrivetrainHardwareOutputs implements LoggableInputs {
        public double leftPosition = 0.0; // Meters
        public double rightPosition = 0.0;
        public double yaw = 0.0;
        // public C
        // public double leftVelocityRadPerSec = 0.0;
        // public double leftAppliedVolts = 0.0;
        // public double[] leftCurrentAmps = new double[] {};
        // public double[] leftTempCelcius = new double[] {};

        // public double rightPositionRad = 0.0;
        // public double rightVelocityRadPerSec = 0.0;
        // public double rightAppliedVolts = 0.0;
        // public double[] rightCurrentAmps = new double[] {};
        // public double[] rightTempCelcius = new double[] {};

        // public boolean externalAvailable = false;
        // public double externalLeftPositionRad = 0.0;
        // public double externalLeftVelocityRadPerSec = 0.0;
        // public double externalRightPositionRad = 0.0;
        // public double externalRightVelocityRadPerSec = 0.0;

        // public double gyroYawPositionRad = 0.0;
        // public double gyroYawVelocityRadPerSec = 0.0;
        // public double gyroPitchPositionRad = 0.0;
        // public double gyroRollPositionRad = 0.0;
        // public double gyroZAccelMetersPerSec2 = 0.0;

        public void toLog(LogTable table) {
            table.put("LeftPosition", leftPosition); //TODO: Find a way to automate this process? Annotations or reflection??? 
            table.put("RightPosition", rightPosition);
            table.put("Yaw",yaw );
            // table.put("LeftPositionRad", leftPositionRad);
            // table.put("LeftVelocityRadPerSec", leftVelocityRadPerSec);
            // table.put("LeftAppliedVolts", leftAppliedVolts);
            // table.put("LeftCurrentAmps", leftCurrentAmps);
            // table.put("LeftTempCelcius", leftTempCelcius);

            // table.put("RightPositionRad", rightPositionRad);
            // table.put("RightVelocityRadPerSec", rightVelocityRadPerSec);
            // table.put("RightAppliedVolts", rightAppliedVolts);
            // table.put("RightCurrentAmps", rightCurrentAmps);
            // table.put("RightTempCelcius", rightTempCelcius);

            // table.put("ExternalAvailable", externalAvailable);
            // table.put("ExternalLeftPositionRad", externalLeftPositionRad);
            // table.put("ExternalLeftVelocityRadPerSec", externalLeftVelocityRadPerSec);
            // table.put("ExternalRightPositionRad", externalRightPositionRad);
            // table.put("ExternalRightVelocityRadPerSec",
            //         externalRightVelocityRadPerSec);

            // table.put("GyroYawPositionRad", gyroYawPositionRad);
            // table.put("GyroYawVelocityRadPerSec", gyroYawVelocityRadPerSec);
            // table.put("GyroPitchPositionRad", gyroPitchPositionRad);
            // table.put("GyroRollPositionRad", gyroRollPositionRad);
            // table.put("GyroZAccelMetersPerSec2", gyroZAccelMetersPerSec2);
        }

        public void fromLog(LogTable table) {
            leftPosition = table.getDouble("LeftPosition", leftPosition);
            rightPosition = table.getDouble("RightPosition", rightPosition);
            yaw = table.getDouble("Yaw", yaw);
            // leftPositionRad = table.getDouble("LeftPositionRad", leftPositionRad);
            // leftVelocityRadPerSec = table.getDouble("LeftVelocityRadPerSec", leftVelocityRadPerSec);
            // leftAppliedVolts = table.getDouble("LeftAppliedVolts", leftAppliedVolts);
            // leftCurrentAmps = table.getDoubleArray("LeftCurrentAmps", leftCurrentAmps);
            // leftTempCelcius = table.getDoubleArray("LeftTempCelcius", leftTempCelcius);

            // rightPositionRad = table.getDouble("RightPositionRad", rightPositionRad);
            // rightVelocityRadPerSec = table.getDouble("RightVelocityRadPerSec", rightVelocityRadPerSec);
            // rightAppliedVolts = table.getDouble("RightAppliedVolts", rightAppliedVolts);
            // rightCurrentAmps = table.getDoubleArray("RightCurrentAmps", rightCurrentAmps);
            // rightTempCelcius = table.getDoubleArray("RightTempCelcius", rightTempCelcius);

            // externalAvailable = table.getBoolean("ExternalAvailable", externalAvailable);
            // externalLeftPositionRad = table.getDouble("ExternalLeftPositionRad", externalLeftPositionRad);
            // externalLeftVelocityRadPerSec = table.getDouble(
            //         "ExternalLeftVelocityRadPerSec", externalLeftVelocityRadPerSec);
            // externalRightPositionRad = table.getDouble("ExternalRightPositionRad", externalRightPositionRad);
            // externalRightVelocityRadPerSec = table.getDouble(
            //         "ExternalRightVelocityRadPerSec", externalRightVelocityRadPerSec);

            // gyroYawPositionRad = table.getDouble("GyroYawPositionRad", gyroYawPositionRad);
            // gyroYawVelocityRadPerSec = table.getDouble("GyroYawVelocityRadPerSec", gyroYawVelocityRadPerSec);
            // gyroPitchPositionRad = table.getDouble("GyroPitchPositionRad", gyroPitchPositionRad);
            // gyroRollPositionRad = table.getDouble("GyroRollPositionRad", gyroRollPositionRad);
            // gyroZAccelMetersPerSec2 = table.getDouble("GyroZAccelMetersPerSec2", gyroZAccelMetersPerSec2);
        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(DrivetrainHardwareOutputs outputs);

    public void set(double leftpercent, double rightprecent);
    /** Enable or disable brake mode. */
    public void setBrakeMode(boolean enable);

}
