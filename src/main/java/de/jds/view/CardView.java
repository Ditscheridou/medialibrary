package de.jds.view;

import de.jds.model.domain.Video;
import info.movito.themoviedbapi.model.ArtworkType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.net.URL;

public class CardView extends AbstractView {

	private static final String imageURL = "https://image.tmdb.org/t/p/original/%s";

	public CardView(MouseListener listener) {
		addMouseListener(listener);
	}

	@Override
	public void onCreate() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.GREEN));
		setPreferredSize(new Dimension(400,400));
	}

	@Override
	public void onStop() {
	}

	public void addVideo(Video video) {
		String imageId = video.metadata().getImages(ArtworkType.POSTER).get(0).getFilePath();
		try {
			add(new JLabel(new ImageIcon(new ImageIcon(ImageIO.read(new URL(imageURL.formatted(imageId)))).getImage().getScaledInstance(Window.getInstance().getWidth() / 8, Window.getInstance().getWidth() / 8, Image.SCALE_DEFAULT))));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		setMaximumSize(new Dimension(getWidth(), getHeight()));
	}
}
