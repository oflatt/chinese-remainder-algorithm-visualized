import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

public class Slide extends JPanel{
    private ArrayList<ModNumber> modNumbers;
    
    public Slide(ArrayList<ModNumber> modNumbersin){
	modNumbers = modNumbersin;
    }
    
    protected void paintComponent(Graphics gin) {
	int pixel = getHeight()/50;
	Graphics2D g = (Graphics2D) gin;
	
	super.paintComponent(g);
	int i = 0;
	for(ModNumber n : modNumbers) {
	    n.draw(g, pixel* 3 *i +pixel, pixel);
	    i += 1;
	}
    }
}
