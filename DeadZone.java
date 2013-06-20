package magichatchling;

import java.awt.Graphics;

public class DeadZone extends Zone {
	
    public void paint(Graphics g) {

    }

    public int getDrawCap() {
            return 6;
    }

    @Override
    public int[] getPos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}