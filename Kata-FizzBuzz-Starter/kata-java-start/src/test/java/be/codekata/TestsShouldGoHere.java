package be.codekata;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestsShouldGoHere {

    @Test
    public void failingTest(){
        assertThat(false,equalTo(true));
    }

    @Test
    void Genk() {
        // we halen de chromedriver uit verkenner en geven die een naam driver
        System.setProperty("webdriver.chrome.driver", "C://browsers/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //we openen de website HLN in google
        driver.get("https://www.hln.be");

        //klikken op de zoekbalk
        WebElement zoekknop = driver.findElement(By.xpath("/html/body/header/section[3]/div[1]/div/nav/div[1]/div/label/span"));
        zoekknop.click();

        WebElement searchbar = driver.findElement(By.xpath("/html/body/header/section[3]/div[2]/div[2]/div/form/input"));
        //we sturen "KRC Genk" in de searchbar en submitten dat
        searchbar.sendKeys("KRC Genk");
        searchbar.submit();

        //nemen de bovenste link en klikken erop
        WebElement genk = driver.findElement(By.xpath("//*[@id=\"page-main-content\"]/div[2]/div/div/div[1]/div/ul/li[1]/article/a/div/div[2]/h2"));
        genk.click();

        //krijg te titel van de site terug
        WebElement title = driver.findElement(By.xpath("//*[@id=\"page-main-content\"]/div[2]/div[2]/div/div/div[1]/article/div/header/h1"));

        assertThat("Gwyneth Vanaenrode en KRC Genk Ladies pakken punt tegen Standard en spelen PO1: “We speelden een schitterende terugronde”",equalTo(title));

        driver.quit();

    }

    @Test
    public void passingTest(){
        assertThat(true,equalTo(true));
    }
}
