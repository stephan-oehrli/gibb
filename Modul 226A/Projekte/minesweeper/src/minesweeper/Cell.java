package minesweeper;

public class Cell {

	private State state = State.HIDDEN;
	private int numOfNeighbourBombs;
	private boolean hasBomb;

	public char getDisplayedIcon() {
		char icon = ' ';
		switch (state) {
		case EXPLODED:
			icon = '*';
			break;
		case MARKED:
			icon = '!';
			break;
		case REVEALED:
			icon = Character.forDigit(numOfNeighbourBombs, 10);
			break;
		case HIDDEN:
		default:
			break;
		}
		return icon;
	}

	public boolean hasCorrectMark() {
		return hasBomb && getState() == State.MARKED;
	}

	public void turn() {
		this.state = hasBomb ? State.EXPLODED : State.REVEALED;
	}

	public void mark() {
		this.state = (this.state == State.HIDDEN) ? State.MARKED : State.HIDDEN;
	}

	public State getState() {
		return this.state;
	}

	public void setNumOfNeighbourBombs(int num) {
		this.numOfNeighbourBombs = num;
	}

	public int getNumOfNeighbourBombs() {
		return numOfNeighbourBombs;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}

	public boolean hasBomb() {
		return hasBomb;
	}
}
