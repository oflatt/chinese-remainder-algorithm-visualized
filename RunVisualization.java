import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RunVisualization{
    public static void main(String[] args) {
	ArrayList <ModNumber> firstlist = new ArrayList<ModNumber>();
	firstlist.add(new ModNumber(10,1));
	Slide firstslide = new Slide(firstlist);
	JFrame mainframe = new JFrame("Chinese Remainder Algorithm Visualized");
	mainframe.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });
	mainframe.getContentPane().add(firstslide);
	mainframe.setSize(2000,1000);
	mainframe.setVisible(true);
    }
}
