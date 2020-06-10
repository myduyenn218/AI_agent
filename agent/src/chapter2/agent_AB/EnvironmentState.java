package chapter2.agent_AB;

import java.util.HashMap;
import java.util.Map;

import UI.FloorPanel;
import UI.StatePanel;
import chapter2.agent_AB.Environment.LocationState;

public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//
	private int currentDirt;
	private StatePanel statePanel;
	private int agentPoint;

	public int getAgentPoint() {
		return agentPoint;
	}

	public void setAgentPoint(int agentPoint) {
		this.agentPoint = agentPoint;
	}

	public static String getKeyState(int i, int j) {
		return i + "," + j;
	}

	public EnvironmentState(Environment.LocationState[][] grid, int currentDirt) {
		this.currentDirt = currentDirt;
		statePanel = new StatePanel(this, grid.length, grid[0].length);
		agentPoint = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				String id = getKeyState(i, j);
//				System.out.println(id);
				this.state.put(id, grid[i][j]);
			}
		}
	}

	public int getCurrentDirt() {
		return currentDirt;
	}

	public void setCurrentDirt(int currentDirt) {
		this.currentDirt = currentDirt;
	}

	public void setAgentLocation(String location) {
//		System.out.println(location);
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, LocationState locationState) {
		this.state.put(location, locationState);
	}

	public StatePanel getStatePanel() {
		return statePanel;
	}

	public void display() {
		statePanel.repaint();
	}
}