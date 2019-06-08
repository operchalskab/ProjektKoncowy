package pl.edu.wszib.projekt.hellper;

import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoutHelper {

    public static List<String> convertRouts(Collection<String> strRouts){
        StyleSheet styleSheet = new StyleSheet();
        List<String> routs = new ArrayList<>();

        for(String strRout : strRouts){
            Color rout = styleSheet.stringToColor(strRout);
            routs.add("rgba(" + rout.getRed() + "," + rout.getGreen() + "," + rout.getBlue() + ", 1");

        }

        return routs;

    }
}
