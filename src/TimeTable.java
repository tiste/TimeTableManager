import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class TimeTable extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private Classroom classroom;
	private String week;
	private JLabel[] label;
	private JComboBox[] combo;
	

	public TimeTable() {
		this.setPreferredSize(new Dimension(700, 500));
		this.setBackground(Color.lightGray);
		this.setLayout(null);

		label = new JLabel[9];

		// Les jours
		label[0] = new JLabel("Lundi");
		label[0].setBounds(135, 70, 90, 50);
		label[1] = new JLabel("Mardi");
		label[1].setBounds(235, 70, 90, 50);
		label[2] = new JLabel("Mercredi");
		label[2].setBounds(335, 70, 90, 50);
		label[3] = new JLabel("Jeudi");
		label[3].setBounds(435, 70, 90, 50);
		label[4] = new JLabel("Vendredi");
		label[4].setBounds(535, 70, 90, 50);
		
		// Horaires
		label[5] = new JLabel("08h - 10h");
		label[5].setBounds(53, 120, 80, 70);
		label[6] = new JLabel("10h - 12h");
		label[6].setBounds(53, 190, 80, 70);
		label[7] = new JLabel("13h - 15h");
		label[7].setBounds(53, 280, 80, 70);
		label[8] = new JLabel("15h - 17h");
		label[8].setBounds(53, 350, 80, 70);
		for (int i=0; i<9 ; i++) {
			label[i].setHorizontalAlignment(SwingConstants.CENTER);
			this.add(label[i]);
		}
		
		// Combobox
		combo = new JComboBox[2];
		combo[0] = new JComboBox(Classroom.findAll().toArray());
		classroom = (classroom == null) ? new Classroom(1) : classroom;
		combo[0].setBounds(50, 30, 200, 30);
		combo[1] = new JComboBox();
		week = (week == null) ? "Semaine 1" : week;
		for (int i=1; i<52; i++) {
			combo[1].addItem("Semaine "+i);
		}
		combo[1].setBounds(250, 30, 200, 30);
		for (int i=0; i<2 ; i++) {
			combo[i].setMaximumRowCount(4);
			combo[i].addActionListener(this);
			this.add(combo[i]);
		}
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
        
        // Affichage des blocs
        List<Plan> lp = Plan.findWith(classroom, week);
        for (int i=0; i<lp.size(); i++) {
        	Plan p = lp.get(i);
        	int day = Integer.parseInt(p.getStart().split("/")[0]) + 1;
        	int startHour = Integer.parseInt(p.getStart().split("/")[1]);
        	int endHour = Integer.parseInt(p.getEnd().split("/")[1]);
        	Rectangle coordDay = null;
        	Rectangle coordStartHour = null;
        	Rectangle coordEndHour = null;
        	
        	switch (day) {
				case 1:
					coordDay = label[0].getBounds();
					break;
					
				case 2:
					coordDay = label[1].getBounds();
					break;
					
				case 3:
					coordDay = label[2].getBounds();
					break;
					
				case 4:
					coordDay = label[3].getBounds();
					break;
					
				case 5:
					coordDay = label[4].getBounds();
					break;
	
				default:
					break;
			}
        	
        	switch (startHour) {
				case 8:
					coordStartHour = label[5].getBounds();
					break;
					
				case 10:
					coordStartHour = label[6].getBounds();
					break;
					
				case 13:
					coordStartHour = label[7].getBounds();
					break;
					
				case 15:
					coordStartHour = label[8].getBounds();
					break;
	
				default:
					break;
			}
        	
        	switch (endHour) {
				case 10:
					coordEndHour = label[5].getBounds();
					break;
					
				case 12:
					coordEndHour = label[6].getBounds();
					break;
					
				case 15:
					coordEndHour = label[7].getBounds();
					break;
					
				case 17:
					coordEndHour = label[8].getBounds();
					break;
	
				default:
					break;
			}
        	
        	if (coordDay != null && coordStartHour != null && coordEndHour != null) {
        		g.fillRect(coordDay.x, coordStartHour.y + 5, coordDay.width, coordEndHour.y + coordEndHour.height - coordStartHour.y - 10);
        	}
        }
    }
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == combo[0]) {
			classroom = (Classroom) combo[0].getSelectedItem();
			this.repaint();
		} else if (e.getSource() == combo[1]) {
			week = (String) combo[1].getSelectedItem();
			this.repaint();
		}
	}
}
