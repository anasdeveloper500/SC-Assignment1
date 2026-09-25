package task3;

public class SmartThermostat implements SmartDevice {
    private boolean isOn = false;
    private double temperature = 22.0; // Celsius

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public String getStatus() {
        return "Thermostat is " + (isOn ? "ON" : "OFF") + " set to " + temperature + "C";
    }

    // Unique to SmartThermostat only
    public void setTemperature(double temp) {
        if (temp < 5 || temp > 35) {
            throw new IllegalArgumentException("Temperature out of safe range.");
        }
        this.temperature = temp;
    }
}
