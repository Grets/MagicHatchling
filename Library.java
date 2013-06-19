package magichatchling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Library extends Zone {

	public Library(String path) {
		super();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				cardList.add(new Card(line));
			}
		} catch(FileNotFoundException fnfe) {
			System.err.println("Deck file not found");
		} catch(IOException ioe) {
			System.err.println("Deck IO exception");
		}
	}
	
	public Library(BufferedReader in) {
		super();
                try {
                    String line;
                    while((line = in.readLine()) != null) {
                            cardList.add(new Card(line));
                    }
                } catch(IOException ioe) {
                    System.err.println(ioe.getMessage());
                }
	}

	public void shuffle() {
		Object swap;
		int pos;
		for(int i=0;i<cardList.size();i++) {
			swap=cardList.get(i);
			pos=(int)(Math.random()*(cardList.size()-i))+i;
			cardList.set(i,cardList.get(pos));
			cardList.set(pos,swap);
		}
	}

	public void insertCard(Card card, int pos) {
		cardList.add(pos,card);
	}

	public void addCardToTop(Card card) {
		insertCard(card,0);
	}

	public void addCardToBottom(Card card) {
		insertCard(card,cardList.size());
	}
		

	public void shuffleInCard(Card card) {
		addCardToTop(card);
		shuffle();
	}

	public Card getTopCard() {
		return (Card)cardList.remove(0);
	}
        
        public void paint() {
            
        }
}