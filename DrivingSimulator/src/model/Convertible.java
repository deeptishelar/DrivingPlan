package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Convertible extends Car{
    boolean roofUp;
    public Convertible(String model, String color, int batteryCapacityKWH, int batteryRangeMiles, int perHourCharging, int hrsToFullCharge, int perHrCharging) {
        super(model, color, batteryCapacityKWH, batteryRangeMiles, perHourCharging, hrsToFullCharge);
        this.usagePerHr = (super.milesTravelPerHr * 100) / batteryRangeMiles;
        this.perHourCharging = perHrCharging;
    }
    public void roofUp()
    {
        roofUp = true;
    }
    public void roofDown()
    {
        roofUp = false;
    }

    @Override
    public String toString() {
        return "Car : " + model + ", " + batteryCapacityKWH +"kWh, " + color +" color" + (this.roofUp ? ", Driving Roof Open" : "");
    }
}
