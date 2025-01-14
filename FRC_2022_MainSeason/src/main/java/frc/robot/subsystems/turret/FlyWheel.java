package frc.robot.subsystems.turret;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants;

public class FlyWheel{

    CANSparkMax flyWheel = new CANSparkMax(Constants.Turret.Ports.flywheelMotorA, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax kickWheel = new CANSparkMax(Constants.Turret.Ports.flywheelMotorB, CANSparkMaxLowLevel.MotorType.kBrushless);


    public double FlyWheelSpeed(){
        return flyWheel.getEncoder().getVelocity(); //should return in ticks per second
    }

}



