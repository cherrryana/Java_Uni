import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;
public class Cinema {
    public static ArrayList<Cinema> cinemas = new ArrayList<>();
    private static ArrayList<CinemaRoom> rooms = new ArrayList<>();


    public void AddRoom(CinemaRoom room){
        rooms.add(room);
    }
    public CinemaRoom GetRoom(int roomId) {
        return rooms.get(roomId);
    }

    public void AddMovie(int roomId, Movie movie) {
        CinemaRoom room;
        room = this.GetRoom(roomId);
        room.AddMovie(movie);
    }
    public static Cinema GetCinema(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер кинотеатра");
        int cinemaId = scanner.nextInt();
        scanner.nextLine();
        return cinemas.get(cinemaId);
    }
    public void ShowAvailableRooms(){
        int size = rooms.size();
        if(size > 0){
            System.out.println("Ниже представлены номера залов, которые доступны для посещения:");
            for(int i = 0; i < rooms.size(); ++i){
                System.out.printf("Номер зала : %d \n",i);
            }
        }
        else{
            System.out.println("К сожалению, доступных залов нет!");
        }

    }

    public static void ShowCinemas() {
        if (cinemas.isEmpty()) {
            System.out.println("На данный момент нет доступных кинотеатров");
            return;
        }
        System.out.println("Номера доступных кинотеатров:");
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.printf("%d ", i);
        }
        System.out.println("");
    }
    public int GetRoomsAmount(){
        return rooms.size();
    }
    public static void InitCinema() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        for (int i = 0; i <= 1; i++) {
            Cinema cinema = new Cinema();
            for (int j = 0; j <= 1; j++) {
                CinemaRoom hall = new CinemaRoom(10, 10);
                cinema.AddRoom(hall);
            }
            cinemas.add(cinema);
        }

        Movie firstMovie = new Movie(60, "Принц Египта", formatter.parse("2023-10-05 15:30"));
        Movie secondMovie = new Movie(60, "Властелин колец", formatter.parse("2023-10-10 10:30"));
        Movie thirdMovie = new Movie(60, "Мстители", formatter.parse("2023-10-05 09:00"));

        cinemas.get(0).GetRoom(0).AddMovie(firstMovie);
        cinemas.get(0).GetRoom(0).AddMovie(thirdMovie);
        cinemas.get(1).GetRoom(0).AddMovie(secondMovie);
    }

    public static void ShowNextMovie(){

        Movie currentMovie = new Movie(0, "", new Date(0));
        int cinemaId = -1;
        int roomId = -1;

        for (int i = 0; i < cinemas.size(); i++) {
            Cinema cinema = cinemas.get(i);
            for (int j = 0; j < cinema.GetRoomsAmount(); j++) {
                CinemaRoom room = cinema.GetRoom(j);
                Movie movie = room.GetNextMovie();
                if (movie != null) {
                    if (movie.getStart().before(currentMovie.getStart()) || currentMovie.getStart().getTime() == 0) {
                        currentMovie = movie;
                        cinemaId = i;
                        roomId = j;
                    }
                }
            }
        }

        if (cinemaId == -1) {
            System.out.println("Ближайшего сеанса не найдено");
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        System.out.println("Ближайший сеанс со свободными местами:");
        System.out.println(currentMovie.getMovieTitle());
        System.out.printf("Время начала %s, длительность %d минут\n", formatter.format(currentMovie.getStart().getTime()), currentMovie.getMovieLength());
        System.out.printf("Кинотеатр %d, зал %d \n", cinemaId, roomId);
    }

}
