/**
 * 
 */
package views;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import common.Action;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author alowe01
 *
 */
public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public MainWindow()
	{
		setTitle("CraigslistAlert!");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Action aListener = new Action(this);
		
		
		JToggleButton tglbtnRun = new JToggleButton("Run");
		tglbtnRun.setActionCommand("tglbtnRun");
		tglbtnRun.addActionListener(aListener);
		
		JRadioButton rdbtn_3day = new JRadioButton("3 times a day");
		rdbtn_3day.setActionCommand("rdbtn_3day");
		rdbtn_3day.addActionListener(aListener);
		
		JRadioButton rdbtn_2day = new JRadioButton("2 times a day");
		rdbtn_2day.setActionCommand("rdbtn_2day");
		rdbtn_2day.addActionListener(aListener);
		
		JRadioButton rdbtn_1day = new JRadioButton("1 times a day");
		rdbtn_1day.setActionCommand("rdbtn_1day");
		rdbtn_1day.addActionListener(aListener);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(rdbtn_1day);
		group.add(rdbtn_2day);
		group.add(rdbtn_3day);
		
		JLabel lblInputSearchQuery = new JLabel("Input Search Query");
		
		textField = new JTextField();
		textField.setText(null);
		textField.setColumns(10);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField)
						.addComponent(lblInputSearchQuery, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(173)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tglbtnRun, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(rdbtn_1day)
							.addComponent(rdbtn_3day)
							.addComponent(rdbtn_2day)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInputSearchQuery)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtn_1day)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtn_2day)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtn_3day)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tglbtnRun)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return textField.getText();
	}

}
