package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PreferencesWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4363295852202818753L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PreferencesWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
