/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyBoardAndMouse;

/**
 *
 * @author Administrator
 */
public class ItemAutoFishing {
    public static int GO_UP = 0;
    public static int GO_DOWN = 1;
    public static int TURN_LEFT = 2;
    public static int TURN_RIGHT = 3;
    public static int TURN_UP = 4;
    public static int TURN_DOWN = 5;
    private int direction;
    private int value;

    public ItemAutoFishing(int direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
