import java.awt.Graphics;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

public class Slide extends JPanel{
    private ArrayList<ModNumber> modNumbers;
    
    public Slide(ArrayList<ModNumber> modNumbersin){
	modNumbers = modNumbersin;
    }
    
    protected void paintComponent(Graphics g) {
	int pixel = getHeight()/50;
	
	super.paintComponent(g);
	for(ModNumber n : modNumbers) {
	    n.draw(g, pixel, pixel);
	}
    }
}