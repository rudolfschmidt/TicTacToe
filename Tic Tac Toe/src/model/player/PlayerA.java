package model.player;

import model.Game;
import model.fieldMarking.AFieldMarking;
import model.fieldMarking.FieldMarking;

public class PlayerA extends Player {

	public PlayerA(Game game, Mediator mediator) {
		super(game, mediator);
	}

	@Override
	public FieldMarking getMarking() {
		return new AFieldMarking();
	}

	@Override
	public void setGameWon() {
		getMediator().setWon(this);
	}
}