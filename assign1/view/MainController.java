package pt.assign1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import pt.assign1.logic.*;
import pt.assign1.model.*;
import pt.assign1.test.JUnitTest;

public class MainController {

	private MainView view;
	private Polynom result;
	private Polynom rest;

	public MainController(MainView v) {
		this.view = v;

		setupControl();

	}

	public void setupControl() {
		ActionListener act = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				Polynom p1 = new Polynom(view.t1.getText());
				Polynom p2 = new Polynom(view.t2.getText());

				if (arg0.getSource().equals(view.b1)) {

					result = Operation.addPoly(p1, p2);

				}
				if (arg0.getSource().equals(view.b2)) {

					result = Operation.subPoly(p1, p2);
				}
				if (arg0.getSource().equals(view.b3)) {
					result = Operation.derivePoly(p1);

				}
				if (arg0.getSource().equals(view.b4)) {
					result = Operation.integratePoly(p1);

				}
				if (arg0.getSource().equals(view.b5)) {
					result = Operation.multiplyPoly(p1, p2);

				}
				if (arg0.getSource().equals(view.b6)) {
					result = Operation.dividePoly(p1, p2);

				}
				if (arg0.getSource().equals(view.b7)) {
					view.t1.setText("");
					view.t2.setText("");

				}

				updateView();
			}

		};
		view.b1.addActionListener(act);
		view.b2.addActionListener(act);
		view.b3.addActionListener(act);
		view.b4.addActionListener(act);
		view.b5.addActionListener(act);
		view.b6.addActionListener(act);
		view.b7.addActionListener(act);
	}

	private void updateView() {
		// TODO Auto-generated method stub
		view.t3.setText(result.toString());

	}

	public static void main(String[] args) {

		MainView v = new MainView();
		MainController c = new MainController(v);

		/*Result result = JUnitCore.runClasses(JUnitTest.class);
		System.out.println(" Test rulat cu succes : " + result.wasSuccessful());
		if (!result.wasSuccessful()) {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}*/

	}
}
