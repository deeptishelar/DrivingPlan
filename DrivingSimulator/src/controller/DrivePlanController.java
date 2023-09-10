package controller;

import model.Vehicle;

public class DrivePlanController {
    Vehicle vehicle;
    int totalMilesToCover;
    public DrivePlanController(Vehicle vehicle, int totalMilesToCover)
    {
        this.vehicle = vehicle;
        this.totalMilesToCover = totalMilesToCover;
    }
    public void printDrivingPlan()
    {
        this.vehicle.startPlan(totalMilesToCover);
    }
}