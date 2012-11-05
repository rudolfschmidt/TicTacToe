package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.states.ButtonState;
import view.states.ButtonStateNeutral;

public class GameAction implements ActionListener {

	private StartClient client;
	private JButton button;
	private ButtonState state;

	public GameAction(StartClient client, JButton button) {
		this.state = new ButtonStateNeutral();
		this.client = client;
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		state.mark(this, client, button);
	}

	public ButtonState getState() {
		return state;
	}

	public void setState(ButtonState state) {
		this.state = state;
	}

}
