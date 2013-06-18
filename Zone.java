package magichatchling;

public abstract class Zone {

	protected List cardList;
	
	protected Zone() {
		cardList = new ArrayList<Card>();
	}
	
	public Iterator<Card> getList() {
		return cardList.iterator();
	}
	
	public int getSize() {
		return cardList.size();
	}
	
	public void paint();
}