package magichatchling;

public class Permenant {
	private int fieldPos,attachPos;
	private Card card;
	
	public Permenant(Card card, int fieldPos, int attachPos) {
		this.card=card;
		this.fieldPos=fieldPos;
		this.attachPos=attachPos;
	}
}