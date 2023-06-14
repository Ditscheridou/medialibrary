package de.jds.controller;

import de.jds.view.AudioView;

public class AudioController extends AbstractController<AudioView> {
	@Override
	protected AudioView createView() {
		return new AudioView();
	}
}
