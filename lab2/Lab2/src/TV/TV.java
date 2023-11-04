package TV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TV {
	enum State {
		ON, OFF
	};

	private State state;
	private String name;
	private Channel channel;
	private Volume volume;
	private Printer printer;

	public TV(String name) throws FileNotFoundException {
		this.state = State.ON;
		this.name = name;
		
		this.printer = new Printer();
		
		this.printer.log("TV " + this.name + " turned: " + this.state);

		this.channel = new Channel(this.printer);
		this.volume = new Volume(this.printer);
	}

	public TV(String name, int channel, int volume, File file) throws FileNotFoundException {
		this.state = State.ON;
		this.name = name;
		
		this.printer = new Printer(file);
		
		this.printer.log("TV " + this.name + " turned: " + this.state);

		this.channel = new Channel(this.printer, channel);
		this.volume = new Volume(this.printer, volume);
	}

	public TV(String name, int channel, int volume, String filename) throws FileNotFoundException {
		this.state = State.ON;
		this.name = name;
		
		this.printer = new Printer(filename);
		
		this.printer.log("TV " + this.name + " turned: " + this.state);

		this.channel = new Channel(this.printer, channel);
		this.volume = new Volume(this.printer, volume);
	}
	
	public String getName() {
		return this.name;
	}
	
	public State getState() {
		return this.state;
	}

	public State turn(State state) {
		this.printer.log("TV turned:" + state);

		return this.state = state;
	}

	public State toggle() {
		this.state = this.state == State.ON ? State.OFF : State.ON;

		this.printer.log("TV turned:" + this.state);

		return this.state;
	}

	public int getChannel() {
		return this.channel.get();
	}

	public int setChannel(int channel) {
		return this.channel.set(channel);
	}

	public int upChannel() {
		return this.channel.up();
	}

	public int upChannel(int value) {
		return this.channel.up(value);
	}

	public int downChannel() {
		return this.channel.down();
	}

	public int downChannel(int value) {
		return this.channel.down(value);
	}

	public int getVolume() {
		return this.volume.get();
	}

	public int setVolume(int volume) {
		return this.volume.set(volume);
	}

	public int increaseVolume(int volume) {
		return this.volume.up(volume);
	}

	public int increaseVolume() {
		return this.volume.up();
	}

	public int decreaseVolume(int volume) {
		return this.volume.down(volume);
	}

	public int decreaseVolume() {
		return this.volume.down();
	}

	public void dispose() {
		this.printer.dispose();
	}

	class Printer {
		private PrintWriter file;

		public Printer() throws FileNotFoundException {
			this.file = new PrintWriter(new File("log.txt"));
		}

		public Printer(File file) throws FileNotFoundException {
			this.file = new PrintWriter(file);
		}

		public Printer(String filename) throws FileNotFoundException {
			this.file = new PrintWriter(new File(filename));
		}

		public void log(String msg) {
			msg = msg.endsWith("\n") ? msg : msg + "\n";

			this.file.print(msg);
			this.file.flush();
		}

		public void dispose() {
			this.file.close();
		}
	}

	class Volume {
		private int value;
		private Printer printer;

		public Volume(Printer printer) {
			this.value = 50;
			this.printer = printer;

			this.printer.log("Volume initialized");
		}

		public Volume(Printer printer, int value) {
			this.value = value > 0 && value <= 100 ? value : 50;
			this.printer = printer;

			this.printer.log("Volume initialized");
		}

		private void log() {
			this.printer.log("Volume set: " + this.value);
		}

		public int get() {
			return value;
		}

		public int set(int value) {
			if (value > 0 && value <= 100)
				this.value = value;

			this.log();
			return this.value;
		}

		public int up() {
			this.value = Math.min(this.value + 1, 101);

			this.log();

			return this.value;
		}

		public int up(int value) {
			this.value = Math.min(this.value + value, 101);

			this.log();

			return this.value;
		}

		public int down() {
			this.value = Math.max(this.value - 1, 0);

			this.log();

			return this.value;
		}

		public int down(int value) {
			this.value = Math.max(this.value - value, 0);

			this.log();

			return this.value;
		}
	}

	class Channel {
		private int current;
		private Printer printer;

		public Channel(Printer printer) {
			this.current = 1;
			this.printer = printer;

			this.printer.log("Channel initialized");
		}

		public Channel(Printer printer, int current) {
			this.current = current > 0 && current <= 100 ? current : 1;
			this.printer = printer;

			this.printer.log("Channel initialized");
		}

		private void log() {
			this.printer.log("Channel set: " + this.current);
		}

		public int get() {
			return current;
		}

		public int set(int current) {
			if (current > 0 && current <= 100)
				this.current = current;

			this.log();

			return this.current;
		}

		public int up() {
			this.current = Math.min(this.current + 1, 101);

			this.log();

			return this.current;
		}

		public int up(int value) {
			this.current = Math.min(this.current + value, 101);

			this.log();

			return this.current;
		}

		public int down() {
			this.current = Math.max(this.current - 1, 0);

			this.log();

			return this.current;
		}

		public int down(int value) {
			this.current = Math.max(this.current - value, 0);

			this.log();

			return this.current;
		}
	}
}
