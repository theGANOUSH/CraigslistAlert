package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import views.MainWindow;

public class Action implements ActionListener {
	
	private final MainWindow mWindow;
	
	public Action(MainWindow pWindow) {
		mWindow = pWindow;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "tglbtnRun" && mWindow.getTglBtnStatus()) 
		{
			System.out.println(mWindow.getTglBtnStatus());
			
			String inputText = mWindow.getText();
			
			if(inputText == null || inputText.length() == 0)
			{
				JOptionPane.showMessageDialog(mWindow,"Please Input a valid search query", "Search Parameter Error", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				String baseURL = "https://orlando.craigslist.org/";
				
				try {
					CraigslistSearch.search(baseURL, inputText);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				System.out.println(mWindow.getText());
			}
			
		}
	}
		
}


