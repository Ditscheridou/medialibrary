package de.jds.view;

import javax.swing.*;

public class AudioView extends AbstractView {

	@Override
	public void onCreate() {
		add(new JLabel("Audio!"));
	}

	@Override
	public void onStop() {

	}
}
