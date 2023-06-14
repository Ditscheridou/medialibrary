package de.jds.view;

import de.jds.listener.ActionEvent;
import de.jds.listener.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import static de.jds.listener.ActionId.BUTTON_CLICK;

public abstract class AbstractView extends JPanel implements ViewLifecycle {

	private final Set<ActionListener> actionListeners;

	protected AbstractView() {
		this.actionListeners = new HashSet<>();
		onCreate();
	}

	public void addListener(ActionListener listener) {
		actionListeners.add(listener);
	}

	protected void fireActionEvent(ActionEvent event) {
		for (ActionListener listener : actionListeners) {
			listener.actionPerformed(event);
		}
	}
	@Override
	public void onStart() {
		for (Component component : getComponents()) {
			if (component instanceof JButton button) {
				button.addActionListener(e -> fireActionEvent(new ActionEvent(BUTTON_CLICK)));
			}
		}
	}

	@Override
	public void onPause() {
		//hook
	}

	@Override
	public void onResume() {
		//hook
	}
}
