package de.jds.controller;

import de.jds.model.domain.Video;
import de.jds.model.services.MediaService;
import de.jds.model.services.VideoService;
import de.jds.view.VideoView;

public class VideoController extends AbstractController<VideoView> {

	private final MediaService<Video> videoService;

	public VideoController() {
		this.videoService = new VideoService();
	}

	@Override
	public void afterinit() {
		videoService.getAll().forEach(future -> future.thenAccept(video -> getView().addVideo(video)));
	}

	@Override
	protected VideoView createView() {
		return new VideoView();
	}
}
