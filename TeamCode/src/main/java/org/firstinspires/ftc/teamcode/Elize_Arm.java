package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class Elize_Arm {
    private final Gamepad gamepad;
    private final HardwareMap hardwareMap;

    //servos
    private Servo base;
    private Servo big;
    private Servo small;
    private Servo claw;


    private double rotation = 0.5;
    private double clawPos = 0.6;
    private double bigServoPos = 0.725;
    private double smallServoPos = 0.175;

    public Elize_Arm(Gamepad gamepad, HardwareMap hardwareMap) {
        this.gamepad = gamepad;
        this.hardwareMap = hardwareMap;
    }

    public void init(){
        base = hardwareMap.get(Servo.class, "Ebase");
        //Forward is positive
        big = hardwareMap.get(Servo.class, "big");
        //Forward is negative
        small = hardwareMap.get(Servo.class, "small");
        //Forward is positive
        claw = hardwareMap.get(Servo.class, "SuperiorClaw");

        //initialize servos
        claw.setPosition(clawPos);
        base.setPosition(rotation);
        big.setPosition(bigServoPos);
        small.setPosition(smallServoPos);
    }

    public void run(){


        if(gamepad.x) {
            rotation -= 0.075;
        }

        if(gamepad.b) {
            rotation += 0.075;
        }

        if(gamepad.right_stick_y > 0.3) {
            bigServoPos += 0.075;
        }

        if(gamepad.right_stick_y < -0.3) {
            bigServoPos -= 0.075;
        }

        if(gamepad.left_stick_y > 0.3) {
            smallServoPos -= 0.075;
        }

        if(gamepad.left_stick_y < -0.3) {
            smallServoPos += 0.075;
        }


        //claw
        if(gamepad.a) {
            clawPos += 0.075;
        }

        if(gamepad.y) {
            clawPos -= 0.075;
        }

        if(gamepad.right_trigger > 0.3) {
            clawPos = 0.6;
        }

        if(gamepad.left_trigger > 0.3) {
            clawPos = 0.77;
        }


        //bounds
        rotation = Range.clip(rotation,0,1);
        clawPos = Range.clip(clawPos,0,1);
        bigServoPos = Range.clip(bigServoPos,0,1);
        smallServoPos = Range.clip(smallServoPos,0,1);

        //sets position
        base.setPosition(rotation);
        small.setPosition(smallServoPos);
        big.setPosition(bigServoPos);
        claw.setPosition(clawPos);
    }
    //functions for getting all servo positions with servo.getPosition()
    public double getBase(){
        return base.getPosition();
    }
    public double getFirst(){
        return big.getPosition();
    }
    public double getMiddle(){
        return small.getPosition();
    }
    public double getClaw(){
        return claw.getPosition();
    }

}
