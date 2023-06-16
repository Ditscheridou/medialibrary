package de.jds.view;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.fullscreen.FullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.fullscreen.exclusivemode.ExclusiveModeFullScreenStrategy;

import javax.swing.*;
import java.awt.*;

import static uk.co.caprica.vlcj.player.component.MediaPlayerSpecs.embeddedMediaPlayerSpec;

public class MediaView extends AbstractView {

    private EmbeddedMediaPlayerComponent mediaPlayerComponent;

    private Canvas videoSurface;
    private MediaPlayerFactory mediaPlayerFactory;

    private EmbeddedMediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        videoSurface = new Canvas();
        videoSurface.setBackground(Color.black);
        videoSurface.setSize(800, 600); // Only for initial layout
        // Since we're mixing lightweight Swing components and heavyweight AWT components this is probably a good idea
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        FullScreenStrategy fullScreenStrategy = new ExclusiveModeFullScreenStrategy(Window.getInstance());
        mediaPlayerFactory = new MediaPlayerFactory("--no-snapshot-preview","--quiet");
        mediaPlayerFactory.application().setUserAgent("vlcj test player");

        mediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
        mediaPlayer.fullScreen().strategy(fullScreenStrategy);
        mediaPlayer.videoSurface().set(mediaPlayerFactory.videoSurfaces().newVideoSurface(videoSurface));

        mediaPlayer.input().enableKeyInputHandling(false);
        mediaPlayer.input().enableMouseInputHandling(false);

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent(embeddedMediaPlayerSpec().withFactory(new MediaPlayerFactory()));
        setLayout(new BorderLayout());
        add(mediaPlayerComponent, BorderLayout.CENTER);
    }

    public void playVideo(String path) {
       mediaPlayerComponent.mediaPlayer().media().play(path);
    }

    @Override
    public void onStop() {

    }
}
