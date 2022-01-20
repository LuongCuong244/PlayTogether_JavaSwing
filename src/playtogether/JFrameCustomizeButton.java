/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import Location.PointButton;
import Thread.ButtonBalo;
import Thread.ThreadActivateMouse;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Administrator
 */
public class JFrameCustomizeButton extends JDialog implements ActionListener {

    private JFrameMain jFrameMain;
    public static int SCREEN_WIDTH_CUSTOM_BUTTON = 500;
    public static int SCREEN_HEIGHT_CUSTOM_BUTTON = 200;

    private JPanel jpn;

    private JPanel jpnContainer;
    private JButton btnBalo, btnCoin, btnDragFish, btnExit, btnFix, btnGarbage, btnGoFishing, btnKeepFish, btnTool,btnHide;
    private JButton btnGoUp_GoFishing_Start,btnChat;
    private float fontSize = 10.f;
    private Color colorBackgoundButton = new Color(27, 79, 147);
    private Color colorForegoundButton = Color.white;

    public JFrameCustomizeButton(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((int) dimension.getWidth() - SCREEN_WIDTH_CUSTOM_BUTTON) / 2, ((int) dimension.getHeight() - SCREEN_HEIGHT_CUSTOM_BUTTON) / 2, SCREEN_WIDTH_CUSTOM_BUTTON, SCREEN_HEIGHT_CUSTOM_BUTTON);
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(true);

        jpn = new JPanel();
        jpn.setLayout(new BorderLayout(0, 10));
        jpn.setBackground(new Color(254, 235, 208));
        this.add(jpn, BorderLayout.CENTER);

        JLabel titile = new JLabel("Tùy chỉnh vị trí nút", SwingConstants.CENTER);
        titile.setForeground(Color.red);
        titile.setFont(titile.getFont().deriveFont(25.f));
        jpn.add(titile, BorderLayout.NORTH);

        jpnContainer = new JPanel();
        jpnContainer.setLayout(new GridLayout(3, 6, 5, 5));
        jpnContainer.setBackground(new Color(254, 235, 208));
        jpnContainer.setBorder(BorderFactory.createTitledBorder(""));
        Border border = jpnContainer.getBorder();
        Border margin = new EmptyBorder(5, 5, 5, 5);
        jpnContainer.setBorder(new CompoundBorder(border, margin));
        jpn.add(jpnContainer);
        setComponentjpnContainer();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                JPanelMenu.isOpenCustomMouse = false;
            }
        });
    }

    private void setComponentjpnContainer() {
        btnBalo = new JButton("Balo");
        btnBalo.setActionCommand("btnBalo");
        btnBalo.addActionListener(this);
        btnBalo.setFont(btnBalo.getFont().deriveFont(fontSize));
        btnBalo.setBackground(colorBackgoundButton);
        btnBalo.setForeground(colorForegoundButton);
        jpnContainer.add(btnBalo);

        btnCoin = new JButton("Tiền sửa cần");
        btnCoin.setActionCommand("btnCoin");
        btnCoin.addActionListener(this);
        btnCoin.setFont(btnCoin.getFont().deriveFont(fontSize));
        btnCoin.setBackground(colorBackgoundButton);
        btnCoin.setForeground(colorForegoundButton);
        jpnContainer.add(btnCoin);

        btnDragFish = new JButton("Kéo cần câu");
        btnDragFish.setActionCommand("btnDragFish");
        btnDragFish.addActionListener(this);
        btnDragFish.setFont(btnDragFish.getFont().deriveFont(fontSize));
        btnDragFish.setBackground(colorBackgoundButton);
        btnDragFish.setForeground(colorForegoundButton);
        jpnContainer.add(btnDragFish);

        btnExit = new JButton("Thoát khỏi Balo");
        btnExit.setActionCommand("btnExit");
        btnExit.addActionListener(this);
        btnExit.setFont(btnExit.getFont().deriveFont(fontSize));
        btnExit.setBackground(colorBackgoundButton);
        btnExit.setForeground(colorForegoundButton);
        jpnContainer.add(btnExit);

        btnFix = new JButton("Sửa cần");
        btnFix.setActionCommand("btnFix");
        btnFix.addActionListener(this);
        btnFix.setFont(btnFix.getFont().deriveFont(fontSize));
        btnFix.setBackground(colorBackgoundButton);
        btnFix.setForeground(colorForegoundButton);
        jpnContainer.add(btnFix);

        btnGarbage = new JButton("Rác");
        btnGarbage.setActionCommand("btnGarbage");
        btnGarbage.addActionListener(this);
        btnGarbage.setFont(btnGarbage.getFont().deriveFont(fontSize));
        btnGarbage.setBackground(colorBackgoundButton);
        btnGarbage.setForeground(colorForegoundButton);
        jpnContainer.add(btnGarbage);

        btnGoFishing = new JButton("Câu cá");
        btnGoFishing.setActionCommand("btnGoFishing");
        btnGoFishing.addActionListener(this);
        btnGoFishing.setFont(btnGoFishing.getFont().deriveFont(fontSize));
        btnGoFishing.setBackground(colorBackgoundButton);
        btnGoFishing.setForeground(colorForegoundButton);
        jpnContainer.add(btnGoFishing);

        btnKeepFish = new JButton("Bảo quản cá");
        btnKeepFish.setActionCommand("btnKeepFish");
        btnKeepFish.addActionListener(this);
        btnKeepFish.setFont(btnKeepFish.getFont().deriveFont(fontSize));
        btnKeepFish.setBackground(colorBackgoundButton);
        btnKeepFish.setForeground(colorForegoundButton);
        jpnContainer.add(btnKeepFish);

        btnTool = new JButton("Công cụ");
        btnTool.setActionCommand("btnTool");
        btnTool.addActionListener(this);
        btnTool.setFont(btnGarbage.getFont().deriveFont(fontSize));
        btnTool.setBackground(colorBackgoundButton);
        btnTool.setForeground(colorForegoundButton);
        jpnContainer.add(btnTool);
        
        btnChat = new JButton("Chat");
        btnChat.setActionCommand("btnChat");
        btnChat.addActionListener(this);
        btnChat.setFont(btnChat.getFont().deriveFont(fontSize));
        btnChat.setBackground(colorBackgoundButton);
        btnChat.setForeground(colorForegoundButton);
        jpnContainer.add(btnChat);
        
        btnHide = new JButton("Ẩn");
        btnHide.setActionCommand("btnHide");
        btnHide.addActionListener(this);
        btnHide.setFont(btnHide.getFont().deriveFont(fontSize));
        btnHide.setBackground(colorBackgoundButton);
        btnHide.setForeground(colorForegoundButton);
        jpnContainer.add(btnHide);
        
        btnGoUp_GoFishing_Start = new JButton("Đi câu cá [S]");
        btnGoUp_GoFishing_Start.setActionCommand("btnGoUp_GoFishing_Start");
        btnGoUp_GoFishing_Start.addActionListener(this);
        btnGoUp_GoFishing_Start.setFont(btnGoUp_GoFishing_Start.getFont().deriveFont(fontSize));
        btnGoUp_GoFishing_Start.setBackground(Color.cyan);
        btnGoUp_GoFishing_Start.setForeground(Color.BLACK);
        jpnContainer.add(btnGoUp_GoFishing_Start);       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnBalo": {
                
                JPanelImage.pointCurrentButton = PointButton.pointBalo;
                JPanelImage.radiusCurrent = PointButton.radiusBalo;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusBalo);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Balo");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnCoin": {
                
                JPanelImage.pointCurrentButton = PointButton.pointCoin;
                JPanelImage.radiusCurrent = PointButton.radiusCoin;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusCoin);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Tiền sửa cần");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnDragFish": {
                
                JPanelImage.pointCurrentButton = PointButton.pointDragFish;
                JPanelImage.radiusCurrent = PointButton.radiusDragFish;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusDragFish);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Kéo cần câu");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnExit": {
                
                JPanelImage.pointCurrentButton = PointButton.pointExit;
                JPanelImage.radiusCurrent = PointButton.radiusExit;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusExit);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Thoát Balo");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnFix": {
                
                JPanelImage.pointCurrentButton = PointButton.pointFix;
                JPanelImage.radiusCurrent = PointButton.radiusFix;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusFix);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Sửa cần câu");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnGarbage": {
                
                JPanelImage.pointCurrentButton = PointButton.pointGarbage;
                JPanelImage.radiusCurrent = PointButton.radiusGarbage;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusGarbage);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Rác");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnGoFishing": {
                
                JPanelImage.pointCurrentButton = PointButton.pointGoFishing;
                JPanelImage.radiusCurrent = PointButton.radiusGoFishing;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusGoFishing);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Câu cá");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnKeepFish": {
                
                JPanelImage.pointCurrentButton = PointButton.pointKeepFish;
                JPanelImage.radiusCurrent = PointButton.radiusKeepFish;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusKeepFish);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Bảo quản cá");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnTool": {
                
                JPanelImage.pointCurrentButton = PointButton.pointTool;
                JPanelImage.radiusCurrent = PointButton.radiusTool;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(PointButton.radiusTool);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Công cụ");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnChat":{
                JPanelImage.pointCurrentButton = PointButton.pointChat;
                JPanelImage.radiusCurrent = PointButton.radiusChat;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(JPanelImage.radiusCurrent);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Chat");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnHide":{
                JPanelImage.pointCurrentButton = null;
                JPanelImage.radiusCurrent = 0;
                jFrameMain.getjPanelMenu().getJspSizeRadius().setValue(0);
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Ẩn");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
            case "btnGoUp_GoFishing_Start":{
                JPanelImage.pointCurrentButton = JFrameCustomMouse.pMouseGoUpStart;
                jFrameMain.getjPanelMenu().getBtnCustomizeButton().setText("Đang chọn: Đi câu (S)");
                
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                
                JPanelMenu.isOpenCustomMouse = false;
                this.setVisible(false);
                break;
            }
        }
    }
}
