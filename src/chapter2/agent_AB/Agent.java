package chapter2.agent_AB;

public class Agent {
	protected AgentProgram program;
	private int points;

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Agent() {
		points = 0;
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	public Action execute(Percept p) {
		if (program != null) {
			return program.execute(p);
		}
		return NoOpAction.NO_OP;
	}
}
