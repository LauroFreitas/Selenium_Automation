package Validacoes;
 
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
//Lauro H.S Freitas
//Exemplo de automação de dois cenários - Login Válido e Inválido
 
public class TesteLeilao {

	
	
  private WebDriver driver;
  private static final String URL_LOGIN= "http://localhost:8080/login";
  private static final String URL_ERRORLOGIN= "http://localhost:8080/login?error";
  private static final String URL_PGINICIAL= "http://localhost:8080/leiloes";
  
  private static String Usuario;
  private static String Senha;
	 
  
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "Drives/chromedriver/chromedriver.exe");  
    driver = new ChromeDriver();
  }
  @After
  public void Exit() {
  driver.close();
  }

  @Test
  public void LoginValido() {
  setUsuario("fulano");
  setSenha("pass");
  driver.navigate().to("http://localhost:8080/leiloes");
  driver.findElement(By.className("text-light")).click();
  driver.findElement(By.name("username")).sendKeys(Usuario);
  driver.findElement(By.name("password")).sendKeys(Senha);
  driver.findElement(By.id("Login-form")).submit();
  Assert.assertFalse(driver.getCurrentUrl().equals("URL_LOGIN"));
  Assert.assertTrue(driver.getCurrentUrl().equals(URL_PGINICIAL));
  
  }
  
  @Test
  public void LoginInvalido() {
  setUsuario("afulano");
  setSenha("apass");
  driver.navigate().to("http://localhost:8080/leiloes");
  driver.findElement(By.className("text-light")).click();
  driver.findElement(By.name("username")).sendKeys(Usuario);
  driver.findElement(By.name("password")).sendKeys(Senha);
  driver.findElement(By.id("Login-form")).submit();
  Assert.assertFalse(driver.getCurrentUrl().equals("URL_LOGIN"));
  Assert.assertTrue(driver.getCurrentUrl().equals(URL_ERRORLOGIN));
  
  }
   
  
  public String getUsuario() {
	return Usuario;
  }

  public void setUsuario(String u) {
	this.Usuario = u;
  }
  

  public String getSenha() {
	return Senha;
  }

  public void setSenha(String s) {
	this.Senha = s;
  }
  		 

	 
}
