package de.jds.controller;

import de.jds.listener.ActionEvent;
import de.jds.listener.ActionListener;
import de.jds.view.AbstractView;
import de.jds.view.Window;

public abstract class AbstractController<V extends AbstractView> implements ActionListener {

	private final V view;

	protected AbstractController() {
		this.view = createView();
		this.view.addListener(this);
		this.view.onStart();
		Window.getInstance().replaceView(view);
	}

	public void afterinit() {
		//hook
	}

	protected abstract V createView();

	public V getView() {
		return view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//hook
	}
}
