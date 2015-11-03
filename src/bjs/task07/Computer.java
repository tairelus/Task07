package bjs.task07;
import java.io.Serializable;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

/**
 * Created by YM on 31.10.2015.
 * Class Computer reworked as JavaBean component
 */



//JavaBean must support persistence. We need to implement java.io.Serializable interface or provide
// custom way for serialization
public class Computer implements Serializable{

	//In JavaBean components all variables must be set only via getters/setters

	//Support for change notification mechanism
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	//The type of the computer. E.g. "PC", "Notebook", etc.
	private String computerType;
	//The type of the CPU. E.g. "Intel", "ARM", etc.
	private String processorType;
	//The CPU clock rate in GHz
    private float processorClockRateGHz;
	//Random access memory size in Gb
    private float randomAccessMemorySizeGb;
		
	//Size of the fixed memory storage in Gb. E.g. hard-drive
	private int fixedMemorySizeGb;
	//Name on the operation system
    private String operationSystem;
	//Human readable computer name
	private String computerName;

	//JavaBean must provide public constructor without parameters
	public Computer() {
	}

	public void powerOn(){
		System.out.println("Power is on. Initialized with parameters:");
		System.out.println("------------------------------------------");

		setComputerType("PC");
		setProcessorType("Intel Core i5-2400 CPU");
		setProcessorClockRateGHz(3.10f);
		setRandomAccessMemorySizeGb(8.00f);
		setFixedMemorySizeGb(1000);

		setOperationSystem("Windows 7, x64");
		setComputerName("MyComputer");
    }

	public void powerOff(){
		System.out.println("\nSystem \"" + computerName + "\" is shut down.");
    }
		
    @Override
    public String toString() {
        //toString() method defined for all existing Java objects and can be overridden for user-defined objects
		String result;
        result = "Computer type: " + computerType + "\n";
        result += "Processor type: " + processorType + "\n";
        
		result += "Processor clock rate: " + getProcessorClockRateGHz() + "\n";
        result += "Random access memory size: " + getRandomAccessMemorySizeGb()  + "\n";
		result += "Fixed memory size: " + getFixedMemorySizeGb() + "\n";
        result += "Operation system: " + getOperationSystem() + "\n";
        result += "Computer name: " + getComputerName() + "\n";

        return result;
    }

	//Adds property change listener
	public void addPropertyChangeListener(PropertyChangeListener changeListener) {
		propertyChangeSupport.addPropertyChangeListener(changeListener);
	}

	//Removes property change listener
	public void removePropertyChangeListener(PropertyChangeListener changeListener) {
		propertyChangeSupport.removePropertyChangeListener(changeListener);
	}

	//Setters
	public void setComputerType(String computerType) {
		this.computerType = computerType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

	public void setProcessorClockRateGHz(float processorClockRateGHz) {
		if (processorClockRateGHz > 0) {
			propertyChangeSupport.firePropertyChange("processorClockRateGHz", this.processorClockRateGHz, processorClockRateGHz);
			this.processorClockRateGHz = processorClockRateGHz;
		}
	}

	public void setRandomAccessMemorySizeGb(float randomAccessMemorySizeGb) {
		if (randomAccessMemorySizeGb > 0)
			this.randomAccessMemorySizeGb = randomAccessMemorySizeGb;
	}

	public void setFixedMemorySizeGb(int fixedMemorySizeGb) {
		this.fixedMemorySizeGb = fixedMemorySizeGb;
	}

	public void setOperationSystem(String operationSystem) {
		if (!operationSystem.isEmpty())
			this.operationSystem = operationSystem;
	}

	public void setComputerName(String computerName) {
		if (!computerName.isEmpty()) {
			propertyChangeSupport.firePropertyChange("computerName", this.computerName, computerName);
			this.computerName = computerName;
		}
	}

	//Getters
	public String getComputerType() {
		return computerType;
	}

	public String getProcessorType() {
		return processorType;
	}

	public float getProcessorClockRateGHz() {
		return processorClockRateGHz;
	}

	public float getRandomAccessMemorySizeGb() {
		return randomAccessMemorySizeGb;
	}

	public int getFixedMemorySizeGb() {
		return fixedMemorySizeGb;
	}

	public String getOperationSystem() {
		return operationSystem;
	}

	public String getComputerName() {
		return computerName;
	}
}
