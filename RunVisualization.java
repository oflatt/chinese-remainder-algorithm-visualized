import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RunVisualization{
    public static void main(String[] args) {
	// define the problem
	int res1 = 1;
	int mod1 = 3;
	int res2 = 6;
	int mod2 = 7;
	   

	// list of all the slides
	ArrayList <Slide> slides = new ArrayList<Slide>();
	
	ArrayList <ModNumber> firstlist = new ArrayList<ModNumber>();
	firstlist.add(new ModNumberMathNotation(res1, mod1));
	firstlist.add(new ModNumberMathNotation(res2, mod2));
	ArrayList<String> setupnotes = new ArrayList<String>();
	setupnotes.add("The Chinese Remainder Thm will be used to solve this set of congruences for possible values of x.");
	setupnotes.add("This algorithm can only be used to solve problems in which the moduli are coprime.");
	setupnotes.add("Each slide will have an accompanying visualization of the step.");
	Slide firstslide = new Slide(firstlist, "Problem Setup", setupnotes);
	slides.add(firstslide);

	Slide firstslideVisualization = new Slide(firstslide);
	firstslideVisualization.convertModNumbersToBoxes();
	firstslideVisualization.convertToResiduals();
	slides.add(firstslideVisualization);

	ArrayList <ModNumber> m1 = new ArrayList<ModNumber>();
	m1.add(new ModNumberMathNotation(0, mod2, "A"));
	m1.add(new ModNumberMathNotation(res1, mod1, "A"));
	ArrayList<String> anotes = new ArrayList<String>();
	anotes.add("A is a number that we can add to the answer without altering the residual of other moduli.");
	anotes.add("This takes care of the condition from the first congruence in the problem (bottom right).");
	slides.add(new Slide(m1, "First find a number A such that", anotes));

	Slide m1Visualization = new Slide(slides.get(slides.size()-1));
	m1Visualization.convertModNumbersToBoxes();
	m1Visualization.convertToResiduals();
	slides.add(m1Visualization);

	ArrayList <ModNumber> m1calculation = new ArrayList<ModNumber>();
	m1calculation.add(new ModNumberMathNotation(res1, mod1, "t", mod2));
	ArrayList<String> anotes2 = new ArrayList<String>();
	anotes2.add("Because A mod " + Integer.toString(mod2) + " is zero, A is a multiple of " + Integer.toString(mod2) + ".");
	anotes2.add("This is why t is multiplied by seven. t represents how many times seven has to be multiplied in order to leave the correct residual in " + Integer.toString(mod1) + ".");
	anotes2.add("In other words, the solution is a multiplicand of seven which leaves a remainder of " + Integer.toString(res1) + " when divided by " + Integer.toString(mod1) + ".");
	Slide m1calcslide = new Slide(m1calculation, "Calculate A by solving this congruence", anotes2);
	slides.add(m1calcslide);

	int t = 4;
	
	ArrayList<ModNumber> m1calcsolved = new ArrayList<ModNumber>();
	m1calcsolved.add(m1calculation.get(0));
	ModNumberMathNotation solutiont = new ModNumberMathNotation(t, 70000, "t"); // modulus does not matter- it is not a congruence
	solutiont.isCongruence = false; // make it an equals sign as one solution to the congruence
	m1calcsolved.add(solutiont);
	Slide tsolvedSlide = new Slide(m1calcsolved, "Finding t", anotes2);
	slides.add(tsolvedSlide);


	ArrayList<ModNumber> findA = new ArrayList<ModNumber>();
	findA.add(solutiont);
	ModNumberMathNotation solutionA = new ModNumberMathNotation(t*mod2, 70000, "A");
	solutionA.isCongruence = false;
	findA.add(solutionA);
	ArrayList<String> findAnotes = new ArrayList<String>();
	findAnotes.add("A is t times the modulus of the second congruence, " + Integer.toString(mod2));
	Slide findaslide = new Slide(findA, "Finding A", findAnotes);
	slides.add(findaslide);

	ArrayList<String> checkAnotes = new ArrayList<String>();
	checkAnotes.add("These were the properties of A that we wanted that make it useful in our calculations.");
        Slide checkAslide = new Slide(m1, "Checking A", checkAnotes);
	slides.add(checkAslide);

	ArrayList <ModNumber> m1Check = new ArrayList<ModNumber>();
	m1Check.add(new ModNumberMathNotation(0, mod2, "28"));
	m1Check.add(new ModNumberMathNotation(res1, mod1, "28"));
	slides.add(new Slide(m1Check, "Checking A", checkAnotes));

	ArrayList <ModNumber> m1CheckCheck = new ArrayList<ModNumber>();
	ModNumberMathNotation cond1 = new ModNumberMathNotation(0, mod2, "28");
	cond1.isCheck = true;
	ModNumberMathNotation cond2 = new ModNumberMathNotation(res1, mod1, "28");
	cond2.isCheck = true;
	m1CheckCheck.add(cond1);
	m1CheckCheck.add(cond2);
	slides.add(new Slide(m1CheckCheck, "Checking A", checkAnotes));

	ArrayList <ModNumber> m1CheckCheckv = new ArrayList<ModNumber>();
	m1CheckCheckv.add(new ModNumberBoxes(28, mod2));
	m1CheckCheckv.add(new ModNumberBoxes(28, mod1));
	ArrayList <String> checkvNotes = new ArrayList<String>();
	checkvNotes.add("Notice the residuals represented by boxes marked '1'.");
	slides.add(new Slide(m1CheckCheckv, "Checking A- visualized", checkvNotes));

	ArrayList <ModNumber> m2 = new ArrayList<ModNumber>();
	m2.add(new ModNumberMathNotation(0, mod1, "B"));
	m2.add(new ModNumberMathNotation(res2, mod2, "B"));
	ArrayList<String> bnotes = new ArrayList<String>();
	bnotes.add("A is a number affecting the first condition but not the second.");
	bnotes.add("Now we need to find B- a number affecting the second condition but not the first.");
	slides.add(new Slide(m2, "The second factor, B", bnotes));

	
	// Code for B -----------------------------
	Slide m2Visualization = new Slide(slides.get(slides.size()-1));
	m2Visualization.convertModNumbersToBoxes();
	m2Visualization.convertToResiduals();
	slides.add(m2Visualization);

	t = 2;
	ArrayList<ModNumber> m2calcsolved = new ArrayList<ModNumber>();
	m2calcsolved.add(new ModNumberMathNotation(res2, mod2, "t", mod1));
	solutiont = new ModNumberMathNotation(t, 70000, "t"); // modulus does not matter- it is not a congruence
	solutiont.isCongruence = false; // make it an equals sign as one solution to the congruence
	m2calcsolved.add(solutiont);
	ArrayList<String> m2notessolved = new ArrayList<String>();
	m2notessolved.add("Following the same procedure as before, we find a new t.");
	m2notessolved.add("This one is more obvious- 6 is divisable evenly by 3 and is also the residual we are looking for.");
	tsolvedSlide = new Slide(m2calcsolved, "Finding t again", m2notessolved);
	slides.add(tsolvedSlide);


	ArrayList<ModNumber> m2calcwithb = new ArrayList<ModNumber>();
	m2calcwithb.add(m2calcsolved.get(0));
	m2calcwithb.add(solutiont);
	ModNumberMathNotation bsol = new ModNumberMathNotation(t*mod1, 70000, "B");
	bsol.isCongruence = false;
	m2calcwithb.add(bsol);
	slides.add(new Slide(m2calcwithb, "Finding B", m2notessolved));
		      
	JFrame mainframe = new JFrame("Chinese Remainder Theorem Visualized");
	mainframe.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		}
	    });


	ArrayList<ModNumber> bboxes = new ArrayList<ModNumber>();
	ModNumberBoxes bbox = new ModNumberBoxes(t*mod1, mod1);
	ModNumberBoxes bboxothermod = new ModNumberBoxes(t*mod1, mod2);
	bboxes.add(bbox);
	bboxes.add(bboxothermod);
	slides.add(new Slide(bboxes, "B visualized"));

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
