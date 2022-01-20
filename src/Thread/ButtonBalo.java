/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import DataAndProperties.Properties;
import Location.PointButton;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import playtogether.JFrameMain;
import playtogether.JPanelTable;

/**
 *
 * @author Administrator
 */
public class ButtonBalo {
    private JFrameMain jFrameMain;

    public ButtonBalo(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
    }

    public boolean checkBalo() {
        BufferedImage img = takeASubScreenShot();
        int i,j;
        int red = 0;
        for(i = 0;i<img.getHeight();i++){
            for(j = 0;j<img.getWidth();j++){
                Color color = new Color(img.getRGB(j, i));
                if((color.getRed() > 220)&&(color.getRed() < 240)&&(color.getGreen()> 55)&&(color.getGreen()< 75)&&(color.getBlue()> 55)&&(color.getBlue()< 75)){
                    red++;
                }
                if(red > 40){
                    return true;
                }
            }
        }
        return false;
    }

    public BufferedImage takeASubScreenShot() {
        BufferedImage screenShot = null;
        try {
            Robot robot = new Robot();
            screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException ex) {
        }
        BufferedImage subImage = null;
        if (screenShot != null) {
            Point p = jFrameMain.getLocation();
            subImage = screenShot.getSubimage(p.x + PointButton.pointBalo.x - 15, p.y + jFrameMain.getjPanelMenu().getHeight() + Properties.space + PointButton.pointBalo.y - 15, 30, 30);
        }
        return subImage;
    }
}
