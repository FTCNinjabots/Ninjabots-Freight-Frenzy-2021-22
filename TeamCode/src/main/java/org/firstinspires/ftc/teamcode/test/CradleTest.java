package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robot.Ninjabot;
@TeleOp(name = "Cradle Test")
public class CradleTest extends LinearOpMode {
    Ninjabot ninjabot;
    @Override
    public void runOpMode() throws InterruptedException {
        ninjabot = new Ninjabot(DcMotor.RunMode.RUN_USING_ENCODER, hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.left_bumper){
                ninjabot.cradle.closeGate();
            }
            else if (gamepad1.right_bumper){
                ninjabot.cradle.openGate();
            }
            if(gamepad1.a){
                ninjabot.cradle.incOpenPos(0.000005);
            }
            else if(gamepad1.b){
                ninjabot.cradle.decOpenPos(0.000005);
            }
            if(gamepad1.x){
                ninjabot.cradle.incClosePos(0.000005);
            }
            else if(gamepad1.y){
                ninjabot.cradle.decClosePos(0.000005);
            }
            telemetry.addData("Grasper Open: ",  ninjabot.cradle.GRASPER_OPEN);
            telemetry.addData("Grasper Close: ",  ninjabot.cradle.GRASPER_CLOSE);
            telemetry.addData("Current: ",  ninjabot.cradle.getGatePos());
            telemetry.update();

        }
    }
}