package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Car implements Vehicle {
    String model;
    String color;
    int batteryCapacityKWH;
    int batteryRangeMiles;
    int perHourCharging;
    int hrsToFullCharge;

    int batteryIncreaseInHrCharging;

    final int milesTravelPerHr = 50;

    int usagePerHr;
    DrivingPlan plan;

    public Car(String model, String color, int batteryCapacityKWH, int batteryRangeMiles, int perHourCharging, int hrsToFullCharge) {
        this.model = model;
        this.color = color;
        this.batteryCapacityKWH = batteryCapacityKWH;
        this.batteryRangeMiles = batteryRangeMiles;
        this.perHourCharging = perHourCharging;
        this.batteryIncreaseInHrCharging = 100/hrsToFullCharge;
        this.hrsToFullCharge = hrsToFullCharge;
    }

    @Override
    public String toString() {
        return "Car : " + model + ", " + batteryCapacityKWH +"kWh, " + color +" color";
    }

    @Override
    public String printDrivingPlan() {
        System.out.println(plan.toString());
        return plan.toString();
    }

    public void startPlan(int totalMilesToCover) {
        String strDate = "2023-10-01T09:00";
        LocalDateTime currentTime = LocalDateTime.parse(strDate);

        plan = new DrivingPlan("San Francisco", "Las Vegas", currentTime, currentTime, STATUS.STARTED, 0, totalMilesToCover, 100);
        printPlan(currentTime);

        //RETURN PLAN
        currentTime = plan.currentTime.plusHours(48);
        plan = new DrivingPlan("Las Vegas", "San Francisco", currentTime, currentTime, STATUS.STARTED, 0, totalMilesToCover, 100);
        printPlan(currentTime);
    }

    private void printPlan(LocalDateTime currentTime) {
        System.out.println("\n\n"+this.toString());
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        String formattedTime = currentTime.format(myFormatObj);
        System.out.println("Beginning the trip at " + plan.source + " at " + formattedTime);
        while (plan.milesRemaining > 0) {
            if (plan.milesRemaining > milesTravelPerHr) {
                currentTime = currentTime.plusHours(1);
                plan.setDateTime(currentTime);
                plan.setMilesTravelled(milesTravelPerHr);
                if (plan.batteryPercentage > 30) {
                    plan.setStatus(STATUS.DRIVING);
                    plan.setBatteryPercentage(plan.batteryPercentage - usagePerHr);
                    plan.setMilesRemaining(plan.milesRemaining - plan.milesTravelled);
                } else {
                    plan.setStatus(STATUS.CHARGING);
                    plan.setBatteryPercentage(plan.batteryPercentage + batteryIncreaseInHrCharging);
                    plan.setMilesRemaining(plan.milesRemaining);
                }
                printDrivingPlan();
            } else {
                plan.setStatus(STATUS.DRIVING);
                plan.setMilesTravelled(plan.milesRemaining);
                int min = (plan.milesRemaining * 60) / milesTravelPerHr;
                plan.setBatteryPercentage(plan.batteryPercentage - ((plan.milesRemaining * this.usagePerHr) / milesTravelPerHr));
                plan.setMilesRemaining(0);
                currentTime = currentTime.plusMinutes(min);
                formattedTime = currentTime.format(myFormatObj);
                plan.setCurrentTime(currentTime);
                System.out.println("Reached Destination " + plan.destination + " at " + formattedTime);
            }

        }
    }
}
