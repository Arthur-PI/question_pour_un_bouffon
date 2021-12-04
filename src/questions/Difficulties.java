package questions;

public enum Difficulties {
	EASY,
	MEDIUM,
	HARD;

	public Difficulties getDifficulty(int i) {
		return switch (i) {
			case 2 -> (MEDIUM);
			case 3 -> (HARD);
			default -> (EASY);
		};
	}
}