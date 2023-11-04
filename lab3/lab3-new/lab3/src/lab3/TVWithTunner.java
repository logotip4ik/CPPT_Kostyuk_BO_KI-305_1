package lab3;

interface Tunner {
	public enum Range {
		Short,
		Wide
	}
	
	public Range getRange();
	public Range setRange(Range range);
}

interface BigTunner {
	public void printBigTunner();
}

public class TVWithTunner extends TV implements Tunner, BigTunner {
	private Range range;
	
	TVWithTunner(String name, int channel, int volume) {
		super(name, channel, volume);
		
		range = Range.Short;
	}

	public Range getRange() {
		return this.range;
	}

	public Range setRange(Range range) {
		this.range = range;
		
		return this.range;
	}
	
	public void printBigTunner() {
		System.out.println("I am a second big tunner");
	}
}
