package task3;

public class SmartBulb implements SmartDevice {
    private boolean isOn = false;
    private int brightness = 100; // percent

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
        return "Bulb is " + (isOn ? "ON" : "OFF") + " at " + brightness + "% brightness";
    }

    // Unique to SmartBulb only
    public void setBrightness(int level) {
        if (level < 0 || level > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100.");
        }
        this.brightness = level;
    }
}
