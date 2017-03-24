package pt.assign1.view;

import java.awt.*;

import javax.swing.*;

public class MainView {

	JLabel l1;
	JLabel l2;
	JLabel l3;
	JFrame frame;
	JPanel panou;
	JPanel panouB;
	JPanel panouB2;
	JPanel panouT;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JTextField t1;
	JTextField t2;
	JTextField t3;

	public MainView() {

		JFrame frame = new JFrame("Polynom Processing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 350);
		frame.setBackground(Color.lightGray);
		panou = new JPanel();
		panou.setLayout(new BoxLayout(panou, BoxLayout.Y_AXIS));
		panouB = new JPanel();
		panouB2 = new JPanel();
		FlowLayout f = new FlowLayout(FlowLayout.CENTER);

		panouB.setLayout(f);
		panouB2.setLayout(f);

		panouT = new JPanel();
		panouT.setLayout(new BoxLayout(panouT, BoxLayout.Y_AXIS));
		l1 = new JLabel("First Polynom:", JLabel.CENTER);
		l2 = new JLabel("Second Polynom:", JLabel.CENTER);
		l3 = new JLabel("Result:", JLabel.CENTER);
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		b1 = new JButton("Add");
		b2 = new JButton("Substract");
		b3 = new JButton("Derivate");
		b4 = new JButton("Integrate");
		b5 = new JButton("Multiply");
		b6 = new JButton("Divide");
		b7 = new JButton("Clear");

		frame.add(panou);

		panou.add(panouT);
		panou.add(panouB);
		panou.add(panouB2);
		panouT.setBackground(new Color(137, 190, 158));
		panouB.setBackground(new Color(137, 190, 158));
		panouB2.setBackground(new Color(137, 190, 158));
		panouT.add(l1);
		panouT.add(t1);
		panouT.add(l2);
		panouT.add(t2);
		panouT.add(l3);
		panouT.add(t3);
		panouB.add(b1);
		panouB.add(b2);
		panouB.add(b3);
		panouB.add(b4);
		panouB2.add(b5);
		panouB2.add(b6);
		panouB2.add(b7);
		b7.setBackground(new Color(237, 234, 97));

		frame.setVisible(true);

	}
}
