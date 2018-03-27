package Elevator;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener {
	public class Key {
		public int presses;
		public boolean down;

		public Key() {
			keys.add(this);
		}

		public void toggle(boolean pressed) {
			if (pressed != down) {
				down = pressed;
			}
			if (pressed) {
				presses++;
			}
		}
	}

	public List<Key> keys = new ArrayList<Key>();

	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key esc = new Key();
	public Key one = new Key();
	public Key two = new Key();
	public Key three = new Key();
	public Key four = new Key();

	public void releaseAll() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}

	public InputHandler(Component pane) {
		pane.addKeyListener(this);
	}

	public void keyPressed(KeyEvent ke) {
		toggle(ke, true);
	}

	public void keyReleased(KeyEvent ke) {
		toggle(ke, false);
	}

	private void toggle(KeyEvent ke, boolean pressed) {

		if (ke.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_UP) up.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) down.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) left.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) right.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) esc.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD1) one.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD2) two.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD3) three.toggle(pressed);
		if (ke.getKeyCode() == KeyEvent.VK_NUMPAD4) four.toggle(pressed);
		if (ke.getKeyCode() == 0x31) one.toggle(pressed);
		if (ke.getKeyCode() == 0x32) two.toggle(pressed);
		if (ke.getKeyCode() == 0x33) three.toggle(pressed);
		if (ke.getKeyCode() == 0x34) four.toggle(pressed);


	}

	public void keyTyped(KeyEvent ke) {
	}
}
