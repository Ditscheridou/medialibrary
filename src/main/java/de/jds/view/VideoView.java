package de.jds.view;

import de.jds.model.domain.Video;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class VideoView extends AbstractView {

	private final Logger logger = Logger.getLogger(VideoView.class.getName());

	private JLabel loading;

	@Override
	public void onCreate() {
		loading = new JLabel("Loading...");
		setLayout(new GridBagLayout());
		add(loading);
	}

	@Override
	public void onStop() {
		//hook
	}

	public void addVideo(Video video) {
		logger.info("Adding %s".formatted(video.name()));
		remove(loading);
		CardView cardView = new CardView();
		cardView.addVideo(video);
		add(cardView);
		revalidate();
		repaint();
	}
}
