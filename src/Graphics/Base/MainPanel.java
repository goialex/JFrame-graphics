package Graphics.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class MainPanel extends Canvas {

    public MainPanel(JFrame window){

        super();
        window.add(this, BorderLayout.CENTER);
        setBackground(Color.ORANGE);
    }

    public void render(BufferedImage screen){

        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.fillRect(0, 0, getWidth(), getHeight());

        int width = screen.getWidth();
        int height = screen.getHeight();
        int x = (getWidth() - width) / 2;
        int y = (getHeight() - height) / 2;
        g.drawImage(screen, x, y, width, height, null);
        g.dispose();
        bs.show();

    }

}
