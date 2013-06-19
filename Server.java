package magichatchling;

public class Server extends Host {

	private DataInputStream in;
	
	public Server(Socket sock) {
		super();
		
		in = new DataInputStream(sock.getInputStream());
		
		Main.setRemoteLibrary(new Library(in));
		
		new Client(sock.getOutputStream());
	}
	
	public Server(InputStream in) {
		super();
		
		this.in = new DataInputStream(in);
		
		Main.setRemoteLibrary(new Library(this.in));
	}
	
	protected static String getName() {
		return "Magic Hatchling Server";
	}
	
	public void run() {
		
	}
}