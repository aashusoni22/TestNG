package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {

	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1, groups="smoke" )
	public void createUser() {
		System.out.println("I am in home test");
		System.out.println("Before Assertion");
		Assert.assertTrue(2 > 3, "Verifying Element");
		System.out.println("After assertion");
		Assert.assertEquals("abc", "abc");
	}

	// we can add dependencies in TestNG so if the createUser fails all other tests
	// which are depend on createUser will be skipped 
	@Test(priority = 2, dependsOnMethods = "createUser")
	public void editUser() {
		System.out.println("Before Assertion");
		softAssert.assertTrue(2 > 3, "Verifying Element");
		System.out.println("After assertion");
		softAssert.assertAll(); // Always remember to add this line when using SoftAssert

	}

	// we can add dependencies in TestNG so if the createUser fails all other tests
	// which are depend on createUser will be skipped
	@Test(priority = 3, dependsOnMethods = "editUser")
	public void deleteUser() {
		System.out.println("I am in end test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2 > 3, "Verifying Element1");
		System.out.println("After assertion");
		softAssert.assertEquals("abc", "abc1");
		System.out.println("After second assertion");
		softAssert.assertAll();
	}
}
