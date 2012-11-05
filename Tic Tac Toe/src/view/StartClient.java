package view;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.states.TurnState;
import view.states.TurnStatePlayerA;

public class StartClient {

	private TurnState state;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				StartClient client = new StartClient();
				client.setState(new TurnStatePlayerA());
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(client.createContentPane());
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public JPanel createContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		panel.add(createButton());
		panel.add(createButton());
		panel.add(createButton());
		panel.add(createButton());
		panel.add(createButton());
		panel.add(createButton());
		panel.add(createButton());
		panel.add(createButton());
		panel.add(createButton());
		return panel;
	}

	private Component createButton() {
		JButton button = new JButton();
		button.setText("-");
		button.addActionListener(new GameAction(this, button));
		return button;
	}

	public TurnState getState() {
		return state;
	}

	public void setState(TurnState state) {
		this.state = state;
	}

	public void nextTurn() {
		state.nextTurn(this);
	}

	public void mark(JButton button) {
		state.mark(button);
	}

}
