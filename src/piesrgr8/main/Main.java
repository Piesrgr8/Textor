package piesrgr8.main;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	
	public static JFrame f;
	public static JMenuItem menuItem;
	public static JTextArea txt;
	
	public static int wid;
	public static int hei;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		new Main().show();
	}
	
	public void show() {
		f = new JFrame("New - Textor");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("textor.png"));
		
		//Dimension dimSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		
		txt = new JTextArea(7, 30);
		txt.setLineWrap(true);
		txt.setWrapStyleWord(true);
		pan.add(new JScrollPane(txt), BorderLayout.CENTER);
		
		f.add(pan);
		f.setIconImage(img);
		f.setJMenuBar(newMenuBar());
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(true);
		
		wid = f.getSize().width;
		hei = f.getSize().height;
	}
	
	private JMenuBar newMenuBar() {
		JMenuBar menu = new JMenuBar();
		String[] titles = {"File", "Edit"};
		String[][] elements = {{"New", "Open", "Save"}, {"LOL"}};
		for(int i=0; i< titles.length; i++) {
			String title = titles[i];
			String[] elems = elements[i];
			menu.add(newMenu(title, elems));
		}
		return menu;
	}
	
	private JMenu newMenu(String title, String[] elements) {
        JMenu menu = new JMenu(title); //Creates a new JMenu with the title ik
        for(String element : elements) { //u understand?yes :d
            JMenuItem menuitem = new JMenuItem(element);//already told you about this :Pok
            menu.add(menuitem); // uses the add method in the JMenu class for our menu to add them menuitems yh ok :d
            menuitem.addActionListener(new MActionListener());//makes it so that the menuitems respond to the actionlistenerok
        }
        return menu;
    }
	
}

class Filter extends javax.swing.filechooser.FileFilter implements FileFilter {

    public boolean accept(File file) {
        return file.getName().endsWith(".txt") || file.getName().endsWith(".java");
    }

    @Override
    public String getDescription() {
        return "Text File (.txt)";  
    }                     
}
