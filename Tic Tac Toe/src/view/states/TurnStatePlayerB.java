package view.states;

import javax.swing.JButton;

import view.StartClient;

public class TurnStatePlayerB implements TurnState {

	@Override
	public void mark(JButton button) {
		button.setText("O");
	}

	@Override
	public void nextTurn(StartClient client) {
		client.setState(new TurnStatePlayerA());
	}

}
