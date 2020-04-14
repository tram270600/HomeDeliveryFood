import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	static DynamicPanel panel = new DynamicPanel();
	static MainFrame mainFrame;
//	JavaConnect2SQL connect = Connection.getConnection();
/*	JavaConnect2SQL java2sql = new JavaConnect2SQL();
	public JavaConnect2SQL getJava2sql() {
		return java2sql;
	}
	public void setJava2sql(JavaConnect2SQL java2sql) {
		this.java2sql = java2sql;
	}
*/	
	public static DynamicPanel getPanel() {
		return panel;
	}
	public static void setPanel(DynamicPanel panel) {
		MainFrame.panel = panel;
	}
	public static MainFrame getMainFrame() {
		return mainFrame;
	}
	public static void setMainFrame(MainFrame mainFrame) {
		MainFrame.mainFrame = mainFrame;
	}
	public MainFrame(){
	  	System.out.println("New Screen");
        setSize(1200,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(220,90);
        setResizable(false);
        add(panel);

	}
	public static void main(String[] args){
	    
        mainFrame = new MainFrame();
        
       
	}
	 public static void callSetPanel(JPanel newpan) {
	       panel.setPanel(newpan);
	    }
}
