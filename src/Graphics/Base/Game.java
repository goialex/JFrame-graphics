package Graphics.Base;

import java.awt.*;

public class Game {

    private final MyGraphics gfx;
    private final InputHandler input;
    private DeltaTime ticks = new DeltaTime(20); // 20 game ticks per second
    private int x = 0;
    private int y = 0;


    public Game(MyGraphics gfx, InputHandler input){

        this.input = input;
        this.gfx = gfx;
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


        if ((input.right.down) && (x + 20 < gfx.getWidth()))
            x += 10;
        if ((input.down.down) && (y + 20 < gfx.getHeight()))
            y += 10;
        if ((input.up.down) && (y > 0))
            y -= 10;
        if ((input.left.down) && (x > 0))
            x -= 10;
    }

    private void draw(){
        gfx.drawRect(x, y, 10, 10, Color.RED);
    }
}
