/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Longo
 */
public class SimpleBot {

    /**
     * @param args the command line arguments
     */
    private static WebDriver drive = null;
    static ResourceField[] ResourceList = new ResourceField[18];
    static int Time;

    static int CheckTime(String Timer) {
        String Seconds = Timer.substring(5);
        String Minutes = Timer.substring(2, 4);
        String Hours = Timer.substring(0, 2);
        System.out.println(Hours);
        System.out.println(Seconds);
        System.out.println(Minutes);
        int secs=30;
        int mins=15;
        
        try {
            int Mins = Integer.parseInt(Minutes) * 60;
            mins=Mins;
        } catch (NumberFormatException e) {
            System.out.println("not a number"+Minutes);
            
        }
        try {
            int Secs = Integer.parseInt(Seconds);
            secs=Secs;
        } catch (NumberFormatException e) {
            System.out.println("not a number"+Seconds);
        }
        int TimeLeft = secs+mins;
        System.out.println(TimeLeft);
        return TimeLeft;

    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        String path = System.getProperty("user.dir") + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        drive = new ChromeDriver();
        TimeManager Timer = new TimeManager();
        drive.get("https://ts80.travian.com/dorf1.php");
        System.out.println(drive.getTitle());
        drive.findElement(By.name("name")).sendKeys("granlongo");
        drive.findElement(By.name("password")).sendKeys("longov9");
        drive.findElement(By.name("s1")).click();
        drive.findElement(By.id("n1")).click();

        for (int i = 1; i < 19; i++) {

            ResourceList[i - 1] = new ResourceField(drive.findElement(By.cssSelector("#rx > area:nth-child(" + i + ")")).getAttribute("alt"), "#rx > area:nth-child(" + i + ")");
        }

        for (int x = 0; x < 5; x++) {
            for (int i = 18; i < 19; i++) {
              // drive.findElement(By.cssSelector("#sidebarBoxVillagelist > div.sidebarBoxInnerBox > div.innerBox.content > ul > li:nth-child(5) > a > div")).click();

                drive.findElement(By.id("n1")).click();
                drive.findElement(By.cssSelector(ResourceList[i - 1].CSSselector)).click();
                drive.findElement(By.className("section1")).click();
                Time = CheckTime(drive.findElement(By.cssSelector("#content > div.boxes.buildingList > div.boxes-contents.cf > ul > li > div.buildDuration > span")).getText());
                Timer.procrastinate(Time, drive);
            }

        }
    }
}
