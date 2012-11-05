package model.logic;

import model.player.Player;

public class GameLogic {

	private FieldHandler firstRowFirstFieldHandler;
	private FieldHandler firstRowSecondFieldHandler;
	private FieldHandler firstRowThirdFieldHandler;

	private FieldHandler secondRowFirstFieldHandler;
	private FieldHandler secondRowSecondFieldHandler;
	private FieldHandler secondRowThirdFieldHandler;

	private FieldHandler thirdRowFirstFieldHandler;
	private FieldHandler thirdRowSecondFieldHandler;
	private FieldHandler thirdRowThirdFieldHandler;

	public void create() {
		firstRowFirstFieldHandler.next(firstRowSecondFieldHandler);
		firstRowSecondFieldHandler.next(firstRowThirdFieldHandler);

		secondRowFirstFieldHandler.next(secondRowSecondFieldHandler);
		secondRowSecondFieldHandler.next(secondRowThirdFieldHandler);

		thirdRowFirstFieldHandler.next(thirdRowSecondFieldHandler);
		thirdRowSecondFieldHandler.next(thirdRowThirdFieldHandler);

		firstRowFirstFieldHandler.next(secondRowFirstFieldHandler);
		secondRowFirstFieldHandler.next(thirdRowFirstFieldHandler);

		firstRowSecondFieldHandler.next(secondRowSecondFieldHandler);
		secondRowSecondFieldHandler.next(thirdRowSecondFieldHandler);

		firstRowThirdFieldHandler.next(secondRowThirdFieldHandler);
		secondRowThirdFieldHandler.next(thirdRowThirdFieldHandler);

		firstRowFirstFieldHandler.next(secondRowSecondFieldHandler);
		thirdRowFirstFieldHandler.next(secondRowSecondFieldHandler);

		secondRowSecondFieldHandler.next(thirdRowThirdFieldHandler);
		secondRowSecondFieldHandler.next(firstRowThirdFieldHandler);
	}

	public void process(Player player) {
		firstRowFirstFieldHandler.handle(player);
		secondRowFirstFieldHandler.handle(player);
		thirdRowFirstFieldHandler.handle(player);
	}

	public void setFirstRowFirstFieldHandler(FieldHandler firstRowFirstFieldHandler) {
		this.firstRowFirstFieldHandler = firstRowFirstFieldHandler;
	}

	public void setFirstRowSecondFieldHandler(FieldHandler firstRowSecondFieldHandler) {
		this.firstRowSecondFieldHandler = firstRowSecondFieldHandler;
	}

	public void setFirstRowThirdFieldHandler(FieldHandler firstRowThirdFieldHandler) {
		this.firstRowThirdFieldHandler = firstRowThirdFieldHandler;
	}

	public void setSecondRowFirstFieldHandler(FieldHandler secondRowFirstFieldHandler) {
		this.secondRowFirstFieldHandler = secondRowFirstFieldHandler;
	}

	public void setSecondRowSecondFieldHandler(FieldHandler secondRowSecondFieldHandler) {
		this.secondRowSecondFieldHandler = secondRowSecondFieldHandler;
	}

	public void setSecondRowThirdFieldHandler(FieldHandler secondRowThirdFieldHandler) {
		this.secondRowThirdFieldHandler = secondRowThirdFieldHandler;
	}

	public void setThirdRowFirstFieldHandler(FieldHandler thirdRowFirstFieldHandler) {
		this.thirdRowFirstFieldHandler = thirdRowFirstFieldHandler;
	}

	public void setThirdRowSecondFieldHandler(FieldHandler thirdRowSecondFieldHandler) {
		this.thirdRowSecondFieldHandler = thirdRowSecondFieldHandler;
	}

	public void setThirdRowThirdFieldHandler(FieldHandler thirdRowThirdFieldHandler) {
		this.thirdRowThirdFieldHandler = thirdRowThirdFieldHandler;
	}

}
