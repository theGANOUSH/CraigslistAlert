package common;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainWindow;

public class Action implements ActionListener {
	private final MainWindow mWindow;
	
	
	public Action(MainWindow pWindow) {
		mWindow = pWindow;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(((Component) e.getSource()).getName());
	}
}
