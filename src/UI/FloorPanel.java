package UI;

import java.awt.Graphics;

import javax.swing.JPanel;

import chapter2.agent_AB.EnvironmentState;

public class FloorPanel extends JPanel {
	private EnvironmentState envState;
	private int width;
	private int height;
	private static final int CELLWIDTH = 20;

	public FloorPanel(EnvironmentState envState, int width, int height) {
		this.envState = envState;
		this.width = width;
		this.height = height;

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for (int x = 30; x <= 300; x += 30)
			for (int y = 30; y <= 300; y += 30)
				g.drawRect(x, y, 30, 30);

	}

}
