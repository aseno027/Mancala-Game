import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class Model {
	private ArrayList<ChangeListener> listeners;
	private ArrayList<Slots> slots;
	
	public Model(){
		listeners = new ArrayList<ChangeListener>();
		slots = new ArrayList<Slots>();
		slots.add(new Slots()); // counstruct 1upper 1lower slots
	}
	
}
