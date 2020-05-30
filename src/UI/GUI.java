package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	public GUI() {
		// TODO Auto-generated method stub
		setTitle("Upgradable App");
//		setLayout(new BorderLayout());
		JPanel menuPanel = new JPanel();

		JLabel mLable = new JLabel("m");
		JLabel nLable = new JLabel("n");
		JLabel DIRT_RATE_Lable = new JLabel("DIRT_RATE");
		JLabel OBS_RATE_Lable = new JLabel("OBS_RATE");

		JTextField m = new JTextField(5);

		JTextField n = new JTextField(5);
		JTextField dirtRate = new JTextField(5);
		JTextField obsRate = new JTextField(5);

		JTextField result = new JTextField(5);
		JButton enter = new JButton("OK");
		result.setEnabled(false);

		menuPanel.add(mLable);
		menuPanel.add(m);
		menuPanel.add(nLable);
		menuPanel.add(n);
		menuPanel.add(DIRT_RATE_Lable);
		menuPanel.add(dirtRate);
		menuPanel.add(OBS_RATE_Lable);
		menuPanel.add(obsRate);
		menuPanel.add(enter);

		JPanel floorPanel = new JPanel();
		floorPanel.setLayout(new GridLayout(5, 5));

//		mp.add(cal);
//
//		cal.addActionListener((ActionListener) new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String aText = a.getText();
//				String bText = b.getText();
//				try {
//					int a = Integer.parseInt(aText);
//					int b = Integer.parseInt(bText);
//					int res = a + b;
//					result.setText(res + "");
//				} catch (NumberFormatException exception) {
//
//				}
//			}
//		});

		getContentPane().add(menuPanel, BorderLayout.NORTH);
		getContentPane().add(floorPanel, BorderLayout.CENTER);
		setSize(600, 500);
		setLocationRelativeTo(null); // BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new GUI();
	}

}
