package magichatchling;

public class Client extends Host {

	private DataOutputStream out;
	
	public Client(Socket sock) {
		super();
		
		out = new DataOutputStream(sock.getOutputStream());
		
		Main.sendLocalLibrary(out);
		
		new Server(sock.getInputStream());
	}
	
	public Client(OutputStream out) {
		super();
		
		this.out = new DataOutputStream(out);
		
		Main.sendLocalLibrary(this.out);
	}
	
	protected static String getName() {
		return "Magic Hatchling Client";
	}
	
	public void run() {
		
	}
}