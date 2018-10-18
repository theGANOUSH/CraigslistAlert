package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import views.MainWindow;

public class Action implements ActionListener {
	
	private final MainWindow mWindow;
	private List<Item> listings;
	
	public Action(MainWindow pWindow) {
		mWindow = pWindow;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "tglbtnRun" && mWindow.getTglBtnStatus()) 
		{
			
			String inputText = mWindow.getText();
			
			if(inputText == null || inputText.length() == 0)
			{
				JOptionPane.showMessageDialog(mWindow,"Please Input a valid search query", "Search Parameter Error", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				String baseURL = "https://orlando.craigslist.org/";
				
				mWindow.setTglBtnStatus();
				mWindow.repaint();
				try {
					listings = CraigslistSearch.search(baseURL, inputText);
					//System.out.println(listings.get(0).getUrl());
					
					Email.sendEmail(listings);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
		}
		else
		{
			mWindow.resetTextField();
		}
	}
		
}


