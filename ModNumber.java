import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;

public class ModNumber{
    private int number, modulus;
    public ModNumber(int numberin, int modulusin){
	number = numberin;
	modulus = modulusin;
    }

    public void draw(Graphics2D g, int ypos, int pixel){
	
	int i = 0;
	while (i<number/modulus) {
	    drawRect(g, i*2*pixel*modulus+pixel, ypos, modulus, pixel);
	    i++;
	}
	i = 0;
	while (i<number%modulus){
	    int offset = (int) number/modulus;
	    offset *= 2 * pixel * modulus;
	    offset += pixel;
	    drawRect(g, offset + pixel* 2 * i, ypos, 1, pixel);
	    i++;
	}
    }

    public void drawRect(Graphics2D g, int xpos, int ypos, int width, int pixel){
	Font f = new Font("TimesRoman", Font.PLAIN, pixel*2);
	Rectangle r = new Rectangle(xpos, ypos, pixel*2*width, pixel*2);
	g.setColor(new Color(230, 0, 0));
	g.fillRoundRect(r.x, r.y, r.width, r.height, pixel/2, pixel/2);
	g.setColor(new Color(100,0,0));
	g.setStroke(new BasicStroke(pixel/5));
	g.drawRoundRect(r.x, r.y, r.width, r.height, pixel/2, pixel/2);
	g.setColor(new Color(0,200,0));
	drawCenteredString(g, Integer.toString(width), r, f);
    }

    public void drawCenteredString(Graphics2D g, String text, Rectangle rect, Font font) {
	FontMetrics metrics = g.getFontMetrics(font);
	int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	g.setFont(font);
	g.drawString(text, x, y);
    }

}
