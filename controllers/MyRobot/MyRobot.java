

import com.cyberbotics.webots.controller.Connector;
import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.LED;
import com.cyberbotics.webots.controller.Motor;
import com.cyberbotics.webots.controller.Robot;

public class MyRobot extends Robot {

	private Motor motor;
	private Connector rearConnector;
	private Connector frontConnector;

	public MyRobot() {
		motor = getMotor("motor");
		rearConnector = getConnector("rear_connector");
		frontConnector = getConnector("front_connector");
	}

	public void run() {
		double t = 0.0;
		// main control loop
		while (true) {
			if (step(64) == -1) {
				break;
			}
			motor.setPosition(t * Math.sin(t));
			t += 64.0/1000.0;
		}

		// Enter here exit cleanup code
	}

	public static void main(String[] args) {
		MyRobot robot = new MyRobot();
		robot.run();
	}
}
