package model.player;


public class Mediator {

	private Player playerA;
	private Player playerB;

	public void registerPlayerA(Player player) {
		playerA = player;
	}

	public void registerPlayerB(Player player) {
		playerB = player;
	}

	public void updateGameState() {
		playerA.updateState();
		playerB.updateState();
	}

	public void setWon(PlayerA player) {
		playerA.setWon();
		playerB.setLost();
	}

	public void setWon(PlayerB player) {
		playerA.setLost();
		playerB.setWon();
	}

}
