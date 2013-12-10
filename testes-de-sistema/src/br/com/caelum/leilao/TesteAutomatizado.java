package br.com.caelum.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		
		System.out.println("Iniciando Teste");
		
		// abre firefox
        // WebDriver driver = new FirefoxDriver();
		// Com o firefox é lançada uma exception

        // abre o IE
		// WebDriver driver = new InternetExplorerDriver();
        
        System.setProperty("webdriver.chrome.driver","c:\\Ferramental\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // acessa o site do google
        driver.get("http://www.google.com.br/");

        // digita no campo com nome "q" do google
        WebElement campoDeTexto = driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Caelum");

        // submete o form
        campoDeTexto.submit();
	}
}
