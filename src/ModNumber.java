import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;

/**ModNumber
 *Stores data for ModNumber
 *Provides accesors and drawRect, requires draw method
 *@author Oliver Flatt
 */
public abstract class ModNumber{

    private int number, modulus;

    /**Constructor
     */
    public ModNumber(int numberin, int modulusin){
	number = numberin;
	modulus = modulusin;
    }

    /**Accesors
     */
    public int getNumber(){
	return number;
    }

    public int getModulus(){
	return modulus;
    }

    /**Draws one rectangle for visualizations
     */
    public void drawRect(Graphics2D g, int xpos, int ypos, int width, int pixel, Color c){
	Color oldColor = g.getColor();
	Font f = new Font("TimesRoman", Font.PLAIN, pixel*2);
	Rectangle r = new Rectangle(xpos, ypos, pixel*2*width, pixel*2);
	g.setColor(c);
	g.fillRoundRect(r.x, r.y, r.width, r.height, pixel/2, pixel/2);
	g.setColor(new Color(100,0,0));
	g.setStroke(new BasicStroke(pixel/5));
	g.drawRoundRect(r.x, r.y, r.width, r.height, pixel/2, pixel/2);
	g.setColor(new Color(0,200,0));
	drawCenteredString(g, Integer.toString(width), r, f);
	g.setColor(oldColor);
    }

    /**Draws a string in the middle of the Rectangle given
     */
    public void drawCenteredString(Graphics2D g, String text, Rectangle rect, Font font) {
	FontMetrics metrics = g.getFontMetrics(font);
	int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	g.setFont(font);
	g.drawString(text, x, y);
    }
    
    public int getNum(){
	return number;
    }

    public int getMod() {
	return modulus;
    }

    /**Declares that all extensions must implement draw
     */
    public abstract void draw(Graphics2D g, int ypos, int pixel);
}
