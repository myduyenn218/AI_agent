package chapter2.agent_AB;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");

	public enum LocationState {
		CLEAN, DIRTY, OBSTACLE
	}

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	private EnvironmentState envState;
	private int m;
	private int n;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(Environment.LocationState[][] grid, int totalDirt) {
		m = grid.length;
		n = grid[0].length;

		envState = new EnvironmentState(grid, totalDirt);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) throws WrongPlaceException {
		// TODO
		System.out.println(location);

		if (envState.getLocationState(location) == LocationState.OBSTACLE) {
			throw new WrongPlaceException();
		}

		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		// TODO
		String agentLocation = envState.getAgentLocation();
		if (action.equals(SUCK_DIRT)) {

			envState.setLocationState(agentLocation, LocationState.CLEAN);
			envState.setCurrentDirt(envState.getCurrentDirt() - 1);
			agent.setPoints(agent.getPoints() + 500);

		} else {
			String nextLocation = null;

			if (action.equals(MOVE_LEFT)) {
				nextLocation = getNextLocation(Direction.LEFT, agentLocation);
			} else if (action.equals(MOVE_RIGHT)) {
				nextLocation = getNextLocation(Direction.RIGHT, agentLocation);
			} else if (action.equals(MOVE_UP)) {
				nextLocation = getNextLocation(Direction.UP, agentLocation);
			} else if (action.equals(MOVE_DOWN)) {
				nextLocation = getNextLocation(Direction.DOWN, agentLocation);
			}

			agent.setPoints(agent.getPoints() - 10);

			if (nextLocation != null && envState.getLocationState(nextLocation) != LocationState.OBSTACLE) {
				agent.setPoints(agent.getPoints() - 100);
				envState.setAgentLocation(nextLocation);
			}
		}

		return envState;
	}

	private String getNextLocation(Environment.Direction direction, String location) {
		String[] loc = location.split(",");
		int i = Integer.parseInt(loc[0]);
		int j = Integer.parseInt(loc[1]);

		switch (direction) {
		case UP:
			i--;
			break;
		case DOWN:
			i++;
			break;
		case LEFT:
			j--;
			break;
		case RIGHT:
			j++;
			break;
		default:
			break;
		}
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return null;
		} else
			return EnvironmentState.getKeyState(i, j);

	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		Percept p = new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
		return p;
	}

	public void step() {
		envState.display(m, n);
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);
		System.out.println("Agent points: " + agent.getPoints());
//		int durt 

		if (envState.getCurrentDirt() == 0)
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display(m, n);
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();

			System.out.println("-------------------------");
			if (isDone) {
				System.out.println("Done");
				break;
			}
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
			System.out.println("-------------------------");
		}
		System.out.println("Done");

	}
}
