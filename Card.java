package magichatchling;

import java.io.File;

public class Card {
	private String name;
	private File image;

	public Card(String name) {
		this.name=name;
		image=new File(name);
	}
	
	protected Card(Card card) {
		this.name = card.name;
		this.image = card.image;
	}

	public void paint(Graphics g, int x, int y) {
		try {
			BufferedImage bi = ImageIO.read(image);
			g.drawImage(bi, x, y, null);
		} catch(IOException ioe) {
			System.err.println("Could not read image for - " + name);
		}
	}
}