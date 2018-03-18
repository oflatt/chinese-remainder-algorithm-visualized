import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RunVisualization{
    public static void main(String[] args) {
	ArrayList <Slide> slides = new ArrayList<Slide>();
	
	ArrayList <ModNumber> firstlist = new ArrayList<ModNumber>();
	firstlist.add(new ModNumberMathNotation(1, 3));
	firstlist.add(new ModNumberMathNotation(6, 7));
	ArrayList<String> setupnotes = new ArrayList<String>();
	setupnotes.add("The Chinese Remainder Thm will be used to solve this set of congruences for possible values of x.");
	setupnotes.add("This algorithm can only be used to solve problems in which the moduli are coprime, ensuring that it has a solution.");
	Slide firstslide = new Slide(firstlist, "Problem Setup", setupnotes);
	slides.add(firstslide);

	ArrayList <ModNumber> m1 = new ArrayList<ModNumber>();
	m1.add(new ModNumberMathNotation(0, 7, "A"));
	m1.add(new ModNumberMathNotation(1, 3, "A"));
	slides.add(new Slide(m1, "The first factor to the answer- a number A such that"));
	
	
	JFrame mainframe = new JFrame("Chinese Remainder Theorem Visualized");
	mainframe.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });

	int width = 1750;
	int height = 1000;
	JButton nextButton = new JButton("Next");
        nextButton.setBounds(100, height-200, 100, 100);
        mainframe.getContentPane().add(nextButton);
	
	mainframe.getContentPane().add(firstslide);
	mainframe.setSize(width, height);
	mainframe.setVisible(true);

	nextButton.addActionListener(new ActionListener(){
		int slideIndex = 0;
		public void actionPerformed(ActionEvent e) {
		    Container pane = mainframe.getContentPane();
		    pane.removeAll();

		    slideIndex += 1;
		    pane.add(slides.get(slideIndex));
		    pane.revalidate();
		    pane.repaint();
		}

	    });
    }
}
