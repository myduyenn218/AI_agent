package chapter2.agent_AB;

import java.util.Random;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO

		if (p.getLocationState().equals(Environment.LocationState.DIRTY)) {
			return Environment.SUCK_DIRT;
		} else if (p.getLocationState().equals(Environment.LocationState.CLEAN)) {

			Environment.Direction d = randomDirection();
			
			
			switch (d) {
			case LEFT:
				return Environment.MOVE_LEFT;

			case RIGHT:
				return Environment.MOVE_RIGHT;

			case UP:
				return Environment.MOVE_UP;

			case DOWN:
				return Environment.MOVE_DOWN;
			}
			
			

		}
		

		return NoOpAction.NO_OP;
	}

	private Environment.Direction randomDirection() {

		Random rd = new Random();
		int number = rd.nextInt(4);
		Environment.Direction direction = null;

		switch (number) {
		case 0:
			direction = Environment.Direction.UP;
			break;
		case 1:
			direction = Environment.Direction.DOWN;
			break;
		case 2:
			direction = Environment.Direction.LEFT;
			break;
		case 3:
			direction = Environment.Direction.RIGHT;
			break;
		}

		return direction;
	}
}