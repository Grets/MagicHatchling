package magichatchling;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

        private static ServerSocket serverSocket;
	private static Socket socket;
	private static BufferedReader in;
	private static PrintWriter out;
	private static Player players[];
	private static boolean isHost;
	
	protected enum State { START, CONNECT, CONNECTED, DISCONNECT, STOP };
	
	protected static final int PORT = 58000;
	
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
							serverSocket = new ServerSocket(PORT);
							socket = serverSocket.accept();
							new Server(socket);
						} else {
							socket = new Socket(args[1], PORT);
							new Client(socket);
						}
						
						state = State.CONNECTED;
					} catch(IOException ioe) {
						System.err.println("Some IO exception - "+ioe.getMessage());
					}
					break;
				case CONNECTED:
					break;
				case DISCONNECT:
					try {
						if(serverSocket != null) {
							serverSocket.close();
						}
					} catch(IOException ioe) {}
					serverSocket = null;
					
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
	
	public static void setRemoteLibrary(Library library) {
		players[1] = new Player(library);
	}
	
	public static void sendLocalLibrary(DataOutputStream out) {
		players[0].getLibrary().send(out);
	}
}