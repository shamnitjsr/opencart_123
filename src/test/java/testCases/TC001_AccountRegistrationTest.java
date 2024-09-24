package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

//	@Test
//	void verify_account_registration() {
//
//		HomePage hp = new HomePage(driver);
//		hp.clickMyAccount();
//		hp.clickRegister();
//		
//		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
//		
//		regpage.setFirstName("firstName");
//		regpage.setLastName("lastName");
//		regpage.setEmail("qwa@gmail.com");
//		regpage.setTelephone("1234567890");
//		regpage.setPassword("123@qaws");
//		regpage.setConfirmPassword("123@qaws");
//		
//		regpage.setPrivacyPolicy();
//		regpage.clickContinue();
//		
//		
//	}

	@Test
	void verify_account_registration() {

		try {
			logger.info("***** Starting TC001_AccountRegistrationTest *****");
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link ");

			hp.clickRegister();
			logger.info("clicked on Register Link ");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing Customer details....");

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());

			regpage.setEmail(randomString() + "@gmail.com"); // randomly generated the email

			regpage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating expected message");
			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {

			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");

	}

}
