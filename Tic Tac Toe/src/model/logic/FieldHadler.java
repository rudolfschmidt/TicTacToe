package model.logic;

import java.util.ArrayList;
import java.util.Collection;

import model.Field;
import model.player.Player;

public class FieldHadler {

	private Collection<FieldHadler> chains = new ArrayList<>();
	private Field field;

	public FieldHadler(Field field) {
		this.field = field;
	}

	public void next(FieldHadler handler) {
		chains.add(handler);
	}

	public void handle(Player player) {
		if (field.equals(player.getMarking())) {
			if (chains.isEmpty()) {
				player.setGameWon();
			} else {
				for (FieldHadler handler : chains) {
					handler.handle(player);
				}
			}
		}
	}

}
