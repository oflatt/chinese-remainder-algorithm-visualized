import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;

public class ModNumber{
    private int number, modulus;
    public ModNumber(int numberin, int modulusin){
	number = numberin;
	modulus = modulusin;
    }

    public void draw(Graphics g, int ypos, int pixel){
	
	int i = 0;
	Font f = new Font("TimesRoman", Font.PLAIN, pixel*2);
	while (i<number/modulus) {
	    Rectangle r = new Rectangle(i*3*pixel+pixel, ypos, pixel*2, pixel*2);
	    g.setColor(new Color(255,0,0));
	    g.fillRect(r.x, r.y, r.width, r.height);
	    g.setColor(new Color(0,255,0));
	    drawCenteredString(g, Integer.toString(modulus), r, f);
	    i++;
	}
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	FontMetrics metrics = g.getFontMetrics(font);
	int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	g.setFont(font);
	g.drawString(text, x, y);
    }

}
