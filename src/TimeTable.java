import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TimeTable extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private int idClassroom = 1;
	private JLabel[] label;
	private JComboBox[] combo;
	

	public TimeTable() {
		this.setPreferredSize(new Dimension(700, 500));
		this.setBackground(Color.lightGray);
		this.setLayout(null);

		label = new JLabel[9];

		// Les jours
		label[0] = new JLabel("Lundi");
		label[0].setBounds(160, 70, 60, 50);
		label[1] = new JLabel("Mardi");
		label[1].setBounds(260, 70, 60, 50);
		label[2] = new JLabel("Mercredi");
		label[2].setBounds(350, 70, 60, 50);
		label[3] = new JLabel("Jeudi");
		label[3].setBounds(465, 70, 60, 50);
		label[4] = new JLabel("Vendredi");
		label[4].setBounds(550, 70, 60, 50);
		
		// Horaires
		label[5] = new JLabel("8h - 10h");
		label[5].setBounds(60, 120, 60, 60);
		label[6] = new JLabel("10h - 12h");
		label[6].setBounds(60, 190, 80, 60);
		label[7] = new JLabel("13h - 15h");
		label[7].setBounds(60, 280, 80, 60);
		label[8] = new JLabel("15h - 17h");
		label[8].setBounds(60, 350, 80, 60);
		for (int i=0; i<9 ; i++) {
			this.add(label[i]);
		}
		
		// Combobox
		combo = new JComboBox[1];
		combo[0] = new JComboBox(Classroom.findAll().toArray());
		combo[0].setBounds(50, 30, 200, 30);
		combo[0].setSelectedIndex(idClassroom-1);
		combo[0].setMaximumRowCount(4);
		combo[0].addActionListener(this);
		this.add(combo[0]);
	}
	
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
    	super.paintComponent(g);
    	
    	// Lignes verticales
        g.drawLine(130, 70, 130, 420);
        g.drawLine(230, 70, 230, 420);
        g.drawLine(330, 70, 330, 420);
        g.drawLine(430, 70, 430, 420);
        g.drawLine(530, 70, 530, 420);
        g.drawLine(630, 70, 630, 420);
        g.drawLine(50, 70, 50, 420);
        
        // Lignes horizontales
        g.drawLine(50, 70, 630, 70);
        g.drawLine(50, 120, 630, 120);
        g.drawLine(50, 190, 630, 190);
        g.drawLine(50, 260, 630, 260);
        g.drawLine(50, 280, 630, 280);
        g.drawLine(50, 350, 630, 350);
        g.drawLine(50, 420, 630, 420);
        
        System.out.println(label[0].getBounds());
        System.out.println(Lesson.findWith(idClassroom, "2013-12-09", "2013-12-13"));
    }
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == combo[0]) {
			Classroom classroom = (Classroom) combo[0].getSelectedItem();
			idClassroom = classroom.getId();
			this.repaint();
		}
	}
}
