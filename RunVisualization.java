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
	setupnotes.add("This algorithm can only be used to solve problems in which the moduli are coprime.");
	Slide firstslide = new Slide(firstlist, "Problem Setup", setupnotes);
	slides.add(firstslide);

	Slide firstslideVisualization = new Slide(firstslide);
	firstslideVisualization.convertModNumbersToBoxes();
	firstslideVisualization.convertToResiduals();
	slides.add(firstslideVisualization);

	ArrayList <ModNumber> m1 = new ArrayList<ModNumber>();
	m1.add(new ModNumberMathNotation(0, 7, "A"));
	m1.add(new ModNumberMathNotation(1, 3, "A"));
	ArrayList<String> anotes = new ArrayList<String>();
	anotes.add("A is a number that we can add to the answer without altering the residual of other moduli.");
	anotes.add("This takes care of the condition from the first congruence in the problem (bottom right).");
	slides.add(new Slide(m1, "First find a number A such that", anotes));

	Slide m1Visualization = new Slide(slides.get(slides.size()-1));
	m1Visualization.convertModNumbersToBoxes();
	m1Visualization.convertToResiduals();
	slides.add(m1Visualization);
	
	
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
		    pane.remove(slides.get(slideIndex));

		    slideIndex = (slideIndex + 1) % slides.size();
		    pane.add(slides.get(slideIndex));
		    
		    pane.revalidate();
		    pane.repaint();
		}

	    });
    }
}
