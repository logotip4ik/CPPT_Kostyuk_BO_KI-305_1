package lab3;

import lab3.TV.State;
import lab3.Tunner.Range;

public class TVApp {
	public static void main(String[] args) {
		TVWithTunner tv = new TVWithTunner("Camchung", 15, 15);
		
		tv.turn(State.ON);
		tv.setRange(Range.Wide);
		tv.setChannel(54);
		tv.setVolume(25);

		tv.turn(State.OFF);
		
		System.out.println(tv.getState());
		System.out.println(tv.getChannel());
		System.out.println(tv.getVolume());
		System.out.println(tv.getRange());
	}
}
