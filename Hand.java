package magichatchling;

import java.awt.Graphics;

public class Hand extends Zone {

    public void paint(Graphics g) {
    }

    public void mulligan(Library library) {
            int handSize=cardList.size();
            while(cardList.isEmpty() == false) {
                    library.addCardToTop((Card)cardList.remove(0));
            }
            library.shuffle();
            for(int i=0;i<handSize-1;i++) {
                    cardList.add(library.getTopCard());
            }
    }

    @Override
    public int getDrawCap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] getPos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}