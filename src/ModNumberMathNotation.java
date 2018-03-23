import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.BasicStroke;

/**ModNumberMathNotation displays the congruence in mathematical notation
 *@author Oliver Flatt
 */

public class ModNumberMathNotation extends ModNumber{
    private String varName;
    private int multiplicand;
    public Boolean isCongruence;
    public Boolean isCheck;

    /**Smaller optional argument constructors
     */
    public ModNumberMathNotation(int numberin, int modulusin){
	this(numberin, modulusin, "x");
    }

    public ModNumberMathNotation(int numberin, int modulusin, String varNamein){
	this(numberin, modulusin, varNamein, 1);
    }

    /**Main constructor
     *Sets the default values
     */
    public ModNumberMathNotation(int numberin, int modulusin, String varNamein, int multiplicandin){
	super(numberin, modulusin);
	varName = varNamein;
	multiplicand = multiplicandin;
	isCongruence = true;
	isCheck = false;
    }

    /**Implements drawing the text
     */
    public void draw(Graphics2D g, int ypos, int pixel){
	
	Font f = new Font("TimesRoman", Font.PLAIN, pixel*4);
	FontMetrics metrics = g.getFontMetrics(f);
	g.setFont(f);

	String multiplicandtext = Integer.toString(multiplicand);
	if(multiplicand == 1){
	    multiplicandtext = "";
	}
	String displayText;
	if(isCongruence){
	    displayText = multiplicandtext + varName + " \u2261 " + Integer.toString(getNum()) + " (mod " + Integer.toString(getMod()) + ")";
	} else{
	    displayText = multiplicandtext + varName + " = " + Integer.toString(getNum());
	}
	g.drawString(displayText, pixel, ypos);
	
	if(isCheck){
	    Color oldcolor = g.getColor();
	    g.setColor(new Color(0, 200, 0));
	    g.drawString("\u2714", pixel+metrics.stringWidth(displayText), ypos);
	    g.setColor(oldcolor);
	}
    }
}
