package magichatchling;

public class Player {

	protected Zone battlefield, library, graveyard, exile, hand;

	public Player(Library library) {
		this.library = library;
		battlefield = new Battlefield();
		graveyard = new DeadZone();
		exile = new DeadZone();
		hand = new Hand();
	}
}