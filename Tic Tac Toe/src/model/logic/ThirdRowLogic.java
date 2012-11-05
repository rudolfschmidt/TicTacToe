package model.logic;

import model.player.Player;

public class ThirdRowLogic {

	private FieldHadler thirdFirstHandler;
	private FieldHadler thirdSecondHandler;
	private FieldHadler thirdThirdHandler;

	public ThirdRowLogic(FieldHadler thirdFirstHandler, FieldHadler thirdSecondHandler, FieldHadler thirdThirdHandler) {
		this.thirdFirstHandler = thirdFirstHandler;
		this.thirdSecondHandler = thirdSecondHandler;
		this.thirdThirdHandler = thirdThirdHandler;
	}

	public void setRowLogic() {
		thirdFirstHandler.next(thirdSecondHandler);
		thirdSecondHandler.next(thirdThirdHandler);
	}

	public void setCrossLogic(SecondRowLogic secondRowLogic) {
		thirdFirstHandler.next(secondRowLogic.getSecondSecondHandler());
	}

	public void process(Player player) {
		thirdFirstHandler.handle(player);
	}

	public FieldHadler getThirdFirstHandler() {
		return thirdFirstHandler;
	}

	public FieldHadler getThirdSecondHandler() {
		return thirdSecondHandler;
	}

	public FieldHadler getThirdThirdHandler() {
		return thirdThirdHandler;
	}
}
