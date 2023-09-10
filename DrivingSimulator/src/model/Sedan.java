package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Sedan extends Car {

    public Sedan(String model, String color, int batteryCapacityKWH, int batteryRangeMiles, int perHourCharging, int hrsToFullCharge, int perHrCharging) {
        super(model, color, batteryCapacityKWH, batteryRangeMiles, perHourCharging, hrsToFullCharge);
        this.usagePerHr = (super.milesTravelPerHr * 100) / batteryRangeMiles;
        this.perHourCharging = perHrCharging;
    }
}
