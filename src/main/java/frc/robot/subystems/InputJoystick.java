package frc.robot.subystems;
import edu.wpi.first.wpilibj.Joystick;
public class InputJoystick {
    double x = 0.0;
	double y = 0.5;
    double r = 0.5;
    double voltage = 0.0;
    public InputJoystick(Joystick joy, double voltage) {
        x = joy.getX();
		y = joy.getY();
        r = joy.getTwist();
        this.voltage = voltage;
    }
    public double getX() {
		return x;
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