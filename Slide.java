import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.FontMetrics;

public class Slide extends JPanel{
    private ArrayList<ModNumber> modNumbers;
    private String message;
    private ArrayList<String> notes;
    
    public Slide(ArrayList<ModNumber> modNumbersin){
	this(modNumbersin, "");
    }

    public Slide(ArrayList<ModNumber> modNumbersin, String messagein) {
	this(modNumbersin, messagein, new ArrayList<String>());
    }

    public Slide(ArrayList<ModNumber> modNumbersin, String messagein, ArrayList<String> notesin) {
	modNumbers = modNumbersin;
	message = messagein;
	notes = notesin;
    }
    
    protected void paintComponent(Graphics gin) {
	int pixel = getHeight()/50;
	Graphics2D g = (Graphics2D) gin;

	super.paintComponent(g);

	// first draw the message
	Font f = new Font("TimesRoman", Font.PLAIN, pixel*2);
	g.setFont(f);
	FontMetrics metrics = g.getFontMetrics(f);
	int stringy = pixel + metrics.getAscent();
	int stringx = (pixel*100 - metrics.stringWidth(message)) / 2;
	g.drawString(message, stringx, stringy);

	// draw the problem in the bottom right corner
	String s1 = "x \u2261 1 (mod 3)";
	String s2 = "x \u2261 6 (mod 7)";
	stringy = getHeight()-metrics.getHeight();
	stringx = getWidth() - metrics.stringWidth(s2);
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
	g.setFont(f);
	for(String s : notes) {
	    g.drawString("-" + s, pixel, pixel*5*i + pixel*10 + metrics.getAscent());
	    i += 1;
	}
    }
}
