/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package untitledslideshow;
/**
 * Importations
 */
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Checks user input in real-time for any invalid characters.
 * ***NEEDS A LIMIT TO NUMBER OF CHARACTERS****
 * 
 * @author Roberto Murcia
 */
public class InputFilter extends DocumentFilter {
    /**
     * Checks user input to verify if it is alphanumeric, and does not contain 
     * any of the illegal windows file name characters. If it contains any
     * of those values,this will prevent
     * the value from being inserted into the text box in real-time.
     * @param fb is the FilterBypass
     * @param offset is the offset of the value being checked
     * @param length is the length of the string
     * @param text is the text being input
     * @param attrs are the attributes
     * @throws BadLocationException 
     */
    private int limit;
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        for(int n = text.length(); n > 0; n--){
            char c = text.charAt(n - 1);
            System.out.println(c);
            if(Character.isAlphabetic(c) || 
                    Character.isDigit(c) || 
                    Character.valueOf(c).compareTo('"') != 0 ||
                    Character.valueOf(c).compareTo('*') != 0 ||
                    Character.valueOf(c).compareTo('<') != 0 ||
                    Character.valueOf(c).compareTo('>') != 0 ||
                    Character.valueOf(c).compareTo('?') != 0 ||
                    Character.valueOf(c).compareTo('\\') != 0 ||
                    Character.valueOf(c).compareTo('|') != 0 ||
                    Character.valueOf(c).compareTo('/') != 0 ||
                    Character.valueOf(c).compareTo(':') != 0){
                super.replace(fb, offset, length, String.valueOf(c), attrs);
            }
            else{
                System.out.println("Invalid Character.");
            }
            
        }
        
    }
    /**
     * Necessary Override
     * @param fb is the FilterBypass
     * @param offset is the offset of the value being checked
     * @param string is the string being checked
     * @param attr is the attribute
     * @throws BadLocationException 
     */
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        super.insertString(fb, offset, string, attr); 
    }
    /**
     * Necessary Override
     * @param fb is the FilterBypass
     * @param offset is the offset of the value being checked
     * @param length is the length of the text
     * @throws BadLocationException 
     */
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length); 
    }
    
}
