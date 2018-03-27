package Elevator;

public class DeltaTime {

    private long elapsedTime;
    private long last;
    private long nsPerTick;

    public DeltaTime(int TicksPerSecond) {

        last = System.nanoTime();
        nsPerTick = 1000000000 / TicksPerSecond;
    }

    public void update(){

        long now = System.nanoTime();

        elapsedTime += now - last;
        last = now;
    }

    public boolean enoughtPassed(){

        if (elapsedTime > nsPerTick){
            return true;
        }
        return false;
    }

    public void subtract(){
        elapsedTime -= nsPerTick;
    }
}

