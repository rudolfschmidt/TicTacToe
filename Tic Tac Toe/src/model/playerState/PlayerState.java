package model.playerState;

import model.Game;
import model.player.Player;

public abstract class PlayerState {

	private Player player;

	public PlayerState(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return getClass().equals(obj.getClass());
	}

	public abstract void updateState(Game game);

	public abstract void setWon();

	public abstract void setLost();

	protected Player getPlayer() {
		return player;
	}

}
