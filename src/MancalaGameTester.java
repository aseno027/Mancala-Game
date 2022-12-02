public class MancalaGameTester {

	public static void main(String args[]) {
		Model m = new Model(3);
		MancalaView v = new MancalaView(m);
		m.addChangeListener(v);
		
	}

}
