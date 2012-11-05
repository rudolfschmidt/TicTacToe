package model.playerState;

import model.Game;
import model.player.Player;

public class LostState extends PlayerState {

	public LostState(Player player) {
		super(player);
	}

	@Override
	public void updateState(Game game) {

	}

	@Override
	public void setWon() {

	}

	@Override
	public void setLost() {

	}

}
