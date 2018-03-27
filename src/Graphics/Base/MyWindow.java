package Graphics.Base;

import javax.swing.*;

public class MyWindow extends JFrame {

    public MyWindow(String name){

        super(name);

        setVisible(true);
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(150,150);
        setLayout(null);
    }


}
