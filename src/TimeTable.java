import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TimeTable extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	

	public TimeTable() {
		this.setPreferredSize(new Dimension(700, 500));
		this.setBackground(Color.lightGray);
		this.setLayout(null);

		JLabel[] label = new JLabel[9];

		// Les jours
		label[0] = new JLabel("Lundi");
		label[0].setBounds(130, 20, 60, 50);
		label[1] = new JLabel("Mardi");
		label[1].setBounds(230, 20, 60, 50);
		label[2] = new JLabel("Mercredi");
		label[2].setBounds(330, 20, 60, 50);
		label[3] = new JLabel("Jeudi");
		label[3].setBounds(430, 20, 60, 50);
		label[4] = new JLabel("Vendredi");
		label[4].setBounds(530, 20, 60, 50);
		
		// Horaires
		label[5] = new JLabel("8h - 10h");
		label[5].setBounds(20, 70, 60, 60);
		label[6] = new JLabel("10h - 12h");
		label[6].setBounds(20, 140, 80, 60);
		label[7] = new JLabel("13h - 15h");
		label[7].setBounds(20, 230, 80, 60);
		label[8] = new JLabel("15h - 17h");
		label[8].setBounds(20, 300, 80, 60);
		for(int i=0; i<9 ; i++){
			this.add(label[i]);
		}
	}
	
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
    	super.paintComponent(g);
    	
        g.drawLine(100, 30, 100, 370);
        g.drawLine(200, 30, 200, 370);
        g.drawLine(300, 30, 300, 370);
        g.drawLine(400, 30, 400, 370);
        g.drawLine(500, 30, 500, 370);
        g.drawLine(600, 30, 600, 370);
        g.drawLine(10, 30, 10, 370);

        g.drawLine(10, 30, 600, 30);
        g.drawLine(10, 70, 600, 70);
        g.drawLine(10, 140, 600, 140);
        g.drawLine(10, 210, 600, 210);
        g.drawLine(10, 230, 600, 230);
        g.drawLine(10, 300, 600, 300);
        g.drawLine(10, 370, 600, 370);
    }
	
    /**
     * @param h 
     * @param d 
     */

    public void drawRec(int h,int d, Graphics g){
    	// h = 1,2,3,4
    	// d = 1,2,3,4,5
    	if(h == 1 && d == 1){
    		g.drawRect(10, 10, 200, 100); 
            g.setColor(Color.white);
    	}
    }
    
	public void actionPerformed(ActionEvent e) {

	}
	
	public static void main(String[] args) {
		TimeTable t = new TimeTable();
		new Window(t, "TimeTable Manager").setVisible(true);

	}
}
