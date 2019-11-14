package minesweeper.playground;

import minesweeper.State;

/**
 * Die Klasse Cell stellt eine einzelne Spielzelle im Minesweeper Spielfeld dar.
 * Die Zelle einer Cell-Instanz verwaltet ihren Status (versteckt, explodiert,
 * markiert, aufgedeckt) und gibt Auskunft darüber.
 * 
 * @author Stephan Oehrli
 *
 */
public class Cell {

	private State state = State.HIDDEN;
	private int numOfNeighbourBombs;
	private boolean hasBomb;

	/**
	 * Gibt das anzuzeigende Symbol gemäss dem Status der Zelle zurück. (* wenn
	 * explodiert, ! wenn markiert, [anzahl Nachbarbomben] wenn aufgedeckt, ' ' wenn
	 * versteckt)
	 * 
	 * @return anzuzeigendes Symbol.
	 */
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

	/**
	 * Gibt an, ob die Spielfeldzelle korrekt markiert wurde.
	 * 
	 * @return true wenn die Spielfeldzelle korrekt markiert wurde.
	 */
	public boolean hasCorrectMark() {
		return hasBomb && isMarked();
	}

	/**
	 * Deckt die Spielfeldzelle auf.
	 */
	public void turn() {
		this.state = hasBomb ? State.EXPLODED : State.REVEALED;
	}

	/**
	 * Markiert die Spielfeldzelle.
	 */
	public void mark() {
		this.state = (this.state == State.HIDDEN) ? State.MARKED : State.HIDDEN;
	}

	/**
	 * Gibt an ob die Spielfeldzelle markiert ist.
	 * 
	 * @return true wenn die Spielfeldzelle markiert ist.
	 */
	public boolean isMarked() {
		return this.state == State.MARKED;
	}

	/**
	 * Gibt an ob die Spielfeldzelle versteckt ist.
	 * 
	 * @return true wenn die Spielfeldzelle versteckt ist.
	 */
	public boolean isHidden() {
		return this.state == State.HIDDEN;
	}

	/**
	 * Gibt an ob die Spielfeldzelle explodiert ist.
	 * 
	 * @return true wenn die Spielfeldzelle explodiert ist.
	 */
	public boolean isExploded() {
		return this.state == State.EXPLODED;
	}

	/**
	 * Gibt an ob die Spielfeldzelle aufgedeckt ist.
	 * 
	 * @return true wenn die Spielfeldzelle aufgedeckt ist.
	 */
	public boolean isRevealed() {
		return this.state == State.REVEALED;
	}

	/**
	 * Gibt an ob die Spielfeldzelle Bomben als Nachbarn hat.
	 * 
	 * @return true wenn die Spielfeldzelle von mindestens einer Mine umgeben ist.
	 */
	public boolean hasNeighbourBombs() {
		return this.numOfNeighbourBombs > 0;
	}

	public boolean hasBomb() {
		return hasBomb;
	}

	public void setNumOfNeighbourBombs(int num) {
		this.numOfNeighbourBombs = num;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}

}
