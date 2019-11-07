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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

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

//    @Test
//    public void camposVacios() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        assertTrue(true);
//    }
//
//    @Test
//    public void testLoginSoloUser() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        assertTrue(true);
//    }
//
//    @Test
//    public void testLoginSoloPaswd() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        assertTrue(true);
//    }
//
//    @Test
//    public void testLogin() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        assertTrue(true);
//    }
//
//    @Test
//    public void RangoMaximo() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("123456789012345678901234567890");
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("123456789012345678901234567890");
//        Thread.sleep(3000);
//        assertTrue(true);
//    }
//
//    //Sprint dos
//    //@Test
//    public void testCerrarsesion() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//
//        //cerrarSesion
//        driver.findElement(By.id("//*[@id=\"j_idt7\"]")).click();
//        driver.findElement(By.id("j_idt16:j_idt17")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCrearNuevoCurso() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//
//        //cambio de url
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("Introduccion Informatica");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("Temas principales de Introduccion Informatica");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("011119");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("05/11/19");
//        driver.findElement(By.id("panel:cupoCurso_input")).sendKeys("20");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCrearNuevoCursoCamposVacios() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCrearNuevoCursoFechasAlreves() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("Introduccion Informatica");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("Temas principales de Introduccion Informatica");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("051119");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("01/11/19");
//        driver.findElement(By.id("panel:panel:cupoCurso_input")).sendKeys("20");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCrearNuevoCursoCuposNegativos() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("Introduccion Informatica");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("Temas principales de Introduccion Informatica");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("011119");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("05/11/19");
//        driver.findElement(By.id("panel:cupoCurso_input")).sendKeys("-20");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCrearNuevoCursoCuposCero() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("Introduccion Informatica");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("Temas principales de Introduccion Informatica");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("011119");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("05/11/19");
//        driver.findElement(By.id("panel:cupoCurso_input")).sendKeys("0");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCrearNuevoCursoRangoMaximo() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("01234567890123456789012345678901234567890");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("01234567890123456789012345678901234567890");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("01111901");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("05/11/2019");
//        driver.findElement(By.id("panel:cupoCurso_input")).sendKeys("01234567890123456789012345678901234567890");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void testCrearNuevoCursoNumerosCupos() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("Introduccion Informatica");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("Temas principales de Introduccion Informatica");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("01/11/19");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("05/11/19");
//        driver.findElement(By.id("panel:cupoCurso_input")).sendKeys("Cero");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//    
//    @Test
//    public void testCrearNuevoCursoLetrasFechas() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("Introduccion Informatica");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("Temas principales de Introduccion Informatica");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("holacomoesta");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("holiholi");
//        driver.findElement(By.id("panel:cupoCurso_input")).sendKeys("Cero");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//    
//    @Test
//    public void testCrearNuevoHoraDuracion() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/creacion.jsf");
//
//        driver.findElement(By.id("panel:nombreCurso")).sendKeys("Introduccion Informatica");
//        driver.findElement(By.id("panel:descripcionCurso")).sendKeys("Temas principales de Introduccion Informatica");
//        driver.findElement(By.id("panel:fechaInicioCurso_input")).sendKeys("01/11/19");
//        driver.findElement(By.id("panel:fechaFinCurso_input")).sendKeys("01/11/19");
//        driver.findElement(By.id("panel:cupoCurso_input")).sendKeys("20");
//        driver.findElement(By.id("panel:j_idt30")).click();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//    
//    @Test
//    public void testModificarCursos() throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./driverChrome/chromedriver");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/index.jsf");
//        driver.findElement(By.id("j_idt6:user")).sendKeys("admin");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:contra")).sendKeys("12345");
//        Thread.sleep(1500);
//        driver.findElement(By.id("j_idt6:inicio")).click();
//        Thread.sleep(3000);
//        driver.get("http://35.232.215.93:8080/CursoUes-1.0-SNAPSHOT/miscursos.jsf");
//
//        Actions actions = new Actions(driver);
//        WebElement table =  driver.findElement(By.id("form:idCursoSelected_data"));
//        table.click();
//        actions.contextClick(table).build().perform();
//        Thread.sleep(3000);
//
//        assertTrue(true);
//    }
//    

}
