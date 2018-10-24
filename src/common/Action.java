package common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import views.MainWindow;

public class Action implements ActionListener {
	
	private final MainWindow mWindow;
	public static List<Item> listings;
	
	public Action(MainWindow pWindow) {
		mWindow = pWindow;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "tglbtnRun" && mWindow.getTglBtnStatus()) 
		{
			
			String inputText = MainWindow.getText();
			
			if(inputText == null || inputText.length() == 0)
			{
				JOptionPane.showMessageDialog(mWindow,"Please Input a valid search query", "Search Parameter Error", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				mWindow.setTglBtnStatus();
				
				//long tStartTime = System.currentTimeMillis();
				Thread t1 = new Thread(new CraigslistSearch());
				t1.start();
				
				System.out.println("Waiting for search to complete");
				try {
					t1.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//System.out.println(tStartTime);
				System.out.println(listings.size());
				
				//Email.sendEmail(listings);
			}
			
		}
		else
		{
			mWindow.resetTextField();
		}
	}
		
}


