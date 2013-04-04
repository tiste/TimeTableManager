import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Plan extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JComboBox[] combo;
	private JButton button;
	
	
	public Plan() {
		this.setPreferredSize(new Dimension(300, 230));
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		JLabel label1 = new JLabel("Professeur");
		label1.setBounds(60, 10, 100, 30);
		this.add(label1);
		JLabel label2 = new JLabel("Matière");
		label2.setBounds(60, 60, 100, 30);
		this.add(label2);
		JLabel label3 = new JLabel("Horaire");
		label3.setBounds(60, 110, 100, 30);
		this.add(label3);
		
		combo = new JComboBox[3];
		combo[0] = new JComboBox(Teacher.findAll().toArray());
		combo[0].setBounds(50, 30, 200, 30);
		combo[0].setSelectedIndex(0);
		combo[0].setMaximumRowCount(4);
		combo[0].addActionListener(this);
		this.add(combo[0]);
		combo[1] = new JComboBox(Lesson.findAll().toArray());
		combo[1].setBounds(50, 80, 200, 30);
		combo[1].setSelectedIndex(0);
		combo[1].setMaximumRowCount(4);
		combo[1].addActionListener(this);
		this.add(combo[1]);
		combo[2] = new JComboBox();
		combo[2].addItem("8-10");
		combo[2].addItem("10-12");
		combo[2].addItem("13-15");
		combo[2].addItem("15-17");
		combo[2].setBounds(50, 130, 200, 30);
		combo[2].setSelectedIndex(0);
		combo[2].setMaximumRowCount(4);
		combo[2].addActionListener(this);
		this.add(combo[2]);
		
		button = new JButton("Valider");
		button.setBounds(152, 170, 100, 30);
		button.addActionListener(this);
		this.add(button);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			Teacher teacher = (Teacher) combo[0].getSelectedItem();
			Lesson lesson = (Lesson) combo[1].getSelectedItem();
			String plan = combo[2].getSelectedItem().toString();
			
			MySQL m = new MySQL();
			int rs = m.insert("INSERT INTO Plans (idTeacher, idLesson, idClassroom) VALUES ("+ teacher.getId() +", "+ lesson.getId() +", 1);");
			
			String info;
			if (rs == 1) {
				info = "Ajout réussi !";
			} else {
				info = "Une erreur s'est produite !";
			}
			
			JOptionPane.showMessageDialog(null, info, "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
