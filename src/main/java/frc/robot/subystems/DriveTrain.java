package frc.robot.subystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWMSpeedController;

public class DriveTrain {
    
    VictorSP leftFront = new VictorSP(RobotMap.leftBitchPort);
    VictorSP rightFront = new VictorSP(RobotMap.rightBitchPort);
    VictorSP leftRear = new VictorSP(RobotMap.leftCheekPort);
    VictorSP rightRear = new VictorSP(RobotMap.rightCheekPort);
    
    //left motor group
    SpeedControllerGroup m_left = new SpeedControllerGroup(leftFront, leftRear);
    //right motor group

    //mechanism motor group
    
    SpeedControllerGroup m_right = new SpeedControllerGroup(rightFront, rightRear);
    //drivetrain group of left and right
    DifferentialDrive drive = new DifferentialDrive(m_left, m_right);
    //stolen from 4068 old robot code
    int inputCurve = 5;
    double RFM = -0.0;
	double RBM = 0.0;
	double LBM = -0.5;
	double LFM = 0.5;
    public DriveTrain(){
        drive.setDeadband(0.02);
    }
    public void manualDrive(double x, double y, double r){
        //halve the turning power
        r *=0.5;
        // front wheel power is linked to rear wheel power so these two are really left power and right power
        //left front power
        double lfpower = +y + r;
        double rfpower = -y + r;

        //some maths that i dont know, stole from old robot code that was working
        lfpower = Math.signum(lfpower) * (Math.pow(inputCurve, Math.abs(lfpower)) - 1) / (inputCurve - 1);
		rfpower = Math.signum(rfpower) * (Math.pow(inputCurve, Math.abs(rfpower)) - 1) / (inputCurve - 1);
        //false is for squared input, if too sensitive change to true
        drive.tankDrive(rfpower * -RFM, lfpower * -LFM, false);
        
        
      }
      

    
}