/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import KeyBoardAndMouse.Mouse;
import Location.PointButton;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class JPanelImage extends JPanel{
    private JPanelTable jPanelTable;
    
    public static Point pointCurrentButton = null;
    public static int radiusCurrent = 0;

    public JPanelImage(JPanelTable jPanelTable) {
        this.jPanelTable = jPanelTable;
        this.setBounds(0, 0, jPanelTable.getWidth(), jPanelTable.getHeight());
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        this.addMouseListener((MouseListener) jPanelTable.getjFrameMain());
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(JPanelTable.pointDrawRectStart.x, JPanelTable.pointDrawRectStart.y, JPanelTable.pointDrawRectEnd.x - JPanelTable.pointDrawRectStart.x, JPanelTable.pointDrawRectEnd.y - JPanelTable.pointDrawRectStart.y);
        
        if(pointCurrentButton != null){
            g2.setColor(Color.blue);
            g2.setStroke(new BasicStroke(2));
            g2.fillOval(pointCurrentButton.x - Mouse.radiusSize, pointCurrentButton.y - Mouse.radiusSize, 2*Mouse.radiusSize, 2*Mouse.radiusSize);
            g2.drawRect(pointCurrentButton.x - radiusCurrent, pointCurrentButton.y - radiusCurrent, radiusCurrent*2, radiusCurrent*2);
        }
        
        if(JFrameCustomMouse.pMouseStartCurrent != null && JFrameCustomMouse.pMouseEndCurrent != null && KeyBoardAndMouse.KeyBoard.isDrawLineMouse){
            g2.setColor(Color.green);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(JFrameCustomMouse.pMouseStartCurrent.x, JFrameCustomMouse.pMouseStartCurrent.y, JFrameCustomMouse.pMouseEndCurrent.x, JFrameCustomMouse.pMouseEndCurrent.y);
        }
        
        if(JFrameCustomMouse.pMouseStartCurrent != null && KeyBoardAndMouse.KeyBoard.isDrawLineMouse){
            g2.setColor(Color.red);
            g2.fillOval(JFrameCustomMouse.pMouseStartCurrent.x - 5, JFrameCustomMouse.pMouseStartCurrent.y - 5, 10, 10);
        }       
        if(JFrameCustomMouse.pMouseEndCurrent != null && KeyBoardAndMouse.KeyBoard.isDrawLineMouse){
            g2.setColor(Color.blue);
            g2.fillOval(JFrameCustomMouse.pMouseEndCurrent.x - 5, JFrameCustomMouse.pMouseEndCurrent.y - 5, 10, 10);
        }
    }
}
