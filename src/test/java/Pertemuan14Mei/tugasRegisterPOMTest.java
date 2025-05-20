package Pertemuan14Mei;

import org.example.EmpatBelasMei.tugasRegisterPOM;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class tugasRegisterPOMTest {
    WebDriver driver;
    tugasRegisterPOM registrationPage;

    @Test
    public void registrationTest() {
        // Inisialisasi WebDriver
        driver = new ChromeDriver();
        registrationPage = new tugasRegisterPOM(driver);

        // Membuka halaman registrasi
        registrationPage.openRegistrationPage();
        // Mengisi detail personal
        registrationPage.fillPersonalDetails("John Doe", "john.doe" + System.currentTimeMillis() + "@example.com");
        // Mengisi detail akun
        registrationPage.fillAccountDetails("Password123", "1", "January", "1990");
        // Memilih preferensi
        registrationPage.selectPreferences();
        // Mengisi detail alamat
        registrationPage.fillAddressDetails("John", "Doe", "TechCorp", "123 Tech Street", "TechCity", "TechState", "12345", "United States", "1234567890");
        // Submit registrasi dan validasi pesan sukses
        String successMessage = registrationPage.submitRegistration();
        System.out.println("Pesan sukses: " + successMessage);
        assertEquals("ACCOUNT CREATED!", successMessage.toUpperCase());

        // Menutup browser setelah pengujian selesai
        if (driver != null) {
            driver.quit();
        }
    }
}