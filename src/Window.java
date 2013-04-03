import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Window(JPanel pan, String title) {
		this.setTitle(title);
		this.getContentPane().add(pan);
		this.pack();
		this.setSize(pan.getWidth() + this.getInsets().left + this.getInsets().right, 
				pan.getHeight() + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}