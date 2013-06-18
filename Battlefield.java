package magichatchling;

import java.util.List;
import java.util.ArrayList;

public class Battlefield {
	
	ArrayList<ArrayList<Card>> battlefield;
	
	public Battlefield() {
		battlefield = new ArrayList<ArrayList<Card>>();
	}
	
	public void addPermenant(Card card) {
		battlefield.add(new ArrayList<Card>(1) {{
			add(card);
		}});
	}
	
	public void attachPermenant(Card card, int pos) {
		battlefield.get(pos).add(card);
	}
}