package model;

import junit.framework.Assert;
import model.fieldMarking.AFieldMarking;
import model.fieldMarking.BFieldMarking;
import model.fieldMarking.EmptyFieldMarking;
import model.logic.FieldHadler;
import model.logic.FirstRowLogic;
import model.logic.GameLogic;
import model.logic.SecondRowLogic;
import model.logic.ThirdRowLogic;
import model.marking.BottomLeftMarking;
import model.marking.BottomMiddleMarking;
import model.marking.BottomRightMarking;
import model.marking.MiddleMiddleMarking;
import model.marking.MiddleRightMarking;
import model.marking.TopLeftMarking;
import model.marking.TopRightMarking;
import model.player.Mediator;
import model.player.Player;
import model.player.PlayerA;
import model.player.PlayerB;
import model.playerState.LostState;
import model.playerState.PlayingState;
import model.playerState.ReadyState;
import model.playerState.WonState;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestModel {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simpleStateAssertation() {
		Field firstRowFirstField = new Field(new EmptyFieldMarking());
		Field firstRowSecondField = new Field(new EmptyFieldMarking());
		Field firstRowThirdField = new Field(new EmptyFieldMarking());

		Field secondRowFirstField = new Field(new EmptyFieldMarking());
		Field secondRowSecondField = new Field(new EmptyFieldMarking());
		Field secondRowThirdField = new Field(new EmptyFieldMarking());

		Field thirdRowFirstField = new Field(new EmptyFieldMarking());
		Field thirdRowSecondField = new Field(new EmptyFieldMarking());
		Field thirdRowThirdField = new Field(new EmptyFieldMarking());

		Row firstRow = new Row(firstRowFirstField, firstRowSecondField, firstRowThirdField);
		Row secondRow = new Row(secondRowFirstField, secondRowSecondField, secondRowThirdField);
		Row thirdRow = new Row(thirdRowFirstField, thirdRowSecondField, thirdRowThirdField);
		Board board = new Board(firstRow, secondRow, thirdRow);

		FieldHadler firstRowFirstFieldHandler = new FieldHadler(firstRowFirstField);
		FieldHadler firstRowSecondFieldHandler = new FieldHadler(firstRowSecondField);
		FieldHadler firstRowThirdFieldHandler = new FieldHadler(firstRowThirdField);

		FieldHadler secondRowFirstFieldHandler = new FieldHadler(secondRowFirstField);
		FieldHadler secondRowSecondFieldHandler = new FieldHadler(secondRowSecondField);
		FieldHadler secondRowThirdFieldHandler = new FieldHadler(secondRowThirdField);

		FieldHadler thirdRowFirstFieldHandler = new FieldHadler(thirdRowFirstField);
		FieldHadler thirdRowSecondFieldHandler = new FieldHadler(thirdRowSecondField);
		FieldHadler thirdRowThirdFieldHandler = new FieldHadler(thirdRowThirdField);

		FirstRowLogic firstRowLogic = new FirstRowLogic(firstRowFirstFieldHandler, firstRowSecondFieldHandler, firstRowThirdFieldHandler);
		SecondRowLogic secondRowLogic = new SecondRowLogic(secondRowFirstFieldHandler, secondRowSecondFieldHandler, secondRowThirdFieldHandler);
		ThirdRowLogic thirdRowLogic = new ThirdRowLogic(thirdRowFirstFieldHandler, thirdRowSecondFieldHandler, thirdRowThirdFieldHandler);
		GameLogic logic = new GameLogic(firstRowLogic, secondRowLogic, thirdRowLogic);

		Game game = new Game(board, logic);
		Mediator mediator = new Mediator();
		Player playerA = new PlayerA(game, mediator);
		Player playerB = new PlayerB(game, mediator);
		mediator.registerPlayerA(playerA);
		mediator.registerPlayerB(playerB);
		logic.prepare();

		Assert.assertEquals(playerA.getState(), new ReadyState(playerA));
		Assert.assertEquals(playerB.getState(), new ReadyState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new EmptyFieldMarking());

		playerA.mark(new TopRightMarking());
		Assert.assertEquals(playerA.getState(), new PlayingState(playerA));
		Assert.assertEquals(playerB.getState(), new PlayingState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new AFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new EmptyFieldMarking());

		playerB.mark(new TopLeftMarking());
		Assert.assertEquals(playerA.getState(), new PlayingState(playerA));
		Assert.assertEquals(playerB.getState(), new PlayingState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new BFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new AFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new EmptyFieldMarking());

		playerA.mark(new BottomLeftMarking());
		Assert.assertEquals(playerA.getState(), new PlayingState(playerA));
		Assert.assertEquals(playerB.getState(), new PlayingState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new BFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new AFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new AFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new EmptyFieldMarking());

		playerB.mark(new MiddleMiddleMarking());
		Assert.assertEquals(playerA.getState(), new PlayingState(playerA));
		Assert.assertEquals(playerB.getState(), new PlayingState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new BFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new AFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new BFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new AFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new EmptyFieldMarking());

		playerA.mark(new BottomRightMarking());
		Assert.assertEquals(playerA.getState(), new PlayingState(playerA));
		Assert.assertEquals(playerB.getState(), new PlayingState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new BFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new AFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new BFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new AFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new AFieldMarking());

		playerB.mark(new MiddleRightMarking());
		Assert.assertEquals(playerA.getState(), new PlayingState(playerA));
		Assert.assertEquals(playerB.getState(), new PlayingState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new BFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new AFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new BFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new BFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new AFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new AFieldMarking());

		playerA.mark(new BottomMiddleMarking());
		Assert.assertEquals(playerA.getState(), new WonState(playerA));
		Assert.assertEquals(playerB.getState(), new LostState(playerB));

		Assert.assertEquals(firstRowFirstField.getState(), new BFieldMarking());
		Assert.assertEquals(firstRowSecondField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(firstRowThirdField.getState(), new AFieldMarking());
		Assert.assertEquals(secondRowFirstField.getState(), new EmptyFieldMarking());
		Assert.assertEquals(secondRowSecondField.getState(), new BFieldMarking());
		Assert.assertEquals(secondRowThirdField.getState(), new BFieldMarking());
		Assert.assertEquals(thirdRowFirstField.getState(), new AFieldMarking());
		Assert.assertEquals(thirdRowSecondField.getState(), new AFieldMarking());
		Assert.assertEquals(thirdRowThirdField.getState(), new AFieldMarking());

	}
}
