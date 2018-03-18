import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;

public class ModNumberBoxes extends ModNumber{
    public Boolean isResidual;
    
    public ModNumberBoxes(int numberin, int modulusin){
	super(numberin, modulusin);
	isResidual = false;
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
	
	int currentx = (int) getNum()/getMod();
	currentx *= 2 * pixel * getMod();
	currentx += pixel;
	currentx += pixel*2*i;

	// draw an extra box if it is a residual
	if(isResidual) {
	    Font f = new Font("TimesRoman", Font.PLAIN, pixel*3);
	    FontMetrics metrics = g.getFontMetrics(f);
	    int ascent = metrics.getAscent();
	    int texty = ypos + ((pixel*2 - metrics.getHeight()) / 2) + ascent;
	    g.setFont(f);
	    if(getNumber() > 0){
		g.drawString(" + ", currentx, texty);
		currentx += metrics.stringWidth(" + ");
	    }
	    drawRect(g, currentx, ypos, getMod(), pixel);
	    currentx += 2*pixel*getMod();
	    g.setFont(f);
	    g.drawString(" * i, i \u2208 \u2124", currentx, texty);
	}
    }

    public void setResidual(Boolean in){
	isResidual = in;
    }
}
