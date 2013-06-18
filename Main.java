package magichatchling;

public class Main {

	private static ServerSocket hostServer;
	private static Socket socket;
	private static BufferedReader in;
	private static PrintWriter out;
	private static Player players[];
	private static boolean isHost;
	
	private enum STATE { START, CONNECT, CONNECTED, DISCONNECT, STOP };
	private enum HOST_MESSAGE { SENDING_DECK, AWAITING DECK, 
	
	private final int PORT = 58000;
	
	public static void main(String args[]) {
		int state = STATE.START;
		
		while(true) {
			try {
				Thread.sleep(10);
			} catch(InterruptedException ie) {}
			
			switch(state) {
				case STATE.START:
					players = new Player[2];
					player[0] = new Player(new Library(args[0]));
					state = STATE.CONNECT;
					isHost = args[2].equals("host");
					break;
				case STATE.CONNECT:
					try {
						if(isHost) {
							hostServer = new ServerSocket(PORT);
							socket = hostServer.accept();
						} else
							socket = new Socket(args[1], PORT);
						
						in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						out = new PrintWriter(socket.getOutputStream(), true);
						
						state = STATE.CONNECTED;
					} catch(IOException ioe) {
						System.err.println("Some IO exception - "+ioe.message());
					}
					break
				case STATE.CONNECTED:
					try {
						if(players[1] == null && isHost) {
							out.print(
						}
					} catch(IOException ioe) {
						System.err.println("Some IO exception - "+ioe.message());
					}
					break;
				case STATE.DISCONNECT:
					try {
						if(hostServer != null) {
							hostServer.close();
						}
					} catch(IOException ioe) {}
					hostServer = null;
					
					try {
						if(socket != null) {
							socket.close();
						}
					} catch(IOException ioe) {}
					socket = null;
					
					try {
						if(in != null) {
							in.close();
						}
					} catch(IOException ioe) {}
					in = null;
					
					try {
						if(out != null) {
							out.close();
						}
					} catch(IOException ioe) {}
					out = null;
					
					break;
				case STATE.STOP:
					return;
				case default: break;
			}
		}
	}
}