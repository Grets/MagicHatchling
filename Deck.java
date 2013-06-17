package magic;

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