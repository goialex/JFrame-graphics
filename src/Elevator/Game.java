package Elevator;

import java.awt.*;

public class Game {

    private final MyGraphics gfx;
    private final InputHandler input;
    private DeltaTime ticks = new DeltaTime(20); // 20 game ticks per second

    private final Floor[] floors;
    private final int floorHeight = 60;
    private final int nrFloors = 5;
    private final Elev elevator;


    public Game(MyGraphics gfx, InputHandler input){

        this.input = input;
        this.gfx = gfx;

        elevator = new Elev(new Rectangle(10, 50, 30, 60), nrFloors, floorHeight, new Point(0, 50));
        floors = new Floor[nrFloors];
        for(int i = 0; i < nrFloors; i++) {

            floors[i] = new Floor(elevator, i, new Point(0, 50 + i * floorHeight));
        }
    }

    public void go(){

        ticks.update();
        if (ticks.enoughtPassed()) {

            ticks.subtract();

            gfx.reset();
            update();
            draw();
            gfx.render();
        }
    }

    private void update(){

        if (input.one.down){
            elevator.addDestination(0);
        }
        if (input.two.down){
            elevator.addDestination(1);
        }
        if (input.three.down){
            elevator.addDestination(2);
        }
        if (input.four.down){
            elevator.addDestination(3);
        }
        if (input.five.down){
            elevator.addDestination(4);
        }
        elevator.update();
    }

    private void draw(){

        drawBackground();

        for (Floor f: floors) {
            f.draw(gfx);
        }
        elevator.draw(gfx);
    }

    private void drawBackground(){

        Color col1 = new Color(40, 105, 73);
        int incremental = 3;

        for (int i = 0; i < gfx.getHeight() - 3; i += incremental) {

            gfx.drawRect( 0, i, gfx.getWidth(), 5, col1);
                col1 = new Color(col1.getRed() + 1, col1.getGreen(), col1.getBlue());
        }
    }

    private void test(){

//        if ((input.right.down) && (x + 20 < gfx.getWidth()))
//            x += 10;
//        if ((input.down.down) && (y + 20 < gfx.getHeight()))
//            y += 10;
//        if ((input.up.down) && (y > 0))
//            y -= 10;
//        if ((input.left.down) && (x > 0))
//            x -= 10;
//
//        gfx.drawRect(x, y, 10, 10, Color.RED);
    }
}
