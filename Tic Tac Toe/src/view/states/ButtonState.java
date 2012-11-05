package view.states;

import javax.swing.JButton;

import view.GameAction;
import view.StartClient;

public interface ButtonState {

	void mark(GameAction gameAction, StartClient client, JButton button);

}
