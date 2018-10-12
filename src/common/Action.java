package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.MainWindow;

public class Action implements ActionListener {
	
	@SuppressWarnings("unused")
	private final MainWindow mWindow;
	
	public Action(MainWindow pWindow) {
		mWindow = pWindow;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "tglbtnRun") 
		{
			String inputText = mWindow.getText();
			
			if(inputText == null || inputText.length() == 0)
			{
				JOptionPane.showMessageDialog(mWindow,"Please Input a Search Query", "Search Parameter Error", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				System.out.println(mWindow.getText());
			}
			
		}
	}
		
}


