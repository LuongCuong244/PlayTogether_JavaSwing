/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyBoardAndMouse;

import java.awt.Point;

/**
 *
 * @author Administrator
 */
public class OneLineMouse {
    private Point start;
    private Point end;
    private long sleep;

    public OneLineMouse(Point start, Point end, long sleep) {
        this.start = start;
        this.end = end;
        this.sleep = sleep;
    }
    
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public long getSleep() {
        return sleep;
    }

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }
    
    
}
