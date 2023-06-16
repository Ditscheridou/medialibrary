package de.jds.controller;

import de.jds.listener.ActionEvent;
import de.jds.listener.ActionListener;
import de.jds.view.AbstractView;
import de.jds.view.Window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class AbstractController<V extends AbstractView> implements ActionListener, MouseListener {

	private final V view;

	protected AbstractController() {
		this.view = createView();
		this.view.addListener(this);
		this.view.addMouseListener(this);
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

	@Override
	public void mousePressed(MouseEvent e) {
		//hook
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//hook
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//hook
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//hook
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//hook
	}
}
