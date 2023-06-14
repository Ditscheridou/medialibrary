package de.jds.view;

import javax.swing.*;

public class HomeView extends AbstractView {

	@Override
	public void onCreate() {
		add(new JButton("Video!"));
		add(new JButton("Music!"));
	}

	@Override
	public void onStop() {

	}
}
