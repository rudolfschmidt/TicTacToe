package model.logic;

import java.util.ArrayList;
import java.util.Collection;

import model.Field;
import model.player.Player;

public class FieldHandler {

	private Collection<FieldHandler> chains = new ArrayList<>();
	private Field field;

	public FieldHandler(Field field) {
		this.field = field;
	}

	public void next(FieldHandler handler) {
		chains.add(handler);
	}

	public void handle(Player player) {
		if (field.equals(player.getMarking())) {
			if (chains.isEmpty()) {
				player.setGameWon();
			} else {
				for (FieldHandler handler : chains) {
					handler.handle(player);
				}
			}
		}
	}

}
