package magichatchling;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Server extends Host {

	private DataInputStream in;
	
	public Server(Socket sock) {
		super();
		
                try {
                    in = new DataInputStream(sock.getInputStream());

                    Main.setRemoteLibrary(new Library(in));

                    new Client(sock.getOutputStream(), true);
                } catch(IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
	}
	
	public Server(InputStream in, boolean IGNORE) {
		super();
		
		this.in = new DataInputStream(in);
		
		Main.setRemoteLibrary(new Library(this.in));
	}
	
	protected String getName() {
		return "Magic Hatchling Server";
	}
	
	public void run() {
		
	}
}