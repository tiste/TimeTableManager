import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class TimeTable extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	
	public TimeTable() {
		this.setPreferredSize(new Dimension(700, 500));
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		
		JComboBox elt = new JComboBox(Teacher.findAll().toArray());
		elt.setBounds(10, 10, 200, 30);
		elt.setSelectedIndex(0);
		elt.setMaximumRowCount(4);
		elt.addActionListener(this);
		this.add(elt);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	public static void main(String[] args) {
		new Window(new TimeTable(), "TimeTable Manager").setVisible(true);
	}
}
