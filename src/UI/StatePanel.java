package UI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chapter2.agent_AB.EnvironmentState;

public class StatePanel extends JPanel {

	private JLabel pointsLabel;
	private FloorPanel floorPanel;
	EnvironmentState envState;

	public StatePanel(EnvironmentState envState, int height, int width) {
		this.envState = envState;
		this.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		JLabel textPoint = new JLabel("Points: ");
		pointsLabel = new JLabel(envState.getAgentPoint() + "");
		floorPanel = new FloorPanel(envState, height, width);
		p.add(textPoint);
		p.add(pointsLabel);

//		add(textPoint, BorderLayout.NORTH);
		add(p, BorderLayout.NORTH);
		add(floorPanel, BorderLayout.CENTER);
	}

	@Override
	public void repaint() {
		if (pointsLabel != null) {
			pointsLabel.setText(this.envState.getAgentPoint() + "");
		}
		super.repaint();
	}
}
