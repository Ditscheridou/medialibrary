package de.jds.model.repositories;

import de.jds.model.domain.Video;

import java.util.Set;

public class FileSystemVideoRepository implements CrudRepository<Video, String> {
	@Override
	public void save(Video entity) {

	}

	@Override
	public void delete(Video entity) {

	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public Video findById(String s) {
		return null;
	}

	@Override
	public Set<Video> findAll() {
		return Set.of(new Video("Harry Potter und der Stein der Weisen", "/Users/jd/Desktop/sample.mp4"),
				new Video("Harry Potter und die Kammer des Schreckens", "/Users/jd/Desktop/sample.mp4"),
				new Video("Harry Potter und der Gefangene von Askaban", "/Users/jd/Desktop/sample.mp4"),
				new Video("Harry Potter und der Feuerkelch", "/Users/jd/Desktop/sample.mp4"),
				new Video("Harry Potter und der Orden des Phoenix", "/Users/jd/Desktop/sample.mp4"),
				new Video("Harry Potter und der Halbblutprinz", "/Users/jd/Desktop/sample.mp4"),
				new Video("Harry Potter und die Heiligtümer des Todes", "/Users/jd/Desktop/sample.mp4"));
	}
}
