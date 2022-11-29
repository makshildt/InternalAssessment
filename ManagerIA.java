import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ManagerIA {
    public static void main(String[] args) {
        new ManagerIA();
    }

    JFrame mainFrame;
    JTabbedPane tabbedPane;
    JPanel page1;

    ManagerIA() {
        mainFrame = new JFrame();
        mainFrame.setSize(500, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        tabbedPane = new JTabbedPane();
        mainFrame.add(tabbedPane);

        page1 = new JPanel();
        tabbedPane.addTab("Page 1", new AddEmployeesPage());
    }
}
