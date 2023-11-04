package lab3;

abstract public class TV {
	enum State {
		ON, OFF
	};

	private State state;
	private String name;
	private Channel channel;
	private Volume volume;

	public TV(String name) {
		this.state = State.ON;
		this.name = name;
		
		this.channel = new Channel();
		this.volume = new Volume();
	}

	public TV(String name, int channel, int volume) {
		this.state = State.ON;
		this.name = name;
		
		this.channel = new Channel(channel);
		this.volume = new Volume(volume);
	}
	
	public String getName() {
		return this.name;
	}
	
	public State getState() {
		return this.state;
	}

	public State turn(State state) {
		System.out.println("TV turned:" + state);

		return this.state = state;
	}

	public State toggle() {
		this.state = this.state == State.ON ? State.OFF : State.ON;

		System.out.println("TV turned:" + this.state);

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

	class Volume {
		private int value;

		public Volume() {
			this.value = 50;
		}

		public Volume(int value) {
			this.value = value > 0 && value <= 100 ? value : 50;
		}

		private void log() {
			System.out.println("Volume set: " + this.value);
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

		public Channel() {
			this.current = 1;
		}

		public Channel(int current) {
			this.current = current > 0 && current <= 100 ? current : 1;
		}

		private void log() {
			System.out.println("Channel set: " + this.current);
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
