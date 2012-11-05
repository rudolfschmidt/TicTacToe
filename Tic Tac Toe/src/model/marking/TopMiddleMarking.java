package model.marking;

import model.Field;
import model.Row;
import model.player.Player;

public class TopMiddleMarking implements Marking {
	@Override
	public void markRow(Row firstRow, Row secondRow, Row thirdRow, Player player) {
		firstRow.mark(this, player);
	}

	@Override
	public void markField(Field firstField, Field secondField, Field thirdField, Player player) {
		secondField.mark(player);
	}
}
