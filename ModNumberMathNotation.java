import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;

public class ModNumberMathNotation extends ModNumber{
    private String varName;
    private int multiplicand;
    
    public ModNumberMathNotation(int numberin, int modulusin){
	this(numberin, modulusin, "x");
    }

    public ModNumberMathNotation(int numberin, int modulusin, String varNamein){
	this(numberin, modulusin, varNamein, 1);
    }

    public ModNumberMathNotation(int numberin, int modulusin, String varNamein, int multiplicandin){
	super(numberin, modulusin);
	varName = varNamein;
	multiplicand = multiplicandin;
    }
    
    public void draw(Graphics2D g, int ypos, int pixel){
	
	Font f = new Font("TimesRoman", Font.PLAIN, pixel*4);
	g.setFont(f);

	String multiplicandtext = Integer.toString(multiplicand);
	if(multiplicand == 1){
	    multiplicandtext = "";
	}
	g.drawString(multiplicandtext + varName + " \u2261 " + Integer.toString(getNum()) + " (mod " + Integer.toString(getMod()) + ")", pixel, ypos);
    }
}
