package de.jds.controller;

import de.jds.model.domain.Video;
import de.jds.model.services.MediaService;
import de.jds.model.services.VideoService;
import de.jds.view.VideoView;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class VideoController extends AbstractController<VideoView> {

	private final MediaService<Video> videoService;

	public VideoController() {
		this.videoService = new VideoService();
	}

	@Override
	public void afterinit() {
		videoService.getAll().forEach(future -> future.thenAcceptAsync(video ->getView().addVideo(video,this),SwingUtilities::invokeLater));
	}

	@Override
	protected VideoView createView() {
		return new VideoView();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked");
		MediaController mediaController = new MediaController();
		mediaController.playVideo(new Video("","C:\\Users\\Jonas\\Videos\\2019-05-04_17-25-29.flv"));
	}
}
