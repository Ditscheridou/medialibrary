package de.jds.view;

import de.jds.model.domain.Video;

import javax.swing.*;
import java.awt.*;

public class VideoView extends AbstractView {

	private JLabel loading;

	@Override
	public void onCreate() {
		loading = new JLabel("Loading...");
		setLayout(new GridLayout(2, 3, 1, 1));
		add(loading);
	}

	@Override
	public void onStop() {
		//hook
	}

	public void addVideo(Video video) {
		remove(loading);
		CardView cardView = new CardView();
		cardView.addVideo(video);
		add(cardView);
		revalidate();
		repaint();
	}
}
