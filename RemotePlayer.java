package magichatchling;

public class RemotePlayer extends Player {

	Socket sock;
	
	public RemotePlayer(Socket sock) {
		battleField = new Battlefield();
		library = new RemoteLibrary();
		this.sock = sock;
	}
}