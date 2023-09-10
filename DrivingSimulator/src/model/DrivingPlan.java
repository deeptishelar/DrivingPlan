package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DrivingPlan {
    public String destination;
    public String source;
    LocalDateTime startDate;
    LocalDateTime currentTime;
    STATUS status;
    int milesTravelled;

    public DrivingPlan(String source, String destination, LocalDateTime startDate, LocalDateTime currentTime, STATUS status, int milesTravelled, int milesRemaining, int batteryPercentage) {
        this.source = source;
        this.destination = destination;
        this.startDate = startDate;
        this.currentTime = currentTime;
        this.status = status;
        this.milesTravelled = milesTravelled;
        this.milesRemaining = milesRemaining;
        this.batteryPercentage = batteryPercentage;
    }

    int milesRemaining;
    int batteryPercentage;

    public void setDateTime(LocalDateTime dateTime) {
        this.currentTime = dateTime;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public void setMilesTravelled(int milesTravelled) {
        this.milesTravelled = milesTravelled;
    }

    public void setMilesRemaining(int milesRemaining) {
        this.milesRemaining = milesRemaining;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }


    @Override
    public String toString() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
        String formattedDate = currentTime.format(myFormatObj);
        return
                formattedDate + ", " + status + ", " + milesTravelled + " miles, " + milesRemaining + " miles, " + batteryPercentage + "%";
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}
