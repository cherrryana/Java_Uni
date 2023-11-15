import java.util.Date;

public class Movie {

    private int seatsFree;

    private boolean [][] seats;

    private Date start = new Date();

    private String movieTitle;

    private int movieLength;


    public int getMovieLength() {
        return movieLength;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public Date getStart() {
        return start;
    }

    public Movie(int length, String title, Date movieStart){
        if(length > 60 || length <= 0){
            System.out.println("Недопустимые параметры сеанса");
            return;
        }
        if(title.isEmpty())
            System.out.println("Название сеанса не может быть пустым");

        this.movieLength = length;
        this.movieTitle = title;
        this.start = movieStart;
    }

    public void SetConfiguration(int row, int col){
        this.seats = new boolean[row][col];
        this.seatsFree = row * col;
    }

    public void ShowConfiguration(){
        System.out.println("Ниже буде представлена схема зала");
        System.out.println("                                    ");
        for (int i = 0; i < this.seats[0].length; ++i) {
            System.out.printf(" %d", i);
        }

        System.out.println("");
        for (int i = 0; i < this.seats.length; ++i) {
            System.out.printf("%d ", i);
            for (int j = 0; j < this.seats[i].length; ++j) {
                System.out.printf("%s ", this.IsBooked(i, j) ? "X" : " -");
            }
            System.out.println("");
        }

    }
    public boolean IsBooked(int row, int col){
        return this.seats[row][col];
    }

    public void Book(int row, int col){
        if(!IsBooked(row,col)){
            this.seats[row][col] = true;
            this.seatsFree--;
            return;
        }
        System.out.println("Место уже забронировано!");
    }

    public boolean FreeSeatExists(){
        return seatsFree > 0;
    }


}
