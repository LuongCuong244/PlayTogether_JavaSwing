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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import playtogether.JFrameMain;
import playtogether.JPanelTable;

/**
 *
 * @author Administrator
 */
public class ThreadManager extends Thread {

    private JFrameMain jFrameMain;
    private BufferedImage screenShot = null;

    public static long time = 0;
    public static int countFish = 0;
    public static boolean isRunTime = false;
    public static Timer timer;

    private StringBuilder string = new StringBuilder();

    private ButtonKeepFish buttonKeepFish;
    private ButtonBalo buttonBalo;
    private ButtonGarbage buttonGarbage;

    private int width = Math.abs(JPanelTable.pointDrawRectEnd.x - JPanelTable.pointDrawRectStart.x);
    private int height = Math.abs(JPanelTable.pointDrawRectEnd.y - JPanelTable.pointDrawRectStart.y);
    private BufferedImage imgExclamationMark;

    public static boolean isColorful = true;

    public ThreadManager(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
        buttonKeepFish = new ButtonKeepFish(jFrameMain);
        buttonBalo = new ButtonBalo(jFrameMain);
        buttonGarbage = new ButtonGarbage(jFrameMain);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                if ((time / 3600) < 10) {
                    string.append(0).append(time / 3600);
                } else {
                    string.append(time / 3600);
                }
                string.append(":");
                if (((time % 3600) / 60) < 10) {
                    string.append(0).append((time % 3600) / 60);
                } else {
                    string.append((time % 3600) / 60);
                }
                string.append(":");
                if (((time % 3600) % 60) < 10) {
                    string.append(0).append((time % 3600) % 60);
                } else {
                    string.append((time % 3600) % 60);
                }
                jFrameMain.getjPanelMenu().getTxtTime().setText(string.toString());
                string.delete(0, string.length());
            }
        });
    }

    @Override
    public void run() {
        System.out.println("Start");
        countFish = JFrameMain.countFish;
        time = JFrameMain.time;
        if (isRunTime) {
            timer.start();
        }
        int i, j, countWhite;
        LocalTime t1 = LocalTime.now();
        Point pointRandom = new Point();
        while (true) {
            try {
                BufferedImage imgBefore = takeAScreenShot();
                pointRandom.setLocation(PointButton.pointGoFishing.x + ((Math.random()) * (2 * PointButton.radiusGoFishing) - PointButton.radiusGoFishing), PointButton.pointGoFishing.y + ((Math.random()) * (2 * PointButton.radiusGoFishing) - PointButton.radiusGoFishing));
                jFrameMain.click(pointRandom);
                Thread.sleep(7000);
                if (compareImage(imgBefore, takeAScreenShot())) { // không có sự thay đổi: có thể do cần câu hỏng, hoặc chưa lôi cần câu ra.
                    if (buttonBalo.checkBalo() == false) { // không phải Balo thì là rác.
                        pointRandom.setLocation(PointButton.pointGarbage.x + ((Math.random()) * (2 * PointButton.radiusGarbage) - PointButton.radiusGarbage), PointButton.pointGarbage.y + ((Math.random()) * (2 * PointButton.radiusGarbage) - PointButton.radiusGarbage));
                        jFrameMain.click(pointRandom);
                    } else {
                        Thread.sleep((long) ((Math.random() * ((1500 - 500) + 1)) + 500));
                        pointRandom.setLocation(PointButton.pointBalo.x + ((Math.random()) * (2 * PointButton.radiusBalo) - PointButton.radiusBalo), PointButton.pointBalo.y + ((Math.random()) * (2 * PointButton.radiusBalo) - PointButton.radiusBalo));
                        jFrameMain.click(pointRandom);

                        Thread.sleep((long) ((Math.random() * ((1500 - 500) + 1)) + 500));

                        pointRandom.setLocation(PointButton.pointTool.x + ((Math.random()) * (2 * PointButton.radiusTool) - PointButton.radiusTool), PointButton.pointTool.y + ((Math.random()) * (2 * PointButton.radiusTool) - PointButton.radiusTool));
                        jFrameMain.click(pointRandom);

                        Thread.sleep((long) ((Math.random() * ((1500 - 500) + 1)) + 500));

                        pointRandom.setLocation(PointButton.pointFix.x + ((Math.random()) * (2 * PointButton.radiusFix) - PointButton.radiusFix), PointButton.pointFix.y + ((Math.random()) * (2 * PointButton.radiusFix) - PointButton.radiusFix));
                        jFrameMain.click(pointRandom);

                        Thread.sleep((long) ((Math.random() * ((1500 - 500) + 1)) + 500));

                        pointRandom.setLocation(PointButton.pointCoin.x + ((Math.random()) * (2 * PointButton.radiusCoin) - PointButton.radiusCoin), PointButton.pointCoin.y + ((Math.random()) * (2 * PointButton.radiusCoin) - PointButton.radiusCoin));
                        jFrameMain.click(pointRandom);

                        Thread.sleep((long) ((Math.random() * ((2000 - 1500) + 1)) + 1500));
                        pointRandom.setLocation(PointButton.pointCoin.x + ((Math.random()) * (2 * PointButton.radiusCoin) - PointButton.radiusCoin), PointButton.pointCoin.y + ((Math.random()) * (2 * PointButton.radiusCoin) - PointButton.radiusCoin));
                        jFrameMain.click(pointRandom);

                        Thread.sleep((long) ((Math.random() * ((2000 - 1000) + 1)) + 1000));
                        pointRandom.setLocation(PointButton.pointExit.x + ((Math.random()) * (2 * PointButton.radiusExit) - PointButton.radiusExit), PointButton.pointExit.y + ((Math.random()) * (2 * PointButton.radiusExit) - PointButton.radiusExit));
                        jFrameMain.click(pointRandom);
                    }
                    Thread.sleep((long) ((Math.random() * ((1500 - 500) + 1)) + 500));
                    pointRandom.setLocation(PointButton.pointGoFishing.x + ((Math.random()) * (2 * PointButton.radiusGoFishing) - PointButton.radiusGoFishing), PointButton.pointGoFishing.y + ((Math.random()) * (2 * PointButton.radiusGoFishing) - PointButton.radiusGoFishing));
                    jFrameMain.click(pointRandom);
                }
                Thread.sleep(3000);
                countWhite = 0;
                imgExclamationMark = takeASubScreenShot();
                LocalTime t3 = LocalTime.now();
                boolean isPause2 = true, isPause = true;
                BufferedImage img;
                while (Duration.between(t3, LocalTime.now()).getSeconds() < 50) {
                    // sóng lặng
                    if (isColorful) {
                        // đa màu sắc
                        img = takeASubScreenShot();
                        int c = 0;
                        int startColor = img.getRGB(0, 0);
                        isPause2 = false;
                        for (i = 0; i < img.getHeight(); i++) {
                            isPause = false;
                            for (j = 0; j < img.getWidth(); j++) {
                                if (startColor != img.getRGB(j, i)) {
                                    System.out.println(c);
                                    c = 0;
                                    isPause = true;
                                    break;
                                }else{
                                    c++;
                                }
                            }
                            if (isPause) {
                                isPause2 = true;
                                break;
                            }
                        }
                        if (isPause2 == false) {
                            pointRandom.setLocation(PointButton.pointDragFish.x + ((Math.random()) * (2 * PointButton.radiusDragFish) - PointButton.radiusDragFish), PointButton.pointDragFish.y + ((Math.random()) * (2 * PointButton.radiusDragFish) - PointButton.radiusDragFish));
                            jFrameMain.click(pointRandom);
                            break;
                        }
                    } else {
                        if (compareSubImage(imgExclamationMark, takeASubScreenShot()) == false && isColorful == false) {
                            pointRandom.setLocation(PointButton.pointDragFish.x + ((Math.random()) * (2 * PointButton.radiusDragFish) - PointButton.radiusDragFish), PointButton.pointDragFish.y + ((Math.random()) * (2 * PointButton.radiusDragFish) - PointButton.radiusDragFish));
                            jFrameMain.click(pointRandom);
                            break;
                        }
                    }
                }
                Thread.sleep(5000);
                if (buttonKeepFish.checkKeepFish(buttonKeepFish.takeScreenShotKeepFish())) {
                    countFish++;
                    jFrameMain.getjPanelMenu().getTxtFish().setText(countFish + "");
                    pointRandom.setLocation(PointButton.pointKeepFish.x + ((Math.random()) * (2 * PointButton.radiusKeepFish) - PointButton.radiusKeepFish), PointButton.pointKeepFish.y + ((Math.random()) * (2 * PointButton.radiusKeepFish) - PointButton.radiusKeepFish));
                    jFrameMain.click(pointRandom);
                } else if (buttonGarbage.checkGarbage(buttonGarbage.takeScreenShotGarbage())) {
                    jFrameMain.getjPanelMenu().getTxtFish().setText(countFish + "");
                    pointRandom.setLocation(PointButton.pointGarbage.x + ((Math.random()) * (2 * PointButton.radiusGarbage) - PointButton.radiusGarbage), PointButton.pointGarbage.y + ((Math.random()) * (2 * PointButton.radiusGarbage) - PointButton.radiusGarbage));
                }
                Thread.sleep((long) ((Math.random() * ((2000 - 1000) + 1)) + 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public BufferedImage takeASubScreenShot() {
        try {
            Robot robot = new Robot();
            screenShot = robot.createScreenCapture(new Rectangle(jFrameMain.getLocation().x + JPanelTable.pointDrawRectStart.x, jFrameMain.getLocation().y + jFrameMain.getjPanelMenu().getHeight() + Properties.space + JPanelTable.pointDrawRectStart.y, width, height));
        } catch (AWTException ex) {
        }
        return screenShot;
    }

    public BufferedImage takeAScreenShot() {
        try {
            Robot robot = new Robot();
            screenShot = robot.createScreenCapture(new Rectangle(jFrameMain.getLocation().x + jFrameMain.getjPanelTable().getWidth() / 3, jFrameMain.getLocation().y + jFrameMain.getjPanelMenu().getHeight() + Properties.space + jFrameMain.getjPanelTable().getHeight() / 3, jFrameMain.getjPanelTable().getWidth() / 3, (jFrameMain.getjPanelTable().getHeight() * 5) / 12));
        } catch (AWTException ex) {
        }
        return screenShot;
    }

    public boolean compareImage(BufferedImage img1, BufferedImage img2) {
        int w1 = img1.getWidth();
        int w2 = img2.getWidth();
        int h1 = img1.getHeight();
        int h2 = img2.getHeight();
        long diff = 0;
        for (int j = 0; j < h1; j++) {
            for (int i = 0; i < w1; i++) {
                //Getting the RGB values of a pixel
                int pixel1 = img1.getRGB(i, j);
                Color color1 = new Color(pixel1, true);
                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();
                int pixel2 = img2.getRGB(i, j);
                Color color2 = new Color(pixel2, true);
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();
                //sum of differences of RGB values of the two images
                long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
                diff = diff + data;
            }
        }
        double avg = diff / (w1 * h1 * 3);
        double percentage = (avg / 255) * 100;
        if (percentage < 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean compareSubImage(BufferedImage img1, BufferedImage img2) {
        int w1 = img1.getWidth();
        int w2 = img2.getWidth();
        int h1 = img1.getHeight();
        int h2 = img2.getHeight();
        long diff = 0;
        for (int j = 0; j < h1; j++) {
            for (int i = 0; i < w1; i++) {
                //Getting the RGB values of a pixel
                int pixel1 = img1.getRGB(i, j);
                Color color1 = new Color(pixel1, true);
                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();
                int pixel2 = img2.getRGB(i, j);
                Color color2 = new Color(pixel2, true);
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();
                //sum of differences of RGB values of the two images
                long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
                diff = diff + data;
            }
        }
        double avg = diff / (w1 * h1 * 3);
        double percentage = (avg / 255) * 100;
        if (percentage < 2) {
            return true;
        } else {
            return false;
        }
    }
}
