package model.logic;

import model.player.Player;

public class FirstRowLogic {

	private FieldHadler firstFirstHandler;
	private FieldHadler firstSecondHandler;
	private FieldHadler firstThirdHandler;

	public FirstRowLogic(FieldHadler firstFirstHandler, FieldHadler firstSecondHandler, FieldHadler firstThirdHandler) {
		this.firstFirstHandler = firstFirstHandler;
		this.firstSecondHandler = firstSecondHandler;
		this.firstThirdHandler = firstThirdHandler;
	}

	public void setRowLogic() {
		firstFirstHandler.next(firstSecondHandler);
		firstSecondHandler.next(firstThirdHandler);
	}

	public void setColumnLogic(SecondRowLogic secondRowLogic) {
		firstFirstHandler.next(secondRowLogic.getSecondFirstHandler());
		firstSecondHandler.next(secondRowLogic.getSecondSecondHandler());
		firstThirdHandler.next(secondRowLogic.getSecondThirdHandler());
	}

	public void setCrossLogic(SecondRowLogic secondRowLogic) {
		firstFirstHandler.next(secondRowLogic.getSecondSecondHandler());
	}

	public void process(Player player) {
		firstFirstHandler.handle(player);
	}

	public FieldHadler getFirstFirstHandler() {
		return firstFirstHandler;
	}

	public FieldHadler getFirstSecondHandler() {
		return firstSecondHandler;
	}

	public FieldHadler getFirstThirdHandler() {
		return firstThirdHandler;
	}

}
