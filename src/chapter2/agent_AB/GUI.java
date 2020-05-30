package chapter2.agent_AB;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	public GUI() {
		JButton b = new JButton("click");// tạo button
		b.setBounds(130, 50, 100, 40);

		add(b);// thêm button vào JFrame
		setSize(400, 200);
		setLayout(null);
		setVisible(true);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.red);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				mainPanel.add(new JButton("a"));
			}
		}
		add(mainPanel);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
