/**
 * 
 */
package views;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import common.Action;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author alowe01
 *
 */
public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JToggleButton tglbtnRun;
	private JTextField textField;

	public MainWindow()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(211, 220);
		this.setLocation(dim.width/2 - this.getWidth()/2, dim.height /2 - this.getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Action aListener = new Action(this);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtn_3day = new JRadioButton("3 times a day");
		rdbtn_3day.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtn_3day.setActionCommand("rdbtn_3day");
		rdbtn_3day.addActionListener(aListener);
		
		JLabel lblInputSearchQuery = new JLabel("Input Search Query");
		lblInputSearchQuery.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtn_2day = new JRadioButton("2 times a day");
		rdbtn_2day.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtn_2day.setActionCommand("rdbtn_2day");
		rdbtn_2day.addActionListener(aListener);
		
		JRadioButton rdbtn_1day = new JRadioButton("1 times a day");
		rdbtn_1day.setSelected(true);
		rdbtn_1day.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtn_1day.setActionCommand("rdbtn_1day");
		rdbtn_1day.addActionListener(aListener);
		
		textField = new JTextField(20);
		textField.setHorizontalAlignment(JTextField.LEFT);
		textField.setMaximumSize(textField.getPreferredSize());
		group.add(rdbtn_1day);
		group.add(rdbtn_2day);
		group.add(rdbtn_3day);
		
		tglbtnRun = new JToggleButton("Run");
		tglbtnRun.setActionCommand("tglbtnRun");
		tglbtnRun.addActionListener(aListener);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(tglbtnRun))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(lblInputSearchQuery, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtn_1day, Alignment.LEADING)
							.addComponent(rdbtn_2day, Alignment.LEADING)
							.addComponent(rdbtn_3day, Alignment.LEADING)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblInputSearchQuery)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtn_1day)
					.addComponent(rdbtn_2day)
					.addComponent(rdbtn_3day)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnRun)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return textField.getText();
	}
	
	public boolean getTglBtnStatus() {
		return tglbtnRun.isSelected();
	}
	public void setTglBtnStatus()
	{
		if(tglbtnRun.isSelected())
		{
			tglbtnRun.setText("Running");
		}
		else
		{
			tglbtnRun.setText("Run");
		}
	}

}
