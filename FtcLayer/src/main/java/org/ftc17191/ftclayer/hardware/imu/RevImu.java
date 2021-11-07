package org.ftc17191.ftclayer.hardware.imu;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


public class RevImu {
    BNO055IMU imu;

    private double heading;

    public RevImu(HardwareMap hmap, String id)
    {
        imu = hmap.get(BNO055IMU.class, id);
    }

    public void init() {
        BNO055IMU.Parameters param = new BNO055IMU.Parameters();
        param.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        param.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        param.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        param.loggingEnabled = true;
        param.loggingTag = "IMU";
        param.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu.initialize(param);

        heading = 0;
    }

    public double getHeading()
    {
        heading = imu.getAngularOrientation().firstAngle;
        return heading;
    }
}
