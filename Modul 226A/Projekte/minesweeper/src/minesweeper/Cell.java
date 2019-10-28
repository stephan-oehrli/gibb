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
		return hasBomb && isMarked();
	}

	public void turn() {
		this.state = hasBomb ? State.EXPLODED : State.REVEALED;
	}

	public void mark() {
		this.state = (this.state == State.HIDDEN) ? State.MARKED : State.HIDDEN;
	}
	
	public boolean isMarked() {
		return this.state == State.MARKED;
	}
	
	public boolean isHidden() {
		return this.state == State.HIDDEN;
	}
	
	public boolean isExploded() {
		return this.state == State.EXPLODED;
	}
	
	public boolean isRevealed() {
		return this.state == State.REVEALED;
	}
	
	public boolean hasBomb() {
		return hasBomb;
	}
	
	public boolean hasNeighbourBombs() {
		return this.numOfNeighbourBombs > 0;
	}

	public void setNumOfNeighbourBombs(int num) {
		this.numOfNeighbourBombs = num;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}

	
}
