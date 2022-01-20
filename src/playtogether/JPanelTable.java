/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Administrator
 */
public class JPanelTable extends JPanel{
    private JFrameMain jFrameMain;
    private JPanelImage jPanelImage;
    
    public static Point pointDrawRectStart = new Point(30,30);
    public static Point pointDrawRectEnd = new Point(130,130);
    
    public JPanelTable(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
        this.setBounds(0, 150 + 100, JFrameMain.SCREEN_WIDTH, JFrameMain.SCREEN_HEIGHT - 150 - 100);
        this.setBorder(new LineBorder(Color.BLUE, 2));
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.f));
        this.setFocusable(true);
        this.addKeyListener(jFrameMain);
        this.addMouseListener((MouseListener) jFrameMain);
        this.setLayout(new BorderLayout());
        jPanelImage = new JPanelImage(this);
        jPanelImage.setVisible(true);
        this.add(jPanelImage, BorderLayout.CENTER);
    }

    public JPanelImage getjPanelImage() {
        return jPanelImage;
    }

    public void setjPanelImage(JPanelImage jPanelImage) {
        this.jPanelImage = jPanelImage;
    }

    public JFrameMain getjFrameMain() {
        return jFrameMain;
    }

    public void setjFrameMain(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
    }
    
    
}
