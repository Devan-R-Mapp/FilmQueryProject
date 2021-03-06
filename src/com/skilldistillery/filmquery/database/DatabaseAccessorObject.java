package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	static {
	//		dee hint mysql> -- .... WHERE title LIKE ? OR description LIKE ?;
	//				mysql> -- pstmt.setString(1, "%" + searchWord + "%");
	//					mysql> -- pstmt.setString(2, "%" + searchWord + "%"); 
	}

	@Override
	public Film findFilmById(int filmId) {
		try {
			Film film = null;
			String user = "student";
			String pass = "student";
			String url = "jdbc:mysql://localhost:3306/sdvid";
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, ";
				   sql += " rental_rate, length, replacement_cost, rating, special_features, language.name "
					+ " FROM film JOIN language ON film.language_id = language.id WHERE film.id =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId2 = rs.getInt(1);
				List<Actor> actors = findActorsByFilmId(filmId2);
				String title = rs.getString(2);
				String desc = rs.getString(3);
				short releaseYear = rs.getShort(4);
				int langId = rs.getInt(5);
				int rentDur = rs.getInt(6);
				double rate = rs.getDouble(7);
				int length = rs.getInt(8);
				double repCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String features = rs.getString(11);
				String language = rs.getString(12);
				
				film = new Film(filmId2, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features, language, actors);
				
			}
			return film;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public List<Film> findFilmByChars(String UserInput) {
		List<Film> films = new ArrayList<>();
		try {
			Film film = null;
			String user = "student";
			String pass = "student";
			String url = "jdbc:mysql://localhost:3306/sdvid";
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT film.id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features, language.name "
					+ " FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? or description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + UserInput + "%");
			stmt.setString(2, "%" + UserInput + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId2 = rs.getInt(1);
				List<Actor> actors = findActorsByFilmId(filmId2);
				String title = rs.getString(2);
				String desc = rs.getString(3);
				short releaseYear = rs.getShort(4);
				int langId = rs.getInt(5);
				int rentDur = rs.getInt(6);
				double rate = rs.getDouble(7);
				int length = rs.getInt(8);
				double repCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String features = rs.getString(11);
				String language = rs.getString(12);
				film = new Film(filmId2, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features, language, actors);
				films.add(film);
			}
			return films;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
		
	}

	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			String user = "student";
			String pass = "student";
			String url = "jdbc:mysql://localhost:3306/sdvid";
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(actorResult.getInt(1), actorResult.getString(3), actorResult.getString(2)); // Create
																												// the
																												// object
				// actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actor = null;
		try {
			String user = "student";
			String pass = "student";
			String url = "jdbc:mysql://localhost:3306/sdvid";
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor INNER JOIN film_actor on actor.id = film_actor.actor_id"
					+ " INNER JOIN film on film.id = film_actor.film_id"
					+ " WHERE film.id =?";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setInt(1, filmId);
					ResultSet actorResult = stmt.executeQuery();
					while (actorResult.next()) {
						int id = actorResult.getInt(1);
						String firstName = actorResult.getString(2);
						String lastName = actorResult.getString(3);	
						actor = new Actor(id, firstName,lastName);
						actors.add(actor);
					}
					
		
				} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		try {
			String user = "student";
			String pass = "student";
			String url = "jdbc:mysql://localhost:3306/sdvid";
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features "
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId2 = rs.getInt(1);
				String title = rs.getString(2);
				String desc = rs.getString(3);
				short releaseYear = rs.getShort(4);
				int langId = rs.getInt(5);
				int rentDur = rs.getInt(6);
				double rate = rs.getDouble(7);
				int length = rs.getInt(8);
				double repCost = rs.getDouble(9);
				String rating = rs.getString(10);
				String features = rs.getString(11);
				Film film = new Film(filmId2, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features, null, null);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

}
