package model.player;

import model.Game;
import model.fieldMarking.FieldMarking;
import model.marking.Marking;
import model.playerState.PlayerState;
import model.playerState.ReadyState;

public abstract class Player {

	private PlayerState state;
	private Game game;
	private Mediator mediator;

	protected Player(Game game, Mediator mediator) {
		this.state = new ReadyState(this);
		this.game = game;
		this.mediator = mediator;
	}

	public void whoWon(Player player) {
		game.whoWon(player);
	}

	public void mark(Marking marking) {
		game.mark(marking, this);
		mediator.updateGameState();
	}

	public void updateState() {
		state.updateState(game);
	}

	public void setWon() {
		state.setWon();
	}

	public void setLost() {
		state.setLost();
	}

	public PlayerState getState() {
		return state;
	}

	public void setState(PlayerState state) {
		this.state = state;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public abstract FieldMarking getMarking();

	public abstract void setGameWon();

}
