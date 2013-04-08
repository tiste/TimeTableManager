import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SetPlan extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JComboBox[] combo;
	private JTextField date;
	private JButton button;
	
	
	public SetPlan() {
		this.setPreferredSize(new Dimension(300, 260));
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		// Labels
		JLabel label1 = new JLabel("Professeur");
		label1.setBounds(60, 10, 100, 30);
		this.add(label1);
		JLabel label2 = new JLabel("Matière");
		label2.setBounds(60, 60, 100, 30);
		this.add(label2);
		JLabel label3 = new JLabel("Horaire");
		label3.setBounds(60, 110, 100, 30);
		this.add(label3);
		JLabel label4 = new JLabel("Classe");
		label4.setBounds(60, 160, 100, 30);
		this.add(label4);
		
		// Combobox
		combo = new JComboBox[5];
		combo[0] = new JComboBox(Teacher.findAll().toArray());
		combo[0].setBounds(50, 30, 200, 30);
		combo[1] = new JComboBox(Lesson.findAll().toArray());
		combo[1].setBounds(50, 80, 200, 30);
		combo[2] = new JComboBox();
		combo[2].addItem("08");
		combo[2].addItem("10");
		combo[2].addItem("13");
		combo[2].addItem("15");
		combo[2].setBounds(150, 120, 100, 30);
		combo[3] = new JComboBox();
		combo[3].addItem("10");
		combo[3].addItem("12");
		combo[3].addItem("15");
		combo[3].addItem("17");
		combo[3].setBounds(150, 140, 100, 30);
		combo[4] = new JComboBox(Classroom.findAll().toArray());
		combo[4].setBounds(50, 180, 200, 30);
		for (int i=0; i<5 ; i++) {
			combo[i].setSelectedIndex(0);
			combo[i].setMaximumRowCount(4);
			combo[i].addActionListener(this);
			this.add(combo[i]);
		}
		
		date = new JTextField("JJ/MM/AAAA");
		date.setBounds(50, 130, 100, 30);
		this.add(date);
		
		button = new JButton("Valider");
		button.setBounds(152, 210, 100, 30);
		button.addActionListener(this);
		this.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			String date = this.date.getText();
			
			if (Pattern.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$", date)) {
				Teacher teacher = (Teacher) combo[0].getSelectedItem();
				Lesson lesson = (Lesson) combo[1].getSelectedItem();
				String startHour = combo[2].getSelectedItem().toString();
				String endHour = combo[3].getSelectedItem().toString();
				Classroom classroom = (Classroom) combo[4].getSelectedItem();
				
				String day = date.split("/")[0];
				String month = date.split("/")[1];
				String year = date.split("/")[2];
				
				String start = year + "-" + month + "-" + day + " " + startHour + ":00:00";
				String end = year + "-" + month + "-" + day + " " + endHour + ":00:00";
				
				MySQL m = new MySQL();
				int rs = m.insert("INSERT INTO Plans (idTeacher, idLesson, idClassroom, start, end) VALUES ("+ teacher.getId() +", "+ lesson.getId() +", "+ classroom.getId() +", '"+ start +"', '"+ end +"');");
				
				String info;
				if (rs == 1) {
					info = "Ajout réussi !";
				} else {
					info = "Une erreur s'est produite !";
				}
				
				JOptionPane.showMessageDialog(null, info, "Information", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "La date n'est pas valide", "Information", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
