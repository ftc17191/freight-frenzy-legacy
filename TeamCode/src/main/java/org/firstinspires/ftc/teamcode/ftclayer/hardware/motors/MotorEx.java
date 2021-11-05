package org.firstinspires.ftc.teamcode.ftclayer.hardware.motors;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftclayer.hardware.motors.motorinfo.MotorInfo;

public class MotorEx {
    public DcMotorEx motor;


    // basic constructors, just sets motor, to well a motor
    public MotorEx(HardwareMap map, String id)
    {
        motor = map.get(DcMotorEx.class, id);
    }

    public MotorEx(DcMotorEx dcmotor)
    {
        motor = dcmotor;
    }

    // gets rpm then calculates it using motorinfo class
    public void setMotorVelocityRPM(double rpm, MotorInfo motorinfo)
    {
        setMotorRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setVelocity((motorinfo.getEncoder_ticks_per_rotation() * rpm ) / 60);
    }

    public void setMotorVelocityTPM(double tpm)
    {
        setMotorRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setVelocity(tpm / 60);
    }

    // checks if already set instead of calling the sdk which takes abt 50 ms
    public void setMotorRunMode(DcMotor.RunMode mode)
    {
        if (motor.getMode() != mode)
        {
            motor.setMode(mode);
        }
    }

    // checks runmoide like above
    public void setMotorPower(double power)
    {
        setMotorRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setPower(power);
    }
}
