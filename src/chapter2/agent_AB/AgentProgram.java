package chapter2.agent_AB;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO

		if (p.getLocationState().equals(Environment.LocationState.DIRTY)) {

			return Environment.SUCK_DIRT;
		} else if (p.getAgentLocation().equals("A")) {

			return Environment.MOVE_RIGHT;
		}

		else if (p.getAgentLocation().equals("B")) {

			return Environment.MOVE_LEFT;

		}

		return NoOpAction.NO_OP;

	}
}