import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class Languadge extends JPanel{
    JComboBox box;
    ResourceBundle bundle;
    Languadge() {
        setSize(200, 300);
        setLayout(null);

        String[] items = {
                "Русский",
                "Украинский",
                "Турецкий",
                "English"

        };
        box = new JComboBox(items);
        box.setAlignmentX(LEFT_ALIGNMENT);
        box.setVisible(true);
        box.setBounds(500,20,100,30);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosed();
                MainWindow.update();
            }
        });
        add(box);

    }
    public void choosed(){
        switch((String)box.getSelectedItem()){
            case "Украинский":
                bundle=ResourceBundle.getBundle("main_window",new Locale("uk"));
            case "Турецкий":
                bundle=ResourceBundle.getBundle("main_window",new Locale("tu"));
            case "English":
                bundle=ResourceBundle.getBundle("main_window",new Locale("en", "SA"));
            case "Русский":
                bundle=ResourceBundle.getBundle("main_window",new Locale("ru"));
        }
    }

}
