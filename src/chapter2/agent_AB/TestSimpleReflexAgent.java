package chapter2.agent_AB;

import java.util.Random;

public class TestSimpleReflexAgent {
	public static final float DIRT_RATE = 0.2f;
	public static final float WALL_RATE = 0.1f;

	private static void shuffle(Environment.LocationState[][] grid) {
		Random r = new Random();
		int m = grid.length;
		int n = grid[0].length;

		int total = m * n;
		for (int i = total - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);

			Environment.LocationState temp = grid[i / n][i % n];
			grid[i / n][i % n] = grid[j / n][j % n];
			grid[j / n][j % n] = temp;
		}

	}

	public static void main(String[] args) {

		Environment.LocationState[][] grid = new Environment.LocationState[3][4];

		int m = grid.length;
		int n = grid[0].length;

		int total = m * n;

		int dirt = Math.round(total * DIRT_RATE);
		int obstacles = Math.round(total * WALL_RATE);
		int i = 0;
		for (; i < dirt; i++) {
			grid[i / n][i % n] = Environment.LocationState.DIRTY;
		}
		for (; i < dirt + obstacles; i++) {
			grid[i / n][i % n] = Environment.LocationState.OBSTACLE;
		}
		for (; i < total; i++) {
			grid[i / n][i % n] = Environment.LocationState.CLEAN;
		}

		shuffle(grid);
		Environment env = new Environment(grid, dirt);
		Agent agent = new Agent(new AgentProgram());

		try {
			env.addAgent(agent, EnvironmentState.getKeyState(0, 0));
			env.stepUntilDone();
		} catch (WrongPlaceException e) {
			System.out.println("Agent can't be put on obstacle");
			e.printStackTrace();
		}

		env.stepUntilDone();
//		env.step(10);

	}
}
