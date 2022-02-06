package frc.robot.subsystems.turret.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.util.SparkMaxWrapper;

// Set pitch using pid
public class SetPitch extends PIDCommand {
    private static double degreesErrorThreshold = 1.0;

    private SparkMaxWrapper pitchMotor;

    public SetPitch(double targetYaw, SparkMaxWrapper pitchMotor){
        super(
            new PIDController(
                Constants.Turret.TunedCoefficients.PitchPID.kP,
                Constants.Turret.TunedCoefficients.PitchPID.kI,
                Constants.Turret.TunedCoefficients.PitchPID.kD
            ),
            () -> {
                return pitchMotor.getPosition();
            },
            () -> targetYaw,
            (output) -> {
                pitchMotor.setPower(output);
            }
        );
        this.getController().setTolerance(degreesErrorThreshold);
        this.pitchMotor = pitchMotor;
    }

    @Override
    public void end(boolean interrupted){
        // This is going to need testing, I kinda eyeballed the logic on this one
        pitchMotor.setPower(0);
    }

    @Override
    public boolean isFinished(){
        return this.getController().atSetpoint();
    }
}
