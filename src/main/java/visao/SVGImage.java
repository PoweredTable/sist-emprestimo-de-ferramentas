/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;
import javax.swing.JButton;
import com.formdev.flatlaf.extras.FlatSVGIcon;
/**
 *
 * @author waldy
 */
public class SVGImage extends JButton{
    private FlatSVGIcon svgIcon;
    public void setSvgImage (String image, int width, int height){
        svgIcon = new FlatSVGIcon(image, width, height);
        
        setIcon(svgIcon);
    }
    
}
