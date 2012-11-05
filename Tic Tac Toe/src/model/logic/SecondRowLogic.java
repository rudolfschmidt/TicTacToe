package model.logic;

import model.player.Player;

public class SecondRowLogic {

	private FieldHadler secondFirstHandler;
	private FieldHadler secondSecondHandler;
	private FieldHadler secondThirdHandler;

	public SecondRowLogic(FieldHadler secondFirstHandler, FieldHadler secondSecondHandler, FieldHadler secondThirdHandler) {
		this.secondFirstHandler = secondFirstHandler;
		this.secondSecondHandler = secondSecondHandler;
		this.secondThirdHandler = secondThirdHandler;
	}

	public void setRowLogic() {
		secondFirstHandler.next(secondSecondHandler);
		secondSecondHandler.next(secondThirdHandler);
	}

	public void setColumnLogic(ThirdRowLogic thirdRowLogic) {
		secondFirstHandler.next(thirdRowLogic.getThirdFirstHandler());
		secondSecondHandler.next(thirdRowLogic.getThirdSecondHandler());
		secondThirdHandler.next(thirdRowLogic.getThirdThirdHandler());
	}

	public void setCrossLogic(ThirdRowLogic thirdRowLogic) {
		secondSecondHandler.next(thirdRowLogic.getThirdThirdHandler());
	}

	public void setCrossLogic(FirstRowLogic firstRowLogic) {
		secondSecondHandler.next(firstRowLogic.getFirstThirdHandler());
	}

	public void process(Player player) {
		secondFirstHandler.handle(player);
	}

	public FieldHadler getSecondFirstHandler() {
		return secondFirstHandler;
	}

	public FieldHadler getSecondSecondHandler() {
		return secondSecondHandler;
	}

	public FieldHadler getSecondThirdHandler() {
		return secondThirdHandler;
	}

}
