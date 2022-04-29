package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface IDrivetrainIO {
    /** The set of loggable inputs for the drive subsystem. */
    public static class DrivetrainHardwareOutputs implements LoggableInputs {
        public double leftPositionMeters = 0.0; 
        public double rightPositionMeters = 0.0;
        public double yawDegrees = 0.0;

        public void toLog(LogTable table) {
            table.put("LeftPositionMeters", leftPositionMeters); //TODO: Find a way to automate this process? Annotations or reflection??? 
            table.put("RightPositionMeters", rightPositionMeters);
            table.put("YawDegrees",yawDegrees );
        }

        public void fromLog(LogTable table) {
            leftPositionMeters = table.getDouble("LeftPositionMeters", leftPositionMeters);
            rightPositionMeters = table.getDouble("RightPositionMeters", rightPositionMeters);
            yawDegrees = table.getDouble("YawDegrees", yawDegrees);
        }
    }

    /** Updates the set of loggable inputs. */
    public void updateHardwareOutputs(DrivetrainHardwareOutputs outputs);

    public void set(double leftpercent, double rightprecent);
    /** Enable or disable brake mode. */
    public void setBrakeMode(boolean enable);

}
