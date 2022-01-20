/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import DataAndProperties.Data;
import DataAndProperties.Properties;
import KeyBoardAndMouse.OneLineMouse;
import Location.PointButton;
import Thread.ThreadManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static playtogether.JFrameCustomMouse.listMouseLine;

/**
 *
 * @author Administrator
 */
public class JPanelMenu extends JPanel implements ActionListener {

    private JFrameMain jFrameMain;
    public static boolean isOpenOperationMouse = false;
    public static boolean isOpenCustomMouse = false;

    private Color colorText = Color.WHITE;
    private JPanel jpnResize;
    private JLabel txtPlusTop, txtPlusBottom, txtPlusRight, txtPlusLeft;
    private JSpinner jspPointFrameX, jspPointFrameY, jspHeightFrame, jspWidthFrame;

    private JPanel jpnDefineExclamationMark;
    private JSpinner jsnWidth, jsnHeight;

    private JPanel jpnCountFish;
    private JLabel txtTime;
    private JLabel txtFish;
    private JButton btnRun, btnPause;

    private JPanel jpnGroup;
    private JButton btnOption;
    private JButton btnExit;

    private JPanel jpnCustom;
    private JButton btnCustomizeButton;
    private JButton btnCustomMouse;
    private JSpinner jspSizeRadius;
    private JFrameCustomMouse jFrameCustomMouse;

    private JFrameOption jFrameOption;

    public JPanelMenu(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
        this.setBounds(0, 0, JFrameMain.SCREEN_WIDTH, 150);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        this.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        this.setBackground(new Color(6, 57, 112));
        this.setFocusable(true);
        this.addKeyListener(jFrameMain);
        this.addMouseListener((MouseListener) jFrameMain);

        jpnResize = new JPanel();
        jpnResize.setLayout(new GridLayout(4, 2, 0, 5));
        jpnResize.setBackground(new Color(6, 57, 112));
        this.add(jpnResize);
        setComponentResize();

        jpnDefineExclamationMark = new JPanel();
        jpnDefineExclamationMark.setLayout(new GridLayout(3, 2, 5, 5));
        jpnDefineExclamationMark.setBackground(new Color(6, 57, 112));
        jpnDefineExclamationMark.setBorder(BorderFactory.createTitledBorder(""));
        Border border = jpnDefineExclamationMark.getBorder();
        Border margin = new EmptyBorder(5, 5, 5, 5);
        jpnDefineExclamationMark.setBorder(new CompoundBorder(border, margin));
        this.add(jpnDefineExclamationMark);
        setComponentDefineExclamationMark();

        jpnCountFish = new JPanel();
        jpnCountFish.setLayout(new GridLayout(3, 2, 5, 5));
        jpnCountFish.setBackground(new Color(6, 57, 112));
        jpnCountFish.setBorder(BorderFactory.createTitledBorder(""));
        Border border1 = jpnCountFish.getBorder();
        Border margin1 = new EmptyBorder(5, 5, 5, 5);
        jpnCountFish.setBorder(new CompoundBorder(border1, margin1));
        this.add(jpnCountFish);
        setComponentCountFish();

        jpnCustom = new JPanel();
        jpnCustom.setLayout(new GridLayout(3, 1, 5, 5));
        jpnCustom.setBackground(new Color(6, 57, 112));
        jpnCustom.setBorder(BorderFactory.createTitledBorder(""));
        border = jpnCustom.getBorder();
        margin = new EmptyBorder(5, 5, 5, 5);
        jpnCustom.setBorder(new CompoundBorder(border, margin));
        this.add(jpnCustom);
        setComponentCustom();
        jFrameCustomMouse = new JFrameCustomMouse(jFrameMain);

        jpnGroup = new JPanel();
        jpnGroup.setLayout(new GridLayout(2, 1, 5, 5));
        jpnGroup.setBackground(new Color(6, 57, 112));
        jpnGroup.setBorder(BorderFactory.createTitledBorder(""));
        border = jpnGroup.getBorder();
        margin = new EmptyBorder(5, 5, 5, 5);
        jpnGroup.setBorder(new CompoundBorder(border, margin));
        this.add(jpnGroup);
        setComponentGroup();

        jFrameOption = new JFrameOption(jFrameMain);
    }

    private void setComponentResize() {
        txtPlusTop = new JLabel("Điểm X: ", SwingConstants.CENTER);
        txtPlusTop.setSize(100, 30);
        txtPlusTop.setForeground(colorText);
        jpnResize.add(txtPlusTop);
        txtPlusTop.setFont(txtPlusTop.getFont().deriveFont(10.f));

        SpinnerModel mode1 = new SpinnerNumberModel(JFrameMain.pointJFrame.x, 0, 1920, 5);
        jspPointFrameX = new JSpinner(mode1);
        jspPointFrameX.setSize(100, 30);
        jpnResize.add(jspPointFrameX);
        jspPointFrameX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (((int) jspPointFrameX.getValue() + JFrameMain.SCREEN_WIDTH) > 1920) {
                    jspPointFrameX.setValue(1920 - JFrameMain.SCREEN_WIDTH);
                }
                JFrameMain.pointJFrame.x = (int) jspPointFrameX.getValue();
                jFrameMain.setBoundsToolFrame();
            }
        });

        txtPlusBottom = new JLabel("Điểm Y: ", SwingConstants.CENTER);
        txtPlusBottom.setSize(100, 30);
        txtPlusBottom.setForeground(colorText);
        jpnResize.add(txtPlusBottom);
        txtPlusBottom.setFont(txtPlusBottom.getFont().deriveFont(10.f));

        SpinnerModel mode2 = new SpinnerNumberModel(JFrameMain.pointJFrame.y, 0, 1080, 5);
        jspPointFrameY = new JSpinner(mode2);
        jspPointFrameY.setSize(100, 30);
        jpnResize.add(jspPointFrameY);
        jspPointFrameY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (((int) jspPointFrameY.getValue() + JFrameMain.SCREEN_HEIGHT) > 1080) {
                    jspPointFrameY.setValue(1080 - JFrameMain.SCREEN_HEIGHT);
                }
                JFrameMain.pointJFrame.y = (int) jspPointFrameY.getValue();
                jFrameMain.setBoundsToolFrame();
            }
        });

        txtPlusLeft = new JLabel("Độ rộng: ", SwingConstants.CENTER);
        txtPlusLeft.setSize(100, 30);
        txtPlusLeft.setForeground(colorText);
        jpnResize.add(txtPlusLeft);
        txtPlusLeft.setFont(txtPlusLeft.getFont().deriveFont(10.f));

        SpinnerModel mode3 = new SpinnerNumberModel(JFrameMain.SCREEN_WIDTH, 600, 1920, 1);
        jspWidthFrame = new JSpinner(mode3);
        jspWidthFrame.setSize(100, 30);
        jpnResize.add(jspWidthFrame);
        jspWidthFrame.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JFrameMain.SCREEN_WIDTH = (int) jspWidthFrame.getValue();
                jFrameMain.setBoundsToolFrame();
            }
        });

        txtPlusRight = new JLabel("Độ dài: ", SwingConstants.CENTER);
        txtPlusRight.setSize(100, 30);
        txtPlusRight.setForeground(colorText);
        jpnResize.add(txtPlusRight);
        txtPlusRight.setFont(txtPlusRight.getFont().deriveFont(10.f));

        SpinnerModel mode4 = new SpinnerNumberModel(JFrameMain.SCREEN_HEIGHT, 300, 1080, 1);
        jspHeightFrame = new JSpinner(mode4);
        jspHeightFrame.setSize(100, 30);
        jpnResize.add(jspHeightFrame);
        jspHeightFrame.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JFrameMain.SCREEN_HEIGHT = (int) jspHeightFrame.getValue();
                jFrameMain.setBoundsToolFrame();
            }
        });
    }

    private void setComponentDefineExclamationMark() {

        JLabel txtTitle = new JLabel("Xác định: ", SwingConstants.RIGHT);
        txtTitle.setSize(100, 30);
        txtTitle.setForeground(Color.CYAN);
        txtTitle.setFont(txtTitle.getFont().deriveFont(10.f));
        jpnDefineExclamationMark.add(txtTitle);

        JLabel txt = new JLabel("tín hiệu câu");
        txt.setSize(100, 30);
        txt.setForeground(Color.CYAN);
        txt.setFont(txt.getFont().deriveFont(10.f));
        jpnDefineExclamationMark.add(txt);

        JLabel txtWidth = new JLabel("Chiều rộng:");
        txtWidth.setForeground(new Color(255, 255, 255));
        txtWidth.setFont(txtWidth.getFont().deriveFont(10.f));
        jpnDefineExclamationMark.add(txtWidth);

        SpinnerModel modelWidth = new SpinnerNumberModel(Properties.width_Move_Rect_ExclamationMark, 10, 300, 3);
        jsnWidth = new JSpinner(modelWidth);
        jsnWidth.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JPanelTable.pointDrawRectEnd.setLocation(JPanelTable.pointDrawRectStart.x + (int) jsnWidth.getValue(), JPanelTable.pointDrawRectStart.y + (int) jsnHeight.getValue());
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                Properties.width_Move_Rect_ExclamationMark = (int) jsnWidth.getValue();
            }
        });
        jpnDefineExclamationMark.add(jsnWidth);

        JLabel txtHeight = new JLabel("Chiều cao:");
        txtHeight.setForeground(new Color(255, 255, 255));
        txtHeight.setFont(txtHeight.getFont().deriveFont(10.f));
        jpnDefineExclamationMark.add(txtHeight);

        SpinnerModel modelHeight = new SpinnerNumberModel(Properties.height_Move_Rect_ExclamationMark, 10, 300, 3);
        jsnHeight = new JSpinner(modelHeight);
        jsnHeight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JPanelTable.pointDrawRectEnd.setLocation(JPanelTable.pointDrawRectStart.x + (int) jsnWidth.getValue(), JPanelTable.pointDrawRectStart.y + (int) jsnHeight.getValue());
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                Properties.height_Move_Rect_ExclamationMark = (int) jsnHeight.getValue();
            }
        });
        jpnDefineExclamationMark.add(jsnHeight);
    }

    private void setComponentCountFish() {
        JLabel txt = new JLabel("Thời gian:", SwingConstants.RIGHT);
        txt.setForeground(Color.WHITE);
        txt.setFont(txt.getFont().deriveFont(12.f));
        jpnCountFish.add(txt);

        txtTime = new JLabel("00:00:00", SwingConstants.CENTER);
        txtTime.setForeground(Color.yellow);
        txtTime.setFont(txtTime.getFont().deriveFont(12.f));
        jpnCountFish.add(txtTime);

        JLabel txt1 = new JLabel("Số cá:", SwingConstants.RIGHT);
        txt1.setForeground(Color.WHITE);
        txt1.setFont(txt1.getFont().deriveFont(12.f));
        jpnCountFish.add(txt1);

        txtFish = new JLabel("0", SwingConstants.CENTER);
        txtFish.setForeground(Color.green);
        txtFish.setFont(txtFish.getFont().deriveFont(12.f));
        jpnCountFish.add(txtFish);

        btnRun = new JButton("Chạy");
        btnRun.setActionCommand("btnRun");
        btnRun.addActionListener(this);
        btnRun.setBackground(Color.PINK);
        btnRun.setForeground(Color.black);
        jpnCountFish.add(btnRun);
        btnRun.setFont(btnRun.getFont().deriveFont(10.f));

        btnPause = new JButton("Dừng");
        btnPause.setActionCommand("btnPause");
        btnPause.addActionListener(this);
        btnPause.setBackground(Color.PINK);
        btnPause.setForeground(Color.black);
        jpnCountFish.add(btnPause);
        btnPause.setFont(btnPause.getFont().deriveFont(10.f));
    }

    private void setComponentCustom() {
        btnCustomizeButton = new JButton();
        btnCustomizeButton.setActionCommand("btnCustomizeButton");
        btnCustomizeButton.setText("Chọn: Ẩn");
        btnCustomizeButton.addActionListener(this);
        btnCustomizeButton.setBackground(Color.PINK);
        btnCustomizeButton.setForeground(Color.black);
        jpnCustom.add(btnCustomizeButton);
        btnCustomizeButton.setFont(btnCustomizeButton.getFont().deriveFont(10.f));

        SpinnerModel model = new SpinnerNumberModel(0, 0, 200, 1);
        jspSizeRadius = new JSpinner(model);
        jpnCustom.add(jspSizeRadius);
        jspSizeRadius.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (JPanelImage.pointCurrentButton != null) {
                    JPanelImage.radiusCurrent = (int) jspSizeRadius.getValue();
                    if (JPanelImage.pointCurrentButton == PointButton.pointBalo) {
                        
                        PointButton.radiusBalo = (int) jspSizeRadius.getValue();
                        
                    } else if (JPanelImage.pointCurrentButton == PointButton.pointCoin) {
                    
                        PointButton.radiusCoin = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointDragFish) {

                        PointButton.radiusDragFish = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointExit) {

                        PointButton.radiusExit = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointFix) {

                        PointButton.radiusFix = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointGarbage) {

                        PointButton.radiusGarbage = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointGoFishing) {

                        PointButton.radiusGoFishing = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointKeepFish) {

                        PointButton.radiusKeepFish = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointTool) {

                        PointButton.radiusTool = (int) jspSizeRadius.getValue();

                    } else if (JPanelImage.pointCurrentButton == PointButton.pointChat) {

                        PointButton.radiusChat = (int) jspSizeRadius.getValue();

                    }
                    jFrameMain.getjPanelTable().setVisible(false);
                    jFrameMain.getjPanelTable().setVisible(true);
                    jFrameMain.getjPanelTable().getjPanelImage().repaint();
                } else {
                    jspSizeRadius.setValue(0);
                }
            }
        });

        btnCustomMouse = new JButton();
        btnCustomMouse.setActionCommand("btnOperationMouse");
        btnCustomMouse.setText("Thao tác chuột");
        btnCustomMouse.addActionListener(this);
        btnCustomMouse.setBackground(Color.PINK);
        btnCustomMouse.setForeground(Color.black);
        jpnCustom.add(btnCustomMouse);
        btnCustomMouse.setFont(btnCustomMouse.getFont().deriveFont(10.f));
    }

    private void setComponentGroup() {

        btnOption = new JButton("Tùy chỉnh thêm");
        btnOption.setBackground(Color.GREEN);
        btnOption.setActionCommand("btnOption");
        btnOption.addActionListener(this);
        btnOption.addKeyListener(jFrameMain);
        jpnGroup.add(btnOption);
        btnOption.setFont(btnOption.getFont().deriveFont(10.f));

        btnExit = new JButton("Thoát");
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.WHITE);
        btnExit.setActionCommand("btnExit");
        btnExit.addActionListener(this);
        btnExit.addKeyListener(jFrameMain);
        jpnGroup.add(btnExit);
        btnExit.setFont(btnExit.getFont().deriveFont(10.f));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnExit": {
                Data.writeData();
                System.exit(0);
                break;
            }
            case "btnCustomizeButton": {
                if (isOpenCustomMouse == false) {
                    new JFrameCustomizeButton(jFrameMain).setVisible(true);
                    isOpenCustomMouse = true;
                }
                break;
            }
            case "btnOperationMouse": {
                if (isOpenOperationMouse == false) {
                    jFrameCustomMouse.setVisible(true);
                    isOpenOperationMouse = true;
                }
                break;
            }
            case "btnRun": {
                if (jFrameMain.getKeyBoard().threadManager.isAlive() == false) {
                    jFrameMain.getKeyBoard().threadManager.start();
                }
                break;
            }
            case "btnPause": {
                jFrameMain.getKeyBoard().threadManager.interrupt();
                ThreadManager.timer.stop();
                JFrameMain.time = ThreadManager.time;
                JFrameMain.countFish = ThreadManager.countFish;
                break;
            }
            case "btnOption": {
                if (jFrameOption.isVisible() == false) {
                    jFrameOption.setVisible(true);
                }
            }
        }
    }

    public JButton getBtnCustomizeButton() {
        return btnCustomizeButton;
    }

    public void setBtnCustomizeButton(JButton btnCustomizeButton) {
        this.btnCustomizeButton = btnCustomizeButton;
    }

    public JLabel getTxtTime() {
        return txtTime;
    }

    public void setTxtTime(JLabel txtTime) {
        this.txtTime = txtTime;
    }

    public JLabel getTxtFish() {
        return txtFish;
    }

    public void setTxtFish(JLabel txtFish) {
        this.txtFish = txtFish;
    }

    public JFrameCustomMouse getjFrameCustomMouse() {
        return jFrameCustomMouse;
    }

    public void setjFrameCustomMouse(JFrameCustomMouse jFrameCustomMouse) {
        this.jFrameCustomMouse = jFrameCustomMouse;
    }

    public JSpinner getJspSizeRadius() {
        return jspSizeRadius;
    }

    public void setJspSizeRadius(JSpinner jspSizeRadius) {
        this.jspSizeRadius = jspSizeRadius;
    }

}
