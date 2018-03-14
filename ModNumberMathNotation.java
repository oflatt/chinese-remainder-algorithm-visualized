import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;

public class ModNumberMathNotation extends ModNumber{
    public ModNumberMathNotation(int numberin, int modulusin){
	super(numberin, modulusin);
    }
    
    public void draw(Graphics2D g, int ypos, int pixel){
	
	Font f = new Font("TimesRoman", Font.PLAIN, pixel*4);
	g.setFont(f);
	
	g.drawString("x" + " \u2261 " + Integer.toString(getNum()) + " (mod " + Integer.toString(getMod()) + ")", pixel, ypos);
    }
}
