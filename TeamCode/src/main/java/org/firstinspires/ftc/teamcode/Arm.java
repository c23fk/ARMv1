/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "ARMS")
public class Arm extends LinearOpMode {

    @Override
    public void runOpMode() {
        final Felix_Arm felix_arm = new Felix_Arm(gamepad1, hardwareMap);
        final Elize_Arm elize_arm = new Elize_Arm(gamepad2, hardwareMap);
        felix_arm.init();
        elize_arm.init();
        telemetry.update();
        waitForStart();
        while(opModeIsActive()) {
            felix_arm.run();
            elize_arm.run();
            telemetry.addData(">Elize_Base: ", elize_arm.getBase());
            telemetry.addData(">Elize_First: ", elize_arm.getFirst());
            telemetry.addData(">Elize_Middle: ", elize_arm.getMiddle());
            telemetry.addData(">Elize_Claw: ", elize_arm.getClaw());
            telemetry.addData(">Felix_Base: ", felix_arm.getBase());
            telemetry.addData(">Felix_First: ", felix_arm.getFirst());
            telemetry.addData(">Felix_Middle: ", felix_arm.getMiddle());
            telemetry.addData(">Felix_Last: ", felix_arm.getLast());
            telemetry.addData(">Felix_Claw: ", felix_arm.getClaw());
            telemetry.update();
            sleep(100);
        }
    }
}
