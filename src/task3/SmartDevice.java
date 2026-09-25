package task3;

/**
 * Task 3: 'Design by Contract' - Abstraction
 * The interface is the contract: any class that implements it GUARANTEES
 * these three behaviors exist, regardless of how different the devices are.
 */
public interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
}
