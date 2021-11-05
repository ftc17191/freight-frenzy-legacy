package org.firstinspires.ftc.teamcode.ftclayer.drivetrain.mechanum;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftclayer.hardware.motors.MotorEx;

@Disabled
public class Mechanum
{
    public MotorEx fr_motor;
    public MotorEx fl_motor;
    public MotorEx br_motor;
    public MotorEx bl_motor;

    private DcMotor.RunMode runmode;

    public Mechanum(
            DcMotorEx front_right_motor,
            DcMotorEx front_left_motor,
            DcMotorEx back_right_motor,
            DcMotorEx back_left_motor)
    {
        fr_motor = new MotorEx(front_right_motor);
        fl_motor = new MotorEx(front_left_motor);
        br_motor = new MotorEx(back_right_motor);
        bl_motor = new MotorEx(back_left_motor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public Mechanum(
            HardwareMap map,
            String front_right_motor,
            String front_left_motor,
            String back_right_motor,
            String back_left_motor)
    {
        
        fr_motor = new MotorEx(map, front_right_motor);
        fl_motor = new MotorEx(map, front_left_motor);
        br_motor = new MotorEx(map, back_right_motor);
        bl_motor = new MotorEx(map, back_left_motor);
        setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    // Sets motor drivetrain
    private void setRunMode(DcMotor.RunMode mode)
    {
        fr_motor.motor.setMode(mode);
        fl_motor.motor.setMode(mode);
        br_motor.motor.setMode(mode);
        bl_motor.motor.setMode(mode);
        runmode = mode;
    }


    public void powerDrive(double forwardPower, double strafePower, double turningPower)
    {
        fr_motor.motor.setPower(forwardPower - strafePower - turningPower);
        fl_motor.motor.setPower(-forwardPower - strafePower - turningPower);
        br_motor.motor.setPower(forwardPower + strafePower - turningPower);
        bl_motor.motor.setPower(-forwardPower + strafePower - turningPower);
    }

}
