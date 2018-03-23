import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 * Displays notes, message (header), and modnumbers given.
 * 
 * @author Oliver Flatt
 */
public class Slide extends JPanel{
    private ArrayList<ModNumber> modNumbers;
    private String message;
    private ArrayList<String> notes;

    /** Smaller constructor for optional arguments
     */
    public Slide(ArrayList<ModNumber> modNumbersin){
	this(modNumbersin, "");
    }

    /** Smaller constructor for optional arguments
     */
    public Slide(ArrayList<ModNumber> modNumbersin, String messagein) {
	this(modNumbersin, messagein, new ArrayList<String>());
    }

    /** Main constructor for the Slide class
     *
     */
    public Slide(ArrayList<ModNumber> modNumbersin, String messagein, ArrayList<String> notesin) {
	modNumbers = modNumbersin;
	message = messagein;
	notes = notesin;
    }

    
    /** Copy constructor
     *Performs a shallow copy of the slide given
     */
    public Slide(Slide otherSlide){
	modNumbers = otherSlide.getModNumbers();
	message = otherSlide.getMessage();
	notes = otherSlide.getNotes();
    }


    /** some accesors
     */
    public ArrayList<ModNumber> getModNumbers(){
	return modNumbers;
    }

    public String getMessage(){
	return message;
    }

    public ArrayList<String> getNotes(){
	return notes;
    }

    public void setMessage(String m){
	message = m;
    }

    /**Creates a new arraylist with all modnumbers the box variety
     */
    public void convertModNumbersToBoxes(){
	ArrayList<ModNumber> newlist = new ArrayList<ModNumber>();
	for(int i = 0; i<modNumbers.size() ; i++){
	    if(modNumbers.get(i) instanceof ModNumberMathNotation) {
		ModNumber old = modNumbers.get(i);
		newlist.add(new ModNumberBoxes(old.getNumber(), old.getModulus()));
	    } else {
		newlist.add(modNumbers.get(i));
	    }
	}
	modNumbers = newlist;

	message = message + "- visualization";
    }

    /**makes all ModNumberBoxes be residuals
     */
    public void convertToResiduals() {
	for(ModNumber m : modNumbers) {
	    if(m instanceof ModNumberBoxes){
		ModNumberBoxes g = (ModNumberBoxes) m;
		g.setResidual(true);
	    }
	}
    }

    /**Override painComponent to draw
     */
    protected void paintComponent(Graphics gin) {
	int pixel = getHeight()/50;
	Graphics2D g = (Graphics2D) gin;

	super.paintComponent(g);

	// first draw the message
	Font f = new Font("TimesRoman", Font.BOLD, pixel*3);
	g.setFont(f);
	FontMetrics metrics = g.getFontMetrics(f);
	int stringy = pixel + metrics.getAscent();
	int stringx = pixel*5;
	g.drawString(message, stringx, stringy);

	f = new Font("TimesRoman", Font.PLAIN, pixel*2);
	g.setFont(f);
	// draw the problem in the bottom right corner
	String s1 = "x \u2261 1 (mod 3)";
	String s2 = "x \u2261 6 (mod 7)";
	stringy = getHeight()-metrics.getHeight();
	stringx = getWidth() - metrics.stringWidth(s2)-pixel;
	g.drawString(s2, stringx, stringy);
	stringy -= metrics.getHeight();
	g.drawString(s1, stringx, stringy);
	
	// draw all the modnumbers
	int i = 0;
	for(ModNumber n : modNumbers) {
	    n.draw(g, pixel* 5 *i + pixel*10, pixel);
	    i += 1;
	}

	// draw all the notes
	int smallerfontsize = (int) (pixel*1.5);
	f = new Font("TimesRoman", Font.PLAIN, smallerfontsize);
	g.setFont(f);
	int ypos = pixel*10 + metrics.getAscent() + i*pixel*5;
	for(String s : notes) {
	    g.drawString("-" + s, pixel, ypos);
	    ypos += pixel*5;
	}
    }
}
