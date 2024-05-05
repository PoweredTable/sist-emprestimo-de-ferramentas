/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author waldy
 */
package visao;
import javax.swing.JLabel;
import com.formdev.flatlaf.extras.FlatSVGIcon;
public class SVGLabel extends JLabel {
    private FlatSVGIcon svgIcon;
    public void setSVGLabel (String image, int width, int height){
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }
}
