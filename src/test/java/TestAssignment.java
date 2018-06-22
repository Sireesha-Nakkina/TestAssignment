import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        Actions actions=new Actions(driver);
        WebDriverWait wait=new WebDriverWait(driver,90);

        //Select Setting
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"wpDesktop.DesktopIcon15.Grid.gContent.imImage\"]")))).click();


        //Select Mail,Contacts,Calendars
        WebElement mailContacts= driver.findElement(By.xpath("//*[@id=\"siMailContactsCalendars.Grid.tbText\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", mailContacts);
        mailContacts.click();

        //Select Maggie Brown
        WebElement magiie_brown=driver.findElement(By.xpath("//*[@id=\"lbAccounts.Grid.Border.ScrollViewer.Grid.Viewport" +
                ".ScrollContentPresenter.OuterElement.InnerElement.ItemsPresenter.StackPanel.SettingsItemSubMenu.Grid.rectClickArea\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", magiie_brown);
        actions.click(magiie_brown).perform();

        //Select mbrown@gmail.com
        driver.findElement(By.xpath("//*[@id=\"siAccount.Grid.tbStateText\"]")).click();

        //Select Advanced
        driver.findElement(By.xpath("//*[@id=\"siAdvanced.Grid.rectClickArea\"]")).click();


        //Slide the button to enable Use SSL
        WebElement ssl=driver.findElement(By.xpath("//*[@id=\"siUseSSL.Grid.tbOnOff.Grid.SwitchRoot.Canvas.SwitchThumb.Grid.Border.Grid.Background\"]"));
        WebElement target =driver.findElement(By.xpath("//*[@id=\"siUseSSL.Grid.tbOnOff.Grid.SwitchRoot\"]"));
        actions.moveToElement(ssl).dragAndDropBy(target,10,0);


        //Verify that the server port is set to 993
        //WebElement port= driver.findElement(By.xpath("Xpath of the element "));
        //Verify.verify(port.getText().contains("993"),"Port is not set to 993");


        //At the top, Select Account
        WebElement account=driver.findElement(By.xpath("//*[@id=\"btnAccount.grid.contentPresenter.TextBlock\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", account);
        actions.click(account).perform();


        //Click done
        driver.findElement(By.xpath("//*[@id=\"btnDone.grid.contentPresenter.TextBlock\"]")).click();


        //Connect to CorpNet-wireless Wi-Fi as follows

        //Click Wi-Fi
        WebElement wifi=driver.findElement(By.xpath("//*[@id=\"rectClickArea\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", wifi);
        actions.click(wifi).perform();


        //Click CorpNet
        driver.findElement(By.xpath("//*[@id=\"SettingsItemNetwork.Grid.rectClickArea\"]")).click();

        //Enter the password
        WebElement password=driver.findElement(By.xpath("//*[@id=\"tbPassword.LayoutRoot.grdMousePreview\"]"));
        actions.sendKeys(password,"@CorpNetWeRSecure!&").perform();

        //Click Join
        actions.click(driver.findElement(By.xpath("//*[@id=\"btnJoin.grid.contentPresenter.TextBlock\"]"))).perform();

        //Click  Done
        actions.click(driver.findElement(By.xpath("//*[@id=\"bDone.Grid.contentPresenter.TextBlock\"]"))).perform();

        //driver.close();
    }
}
