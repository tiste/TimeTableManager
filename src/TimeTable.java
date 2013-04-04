import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class TimeTable extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JComboBox[] combo;
	
	
	public TimeTable() {
		this.setPreferredSize(new Dimension(700, 500));
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		
		combo = new JComboBox[1];
		combo[0] = new JComboBox(Teacher.findAll().toArray());
		combo[0].setBounds(10, 10, 200, 30);
		combo[0].setSelectedIndex(0);
		combo[0].setMaximumRowCount(4);
		combo[0].addActionListener(this);
		this.add(combo[0]);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == combo[0]) {
			System.out.println(combo[0].getSelectedItem().toString());
		}
	}
	
	public static void main(String[] args) {
		new Window(new TimeTable(), "TimeTable Manager").setVisible(true);
	}
}
