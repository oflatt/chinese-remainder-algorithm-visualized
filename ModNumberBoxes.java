import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;

public class ModNumberBoxes extends ModNumber{
    public ModNumberBoxes(int numberin, int modulusin){
	super(numberin, modulusin);
    }
    
    public void draw(Graphics2D g, int ypos, int pixel){
	
	int i = 0;
	while (i<getNum()/getMod()) {
	    drawRect(g, i*2*pixel*getMod()+pixel, ypos, getMod(), pixel);
	    i++;
	}
	i = 0;
	while (i<getNum()%getMod()){
	    int offset = (int) getNum()/getMod();
	    offset *= 2 * pixel * getMod();
	    offset += pixel;
	    drawRect(g, offset + pixel* 2 * i, ypos, 1, pixel);
	    i++;
	}
    }
}
