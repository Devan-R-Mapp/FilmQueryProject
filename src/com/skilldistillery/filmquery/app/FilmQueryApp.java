package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	public static final boolean debug = false;

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int userChoice = 0;
		MenuPrint: while (true) {
			UserCho: while (true) {
				try {
					menuPrintOut();
					userChoice = input.nextInt();
					break UserCho;
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("Please enter a number on the list.");
				}

			}
			if (debug) {
				System.out.println("out of usercho");
			}
			switch (userChoice) {
			case 1:
				if (debug) {
					System.out.println("in case 1");
				}
				while (true) {
					System.out.println("Please enter the id of the movie you would like to see: ");
					int movieid;
					while (true) {
						try {
							movieid = input.nextInt();
							break;
						} catch (InputMismatchException e) {
							input.nextLine();
							System.out.println("Please enter a number.");
						}

					}
					Film returnedFilm = db.findFilmById(movieid);
					System.out.println(returnedFilm.toString());
					if (!yesOrNo(input)) {
						break;
					}
				}
				break;
			case 2:
				if (debug) {
					System.out.println("in case 2");
				}

				while (true) {
					System.out.println("Please enter the string of that a movie title or decription contains : ");
					String movieidstring = "";
					input.nextLine();
					movieidstring = input.nextLine();

					try {
						List<Film> returnedFilm = db.findFilmByChars(movieidstring);
						if (!returnedFilm.isEmpty()) {
							System.out.println(returnedFilm.toString());
						} else {
							System.out
									.println("There are no movie titles or descriptons that contain " + movieidstring);
						}
					} catch (Exception e) {

						e.printStackTrace();
					}
					if (!yesOrNo(input)) {
						break;
					}
				}
				break;

			case 3:
				System.out.println("Goodbye!");
				break MenuPrint;
			default:
				System.out.println("Please enter a number on the list.");
				break;
			}
		}
	}

	protected boolean yesOrNo(Scanner input) {
		while (true) {
			int ynchoice = 0;
			System.out.println("Would you like to enter another one?");
			System.out.println("1. Yes!");
			System.out.println("2. No.");
			YoN: while (true) {
				try {
					ynchoice = input.nextInt();
					break YoN;
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("Please enter 1 or 2.");
				}
			}
			if (ynchoice == 1) {
				return true;
			} else if (ynchoice == 2) {
				return false;
			} else {
				System.out.println("Please enter 1 or 2.");
			}
		}
	}

	private void menuPrintOut() {
		System.out.println("Please choose one to find out about your movie of choice:");
		System.out.println("1. Find Film by flim Id");
		System.out.println("2. Find Film by keyword");
		System.out.println("3. Exit");

	}
}
