package Graphics.Base;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MyGraphics{

    private final MainPanel pane;
    private final BufferedImage ScreenImage;
    private final Graphics2D ImageGfx;
    private final int width;// = 384;
    private final int height;// = 361;

    public MyGraphics(MainPanel pane) {

        this.pane = pane;
        this.width = pane.getWidth();
        this.height = pane.getHeight();
        ScreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        ImageGfx = ScreenImage.createGraphics();
    }

    public void drawPix(int x, int y, Color c){
        drawRect(x, y, 1,1, c);
    }

    public void drawRect(int x, int y, int width, int height, Color c){

        assert(x + width <= this.width);
        assert(x >= 0);
        assert(y + height <= this.height);
        assert(y >= 0);

        ImageGfx.setColor(c);
        ImageGfx.fillRect(x, y, width, height);
    }

    public void reset(){

        ImageGfx.setColor(Color.BLACK);
        ImageGfx.fillRect(0,0, width, height);
    }

    public void render(){
        pane.render(ScreenImage);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
