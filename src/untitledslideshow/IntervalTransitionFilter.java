package untitledslideshow;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * IntervalTransitionFilter is a filter that only allows for positive numeric
 * values to be placed in which ever text field it is applied to. For the case
 * of this project, it is applied to the Interval Length and Transition Length
 * JTextfields as those should only accept positive numbers as input.
 * @author Roberto Murcia
 */
public class IntervalTransitionFilter extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        
        for(int n = text.length(); n > 0; n--){
            char c = text.charAt(n - 1);
            System.out.println(c);
            if(Character.isDigit(c) && Character.valueOf(c).compareTo('-') != 0){
                super.replace(fb, offset, length, text, attrs);
            }
            else{
                System.out.println("Invalid Character");
            }
        }
    }
    
}
