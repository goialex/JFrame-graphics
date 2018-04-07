package Elevator;

import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args){

        CustomWindow window = new CustomWindow("Main", 500, 500);
        MainPanel pane = new MainPanel(window);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyGraphics gfx = new MyGraphics(pane);
        InputHandler input = new InputHandler(pane);
        Game game = new Game(gfx, input);

        while (!input.esc.down) {

                game.go();
        }

        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
}
