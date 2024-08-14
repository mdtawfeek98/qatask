package com.java.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QaTask {

    public static void main(String[] args) {
    	
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tawfe\\eclipse-workspace\\QA_Task\\Resources\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage with the search functionality
            driver.get("https://www.google.com");

            // Locate the search input field using its name, id, or another attribute
            WebElement searchBox = driver.findElement(By.name("searchBox"));

            // Enter the search term "Selenium" into the search box
            searchBox.sendKeys("Iphone");

            // Locate the search button and click it
            WebElement searchButton = driver.findElement(By.id("searchButton"));
            searchButton.click();

            // Wait until the results area is visible (use an appropriate locator for your case)
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));

            // Verify that the results area displays the expected text
            String expectedText = "Results for 'Selenium'";
            String actualText = results.getText();
            
            if (actualText.contains(expectedText)) {
                System.out.println("Test passed: Results area displays the correct text.");
            } else {
                System.out.println("Test failed: Results area does not display the expected text.");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
