package view.states;

import javax.swing.JButton;

import view.StartClient;

public interface TurnState {

	void mark(JButton button);

	void nextTurn(StartClient client);

}
