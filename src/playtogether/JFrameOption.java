/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import Thread.ThreadManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Administrator
 */
public class JFrameOption extends JDialog{

    public static int SCREEN_WIDTH_OPTION = 300;
    public static int SCREEN_HEIGHT_OPTION = 150;
    private JFrameMain jFrameMain;
    
    private JScrollPane jScPane;
    private JPanel container;
    
    private JPanel jpnRunTime;
    private JRadioButton jrbYesRunTime,jrbNoRunTime;
    private ButtonGroup groupRunTime;
    
    private JPanel jpnOnTop;
    private JRadioButton jrbYesOnTop,jrbNoOnTop;
    private ButtonGroup groupOnTop;
    
    private JPanel jpnColourful;
    private JRadioButton jrbYesColourful,jrbNoColourful;
    private ButtonGroup groupColourful;
    
    public JFrameOption(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((int) dimension.getWidth() - SCREEN_WIDTH_OPTION) / 2, ((int) dimension.getHeight() - SCREEN_HEIGHT_OPTION) / 2, SCREEN_WIDTH_OPTION, SCREEN_HEIGHT_OPTION);
        this.setLayout(null);
        this.setAlwaysOnTop(true);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        jScPane = new JScrollPane(container, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScPane.setBounds(0, 0, SCREEN_WIDTH_OPTION - 15, SCREEN_HEIGHT_OPTION - 40);
        container.setBackground(new Color(254, 235, 208));
        container.setBorder(BorderFactory.createTitledBorder(""));
        Border border = container.getBorder();
        Border margin = new EmptyBorder(5, 5, 5, 5);
        container.setBorder(new CompoundBorder(border, margin));
        this.add(jScPane);
        
        jpnRunTime = new JPanel();
        jpnRunTime.setLayout(new GridLayout(1, 2, 5, 10));
        jpnRunTime.setBackground(new Color(254, 235, 208));       
        jpnRunTime.setBorder(BorderFactory.createTitledBorder("Chạy thời gian"));
        border = jpnRunTime.getBorder();
        jpnRunTime.setBorder(new CompoundBorder(border, margin));
        container.add(jpnRunTime);
        setComponentjpnAutoGoFishing();
        
        jpnOnTop = new JPanel();
        jpnOnTop.setLayout(new GridLayout(1, 2, 5, 10));
        jpnOnTop.setBackground(new Color(254, 235, 208));
        jpnOnTop.setBorder(BorderFactory.createTitledBorder("Luôn hiển thị ở trên"));
        border = jpnOnTop.getBorder();
        jpnOnTop.setBorder(new CompoundBorder(border, margin));
        container.add(jpnOnTop);
        setComponentjpnOnTop();
        
        jpnColourful = new JPanel();
        jpnColourful.setLayout(new GridLayout(1, 2, 5, 10));
        jpnColourful.setBackground(new Color(254, 235, 208));
        jpnColourful.setBorder(BorderFactory.createTitledBorder("Tùy chọn vùng câu cá"));
        border = jpnColourful.getBorder();
        jpnColourful.setBorder(new CompoundBorder(border, margin));
        container.add(jpnColourful);
        setComponentjpnColourful();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if(jrbYesRunTime.isSelected()){
                    ThreadManager.isRunTime = true;
                }else{
                    ThreadManager.isRunTime = false;
                }
                jFrameMain.setAlwaysOnTop(jrbYesOnTop.isSelected());
                ThreadManager.isColorful = jrbYesColourful.isSelected();
            }
        });
    }
    
    
    private void setComponentjpnAutoGoFishing() {
        
        jrbYesRunTime = new JRadioButton("Có");
        jrbYesRunTime.setBackground(new Color(254, 235, 208));
        jpnRunTime.add(jrbYesRunTime);
        
        jrbNoRunTime = new JRadioButton("Không");
        jrbNoRunTime.setBackground(new Color(254, 235, 208));
        jpnRunTime.add(jrbNoRunTime);
        
        if(ThreadManager.isRunTime){
            jrbYesRunTime.setSelected(true);
            jrbNoRunTime.setSelected(false);
        }else{
            jrbYesRunTime.setSelected(false);
            jrbNoRunTime.setSelected(true);
        }
        
        groupRunTime = new ButtonGroup();
        groupRunTime.add(jrbNoRunTime);
        groupRunTime.add(jrbYesRunTime);
    }
    
    private void setComponentjpnOnTop(){
        jrbYesOnTop = new JRadioButton("Có");
        jrbYesOnTop.setBackground(new Color(254, 235, 208));
        jpnOnTop.add(jrbYesOnTop);
        
        jrbNoOnTop = new JRadioButton("Không");
        jrbNoOnTop.setBackground(new Color(254, 235, 208));
        jpnOnTop.add(jrbNoOnTop);
        
        if(jFrameMain.isAlwaysOnTop()){
            jrbYesOnTop.setSelected(true);
            jrbNoOnTop.setSelected(false);
        }else{
            jrbYesOnTop.setSelected(false);
            jrbNoOnTop.setSelected(true);
        }
        
        groupOnTop = new ButtonGroup();
        groupOnTop.add(jrbNoOnTop);
        groupOnTop.add(jrbYesOnTop);
    }
    
    private void setComponentjpnColourful(){
        jrbYesColourful = new JRadioButton("Đa màu");
        jrbYesColourful.setBackground(new Color(254, 235, 208));
        jpnColourful.add(jrbYesColourful);
        
        jrbNoColourful = new JRadioButton("Một màu");
        jrbNoColourful.setBackground(new Color(254, 235, 208));
        jpnColourful.add(jrbNoColourful);
        
        if(ThreadManager.isColorful){
            jrbYesColourful.setSelected(true);
            jrbNoColourful.setSelected(false);
        }else{
            jrbYesColourful.setSelected(false);
            jrbNoColourful.setSelected(true);
        }
        
        groupColourful = new ButtonGroup();
        groupColourful.add(jrbNoColourful);
        groupColourful.add(jrbYesColourful);
    }
}
