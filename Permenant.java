package magichatchling;

public class Permenant extends Card {
	
	private boolean isTapped, autoUntaps;
	private List attachments;
	
	public Permenant(Card card) {
		super(card);
		isTapped = false;
		autoUntaps = true;
		attachments = new ArrayList<Permenant>();
	}
	
	public attachPermenant(Card card) {
		attachments.add(new Permenant(card));
	}
}