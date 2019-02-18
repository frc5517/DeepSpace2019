package frc.robot.utilities;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TalonDebug {

    public static void printSrxClosedLoopValues(TalonSRX talonSrx) {
        printSrxClosedLoopValues(talonSrx, null);
    }

    public static void printSrxClosedLoopValues(TalonSRX talonSrx, String name) {
        System.out.println(
            (name == null ? "" : "[" + name + "] ") +
            "[ID" + talonSrx.getDeviceID() + "]: " + 
            " Voltage = " + talonSrx.getMotorOutputVoltage() +
            " Sensor Pos = " + talonSrx.getSelectedSensorPosition() +
            " Target = " + talonSrx.getClosedLoopTarget() +
            " Error = " + talonSrx.getClosedLoopError() +
            " Error Derivative = " + talonSrx.getErrorDerivative() +
            " Integral Accumulator = " + talonSrx.getIntegralAccumulator()
        );
    }

}