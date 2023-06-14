package de.jds.model.domain;

import java.util.Objects;

public abstract class Media<T> {
	private final String name;
	private final String path;

	private T metadata;

	protected Media(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String name() {
		return name;
	}

	public String path() {
		return path;
	}

	public T metadata() {
		return metadata;
	}

	public void setMetadata(T metadata) {
		this.metadata = metadata;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		var that = (Media) obj;
		return Objects.equals(this.name, that.name) && Objects.equals(this.path, that.path);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, path);
	}

	@Override
	public String toString() {
		return "Media[" + "name=" + name + ", " + "path=" + path + ']';
	}

}
