package model;

import model.fieldMarking.FieldMarking;
import model.player.Player;

public class Field {

	private FieldMarking state;

	public Field(FieldMarking state) {
		this.state = state;
	}

	public FieldMarking getState() {
		return state;
	}

	public void mark(Player player) {
		state = player.getMarking();
	}

	public boolean equals(FieldMarking marking) {
		return state.equals(marking);
	}

}
