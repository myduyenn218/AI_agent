package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chapter2.agent_AB.Agent;
import chapter2.agent_AB.AgentProgram;
import chapter2.agent_AB.Environment;
import chapter2.agent_AB.EnvironmentState;
import chapter2.agent_AB.WrongPlaceException;

public class GUI extends JFrame {

	private JTextField tfM;
	private JTextField tfN;
	private JTextField tfDirtRate;
	private JTextField tfObsRate;
	private Environment env;

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

	public void start() {
		int m = Integer.parseInt(tfM.getText());
		int n = Integer.parseInt(tfN.getText());
		double dirtRate = Double.parseDouble(tfDirtRate.getText());
		double obsRate = Double.parseDouble(tfObsRate.getText());
		int total = m * n;
		int dirt = (int) Math.round(total * dirtRate);
		int obstacles = (int) Math.round(total * obsRate);

		Environment.LocationState[][] grid = new Environment.LocationState[m][n];

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

		boolean flagAgent = false;

		while (!flagAgent) {
			try {
				env = new Environment(grid, dirt);
				Agent agent = new Agent(new AgentProgram());
				env.addAgent(agent, EnvironmentState.getKeyState(0, 0));
				flagAgent = true;
			} catch (WrongPlaceException e) {
				System.out.println("Agent can't be put on obstacle");
				shuffle(grid);
//				e.printStackTrace();
			}
		}
		JPanel floorPanel = env.getCurrentState().getStatePanel();
		JPanel main = new JPanel();

		main.add(floorPanel);

		getContentPane().add(main, BorderLayout.CENTER);
		validate();
	}

	public GUI() {
		// TODO Auto-generated method stub
		setTitle("Upgradable App");
		setLayout(new BorderLayout());
		JPanel menuPanel = new JPanel();

		JLabel mLable = new JLabel("m");
		JLabel nLable = new JLabel("n");
		JLabel DIRT_RATE_Lable = new JLabel("DIRT_RATE");
		JLabel OBS_RATE_Lable = new JLabel("OBS_RATE");

		tfM = new JTextField(5);
		tfN = new JTextField(5);
		tfDirtRate = new JTextField(5);
		tfObsRate = new JTextField(5);

		JTextField result = new JTextField(5);
		JButton enter = new JButton("Start");
		result.setEnabled(false);

		menuPanel.add(mLable);
		menuPanel.add(tfM);
		menuPanel.add(nLable);
		menuPanel.add(tfN);
		menuPanel.add(DIRT_RATE_Lable);
		menuPanel.add(tfDirtRate);
		menuPanel.add(OBS_RATE_Lable);
		menuPanel.add(tfObsRate);
		menuPanel.add(enter);

		getContentPane().add(menuPanel, BorderLayout.NORTH);

		setSize(600, 500);
		setLocationRelativeTo(null); // BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		enter.addActionListener(new ActionListener() {
			boolean flag = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				Thread th;

				if (enter.getText().equals("Start")) {
					flag = false;
					enter.setText("Stop");
					start();

					th = new Thread(new Runnable() {

						@Override
						public void run() {
							while (true) {
								env.step();

								try {
									Thread.sleep(100);
									if (env.isDone()) {
										JOptionPane.showMessageDialog(null, "Successfully Done Activity", "Success",
												JOptionPane.INFORMATION_MESSAGE);
										enter.setText("Start");
										break;
									} else if (flag) {
										break;
									}
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						}
					});
					th.start();
				} else {
					enter.setText("Start");
					flag = true;

				}
			}

		});

	}

	public static void main(String[] args) {
		new GUI();
	}

}
