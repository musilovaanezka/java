package musilova;

import java.util.Scanner;

/**
 *
 * @author Musilová
 */
public class ParametryTrojuhelniku {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Zadej délky stran trojuhelniku");
        float a = sc.nextFloat(); 
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        
        //obvod 
        float obvod = a + b + c;
        
        //druhé mocniny
        double aa = Math.pow(a, 2);
        double bb = Math.pow(b, 2);
        double cc = Math.pow(c, 2);
        
        //cos
        double cosalpha = (bb + cc - aa) / (2 * b * c);
        double cosbeta = (aa + cc - bb) / (2 * a * c);
        double cosgamma = (aa + bb - cc) / (2 * a * b);
        
        //velikost uhlu
        double alpha = Math.toDegrees(Math.acos(cosalpha));
        double beta = Math.toDegrees(Math.acos(cosbeta));
        double gamma = Math.toDegrees(Math.acos(cosgamma));
        
        //siny
        double sinalpha = Math.sin(Math.toRadians(alpha));
        double sinbeta = Math.sin(Math.toRadians(beta));
        double singamma = Math.sin(Math.toRadians(gamma));
        
        //výšky
        double va = b * singamma;
        double vb = a * singamma;
        double vc = a * sinbeta;
                
        //těžnice
        double ta = (1 / 2) * (bb + cc + (2 * c * b * cosalpha));
        double tb = (1 / 2) * (aa + cc + (2 * a * c * cosbeta));
        double tc = (1 / 2) * (aa + bb + (2 * a * b * cosgamma));
        
        //kružnice opsaná
        double rop = a / (2 * sinalpha)
        
        //kružnice vepsaná
        float s = (a + b + c) / 2;
        double rvep = (Math.sqrt()) / 2;
    }

}
