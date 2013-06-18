package magichatchling;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deckList;

	public Deck(String path) {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		deckList=new ArrayList<Card>();
		while((line = br.readLine()) != null) {
			deckList.add(new Card(line));
		}
	}

	public ArrayList<Card> getDeckList() {
		ArrayList<Card> copy=new ArrayList<Card>(deckList.size());
		Collections.copy(deckList,copy);
		return copy;
	}
}