package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class Felix_Arm {
    private final Gamepad gamepad;
    private final HardwareMap hardwareMap;
    private Servo base;
    private Servo first;
    private Servo middle;
    private Servo last;
    private Servo claw;
    private double rotation = 0.5;
    private double lowServoPos = 0.75;
    private double midServoPos = 0.5;
    private double topServoPos = 0.8;

    public Felix_Arm(Gamepad gamepad, HardwareMap hardwareMap) {
        this.gamepad = gamepad;
        this.hardwareMap = hardwareMap;
    }

    public void init(){
        base = hardwareMap.get(Servo.class, "base");
        //Forward is positive
        first = hardwareMap.get(Servo.class, "first");
        //Forward is negative
        middle = hardwareMap.get(Servo.class, "middle");
        //Forward is positive
        last = hardwareMap.get(Servo.class, "last");
        claw = hardwareMap.get(Servo.class, "claw");

        //initialize servos
        base.setPosition(0.5);
        first.setPosition(0.75);
        middle.setPosition(0.5);
        last.setPosition(0.8);
    }

    public void run(){
        //base servo

        if(gamepad.left_trigger> .3){
            rotation = 0.5;
            topServoPos = .325;
            midServoPos = 0.5;
            lowServoPos = 0.4;
        }

        if(gamepad.dpad_up){
            rotation-=0.075;
        }
        if(gamepad.dpad_down){
            rotation+=0.075;
        }

        //low servo
        if(gamepad.left_stick_y < -0.3){
            lowServoPos += 0.075;
        }
        if(gamepad.left_stick_y > 0.3){
            lowServoPos -= 0.075;
        }

        //mid servo
        if(gamepad.right_stick_y < -0.3){
            midServoPos -= 0.075;
        }
        if(gamepad.right_stick_y > 0.3){
            midServoPos += 0.075;
        }

        //top servo
        if(gamepad.left_bumper){
            topServoPos-=0.075;
        }
        if(gamepad.right_bumper){
            topServoPos+=0.075;
        }

        //claw
        if(gamepad.a) {
            claw.setPosition(0.82);
        }
        if(gamepad.b){
            claw.setPosition(0.43);
        }
        if(gamepad.x) {
            claw.setPosition(0.645);
        }

        rotation = Range.clip(rotation,0,1);
        lowServoPos = Range.clip(lowServoPos,0,1);
        midServoPos = Range.clip(midServoPos,0,1);
        topServoPos = Range.clip(topServoPos,0,1);
        base.setPosition(rotation);
        last.setPosition(topServoPos);
        middle.setPosition(midServoPos);
        first.setPosition(lowServoPos);
    }
    //functions for getting all servo positions with servo.getPosition()
    public double getBase(){
        return base.getPosition();
    }
    public double getFirst(){
        return first.getPosition();
    }
    public double getMiddle(){
        return middle.getPosition();
    }
    public double getLast(){
        return last.getPosition();
    }
    public double getClaw(){
        return claw.getPosition();
    }

}
