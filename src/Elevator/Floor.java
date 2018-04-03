package Elevator;

import java.awt.*;

public class Floor {

    public final Button callButton;
    InputHandler input;
    private Rectangle screenReprez;
    private final int THICKNESS = 5;

    private final int floor;

    public Floor(Elev elevator, int floorNr, Rectangle screenReprez, InputHandler input){

        floor = floorNr;
        callButton = new Button(new Button.ButtonAction() {

            @Override
            public void onActionTriggered() {

                elevator.addDestination(floorNr);
            }
        }, new Rectangle(screenReprez.x + screenReprez.width + 10, screenReprez.y + (screenReprez.height / 2), 10,10));

        this.screenReprez = screenReprez;
        this.input = input;
    }

    public void draw(MyGraphics gfx){

        callButton.draw(gfx);
        gfx.drawRect(screenReprez.x, screenReprez.y, THICKNESS, screenReprez.height, Color.BLUE);
        gfx.drawRect(screenReprez.x + screenReprez.width - THICKNESS, screenReprez.y, THICKNESS, screenReprez.height / 5, Color.BLUE);
        gfx.drawRect(screenReprez.x + screenReprez.width - THICKNESS, screenReprez.y + screenReprez.height - THICKNESS, 200, THICKNESS, Color.BLUE);
    }

    public void update(){

        if (input.MB1.down){
            if (callButton.getScreenReprez().contains(input.MB1.pos))
                callButton.push();
        }
    }


}
