/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  //if no signal to compressor or piston double check port numbers
  Solenoid pistonSol= new Solenoid (1,1);
   
  Compressor aCompressor = new Compressor(1);
  public Pneumatics() {
  }
  public void pistonSwitch(boolean state) {
    pistonSol.set(state);
  }
  public void compressorState(boolean state) {
    
    if (state == true) {
      aCompressor.setClosedLoopControl(true);
      
    }
    else {
      aCompressor.setClosedLoopControl(false);
    }
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
