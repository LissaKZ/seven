import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class Languadge extends JPanel{
    JComboBox box;
    ResourceBundle bundle;
    Languadge(){
        System.out.println("beg");
        setSize(100,30);
        setLayout(null);

        String[] items = {
                "Украинский",
                "Турецкий",
                "English",
                "Русский"
        };
        box=new JComboBox(items);
        box.addItem("kllk");

        box.setAlignmentX(LEFT_ALIGNMENT);


        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosed();

            }
        });

        add(box);
    } public void choosed(){
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
