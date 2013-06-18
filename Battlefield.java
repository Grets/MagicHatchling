package magichatchling;

import java.util.List;
import java.util.ArrayList;

public class Battlefield extends Zone {
	
	public Battlefield() {
		super.cardList = new ArrayList<Permenant>();
	}
	
	public void addPermenant(Card card) {
		final Card temp=card;
		cardList.add(new ArrayList<Card>(1) {{
			add(new Permenant(temp));
		}});
	}
	
	public void attachPermenant(Card card, int pos) {
		cardList.get(pos).attachPermenant(card);
	}
	
	public Iterator<Card> getList() {
		return ((ArrayList<Card>)cardList).iterator();
	}
}