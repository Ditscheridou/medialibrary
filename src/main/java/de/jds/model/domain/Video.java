package de.jds.model.domain;

import info.movito.themoviedbapi.model.MovieDb;

public class Video extends Media<MovieDb> {

	public Video(String name, String path) {
		super(name, path);
	}

}
