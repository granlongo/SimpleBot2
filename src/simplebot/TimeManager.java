/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Longo
 */
public class TimeManager {

    public void procrastinate(int Time, WebDriver drive) throws InterruptedException {

        for (int i = Time; i > 0; i = i - 60) {
            if (Time < 60) {
                Thread.sleep(Time * 60);

            } else if (Time > 59) {
                drive.findElement(By.id("n2")).click();
                drive.findElement(By.id("n3")).click();
                drive.findElement(By.id("n1")).click();
                Thread.sleep(60000);
            }
        }
    }
}
