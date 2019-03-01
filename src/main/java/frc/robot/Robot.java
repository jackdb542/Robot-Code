/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subystems.DriveTrain;
import frc.robot.subystems.InputJoystick;
import frc.robot.subystems.Mechanism;
import frc.robot.subystems.Pneumatics;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  Joystick joy = new Joystick(0);
  DriveTrain driver = new DriveTrain();
  Pneumatics pneu = new Pneumatics();
  XboxController xbox = new XboxController(1);
  
  private boolean pressedUp;
  private boolean pressedDown;
  private boolean mechPressedDown;
  private boolean mechPressedUp;

  private boolean pistonUp;
  private boolean pistonDown;
  Mechanism mech = new Mechanism();
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    //start compressor
    pneu.compressorState(true);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  public void doPeriodic() {
    InputJoystick injoy = new InputJoystick(joy, 0.0);
    InputJoystick inbox = new InputJoystick(xbox, 0.0);
    
    pressedUp = inbox.getButtonUp();
    pressedDown = inbox.getButtonDown();
    mechPressedUp = inbox.GetButtonMechUp();
    mechPressedDown = inbox.GetButtonMechDown();
    pistonUp = injoy.GetButtonPistonUp();
    pistonDown = injoy.GetButtonPistonDown();
    if (pressedUp == false && pressedDown == false) {
      mech.mechDrive(0);
    }
    if (pressedUp == true && pressedDown != true) {
      mech.mechDrive(0.8);
    }
    else if (pressedDown == true && pressedUp != true) {
      mech.mechDrive(-0.8);
    }
    else {
      mech.mechDrive(0);
    }
    if (mechPressedUp == false && mechPressedDown == false) {
      mech.mechTurn(0);
    }
    if (mechPressedUp == true && mechPressedDown != true) {
      mech.mechTurn(0.2);
    }
    else if (mechPressedDown == true && mechPressedUp != true) {
      mech.mechTurn(-0.2);
    }
    else {
      mech.mechTurn(0);
    }
    //piston
    if (pistonUp = true) {
      pneu.pistonSwitch(true);
    }
    else if (pistonDown = true) {
      pneu.pistonSwitch(false);
    }
    drive(injoy);
  }
  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    doPeriodic();
  }

  /**
   * This function is called periodically during operator control.
   */

   
  

  @Override
  public void teleopPeriodic() {
    doPeriodic();
  }
  
  public void drive(InputJoystick injoy) {
    
    double x = injoy.getX();
    double y = injoy.getY();
    double r = injoy.getTwist();
    driver.manualDrive(x, y, r);
  }
  
  @Override
  public void testPeriodic() {
    
  }
}
