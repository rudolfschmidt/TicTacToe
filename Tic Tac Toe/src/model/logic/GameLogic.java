package model.logic;

import model.player.Player;

public class GameLogic {

	private FirstRowLogic firstRowLogic;
	private SecondRowLogic secondRowLogic;
	private ThirdRowLogic thirdRowLogic;

	public GameLogic(FirstRowLogic firstRowLogic, SecondRowLogic secondRowLogic, ThirdRowLogic thirdRowLogic) {
		this.firstRowLogic = firstRowLogic;
		this.secondRowLogic = secondRowLogic;
		this.thirdRowLogic = thirdRowLogic;
	}

	public void prepare() {
		firstRowLogic.setRowLogic();
		secondRowLogic.setRowLogic();
		thirdRowLogic.setRowLogic();

		firstRowLogic.setColumnLogic(secondRowLogic);
		secondRowLogic.setColumnLogic(thirdRowLogic);

		firstRowLogic.setCrossLogic(secondRowLogic);
		secondRowLogic.setCrossLogic(thirdRowLogic);
		secondRowLogic.setCrossLogic(firstRowLogic);
		thirdRowLogic.setCrossLogic(secondRowLogic);
	}

	public void process(Player player) {
		firstRowLogic.process(player);
		secondRowLogic.process(player);
		thirdRowLogic.process(player);
	}
}
