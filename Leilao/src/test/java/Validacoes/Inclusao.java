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
//Exemplo cenário de inclusão de um novo leilao
 
public class Inclusao {

	
	
  private WebDriver driver;
  private static final String URL_LOGIN= "http://localhost:8080/login";
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
 
  }

  @Test //Login
  public void LoginValido() {
  setUsuario("fulano");
  setSenha("pass");
  driver.navigate().to("http://localhost:8080/leiloes");
  driver.findElement(By.className("text-light")).click();
  driver.findElement(By.name("username")).sendKeys(Usuario);
  driver.findElement(By.name("password")).sendKeys(Senha);
  driver.findElement(By.id("Login-form")).submit();
  Assert.assertFalse(driver.getCurrentUrl().equals(URL_LOGIN));
  Assert.assertTrue(driver.getCurrentUrl().equals(URL_PGINICIAL));
  NovoLeilao(5);
  }
  
  
  public void NovoLeilao(int q) {

	  for (int i = 0; i < q; i++) {
		  driver.findElement(By.id("novo_leilao_link")).click();
		  driver.findElement(By.id("nome")).sendKeys("Leilao"+i);
		  driver.findElement(By.id("valorInicial")).sendKeys("200"+i);
		  driver.findElement(By.id("dataAbertura")).sendKeys("30/12/2022");
		  driver.findElement(By.id("button-submit")).click();
		}
 
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
