package frc.robot.subystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
public class InputJoystick {
    double x = 0.0;
	double y = 0.5;
    double r = 0.5;
	double voltage = 0.0;
	boolean up, down, mechUp, mechDown, pistonUp, pistonDown;
    public InputJoystick(Joystick joy, double voltage) {
        x = joy.getX();
		y = joy.getY();
		r = joy.getTwist();
        this.voltage = voltage;
	}
	public InputJoystick(XboxController box, double voltage) {
		pistonUp = box.getRawButton(1);
		pistonDown = box.getRawButton(4);
		up = box.getRawButton(5);
		down = box.getRawButton(6);
		mechUp = box.getRawButton(7);
		mechDown = box.getRawButton(8);
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
	public boolean GetButtonMechUp() {
		return mechUp;
	}
	public boolean GetButtonMechDown() {
		return mechDown;
	}
	public boolean GetButtonPistonUp() {
		return pistonUp;
	}
	public Boolean GetButtonPistonDown() {
		return pistonDown;
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