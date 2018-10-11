package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainWindow;

public class Action implements ActionListener {
	
	@SuppressWarnings("unused")
	private final MainWindow mWindow;
	
	public Action(MainWindow pWindow) {
		mWindow = pWindow;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
	}
}
