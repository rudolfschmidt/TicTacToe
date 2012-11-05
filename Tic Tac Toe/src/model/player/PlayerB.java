package model.player;

import model.Game;
import model.fieldMarking.BFieldMarking;
import model.fieldMarking.FieldMarking;

public class PlayerB extends Player {

	public PlayerB(Game game, Mediator mediator) {
		super(game, mediator);
	}

	@Override
	public FieldMarking getMarking() {
		return new BFieldMarking();
	}

	@Override
	public void setGameWon() {
		getMediator().setWon(this);
	}
}