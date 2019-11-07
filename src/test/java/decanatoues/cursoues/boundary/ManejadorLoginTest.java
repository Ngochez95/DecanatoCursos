package decanatoues.cursoues.boundary;

import decanatoues.cursoues.entity.Administrador;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author gochez
 */
public class ManejadorLoginTest {

    public ManejadorLoginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void camposVacios() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
        driver.findElement(By.id("j_idt6:j_idt8")).sendKeys("admin");
        driver.findElement(By.id("j_idt6:j_idt10")).sendKeys("");

        driver.findElement(By.id("j_idt6:j_idt12")).click();
        assertTrue(true);
    }

    @Test
    public void testLoginSoloUser() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
        driver.findElement(By.id("j_idt6:j_idt8")).sendKeys("admin");
        driver.findElement(By.id("j_idt6:j_idt10")).sendKeys("");

        driver.findElement(By.id("j_idt6:j_idt12")).click();
        assertTrue(true);
    }

    @Test
    public void testLoginSoloPaswd() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
        driver.findElement(By.id("j_idt6:j_idt8")).sendKeys("");

        driver.findElement(By.id("j_idt6:j_idt10")).sendKeys("12345");

        driver.findElement(By.id("j_idt6:j_idt12")).click();
        assertTrue(true);
    }

    @Test
    public void testLogin() throws MalformedURLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
        driver.findElement(By.id("j_idt6:j_idt8")).sendKeys("admin");
        Thread.sleep(3000);

        driver.findElement(By.id("j_idt6:j_idt10")).sendKeys("12345");
        Thread.sleep(3000);

        driver.findElement(By.id("j_idt6:j_idt12")).click();
        assertTrue(true);
    }

}
