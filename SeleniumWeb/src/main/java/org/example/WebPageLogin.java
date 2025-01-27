package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageLogin {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            // Locate the username field and enter the username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("tomsmit");

            // Locate the password field and enter the password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("SuperSecretPassword!");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            // Wait briefly to observe the result
            Thread.sleep(3000);

            // Check if login was successful
            if (driver.getPageSource().contains("Welcome to the Secure Area")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}