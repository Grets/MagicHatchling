package magichatchling;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Host {

	private DataOutputStream out;
	
	public Client(Socket sock) {
		super();
		
                try {
                    out = new DataOutputStream(sock.getOutputStream());

                    Main.sendLocalLibrary(out);

                    new Server(sock.getInputStream(), true);
                } catch(IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
	}
	
	public Client(OutputStream out, boolean IGNORE) {
		super();
		
		this.out = new DataOutputStream(out);
		
		Main.sendLocalLibrary(this.out);
	}
	
	protected String getName() {
		return "Magic Hatchling Client";
	}
	
	public void run() {
		
	}
}