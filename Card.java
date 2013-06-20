package magichatchling;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card {
	protected String name;
	protected File image;

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