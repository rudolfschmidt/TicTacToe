package model.playerState;

import model.Game;
import model.player.Player;

public class WonState extends PlayerState {

	public WonState(Player player) {
		super(player);
	}

	@Override
	public void updateState(Game game) {
		throw new IllegalStateException();
	}

	@Override
	public void setWon() {
		throw new IllegalStateException();
	}

	@Override
	public void setLost() {
		throw new IllegalStateException();
	}

}
