package chapter2.agent_AB;

public class Agent {
	protected AgentProgram program;
	private int points;

	public Agent() {
		points = 0;
	}

	public int getPoints() {
		return points;
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	public Action execute(Percept p) {
		if (program != null) {
			Action ac = program.execute(p);
			if (ac == Environment.SUCK_DIRT) {
				points += 500;
			} else {
				
				points -= 10;

			}
			return program.execute(p);
		}
		points -= 100;
		return NoOpAction.NO_OP;
	}
}
