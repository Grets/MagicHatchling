package magichatchling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	private static ServerSocket hostServer;
	private static Socket socket;
	private static BufferedReader in;
	private static PrintWriter out;
	private static Player players[];
	private static boolean isHost;
	
	protected enum State { START, CONNECT, CONNECTED, DISCONNECT, STOP };
	
	private static final int PORT = 58000;
	
	public static void main(String args[]) {
		State state = State.START;
		
		while(true) {
			try {
				Thread.sleep(10);
			} catch(InterruptedException ie) {}
			
			switch(state) {
				case START:
					players = new Player[2];
					players[0] = new Player(new Library(args[0]));
					state = State.CONNECT;
					isHost = args[2].equals("host");
					break;
				case CONNECT:
					try {
						if(isHost) {
							hostServer = new ServerSocket(PORT);
							socket = hostServer.accept();
						} else
							socket = new Socket(args[1], PORT);
						
						in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						out = new PrintWriter(socket.getOutputStream(), true);
						
						state = State.CONNECTED;
					} catch(IOException ioe) {
						System.err.println("Some IO exception - "+ioe.getMessage());
					}
					break;
				case CONNECTED:
					//try {
						//if(players[1] == null && isHost) {
							
						//}
					//} catch(IOException ioe) {
						//System.err.println("Some IO exception - "+ioe.getMessage());
					//}
					break;
				case DISCONNECT:
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
					
                                        if(out != null) {
                                                out.close();
                                        }
					out = null;
					
					break;
				case STOP:
					return;
				default: break;
			}
		}
	}
}