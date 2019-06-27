import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Animation extends JPanel {
    Animation() throws MalformedURLException {
        Icon icon = new ImageIcon("src/res/escape.gif");
        JLabel label = new JLabel(icon);

        add(label);
    }
}
