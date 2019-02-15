/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PWMTalonSRX;
public class Mechanism {
  public Mechanism() {
    
  }
  VictorSP mechOne = new VictorSP(RobotMap.mechOnePort);
  PWMTalonSRX mechTwo = new PWMTalonSRX(RobotMap.mechTwoPort);
  SpeedControllerGroup m_mech = new SpeedControllerGroup(mechOne, mechTwo);
  public void mechDrive(double power){
    m_mech.set(power);
  }
  
}
