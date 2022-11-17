import java.util.ArrayList;

public class Slots {
	private ArrayList<Slot> upperSlots;
	private ArrayList<Slot> lowerSlots;
	
	// initialize slots with upper: 6, lower: 6
	public Slots() {
		upperSlots = new ArrayList<Slot>();
		lowerSlots = new ArrayList<Slot>();
		for(int i = 0; i < 6; i++) {
			upperSlots.add(new Slot(i));
			lowerSlots.add(new Slot(11-i));
		}
	}
	
	public boolean upperIsEmpty() {
		for(Slot s : upperSlots) {
			if(!s.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean lowerIsEmpty() {
		for(Slot s : lowerSlots) {
			if(!s.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
}
