package org.cs4398g4.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.cs4398g4.Action;
import org.cs4398g4.Actuator;
import org.cs4398g4.BaseStation;
import org.cs4398g4.Behavior;
import org.cs4398g4.Condition;
import org.cs4398_G4.Controller;
import org.cs4398_G4.Room;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@RunWith(Parameterized.class)
public class ConditionTest {
	
	BaseStation testBase;
	
	private HashMap<String, Pin> inputPinNumbers = new HashMap<String, Pin>();
	private HashMap<String, Pin> outputPinNumbers = new HashMap<String, Pin>();
	
	public ConditionTest(HashMap<String, Pin> input, HashMap<String, Pin> output) {
		testBase = new BaseStation();
		
		this.inputPinNumbers = input;
		this.outputPinNumbers = output;
	}
	
	@Parameters
	public static Collection<Object[]> generateTestData() {
		
		HashMap<String, Pin> inputEmpty = new HashMap<String, Pin>();
		HashMap<String, Pin> outputEmpty = new HashMap<String, Pin>();
		
		HashMap<String, Pin> input1 = new HashMap<String, Pin>();
		HashMap<String, Pin> output1 = new HashMap<String, Pin>();
		
		input1.put("SensorInput", RaspiPin.GPIO_00);
		output1.put("SensorOutput", RaspiPin.GPIO_01);
		
		input1.put("LightInput", RaspiPin.GPIO_03);
		output1.put("LightOutput", RaspiPin.GPIO_04);
		
		Object[][] data = new Object[][] { { inputEmpty, outputEmpty },
				{ input1, output1 }
		};

		return Arrays.asList(data);
		
	}
	
	@Test
	public void Test() {
		
		Controller testController = new Controller(testBase);
				
		Room testRoom = new Room("Test Room");
		testBase.AddRoom(testRoom);
				
		List<Condition> testConditions = new ArrayList<Condition>();
		List<Action> testActions = new ArrayList<Action>();
						
		//create sensor and light
		Actuator testLight = new Actuator("test light", inputPinNumbers, outputPinNumbers);
		Sensor testSensor = new Sensor("testSensor", inputPinNumbers, outputPinNumbers);
				
		testController.AddComponent(testSensor, testRoom);
		testController.AddComponent(testLight, testRoom);
				
		//create test actions and conditions for baseStation behavior test
		Action testAction = new Action(testLight, PinState.HIGH, 5);
		Condition testCondition = new Condition(testSensor, PinState.HIGH, 10);
				
		testConditions.add(testCondition);
		testActions.add(testAction);
						
		Behavior testBehavior = new Behavior("TestBehavior", testConditions, testActions, testBase);
		
		
		//---Tests-----
		
		if(testAction.getActuator().isOn()) {
			fail("Light should be off");
		}
		
		testCondition.setConditionMet(true);
		testBehavior.conditionMet();
		
		if(testAction.getPinState() == PinState.LOW) {
			fail("PinState for light is LOW");
		}
		
		if(!testAction.getActuator().isOn()) {
			fail("Light should be on");
		}
		
	}

}