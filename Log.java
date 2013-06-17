package magic;

public Class Log extends JScrollPane {

	private JTextArea textArea;

	/**
	 * http://docs.oracle.com/javase/tutorial/uiswing/components/textarea.html
	 **/
	public Log() {
		super(textArea = new JTextArea(30,20));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		super.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
}