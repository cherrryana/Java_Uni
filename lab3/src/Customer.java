import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{

    private ArrayList<Ticket> tickets = new ArrayList<>();
    public Customer(){
        super(false);
    }

    public void BuyTicket(){
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = Cinema.GetCinema();
        cinema.ShowAvailableRooms();
        System.out.println("Введите номер кинозала");
        int roomId = scanner.nextInt();
        scanner.nextLine();

        CinemaRoom room;
        try {
            room = cinema.GetRoom(roomId);
        }
        catch (Error e) {
            System.out.println(e.getMessage());
            this.ShowActions();
            return;
        }

        room.ShowMovies();

        System.out.println("Введите название интересующего фильма:");
        String movieTitle = scanner.nextLine();

        Movie movie = room.GetMovie(movieTitle);
        movie.ShowConfiguration();

        System.out.println("Введите номер строки и столбца нужного кресла:");
        int row = scanner.nextInt();
        scanner.nextLine();
        int column = scanner.nextInt();
        scanner.nextLine();
        movie.Book(row, column);
        tickets.add(new Ticket(Cinema.cinemas.indexOf(cinema), roomId, movieTitle, row, column));
    }

    public void ShowTickets(){
        if (tickets.isEmpty()) {
            System.out.println("У вас нет купленных билетов");
            return;
        }
        System.out.println("Ваши купленные билеты:");
        for (Ticket ticket : tickets) {
            System.out.printf("Название: %s, кинотеатр %d, зал %d \n", ticket.GetMovieTitle(), ticket.GetCinema(), ticket.GetRoom());
        }
    }

    public void Dialog(int ans){
        switch (ans){
            case 1:
                this.BuyTicket();
                break;
            case 2:
                this.ShowTickets();
                break;
            case 3:
                Cinema.ShowNextMovie();
        }
    }

    @Override
    public void ShowActions() {
        System.out.println("Перед вами список возможных действий вас как пользователя: ");
        System.out.println("Введите один из нижепредставленных номеров для соверешния действий ");
        System.out.println("1. Купить билет");
        System.out.println("2. Показать доступные билеты");
        System.out.println("3. Посмотреть следующий фильм");
    }
}
