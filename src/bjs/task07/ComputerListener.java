package bjs.task07;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * Created by YM on 03.11.2015. Class to demonstrate bound properties and listening mechanism
 */
public class ComputerListener implements PropertyChangeListener {
    public void propertyChange(PropertyChangeEvent changeEvent) {
        System.out.println("------------------------------------------");
        System.out.println("Property name: " + changeEvent.getPropertyName());
        System.out.println("Old property value: " + changeEvent.getOldValue());
        System.out.println("New property value: " + changeEvent.getNewValue());
    }
}
