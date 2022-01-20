/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyBoardAndMouse;

import Thread.Move.MoveRectExclamationMark;
import Thread.Move.MoveTouchButton;
import Thread.ThreadManager;
import java.awt.event.KeyEvent;
import playtogether.JFrameMain;

/**
 *
 * @author Administrator
 */
public class Mouse {

    private JFrameMain jFrameMain;
    
    public static boolean isMoveRect = false;
    
    public static boolean isMoveTouchButton = false;
    public static int radiusSize = 7;
    
    public Mouse(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
    }

    public void Pressed(String option) {
        switch (option) {
            case "Move_Rect_Exclamation_Mark": {
                isMoveRect = true;
                new MoveRectExclamationMark(jFrameMain).start();
                break;
            }
            case "Move_Touch_Button":{
                isMoveTouchButton = true;
                new MoveTouchButton(jFrameMain).start();
                break;
            }
        }
    }
    
    public void Release(String option) {
        switch (option) {
            case "Move_Rect_Exclamation_Mark": {
                isMoveRect = false;
                break;
            }
            case "Move_Touch_Button": {
                isMoveTouchButton = false;
                break;
            }
        }
    }
}
