package view.states;

import javax.swing.JButton;

import view.GameAction;
import view.StartClient;

public class ButtonStateNeutral implements ButtonState {

	@Override
	public void mark(GameAction gameAction, StartClient client, JButton button) {
		client.mark(button);
		client.nextTurn();
		gameAction.setState(new ButtonStateMarked());
	}

}
