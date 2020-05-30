package chapter2.agent_AB;

import java.util.HashMap;
import java.util.Map;

import chapter2.agent_AB.Environment.LocationState;

public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//
	private int currentDirt;

	public static String getKeyState(int i, int j) {
		return i + "," + j;
	}

	public EnvironmentState(Environment.LocationState[][] grid, int currentDirt) {
		this.currentDirt = currentDirt;
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

	public void display(int m, int n) {
		System.out.println("Environment state: \n\tCurrent Dirt" + currentDirt + "\n");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
//				System.out.print(EnvironmentState.getKeyState(i, j) + " " +agentLocation);
				if (EnvironmentState.getKeyState(i, j).equals(agentLocation)) {
					System.out.print("AGENT\t");
				} else if (state.get(EnvironmentState.getKeyState(i, j)) == LocationState.OBSTACLE) {
					System.out.print("OBSTA\t");
				}
				else {
					System.out.print(state.get(EnvironmentState.getKeyState(i, j)) + "\t");
				}

			}
			System.out.println();
		}

	}
}