package org.firstinspires.ftc.teamcode.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.robot.vision.Camera;
import org.firstinspires.ftc.teamcode.robot.vision.CameraPipeline;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvWebcam;

@Autonomous(name = "Vision Test")
@Config
public class VisionTest extends LinearOpMode {
    private Camera webcam;
    private TelemetryPacket packet;

    @Override
    public void runOpMode() throws InterruptedException {
        webcam = new Camera(hardwareMap);
        //FtcDashboard dashboard = FtcDashboard.getInstance();
        //dashboard.setTelemetryTransmissionInterval(25);
        //packet = new TelemetryPacket();

        waitForStart();
        while (opModeIsActive()){
            webcam.detect();
            telemetry.addData("Analysis 1:", webcam.getAverage1());
            telemetry.addData("Analysis 2:", webcam.getAverage2());
            //telemetry.addData("Analysis 3:", webcam.getAverage3());

            telemetry.update();
        }
    }
}
