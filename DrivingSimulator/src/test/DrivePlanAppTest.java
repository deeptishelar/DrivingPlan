package test;

import controller.DrivePlanController;
import model.Sedan;
import org.junit.Test;

public class DrivePlanAppTest {
    Sedan tesla = new Sedan("Tesla",
            "White",
            100,
            500,
            50,
            10, 50);
    DrivePlanController controller = new DrivePlanController(tesla, 570);
    @Test
    public void test()
    {
        controller.printDrivingPlan();
    }
}
