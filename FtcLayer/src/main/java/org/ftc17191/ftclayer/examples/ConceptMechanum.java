/*
 *
 *
 * This opmode simply moves a mechanum drivetrain.
 *
 * To use this opmode, move the file to the team code folder.
 * then follow the instructions through out the file
 *
 *
 */



package org.ftc17191.ftclayer.examples; // Delete this line if using as an opmode

// Then remove the double slash at the start of the line below
// package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.ftc17191.ftclayer.drivetrain.mechanum.Mechanum;



@TeleOp(name="Concept Mechanum", group="Concept")
@Disabled // Remove this Line if using as an opmode
public class ConceptMechanum extends OpMode
{
    Mechanum train;

    @Override
    public void init() {
        train = new Mechanum(hardwareMap,
                "fr_motor",
                "fl_motor",
                "br_motor",
                "bl_motor");
        telemetry.addLine("Press Start to begin!");
        telemetry.update();
    }

    @Override
    public void loop() {
        train.powerDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        telemetry.addLine("Fr Motor Power: " + train.fr_motor.motor.getPower());
        telemetry.addLine("Fl Motor Power: " + train.fl_motor.motor.getPower());
        telemetry.addLine("Br Motor Power: " + train.br_motor.motor.getPower());
        telemetry.addLine("Bl Motor Power: " + train.bl_motor.motor.getPower());
        telemetry.update();
    }

}
