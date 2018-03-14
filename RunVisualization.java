import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RunVisualization{
    public static void main(String[] args) {
	ArrayList<Slide> slides = new ArrayList<Slide>();
	
	ArrayList <ModNumber> firstlist = new ArrayList<ModNumber>();
	firstlist.add(new ModNumberBoxes(10,3));
	Slide firstslide = new Slide(firstlist);
	slides.add(firstslide);

	ArrayList <ModNumber> problem = new ArrayList<ModNumber>();
	problem.add(new ModNumberMathNotation(4, 5));
	slides.add(new Slide(problem));
	
	
	JFrame mainframe = new JFrame("Chinese Remainder Algorithm Visualized");
	mainframe.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });

	int width = 2000;
	int height = 1000;
	JButton nextButton = new JButton("Next");
        nextButton.setBounds(width-200, height-200, 100, 100);
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
