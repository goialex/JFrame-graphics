package Elevator;

import java.awt.*;

public class Button {

    private final ButtonAction action;
    private Rectangle screenReprez;

    public Button(ButtonAction action, Rectangle screenReprez) {

        this.action = action;
        this.screenReprez = screenReprez;
    }

    public Rectangle getScreenReprez() {
        return screenReprez;
    }

    public void push(){

        action.onActionTriggered();
    }

    public interface ButtonAction{
        void onActionTriggered();
    }

    public void draw(MyGraphics gfx){

        gfx.drawRect(screenReprez, Color.CYAN);
    }
}
