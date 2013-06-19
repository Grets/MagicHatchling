package magichatchling;

import java.util.ArrayList;
import java.util.Iterator;

public class Battlefield extends Zone {
	
	public Battlefield() {
		super.cardList = new ArrayList<Permenant>();
	}
	
	public void addPermenant(Card card) {
		final Card temp=card;
		cardList.add(new ArrayList<Permenant>(1) {{
			add(new Permenant(temp));
		}});
	}
	
	public void attachPermenant(Card card, int pos) {
		((Permenant)cardList.get(pos)).attachPermenant(card);
	}
	
	public Iterator<Card> getList() {
		return ((ArrayList<Card>)cardList).iterator();
	}
        
        public void paint() {
            
        }
}