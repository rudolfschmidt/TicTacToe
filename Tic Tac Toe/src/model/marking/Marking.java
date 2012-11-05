package model.marking;

import model.Field;
import model.Row;
import model.player.Player;

public interface Marking {

	void markRow(Row firstRow, Row secondRow, Row thirdRow, Player player);

	void markField(Field firstField, Field secondField, Field thirdField, Player player);

}
