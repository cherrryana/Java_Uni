import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
public class Admin extends User{
    public Admin(){
        super(true);
    }

    @Override
    public void ShowActions() {
        System.out.println("Перед вами список возможных действий вас как администратора: ");
        System.out.println("Введите один из нижепредставленных номеров для соверешния действий ");
        System.out.println("1. Добавить кинотеатр");
        System.out.println("2. Добавить зал");
        System.out.println("3. Добавить сеанс");
    }
    public void Dialog(int ans) throws ParseException {
        switch (ans){
            case 1:
                this.AddCinema();
                break;
            case 2:
                this.AddCinemaRoom();
                break;
            case 3:
                this.AddMovie();
        }
    }
    public void AddCinema(){
        Cinema newCinema = new Cinema();
        Cinema.cinemas.add(newCinema);
        System.out.printf("Номер нового кинотеатра - %d \n\n", Cinema.cinemas.size() - 1);
        this.ShowActions();
    }

    public void AddCinemaRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество рядов:");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите количество сидений в 1 ряду:");
        int column = scanner.nextInt();
        scanner.nextLine();
        CinemaRoom newRoom = new CinemaRoom(row, column);
        Cinema cinema;
        cinema = Cinema.GetCinema();
        cinema.AddRoom(newRoom);
        System.out.printf("Номер нового зала - %d \n\n", cinema.GetRoomsAmount() - 1);
    }

    public void AddMovie() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        Cinema cinema = Cinema.GetCinema();

        cinema.ShowAvailableRooms();
        System.out.println("Введите номер кинозала");
        int roomId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите название фильма");
        String title = scanner.nextLine();

        System.out.println("Введите дату (пример: 2023-11-15 16:30)");
        String stringDate = scanner.nextLine();

        System.out.println("Введите продолжительность фильма в минутах");
        int length = scanner.nextInt();
        scanner.nextLine();

        Date date = formatter.parse(stringDate);
        Movie movie = new Movie(length, title, date);
        cinema.AddMovie(roomId, movie);
        this.ShowActions();
    }
}
