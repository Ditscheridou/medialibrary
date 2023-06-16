package de.jds.view;

import de.jds.model.domain.Video;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

public class VideoView extends AbstractView {
	private final Logger logger = Logger.getLogger(VideoView.class.getName());
	private JLabel loading;
	JPanel contentLayout;

	@Override
	public void onCreate() {
		contentLayout = new JPanel();
		contentLayout.setLayout(new GridBagLayout());
		loading = new JLabel("Loading...");
		setLayout(new GridBagLayout());
		contentLayout.setBorder(BorderFactory.createLineBorder(Color.RED));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weighty = 1.0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		contentLayout.add(loading);
		add(contentLayout,gbc);
	}

	@Override
	public void onStop() {
		//hook
	}

	public void addVideo(Video video, MouseListener listener) {
		logger.info("Adding %s".formatted(video.name()));
		contentLayout.remove(loading);
		remove(contentLayout);
		GridBagConstraints cgbc = new GridBagConstraints();
		cgbc.weighty = 1.0;
		cgbc.weightx = 1.0;
		cgbc.anchor = GridBagConstraints.NORTHWEST;
		add(contentLayout,cgbc);
		CardView cardView = new CardView(listener);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15,15,15,15);
		cardView.addVideo(video);
		contentLayout.add(cardView,gbc);
		contentLayout.revalidate();
		contentLayout.repaint();
	}
}
