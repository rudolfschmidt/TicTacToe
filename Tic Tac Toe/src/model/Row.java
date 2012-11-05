package model;

import model.marking.Marking;
import model.player.Player;

public class Row {

	private Field firstField;
	private Field secondField;
	private Field thirdField;

	public Row(Field firstField, Field secondField, Field thirdField) {
		this.firstField = firstField;
		this.secondField = secondField;
		this.thirdField = thirdField;
	}

	public void mark(Marking marking, Player player) {
		marking.markField(firstField, secondField, thirdField, player);
	}
}
