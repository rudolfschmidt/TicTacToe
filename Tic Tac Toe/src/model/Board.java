package model;

import model.marking.Marking;
import model.player.Player;

public class Board {

	private Row firstRow;
	private Row secondRow;
	private Row thirdRow;

	public Board(Row firstRow, Row secondRow, Row thirdRow) {
		this.firstRow = firstRow;
		this.secondRow = secondRow;
		this.thirdRow = thirdRow;
	}

	public void mark(Marking marking, Player player) {
		marking.markRow(firstRow, secondRow, thirdRow, player);
	}
}
