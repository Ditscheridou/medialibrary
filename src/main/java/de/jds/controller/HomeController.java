package de.jds.controller;

import de.jds.listener.ActionEvent;
import de.jds.view.HomeView;

public class HomeController extends AbstractController<HomeView> {
	@Override
	protected HomeView createView() {
		return new HomeView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.actionId()) {
		case BUTTON_CLICK -> {
			VideoController videoController = new VideoController();
			videoController.afterinit();

		}
		default -> {
			System.out.println("wrong id");
		}
		}
	}
}
