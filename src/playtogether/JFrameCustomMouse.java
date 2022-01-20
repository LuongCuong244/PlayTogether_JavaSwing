/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import DataAndProperties.Properties;
import KeyBoardAndMouse.ItemAutoFishing;
import KeyBoardAndMouse.KeyBoard;
import KeyBoardAndMouse.OneLineMouse;
import Thread.ThreadActivateMouse;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

/**
 *
 * @author Administrator
 */
public class JFrameCustomMouse extends JFrame implements ActionListener {

    public static int SCREEN_WIDTH_CUSTOM_MOUSE = 500;
    public static int SCREEN_HEIGHT_CUSTOM_MOUSE = 320;
    private JFrameMain jFrameMain;
    public static ArrayList<OneLineMouse> listMouseLine;

    public static ArrayList<ItemAutoFishing> listAutoFishing;
    public static Point pMouseGoUpStart = new Point(20, 20);

    public static Point pMouseStartCurrent = null;
    public static Point pMouseEndCurrent = null;
    public static long sleep = -1;

    private JScrollPane jScPane;
    private JPanel container;

    private JPanel jpnCustomMouse;
    private JButton btnRemoveAll, btnSave, btnPreview, btnPreviewAll, btnRemoveOne, btnAddSleep;
    private float fontSize = 12.f;
    private JPanel jpnTime;
    private JLabel txtTime;
    private JTextField edtSleep;

    private JPanel jpnAutoGoFishing;
    private JButton btnResetGoFishing, btnSaveGoFishing, btnRunGoFishing;
    private JSpinner jspGoUp, jspTurnLeft, jspTurnRight, jspTurnUp, jspTurnDown, jspGoDown;
    private JLabel txtFrameCurrentGoFishing;
    private int run = 1;

    public JFrameCustomMouse(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
        if (listMouseLine == null) {
            listMouseLine = new ArrayList<OneLineMouse>();
        }
        if (listAutoFishing == null) {
            listAutoFishing = new ArrayList<ItemAutoFishing>();
        }
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((int) dimension.getWidth() - SCREEN_WIDTH_CUSTOM_MOUSE) / 2, ((int) dimension.getHeight() - SCREEN_HEIGHT_CUSTOM_MOUSE) / 2, SCREEN_WIDTH_CUSTOM_MOUSE, SCREEN_HEIGHT_CUSTOM_MOUSE);
        this.setLayout(null);
        this.setAlwaysOnTop(true);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        jScPane = new JScrollPane(container, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScPane.setBounds(0, 0, SCREEN_WIDTH_CUSTOM_MOUSE - 15, SCREEN_HEIGHT_CUSTOM_MOUSE - 10);
        container.setBackground(new Color(254, 235, 208));
        container.setBorder(BorderFactory.createTitledBorder(""));
        Border border = container.getBorder();
        Border margin = new EmptyBorder(5, 5, 5, 5);
        container.setBorder(new CompoundBorder(border, margin));
        this.add(jScPane);

        jpnCustomMouse = new JPanel();
        jpnCustomMouse.setLayout(new GridLayout(3, 4, 5, 10));
        jpnCustomMouse.setBackground(new Color(254, 235, 208));
        jpnCustomMouse.setBorder(BorderFactory.createTitledBorder("Tùy chọn thao tác chuột"));
        border = jpnCustomMouse.getBorder();
        margin = new EmptyBorder(5, 5, 5, 5);
        jpnCustomMouse.setBorder(new CompoundBorder(border, margin));
        container.add(jpnCustomMouse);
        setComponentjpnContainer();

        jpnAutoGoFishing = new JPanel();
        jpnAutoGoFishing.setLayout(new GridLayout(8, 2, 5, 10));
        jpnAutoGoFishing.setBackground(new Color(254, 235, 208));
        jpnAutoGoFishing.setBorder(BorderFactory.createTitledBorder("Tự động ra câu cá"));
        border = jpnAutoGoFishing.getBorder();
        margin = new EmptyBorder(5, 5, 5, 5);
        jpnAutoGoFishing.setBorder(new CompoundBorder(border, margin));
        container.add(jpnAutoGoFishing);
        setComponentjpnAutoGoFishing();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                JPanelMenu.isOpenOperationMouse = false;
                KeyBoard.isDrawLineMouse = false;
                pMouseEndCurrent = null;
                pMouseStartCurrent = null;
                sleep = -1;
            }
        });
    }

    private void setComponentjpnContainer() {
        btnRemoveOne = new JButton("Xóa 1 frame");
        btnRemoveOne.setActionCommand("btnRemove");
        btnRemoveOne.addActionListener(this);
        btnRemoveOne.setFont(btnRemoveOne.getFont().deriveFont(fontSize));
        btnRemoveOne.setBackground(Color.pink);
        btnRemoveOne.setForeground(Color.black);
        jpnCustomMouse.add(btnRemoveOne);

        btnSave = new JButton("Lưu frame");
        btnSave.setActionCommand("btnSave");
        btnSave.addActionListener(this);
        btnSave.setFont(btnSave.getFont().deriveFont(fontSize));
        btnSave.setBackground(Color.cyan);
        btnSave.setForeground(Color.black);
        jpnCustomMouse.add(btnSave);

        btnAddSleep = new JButton("Tạo độ trễ");
        btnAddSleep.setActionCommand("btnAddSleep");
        btnAddSleep.addActionListener(this);
        btnAddSleep.setFont(btnAddSleep.getFont().deriveFont(fontSize));
        btnAddSleep.setBackground(Color.YELLOW);
        btnAddSleep.setForeground(Color.black);
        jpnCustomMouse.add(btnAddSleep);

        txtTime = new JLabel("Thời gian trễ (ms):", SwingConstants.RIGHT);
        txtTime.setForeground(Color.black);
        txtTime.setFont(txtTime.getFont().deriveFont(fontSize + 2));
        jpnCustomMouse.add(txtTime);

        edtSleep = new JTextField();
        edtSleep.setForeground(Color.black);
        edtSleep.setFont(edtSleep.getFont().deriveFont(fontSize));
        jpnCustomMouse.add(edtSleep);

        JLabel txt = new JLabel("");
        jpnCustomMouse.add(txt);

        btnRemoveAll = new JButton("Xóa toàn bộ");
        btnRemoveAll.setActionCommand("btnRemoveAll");
        btnRemoveAll.addActionListener(this);
        btnRemoveAll.setFont(btnRemoveAll.getFont().deriveFont(fontSize));
        btnRemoveAll.setBackground(Color.red);
        btnRemoveAll.setForeground(Color.white);
        jpnCustomMouse.add(btnRemoveAll);

        btnPreviewAll = new JButton("Xem trước toàn bộ");
        btnPreviewAll.setActionCommand("btnPreviewAll");
        btnPreviewAll.addActionListener(this);
        btnPreviewAll.setFont(btnPreviewAll.getFont().deriveFont(fontSize));
        btnPreviewAll.setBackground(Color.GREEN);
        btnPreviewAll.setForeground(Color.blue);
        jpnCustomMouse.add(btnPreviewAll);
    }

    private void setComponentjpnAutoGoFishing() {
        btnResetGoFishing = new JButton("Xóa tất frame");
        btnResetGoFishing.setActionCommand("btnResetGoFishing");
        btnResetGoFishing.addActionListener(this);
        btnResetGoFishing.setFont(btnResetGoFishing.getFont().deriveFont(fontSize));
        btnResetGoFishing.setBackground(Color.pink);
        btnResetGoFishing.setForeground(Color.black);
        jpnAutoGoFishing.add(btnResetGoFishing);

        btnSaveGoFishing = new JButton("Lưu");
        btnSaveGoFishing.setActionCommand("btnSaveGoFishing");
        btnSaveGoFishing.addActionListener(this);
        btnSaveGoFishing.setFont(btnSaveGoFishing.getFont().deriveFont(fontSize));
        btnSaveGoFishing.setBackground(Color.green);
        btnSaveGoFishing.setForeground(Color.black);
        jpnAutoGoFishing.add(btnSaveGoFishing);

        JLabel txtGoUp = new JLabel("Đi lên: ", SwingConstants.CENTER);
        txtGoUp.setFont(txtGoUp.getFont().deriveFont(fontSize + 2));
        jpnAutoGoFishing.add(txtGoUp);

        SpinnerModel modeGoUp = new SpinnerNumberModel(0, 0, 100000, 500);
        jspGoUp = new JSpinner(modeGoUp);
        jspGoUp.setFont(jspGoUp.getFont().deriveFont(fontSize));
        jpnAutoGoFishing.add(jspGoUp);
        jspGoUp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) jspGoUp.getValue() > 0) {
                    jspTurnLeft.setValue(0);
                    jspTurnRight.setValue(0);
                    jspTurnDown.setValue(0);
                    jspTurnUp.setValue(0);
                    jspGoDown.setValue(0);
                }
            }
        });

        JLabel txtGoDown = new JLabel("Đi xuống: ", SwingConstants.CENTER);
        txtGoDown.setFont(txtGoDown.getFont().deriveFont(fontSize + 2));
        jpnAutoGoFishing.add(txtGoDown);

        SpinnerModel modeGoDown = new SpinnerNumberModel(0, 0, 100000, 500);
        jspGoDown = new JSpinner(modeGoDown);
        jspGoDown.setFont(jspGoDown.getFont().deriveFont(fontSize));
        jpnAutoGoFishing.add(jspGoDown);
        jspGoDown.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) jspGoDown.getValue() > 0) {
                    jspTurnLeft.setValue(0);
                    jspTurnRight.setValue(0);
                    jspTurnDown.setValue(0);                            
                    jspTurnUp.setValue(0);
                    jspGoUp.setValue(0);
                }
            }
        });

        JLabel txtTurnLeft = new JLabel("Xoay trái: ", SwingConstants.CENTER);
        txtTurnLeft.setFont(txtTurnLeft.getFont().deriveFont(fontSize + 2));
        jpnAutoGoFishing.add(txtTurnLeft);

        SpinnerModel mode1 = new SpinnerNumberModel(0, 0, 800, 10);
        jspTurnLeft = new JSpinner(mode1);
        jspTurnLeft.setFont(jspTurnLeft.getFont().deriveFont(fontSize));
        jpnAutoGoFishing.add(jspTurnLeft);
        jspTurnLeft.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) jspTurnLeft.getValue() > 0) {
                    jspGoUp.setValue(0);
                    jspTurnRight.setValue(0);
                    jspTurnDown.setValue(0);
                    jspTurnUp.setValue(0);
                    jspGoDown.setValue(0);
                }
            }
        });

        JLabel txtTurnRight = new JLabel("Xoay phải: ", SwingConstants.CENTER);
        txtTurnRight.setFont(txtTurnRight.getFont().deriveFont(fontSize + 2));
        jpnAutoGoFishing.add(txtTurnRight);

        SpinnerModel mode2 = new SpinnerNumberModel(0, 0, 800, 10);
        jspTurnRight = new JSpinner(mode2);
        jspTurnRight.setFont(jspTurnRight.getFont().deriveFont(fontSize));
        jpnAutoGoFishing.add(jspTurnRight);
        jspTurnRight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) jspTurnRight.getValue() > 0) {
                    jspGoUp.setValue(0);
                    jspTurnLeft.setValue(0);
                    jspTurnDown.setValue(0);
                    jspTurnUp.setValue(0);
                    jspGoDown.setValue(0);
                }
            }
        });

        JLabel txtTurnUp = new JLabel("Xoay trên: ", SwingConstants.CENTER);
        txtTurnUp.setFont(txtTurnUp.getFont().deriveFont(fontSize + 2));
        jpnAutoGoFishing.add(txtTurnUp);

        SpinnerModel mode3 = new SpinnerNumberModel(0, 0, 500, 10);
        jspTurnUp = new JSpinner(mode3);
        jspTurnUp.setFont(jspTurnUp.getFont().deriveFont(fontSize));
        jpnAutoGoFishing.add(jspTurnUp);
        jspTurnUp.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) jspTurnUp.getValue() > 0) {
                    jspGoUp.setValue(0);
                    jspTurnLeft.setValue(0);
                    jspTurnDown.setValue(0);
                    jspTurnRight.setValue(0);
                    jspGoDown.setValue(0);
                }
            }
        });

        JLabel txtTurnDown = new JLabel("Xoay dưới: ", SwingConstants.CENTER);
        txtTurnDown.setFont(txtTurnDown.getFont().deriveFont(fontSize + 2));
        jpnAutoGoFishing.add(txtTurnDown);

        SpinnerModel mode4 = new SpinnerNumberModel(0, 0, 500, 10);
        jspTurnDown = new JSpinner(mode4);
        jspTurnDown.setFont(jspTurnDown.getFont().deriveFont(fontSize));
        jpnAutoGoFishing.add(jspTurnDown);
        jspTurnDown.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) jspTurnDown.getValue() > 0) {
                    jspGoUp.setValue(0);
                    jspTurnLeft.setValue(0);
                    jspTurnUp.setValue(0);
                    jspTurnRight.setValue(0);
                    jspGoDown.setValue(0);
                }
            }
        });

        btnRunGoFishing = new JButton("Chạy");
        btnRunGoFishing.setActionCommand("btnRunGoFishing");
        btnRunGoFishing.addActionListener(this);
        btnRunGoFishing.setFont(btnRunGoFishing.getFont().deriveFont(fontSize));
        btnRunGoFishing.setBackground(Color.cyan);
        btnRunGoFishing.setForeground(Color.black);
        jpnAutoGoFishing.add(btnRunGoFishing);

        txtFrameCurrentGoFishing = new JLabel("", SwingConstants.CENTER);
        txtFrameCurrentGoFishing.setText("Số Frame: " + listAutoFishing.size());
        txtFrameCurrentGoFishing.setFont(txtFrameCurrentGoFishing.getFont().deriveFont(fontSize + 2));
        jpnAutoGoFishing.add(txtFrameCurrentGoFishing);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "btnRemoveOne": {
                if (listMouseLine.size() > 0) {
                    listMouseLine.remove(listMouseLine.size() - 1);
                    JOptionPane.showMessageDialog(jFrameMain, "Đã xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(jFrameMain, "Danh sách trống!");
                }
                break;
            }
            case "btnSave": {
                if (checkEdtSleep(edtSleep.getText().trim()) && pMouseEndCurrent != null & pMouseStartCurrent != null && checkEdtSleep(edtSleep.getText().trim())) {
                    sleep = Long.parseLong(edtSleep.getText().trim());
                    dragAndDrop(pMouseStartCurrent, pMouseEndCurrent, Long.parseLong(edtSleep.getText().trim()));
                    listMouseLine.add(new OneLineMouse(pMouseStartCurrent, pMouseEndCurrent, sleep));
                    listMouseLine.add(new OneLineMouse(null, null, 100));
                    pMouseEndCurrent = null;
                    pMouseStartCurrent = null;
                    sleep = -1;
                    JOptionPane.showMessageDialog(jFrameMain, "Đã lưu!");
                }
                break;
            }
            case "btnAddSleep": {
                if (checkEdtSleep(edtSleep.getText().trim())) {
                    listMouseLine.add(new OneLineMouse(null, null, Long.parseLong(edtSleep.getText().trim())));
                }
                break;
            }
            case "btnRemoveAll": {
                int input = JOptionPane.showConfirmDialog(jFrameMain, "Bạn có muốn xóa tất cả!!", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (input == 0) {
                    listMouseLine.clear();
                }
                break;
            }
            case "btnPreviewAll": {
                int input = JOptionPane.showConfirmDialog(jFrameMain, "Xem lại toàn bộ!", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (input == 0) {
                    for (int i = 0; i < listMouseLine.size(); i++) {
                        OneLineMouse frame = listMouseLine.get(i);
                        if (frame.getStart() != null && frame.getEnd() != null) { // frame thực
                            dragAndDrop(frame.getStart(), frame.getEnd(), frame.getSleep());
                        } else { // frame tạo độ trễ
                            try {
                                Thread.sleep(frame.getSleep());
                            } catch (InterruptedException ex) {
                                Logger.getLogger(JFrameCustomMouse.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                break;
            }
            case "btnResetGoFishing": {
                int input = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tất cả!!", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                if (input == 0) {
                    listAutoFishing.clear();
                    txtFrameCurrentGoFishing.setText("Số Frame: 0");
                }
                break;
            }
            case "btnSaveGoFishing": {
                int valueGoUp = (int) jspGoUp.getValue();
                int valueGoDown = (int) jspGoDown.getValue();
                int valueTurnLeft = (int) jspTurnLeft.getValue();
                int valueTurnRight = (int) jspTurnRight.getValue();
                int valueTurnUp = (int) jspTurnUp.getValue();
                int valueTurnDown = (int) jspTurnDown.getValue();

                if (valueGoUp > 0 && pMouseGoUpStart.x != 20 && pMouseGoUpStart.y != 20) {

                    listAutoFishing.add(new ItemAutoFishing(ItemAutoFishing.GO_UP, valueGoUp));
                    dragAndDrop(pMouseGoUpStart, new Point(pMouseGoUpStart.x,pMouseGoUpStart.y - 80), valueGoUp);

                } else if (valueGoDown > 0 && pMouseGoUpStart.x != 20&& pMouseGoUpStart.y != 20) {

                    listAutoFishing.add(new ItemAutoFishing(ItemAutoFishing.GO_DOWN, valueGoDown));
                    dragAndDrop(pMouseGoUpStart, new Point(pMouseGoUpStart.x,pMouseGoUpStart.y + 80), valueGoDown);

                } else if (valueTurnLeft > 0) {

                    listAutoFishing.add(new ItemAutoFishing(ItemAutoFishing.TURN_LEFT, valueTurnLeft));
                    Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
                    Point pEnd = new Point(pRotationsFocus.x - valueTurnLeft, pRotationsFocus.y);
                    dragAndDrop(pRotationsFocus, pEnd, 0);

                } else if (valueTurnRight > 0) {

                    listAutoFishing.add(new ItemAutoFishing(ItemAutoFishing.TURN_RIGHT, valueTurnRight));
                    Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
                    Point pEnd = new Point(pRotationsFocus.x + valueTurnRight, pRotationsFocus.y);
                    dragAndDrop(pRotationsFocus, pEnd, 0);

                } else if (valueTurnUp > 0) {

                    listAutoFishing.add(new ItemAutoFishing(ItemAutoFishing.TURN_UP, valueTurnUp));
                    Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
                    Point pEnd = new Point(pRotationsFocus.x, pRotationsFocus.y - valueTurnUp);
                    dragAndDrop(pRotationsFocus, pEnd, 0);

                } else if (valueTurnDown > 0) {

                    listAutoFishing.add(new ItemAutoFishing(ItemAutoFishing.TURN_DOWN, valueTurnDown));
                    Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
                    Point pEnd = new Point(pRotationsFocus.x, pRotationsFocus.y + valueTurnDown);
                    dragAndDrop(pRotationsFocus, pEnd, 0);

                }
                txtFrameCurrentGoFishing.setText("Số Frame:" + listAutoFishing.size());
                break;
            }
            case "btnRunGoFishing": {
//                if(run == 1){
//                    new ThreadActivateMouse(jFrameMain).runFrameReverse();
//                    run = 2;
//                }else{
//                    new ThreadActivateMouse(jFrameMain).runFrame();
//                }
                
                break;
            }
        }
    }

    private boolean checkEdtSleep(String value) {
        if (value.isEmpty()) {
            edtSleep.setText("0");
            return true;
        }
        for (int i = 0; i < value.length(); i++) {
            int a = value.charAt(i);
            if (a > 57 && a < 48) {
                if (a != 46) {
                    JOptionPane.showMessageDialog(this, "Không hợp lệ!");
                    return false;
                }
            }
        }
        Double sleep = Double.parseDouble(value);
        if (sleep >= Long.MAX_VALUE) {
            JOptionPane.showMessageDialog(this, "Số quá lớn!");
            return false;
        }
        return true;
    }

    public void dragAndDrop(Point pStart, Point pEnd, long sleep) {
        Robot bot = null;
        if (sleep < 0) {
            sleep = 0;
        }
        try {
            bot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        bot.mouseMove(pStart.x + JFrameMain.pointJFrame.x, pStart.y + JFrameMain.pointJFrame.y + Properties.space + jFrameMain.getjPanelMenu().getHeight());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(JFrameCustomMouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        bot.mouseMove(pEnd.x + JFrameMain.pointJFrame.x, pEnd.y + JFrameMain.pointJFrame.y + Properties.space + jFrameMain.getjPanelMenu().getHeight());
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(JFrameCustomMouse.class.getName()).log(Level.SEVERE, null, ex);
        }

        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public JLabel getTxtFrameCurrentGoFishing() {
        return txtFrameCurrentGoFishing;
    }

    public void setTxtFrameCurrentGoFishing(JLabel txtFrameCurrentGoFishing) {
        this.txtFrameCurrentGoFishing = txtFrameCurrentGoFishing;
    }
}
