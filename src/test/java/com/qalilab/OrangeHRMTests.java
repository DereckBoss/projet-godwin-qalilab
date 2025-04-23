/**
 * CREATED BY @author GODWIN
 * DATE : 23/04/2025
 * YEAR : 2025
 * TIME : 15:02
 * PROJECT NAME : projet-godwin-qalilab
 * CLASS : OrangeHRMTests
 * PACKAGE : com.qalilab
 * EMAIL: lordandre8@gmail.com
 */

package com.qalilab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * CREATED BY @author GODWIN
 * DATE : 23/04/2025
 * YEAR : 2025
 * TIME : 15:02
 * PROJECT NAME : projet-godwin-qalilab
 * CLASS : OrangeHRMTests
 * PACKAGE : com.qalilab
 * EMAIL: lordandre8@gmail.com
 */
public class OrangeHRMTests {

    private WebDriver driver;

    @BeforeMethod
    public void  setup() {
        // definir le chemin du webDriver
        // navigateur
        driver = new ChromeDriver();
        // url du site
        driver.get("https://opensource-demo.orangehrmlive.com");

    }

    @Test(priority = 0, description = "Connexion avec identifiants valides")
    public void loginValideTest() {

        // Attente pendant 20 secondes
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Saisir les identifiants valides
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");

        // Cliquer sur le bouton Login
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Vérifier que l'utilisateur est redirigé vers le tableau de bord
        WebElement dashboard = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        Assert.assertTrue(dashboard.isDisplayed(), "L'utilisateur n'est pas redirigé vers le tableau de bord.");
        Assert.assertEquals(dashboard.getText(), "Dashboard");
    }

    @Test(priority = 1, description = "Connexion avec identifiants invalides")
    public void loginInvalideTest() {
        // Attente pendant 20 secondes
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Saisir des identifiants invalides
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");

        // Cliquer sur le bouton Login
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Vérifier que le message d'erreur s'affiche
        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Le message d'erreur n'est pas affiché.");
        Assert.assertEquals(errorMessage.getText(), "Invalid credentials");
    }

    @Test(priority = 2, description = "Ajouter Employe")
    public void AddEmployeTest() throws InterruptedException {

        // Attente pendant 20 secondes
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Saisir les identifiants valides
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");

        // Cliquer sur le bouton Login
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Vérifier que l'utilisateur est redirigé vers le tableau de bord
        WebElement dashboard = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        Assert.assertTrue(dashboard.isDisplayed(), "L'utilisateur n'est pas redirigé vers le tableau de bord.");
        Assert.assertEquals(dashboard.getText(), "Dashboard");

        // Étape 1 : Accéder à la section PIM
        driver.findElement(By.cssSelector("a[href=\"/web/index.php/pim/viewPimModule\"]")).click();

        // Ajouter un nouvel employé
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(By.xpath("//button[normalize-space()='Add']")).isEnabled());
        WebElement addBtn = wait.until(d -> d.findElement(By.xpath("//button[normalize-space()='Add']")));
        addBtn.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.clear();
        firstName.sendKeys("Jules");
        WebElement middleName = driver.findElement(By.xpath("//input[@placeholder='Middle Name']"));
        middleName.clear();
        middleName.sendKeys("Kokou");

        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.clear();
        lastName.sendKeys("ABALO");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
