package main;

import controller.DrivePlanController;
import model.Convertible;
import model.Sedan;
import org.junit.Test;

public class DrivePlanApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Sedan tesla = new Sedan("Tesla",
                "White",
                100,
                500,
                50,
                10,25);
        DrivePlanController controller = new DrivePlanController(tesla, 570);
        controller.printDrivingPlan();

        Convertible mercedes = new Convertible("Mercedes-AMG",
                "Red",
                80,
                300,
                25,
                12
        ,25);
        mercedes.roofUp();

        controller = new DrivePlanController(mercedes, 570);
        controller.printDrivingPlan();
    }
}
