package magichatchling;

public class Player {

	private Zone battlefield, library, graveyard, exile, hand;

	public Player(Library library) {
		this.library = library;
		battlefield = new Battlefield();
		graveyard = new DeadZone();
		exile = new DeadZone();
		hand = new Hand();
	}
	
	public Library getLibrary() {
		return (Library)library;
	}
}