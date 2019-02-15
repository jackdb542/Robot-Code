package frc.robot.subystems;
import edu.wpi.first.wpilibj.Joystick;
public class InputJoystick {
    double x = 0.0;
	double y = 0.5;
    double r = 0.5;
	double voltage = 0.0;
	boolean up, down;
    public InputJoystick(Joystick joy, double voltage) {
        x = joy.getX();
		y = joy.getY();
		r = joy.getTwist();
		up = joy.getRawButton(3);
		down = joy.getRawButton(4);
        this.voltage = voltage;
    }
    public double getX() {
		return x;
	}
	public boolean getButtonUp() {
		return up;
	}
	public boolean getButtonDown() {
		return down;
	}
	
	public void setX(double value) {
		x = value;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double value) {
		y = value;
	}
	
	public double getTwist() {
		return r;
	}
	
	public void setTwist(double value) {
		r = value;
	}
	
}