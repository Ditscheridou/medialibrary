package de.jds.controller;

import de.jds.model.domain.Video;
import de.jds.view.MediaView;

public class MediaController extends AbstractController<MediaView> {
    @Override
    protected MediaView createView() {
        return new MediaView();
    }

    public void playVideo(Video video) {
            getView().playVideo(video.path());
    }
}
