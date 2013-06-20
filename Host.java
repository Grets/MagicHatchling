package magichatchling;

public abstract class Host implements Runnable {

	private Thread t;
	protected final String NAME;
	
	protected Host() {
		NAME = getName();
		t = new Thread(this, NAME);
		t.start();
	}
	
	protected abstract String getName();
}