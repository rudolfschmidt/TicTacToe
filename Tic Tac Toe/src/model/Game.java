package model;

import model.logic.GameLogic;
import model.marking.Marking;
import model.player.Player;

public class Game {

	private Board board;
	private GameLogic logic;

	public Game(Board board, GameLogic logic) {
		this.board = board;
		this.logic = logic;
	}

	public void mark(Marking marking, Player player) {
		board.mark(marking, player);
	}

	public void whoWon(Player player) {
		logic.process(player);
	}
}
