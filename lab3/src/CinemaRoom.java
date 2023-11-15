import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class CinemaRoom {

    private ArrayList<Movie> movies = new ArrayList<>();
    int seatsRow;
    int seatsColumn;

    public CinemaRoom(int _seatsRow,int _seatsColumn){
        if(_seatsRow <= 0 || _seatsColumn <= 0){
            System.out.println("Недопустимые параметры зала");
        }
        this.seatsColumn = _seatsColumn;
        this.seatsRow = _seatsRow;
    }

    public boolean CanAppendMovie(Date date,int length){
        for (Movie movie : this.movies) {
            if (movie.getStart().after(date)) {
                if (movie.getStart().getTime() < date.getTime() + (long) length * 60000L) {
                    return false;
                }
            }
        }
        return true;
    }

    public void AddMovie(Movie movie){
        if(!CanAppendMovie(movie.getStart(),movie.getMovieLength())){
            System.out.println("Невозможно добавить сеанс с указанной датой и длинной");
        }
        else{
            movie.SetConfiguration(this.seatsRow,this.seatsColumn);
            movies.add(movie);
            movies.sort(Comparator.comparing(Movie::getStart));
        }
    }

    public int GetMoviesAmount(){
        return movies.size();
    }
    public Movie GetMovie(String movieTitle) {
        for (Movie movie : movies) {
            if (movie.getMovieTitle().equals(movieTitle)) {
                return movie;
            }
        }
        System.out.println("Такого фильма нет");
        return null;
    }

    public Movie GetNextMovie() {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).FreeSeatExists()) {
                return movies.get(i);
            }
        }
        return null;
    }

    public void ShowMovies() {
        System.out.println("Доступные фильмы:");
        for (Movie movie : movies) {
            if (movie.FreeSeatExists()) {
                System.out.printf("Название '%s', длительность %d минут\n", movie.getMovieTitle(), movie.getMovieLength());
            }
        }
    }
}
