package de.jds.view;

import de.jds.model.domain.Video;
import info.movito.themoviedbapi.model.ArtworkType;

import javax.swing.*;
import java.awt.*;

public class CardView extends AbstractView {

	@Override
	public void onCreate() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void onStop() {
	}

	public void addVideo(Video video) {
		add(new JLabel(video.name()));
		add(new JLabel(video.metadata().getOriginalTitle()));
//		add(new JLabel(video.metadata().getImages(ArtworkType.POSTER).get(0).getFilePath()));
		setMaximumSize(new Dimension(getWidth(), getHeight()));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//		g.drawImage(null, 0, 0, getWidth(), getHeight(), null);
	}
}
