package vtiger.genericutility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import vtiger.pomrepo.HomePage;
import vtiger.pomrepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public javaUtility jUtils = new javaUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	
	@BeforeClass
	public void bc() throws IOException {
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		wUtils.maximizeWindow(driver);
		wUtils.waitForPageToLoad(driver);
		driver.get(url);
		System.out.println("The Browser is launched");
	

	}

	@BeforeMethod
	public void bm() throws IOException {
		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("The user has logged in");
	}

	@AfterMethod
	public void am() {
		HomePage home = new HomePage(driver);
		home.logoutAction();
		System.out.println("The user has logged out");
	}

	@AfterClass
	public void ac() {
		driver.quit();
		System.out.println("The browser is closed");
	}

	
	

}

