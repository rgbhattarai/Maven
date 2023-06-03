package Teste.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TR8 {

	@Test(dependsOnMethods={"driveCar"})
	public void StartCar() {
		System.out.println("Start the Car");
	}

	@Test  (dependsOnMethods={"parkingCar"})
	public void driveCar() {
	System.out.println("Stop the Car");
	Assert.fail();
}

	@Test ()
	public void parkingCar() {
	System.out.println("Park the Car");
	}
}
