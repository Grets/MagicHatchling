package magic;

public Class Card {
	private boolean isTapped, autoUntaps;
	private String name;
	private File image;

	public Card(String name) {
		this.name=name;
		isTapped=false;
		autoUntaps=true;
		image=new File(name);
	}

	public void draw(Graphics g, int x, int y) {
		try {
			BufferedImage bi = ImageIO.read(image);
			Graphics2D g2d = (Graphics2D)g;
			AffineTransform trans = new AffineTransformation();

			trans.translate(x,y);

			if(isTapped = true) {
				trans.rotate(Math.PI/2);
			}

			g2d.drawImage(image,trans,null);
		} catch(IOException ioe) {
			System.err.println("Could not read image for - " + name);
		}
	}
}