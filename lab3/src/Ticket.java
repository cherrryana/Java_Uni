public class Ticket {
    private int cinemaId;
    private int roomId;
    private int[] seat = new int[2];
    private String movieTitle;

    public Ticket(int cinemaId, int hallId, String movieTitle, int row, int column) {
        this.cinemaId = cinemaId;
        this.roomId = hallId;
        this.movieTitle = movieTitle;
        this.seat[0] = row;
        this.seat[1] = column;
    }

    public int GetCinema() {
        return this.cinemaId;
    }

    public int GetRoom() {
        return this.roomId;
    }

    public int[] GetSeat() {
        return this.seat;
    }
    public String GetMovieTitle() {
        return this.movieTitle;
    }
}
