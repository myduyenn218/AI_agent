package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import chapter2.agent_AB.Environment;
import chapter2.agent_AB.Environment.LocationState;
import chapter2.agent_AB.EnvironmentState;

public class FloorPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int CELLWIDTH = 20;

	private EnvironmentState envState;
	private int width;
	private int height;

	public FloorPanel(EnvironmentState envState, int height, int width) {
		this.envState = envState;
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width * CELLWIDTH + 1, height * CELLWIDTH + 1));

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				String location = EnvironmentState.getKeyState(i, j);
				int x = j * CELLWIDTH;
				int y = i * CELLWIDTH;
				Environment.LocationState locationState = envState.getLocationState(location);

				if (location.equals(envState.getAgentLocation())) {
					g2.setColor(Color.BLUE);
				} else {
					if (locationState == LocationState.CLEAN) {
						g2.setColor(Color.WHITE);
					} else if (locationState == LocationState.DIRTY) {
						g2.setColor(Color.BLACK);
					} else if (locationState == LocationState.OBSTACLE) {
						g2.setColor(Color.RED);
					}
				}

				g2.fillRect(x, y, CELLWIDTH, CELLWIDTH);

				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(1));
				g2.drawRect(x, y, CELLWIDTH, CELLWIDTH);
			}
		}

		g2.dispose();
	}

}
