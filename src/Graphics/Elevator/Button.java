package Elevator;

public class Button {

    private final ButtonAction action;

    public Button(ButtonAction action) {

        this.action = action;
    }

    public void push(){

        action.onActionTriggered();
    }

    public interface ButtonAction{
        void onActionTriggered();
    }
}
