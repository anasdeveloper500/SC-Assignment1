package task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SmartBulb bulb = new SmartBulb();
        bulb.turnOn();
        bulb.setBrightness(60);

        SmartThermostat thermostat = new SmartThermostat();
        thermostat.turnOn();
        thermostat.setTemperature(24.5);

        List<SmartDevice> devices = new ArrayList<>();
        devices.add(bulb);
        devices.add(thermostat);

        for (SmartDevice d : devices) {
            System.out.println(d.getStatus());
        }
    }
}
