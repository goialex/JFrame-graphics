package Elevator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Elev {

    private final int nrFloors;
    private final List<Integer> que = new ArrayList<>();
    private final int floorHeight;
    private final Point floorOffset;
    private int lastFloor = 1;
    private Button floorButton[];
    private Rectangle ScreenRepres;
    private Doors doors;

    public Elev(Rectangle ScreenRepres, int nrFloors, int floorHeight, Point floorStart ) {

        this.floorHeight = floorHeight;
        this.nrFloors = nrFloors;
        this.floorOffset = floorStart;

        floorButton = new Button[nrFloors];
        for(int i = 0; i < nrFloors; i++){

            floorButton[i] = new Button(new setDestinationAction(i));
        }

        this.ScreenRepres = ScreenRepres;
        doors = new Doors(ScreenRepres.height);
    }

    private class setDestinationAction implements Button.ButtonAction{

        private final int destination;

        public  setDestinationAction(int destination){

            this.destination = destination;
        }

        public void onActionTriggered(){

            addDestination(destination);
        }
    }

    public void addDestination(int toFloor) {

        assert (toFloor < nrFloors);

        if (que.size() == nrFloors)
            return;

        if (que.contains(toFloor))
            return;

        if (que.isEmpty()){
            que.add(toFloor);
        }
        else {
            addtoQue(toFloor);
        }

    }

    private void addtoQue(int toAdd){

        assert (toAdd <= nrFloors);
        assert (toAdd >= 0);

        if (isBetween(currentFloor(), toAdd, que.get(0))){
            que.add(0, toAdd);
            return;
        }

        for (int i = 0; i + 1 < que.size(); i++) {

            if (isBetween(que.get(i), toAdd, que.get(i + 1))){
                que.add(i + 1, toAdd);
                return;
            }
        }

        que.add(toAdd);

    }

    private boolean isBetween(int a, int b, int c){

        if (a > c){
            int temp = a;
            a = c;
            c = temp;
        }

        if ((b > a) && (b < c)){
            return true;
        }
        return  false;
    }

    public void draw(MyGraphics gfx){

        gfx.drawRect(ScreenRepres.x, ScreenRepres.y, 3, ScreenRepres.height, Color.ORANGE);
        gfx.drawRect(ScreenRepres.x, ScreenRepres.y, ScreenRepres.width, 3, Color.ORANGE);
        doors.draw(gfx, new Point(ScreenRepres.x + ScreenRepres.width - 3, ScreenRepres.y), Color.ORANGE);
        gfx.drawRect(ScreenRepres.x, ScreenRepres.y + ScreenRepres.height - 3, ScreenRepres.width, 3, Color.ORANGE);
    }

    public void update(){

        if (doors.status != Status.idle){
            doors.update();
            return;
        }

        if (!que.isEmpty()){

            if (getFloorCoord(que.get(0)).y == ScreenRepres.y) {
                que.remove(0);
                doors.open();
                return;
            }

            if(getFloorCoord(que.get(0)).y > ScreenRepres.y){
                moveDown();
            }
            else
                moveUp();
        }
    }

    private void moveUp(){
        ScreenRepres.y -= 2;
    }

    private void moveDown(){
        ScreenRepres.y += 2;
    }

    private Point getFloorCoord(int level){

        return (new Point(ScreenRepres.x, (level * floorHeight) + floorOffset.y));
    }

    private int currentFloor(){

        return ((ScreenRepres.y - floorOffset.y) / floorHeight);
    }

    private enum Status{
        opening,
        closing,
        idle
    }

    private class Doors{

        private Status status = Status.idle;
        private int height;
        private int currentHeight;

        public Doors(int height) {
            this.height = height;
            currentHeight = height;
        }

        public void update(){

            if (status != Status.idle){
                if (status == Status.opening){
                    retract();
                }
                else {
                    extend();
                }
            }
        }

        private void retract() {

            assert (status == Status.opening);

            currentHeight = currentHeight - (height / 10);

            if (currentHeight == 0)
                status = Status.closing;
        }

        private void extend() {

            assert (status == Status.closing);

            currentHeight = currentHeight + (height / 10);

            if (currentHeight == height)
                status = Status.idle;
        }

        public void draw(MyGraphics gfx, Point pos, Color c){

            gfx.drawRect(pos.x, pos.y, 3, currentHeight, c);
        }

        public void open() {

            assert( status == Status.idle);

            status = Status.opening;
        }
    }
}
