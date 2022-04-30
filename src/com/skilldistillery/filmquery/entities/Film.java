package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private short release_year;
	private int language_id;
	private int rental_duration;
	private double rental_rate;
	private int length;
	private double replacment_cost;
	private String rating;
	private String Special_features;
	private String language;
	private List<Actor> actors;
	

	public short getRelease_year() {
		return release_year;
	}
	public void setRelease_year(short release_year) {
		this.release_year = release_year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String toStringLarge() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", realease_year=");
		builder.append(release_year);
		builder.append(", language_id=");
		builder.append(language_id);
		builder.append(", rental_duration=");
		builder.append(rental_duration);
		builder.append(", rental_rate=");
		builder.append(rental_rate);
		builder.append(", length=");
		builder.append(length);
		builder.append(", replacment_cost=");
		builder.append(replacment_cost);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", Special_features=");
		builder.append(Special_features);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("Film: ");
		builder.append(title);
		builder.append(" was released in ");
		builder.append(release_year);
		builder.append(" in ");		
		builder.append(language);		
		builder.append(". It was rated as |");
		builder.append(rating);
		builder.append("| and could be described as ");
		builder.append(description);
		builder.append("\nPresenting: " + title + " Starring: ");
		builder.append(actors);
		
		return builder.toString();
	}

	public Film(int id, String title, String description, short release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacment_cost, String rating, String special_features,
			String language, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacment_cost = replacment_cost;
		this.rating = rating;
		Special_features = special_features;
		this.language = language;
		this.actors = actors;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Special_features, description, id, language_id, length, rating, release_year,
				rental_duration, rental_rate, replacment_cost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(Special_features, other.Special_features)
				&& Objects.equals(description, other.description) && id == other.id && language_id == other.language_id
				&& length == other.length && rating == other.rating
				&& Objects.equals(release_year, other.release_year) && rental_duration == other.rental_duration
				&& Double.doubleToLongBits(rental_rate) == Double.doubleToLongBits(other.rental_rate)
				&& Double.doubleToLongBits(replacment_cost) == Double.doubleToLongBits(other.replacment_cost)
				&& Objects.equals(title, other.title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getRealease_year() {
		return release_year;
	}

	public void setRealease_year(Short realease_year) {
		this.release_year = realease_year;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public int getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}

	public double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacment_cost() {
		return replacment_cost;
	}

	public void setReplacment_cost(double replacment_cost) {
		this.replacment_cost = replacment_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return Special_features;
	}

	public void setSpecial_features(String special_features) {
		Special_features = special_features;
	}

	public Film(int id, String title, String description, Short realease_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacment_cost, String rating, String special_features, String language, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = realease_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacment_cost = replacment_cost;
		this.rating = rating;
		Special_features = special_features;
	}
	
	public Film(int id, String title, String description, short release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacment_cost, String rating, String special_features,
			String language) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacment_cost = replacment_cost;
		this.rating = rating;
		Special_features = special_features;
		this.language = language;
	}
	public Film() {
		
	}
	
	
	
}
