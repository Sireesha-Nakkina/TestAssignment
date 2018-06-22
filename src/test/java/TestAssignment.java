import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestAssignment {

    public static void main(String[] args){
        String url = "http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true";
        WebDriver driver=null;

        ChromeDriverManager.getInstance().setup();
        driver= new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        driver.get (url);
        driver.findElement(By.xpath("//*[@id='wpDesktop.DesktopIcon15.Grid.gContent.imImage']")).click();
        driver.close();
    }
}
