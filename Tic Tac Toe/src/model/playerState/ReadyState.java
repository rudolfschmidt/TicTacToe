package model.playerState;

import model.Game;
import model.player.Player;

public class ReadyState extends PlayerState {

	public ReadyState(Player player) {
		super(player);
	}

	@Override
	public void updateState(Game game) {
		getPlayer().setState(new PlayingState(getPlayer()));
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
