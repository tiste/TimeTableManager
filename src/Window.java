import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Window extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private List<JMenuItem> choice;
	
	
	/**
	 * Create a JFrame
	 * @param pan JPanel
	 * @param title Page title
	 */
	public Window(JPanel pan, String title) {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
		}
		
		menuBar = new JMenuBar();
		menu = new JMenu("Fichier");
		choice = new ArrayList<JMenuItem>();
		choice.add(new JMenuItem("Nouvelle planification"));
		choice.get(0).addActionListener(this);
		menu.add(choice.get(0));
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		this.setTitle(title);
		this.getContentPane().add(pan);
		this.pack();
		this.setSize(pan.getWidth() + this.getInsets().left + this.getInsets().right, 
				pan.getHeight() + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == choice.get(0)) {
			new Window(new Plan(), "Nouvelle planification").setVisible(true);
		}
	}
}