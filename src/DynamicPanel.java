import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DynamicPanel  extends JPanel  {
	 static LogInPanel loginPanel = new LogInPanel();
//	 static RestaurantPanel resP = new RestaurantPanel("Papaschicken","18/2","PC");
//	 static CustomerPanel cusP = new CustomerPanel("Cus","test");

	 public static LogInPanel getLoginPanel() {
		return loginPanel;
	}
	//	 static RestaurantPanel resP = new RestaurantPanel();
	 public DynamicPanel() {
	        init();
	    }
	 private void init() {
		 setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		 add(loginPanel);
//		 add(resPanel);
//		 add(resP);
//		 add(cusP);
	    }

	 public void setPanel(JPanel pn) {
		removeAll();
		add(pn);
		repaint();
		revalidate();
	    }
	 
}
