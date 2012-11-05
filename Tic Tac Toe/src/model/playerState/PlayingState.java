package model.playerState;

import model.Game;
import model.player.Player;

public class PlayingState extends PlayerState {

	public PlayingState(Player player) {
		super(player);
	}

	@Override
	public void updateState(Game game) {
		game.whoWon(getPlayer());
	}

	@Override
	public void setWon() {
		getPlayer().setState(new WonState(getPlayer()));
	}

	@Override
	public void setLost() {
		getPlayer().setState(new LostState(getPlayer()));
	}

}
