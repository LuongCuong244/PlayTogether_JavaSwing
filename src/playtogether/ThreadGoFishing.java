/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public class ThreadGoFishing extends Thread {

    private String path = System.getProperty("user.dir") + File.separator + "buttonGoFishing.jpg";
    private BufferedImage imgMenu;
    private BufferedImage imgButtonGoFishing;
    private JFrameMenu jFrameMenu;

    public ThreadGoFishing(JFrameMenu jFrameMenu) {
        this.jFrameMenu = jFrameMenu;
    }

    @Override
    public void run() {
        imgMenu = JFrameMenu.takeAScreenShot();
        if (imgMenu == null) {
            return;
        }
        imgButtonGoFishing = JFrameMenu.takeImageFromComputer(path);
        if (imgButtonGoFishing == null) {
            return;
        }
        int[][][] chartButton = new int[4][4][4];  // Biểu đồ màu của ảnh Button
        for (int x = 0; x < imgButtonGoFishing.getWidth(); x++) {
            for (int y = 0; y < imgButtonGoFishing.getHeight(); y++) {
                int color = imgButtonGoFishing.getRGB(x, y);
                int red = (color & 0x00ff0000) >> 16;
                int green = (color & 0x0000ff00) >> 8;
                int blue = color & 0x000000ff;
                chartButton[red / 64][green / 64][blue / 64]++;
            }
        }
        int i, j;
        for (i = imgMenu.getWidth() - 1 - imgButtonGoFishing.getWidth(); i >= imgMenu.getWidth()/2; i--) {
            boolean isHadFound = false;
            for (j = imgMenu.getHeight() - 1 - imgButtonGoFishing.getHeight(); j >= 0; j--) {
                int w, h;
                BufferedImage imgSub = imgMenu.getSubimage(i, j, imgButtonGoFishing.getWidth(), imgButtonGoFishing.getHeight());
                
                int[][][] chartSub = new int[4][4][4];
                for (int x = 0; x < imgSub.getWidth(); x++) {
                    for (int y = 0; y < imgSub.getHeight(); y++) {
                        int color = imgSub.getRGB(x, y);
                        int red = (color & 0x00ff0000) >> 16;
                        int green = (color & 0x0000ff00) >> 8;
                        int blue = color & 0x000000ff;
                        chartSub[red / 64][green / 64][blue / 64]++;
                    }
                }
                int dem = 0;
                for (int a = 0; a < 4; a++) {
                    for (int b = 0; b < 4; b++) {
                        for (int c = 0; c < 4; c++) {
                            if(Math.abs(chartButton[a][b][c] - chartSub[a][b][c]) < 30){
                                dem++;
                            }
                        }
                    }
                }
                if(dem >= 60){
                    try {
                    ImageIO.write(imgSub, "jpg", new File("hi.jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(ThreadGoFishing.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println(dem);
                    System.out.println("Đã thấy");
                    System.out.println("i = "+i+" , j = "+j);
                    JFrameMenu.a = i;
                    JFrameMenu.b = j;
                    JFrameMenu.c = imgButtonGoFishing.getWidth();
                    JFrameMenu.d = imgButtonGoFishing.getHeight();
                    jFrameMenu.getJpnContainer().repaint();
                    isHadFound = true;
                    break;
                }
            }
            if (isHadFound) {
                break;
            }
        }
        System.err.println("Không thấy");
    }
}
