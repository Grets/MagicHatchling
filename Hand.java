package magichatchling;

public class Hand extends Zone {

	public void paint(Graphics g) {
	}
	
	public void mulligan(Library library) {
		int handSize=cardList.size();
		while(cardList.isEmpty() == false) {
			library.addCardToTop((Card)cardList.remove(0));
		}
		library.shuffle();
		for(int i=0;i<handSize-1;i++) {
			cardList.add(library.getTopCard());
		}
	}
}