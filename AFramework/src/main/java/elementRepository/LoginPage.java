package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	    @FindBy(name="user_name")
		private WebElement usernameTextfield;
		
        @FindAll({  @FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']") })
        private WebElement passwordTextfield;
       
        @FindBy(id="submitButton")
        private WebElement loginButton;

		/**
		 * @return the usernameTextfield
		 */
		public WebElement getUsernameTextfield() {
			return usernameTextfield;
		}

		/**
		 * @return the passwordTextfield
		 */
		public WebElement getPasswordTextfield() {
			return passwordTextfield;
		}

		/**
		 * @return the loginButton
		 */
		public WebElement getLoginButton() {
			return loginButton;
		}

        
}