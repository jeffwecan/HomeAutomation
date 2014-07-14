package org.txstate.cs4398_sum14.group4;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
 

/**
 * @author Jeffrey Hogan
 *
 */
public class BaseStation {
	// create gpio controller instance
	final GpioController gpio = GpioFactory.getInstance();
	
	
	String GetStatus() {
		
		return "Home lookin' p good bro!";
	}
	
	/**
	 * Each component will need to hold a reference to this BaseStation class in order to access / setup their gipo status
	 * @param addition
	 * @return 
	 */
	public void AddSensor(Sensor newSensor) {
		
		
	}
}