package magichatchling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Zone {

	protected List cardList;
	protected final int DRAW_CAP;
	protected final int X_POS, y_POS;
	
	protected Zone() {
		cardList = new ArrayList<Card>();
		DRAW_CAP = getDrawCap();
		X_POS = getPos()[0];
		Y_POS = getPos()[1];
	}
	
	public Iterator<Card> getList() {
		return cardList.iterator();
	}
	
	public int getSize() {
		return cardList.size();
	}
	
	public abstract void paint(Graphics g);
	public abstract int getDrawCap();
	public abstract 
}