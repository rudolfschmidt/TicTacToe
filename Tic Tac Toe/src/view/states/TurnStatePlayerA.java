package view.states;

import javax.swing.JButton;

import view.StartClient;

public class TurnStatePlayerA implements TurnState {

	@Override
	public void mark(JButton button) {
		button.setText("X");
	}

	@Override
	public void nextTurn(StartClient client) {
		client.setState(new TurnStatePlayerB());
	}

}
