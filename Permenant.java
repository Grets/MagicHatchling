package magichatchling;

import java.util.ArrayList;
import java.util.List;

public class Permenant extends Card {
	
	private boolean isTapped, autoUntaps;
	private List attachments;
	
	public Permenant(Card card) {
		super(card);
		isTapped = false;
		autoUntaps = true;
		attachments = new ArrayList<Permenant>();
	}
	
	public void attachPermenant(Card card) {
		attachments.add(new Permenant(card));
	}
	
	public void paint(Graphics g, int x, int y) {
		try {
			BufferedImage bi = ImageIO.read(image);
			Graphics2D g2d = (Graphics2D)g;
			AffineTransform trans = new AffineTransform();

			trans.translate(x,y);

			if(isTapped = true) {
				trans.rotate(Math.PI/2);
			}

			g2d.drawImage(bi,trans,null);
		} catch(IOException ioe) {
			System.err.println("Could not read image for - " + name);
		}
	}
}