package br.com.sevencomm.agse.acertocontabil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AcertoContabilPage {

	private WebDriver driver;

	public AcertoContabilPage(InternetExplorerDriver parmDriver) {
		this.driver = parmDriver;
	}

	/**
	 * @param args
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws AWTException {

		AcertoContabilPage acp = new AcertoContabilPage(new InternetExplorerDriver());

		acp.rodaTeste();

	}

	private void rodaTeste() throws AWTException {
		driver.get("http://10.100.49.146:9080/agse");

		enviaUserPassword("m1036", "gseg011");
		
		testeLink();

	}

	private void enviaUserPassword(String user, String password)
			throws AWTException {
		// Code to handle Basic driverser Authentication in Selenium.
		Alert aa = driver.switchTo().alert();
		aa.sendKeys(user);

		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_G);
		robo.keyPress(KeyEvent.VK_S);
		robo.keyPress(KeyEvent.VK_E);
		robo.keyPress(KeyEvent.VK_G);
		robo.keyPress(KeyEvent.VK_0);
		robo.keyPress(KeyEvent.VK_1);
		robo.keyPress(KeyEvent.VK_1);

		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyPress(KeyEvent.VK_ENTER);
	}
	
	private void testeLink() {
		driver.findElement(By.linkText("Listar Solicitações")).click();
	}

}
