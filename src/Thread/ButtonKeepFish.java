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

/**
 *
 * @author Administrator
 */
public class ButtonKeepFish {

    private JFrameMain jFrameMain;

    public ButtonKeepFish(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
    }

    public void PressButton() {
        jFrameMain.click(PointButton.pointKeepFish);
    }

    public boolean checkKeepFish(BufferedImage img) {
        int i, j;
        int blue = 0;
        int red = 0;
        int yelow = 0;
        for (i = 0; i < img.getHeight(); i++) {
            for (j = 0; j < img.getWidth(); j++) {
                Color color = new Color(img.getRGB(j, i));
                if ((color.getRed() == 65)&&(color.getGreen() == 197)&&(color.getBlue()== 243)) {
                    blue++;
                }else if((color.getRed() == 255)&&(color.getGreen() == 199)&&(color.getBlue()== 29)){
                    yelow++;
                }else if((color.getRed() == 235)){
                    red++;
                }
                if (red > 20 && blue > 70 && yelow > 70) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public BufferedImage takeScreenShotKeepFish() {
        BufferedImage screenShot = null;
        try {
            Robot robot = new Robot();
            screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException ex) {
        }
        BufferedImage subImage = null;
        if (screenShot != null) {
            Point p = jFrameMain.getLocation();
            subImage = screenShot.getSubimage(p.x + PointButton.pointKeepFish.x - 100, p.y + jFrameMain.getjPanelMenu().getHeight() + Properties.space + PointButton.pointKeepFish.y - 100, 320, 160);
        }
        return subImage;
    }
}
