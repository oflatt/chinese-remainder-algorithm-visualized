import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;


/**ModNumberBoxes displays ModNumber visually
 *@author Oliver Flatt
 */
public class ModNumberBoxes extends ModNumber{
    public Boolean isResidual;
    public int colorBlueThreshhold;
    public Boolean isThreshholdLessthan;

    /**Smaller constructor for optional argument
     */
    public ModNumberBoxes(int numberin, int modulusin) {
	this(numberin, modulusin, -1);
    }

    /**Main constructor
     */
    public ModNumberBoxes(int numberin, int modulusin, int colorBlueThreshholdin){
	super(numberin, modulusin);
	isResidual = false;
	colorBlueThreshhold = colorBlueThreshholdin;
	isThreshholdLessthan = true;
    }

    /**Draws the boxes for visualization
     *Depends on drawRect
     */
    public void draw(Graphics2D g, int ypos, int pixel){
	
	int i = 0;
	while (i<getNum()/getMod()) {
	    Color c = new Color(230, 0, 0);
	    if(getMod()*i<colorBlueThreshhold) {
		if(isThreshholdLessthan) {
		    c = new Color(0,0,200);
		}
	    } else if(!isThreshholdLessthan){
		c = new Color(0,0,200);
	    }
	    drawRect(g, i*2*pixel*getMod()+pixel, ypos, getMod(), pixel, c);
	    i++;
	}
	i = 0;
	while (i<getNum()%getMod()){
	    Color c = new Color(230, 0, 0);
	    if(getNum()-(getNum()%getMod())+i<colorBlueThreshhold) {
		if(isThreshholdLessthan){
		    c = new Color(0,0,200);
		}
	    } else if(!isThreshholdLessthan){
		c = new Color(0,0,200);
	    }
	    int offset = (int) getNum()/getMod();
	    offset *= 2 * pixel * getMod();
	    offset += pixel;
	    drawRect(g, offset + pixel* 2 * i, ypos, 1, pixel, c);
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
	    Color c = new Color(230, 0, 0);
	    if(getNum()+getMod()<colorBlueThreshhold) {
		c = new Color(0,0,200);
	    }
	    drawRect(g, currentx, ypos, getMod(), pixel, c);
	    currentx += 2*pixel*getMod();
	    g.setFont(f);
	    g.drawString(" * i, i \u2208 \u2124", currentx, texty);
	}
    }

    /**Setattr function
     */
    public void setResidual(Boolean in){
	isResidual = in;
    }
}
