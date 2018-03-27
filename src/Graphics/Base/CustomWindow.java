package Graphics.Base;

import javax.swing.*;
import java.awt.*;

public class CustomWindow extends JFrame {

    public CustomWindow(String name, int width, int height){

        super(name);

        setLayout(new BorderLayout());
        setVisible(true);
        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(150,150);
    }


}
