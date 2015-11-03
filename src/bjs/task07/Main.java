package bjs.task07;
import java.beans.*;

public class Main {

    public static void main(String[] args) {
		Computer desktopComputer = new Computer();

        //Use introspection to print properties of the "Computer" JavaBean to test component
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(desktopComputer.getClass());
            System.out.println("Property list of the \"Computer\" JavaBean: ");
            PropertyDescriptor propertyDescriptor[] = beanInfo.getPropertyDescriptors();

            for (int i = 0; i < propertyDescriptor.length; i++) {
                System.out.println("\t" + propertyDescriptor[i].getName());
            }

            System.out.println("");
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        desktopComputer.powerOn();
        System.out.print(desktopComputer.toString());

        ComputerListener computerListener = new ComputerListener();
        desktopComputer.addPropertyChangeListener(computerListener);

        //Print out changes for property values
        System.out.println("\nChange property values:");
        desktopComputer.setProcessorClockRateGHz(4.0f);
        desktopComputer.setComputerName("My new computer");

        desktopComputer.removePropertyChangeListener(computerListener);
        desktopComputer.powerOff();
    }
}
