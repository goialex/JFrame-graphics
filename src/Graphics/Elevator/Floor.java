package Elevator;

import java.awt.*;

public class Floor {

    public final Button callButton;
    private final Point pos;
    private final int width = 50;
    private final int height = 60;
    private final int thickness = 5;

    private final int floor;

    public Floor(Elev elevator, int floornr, Point pos){

        floor = floornr;
        callButton = new Button(new Button.ButtonAction() {

            @Override
            public void onActionTriggered() {

                elevator.addDestination(floornr);
            }
        });

        this.pos = pos;
    }

    public void draw(MyGraphics gfx){

        gfx.drawRect(pos.x, pos.y, thickness, height, Color.BLUE);
        gfx.drawRect(pos.x + width - thickness, pos.y, thickness, height / 5, Color.BLUE);
        gfx.drawRect(pos.x + width - thickness, pos.y + height - thickness, 200, thickness, Color.BLUE);
    }
}
