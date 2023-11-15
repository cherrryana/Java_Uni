import java.text.ParseException;
import java.util.Scanner;

public class ConsoleApp {

    public static User user;
    public static Scanner scanner = new Scanner(System.in);
    public static void Login(){
        System.out.println("Нажмите 1 для входа как админ, нажмите 2 для входа как пользователь");

        int type = scanner.nextInt();
        if(type == 1){
            user = new Admin();
        } else {
            user = new Customer();
        }
    }
    public static void Init() throws ParseException {
        Cinema.InitCinema();
        Login();
        user.ShowActions();
        System.out.println("Введите номер действия");
        int ans = scanner.nextInt();
        if(user instanceof Customer ){
           ((Customer) user).Dialog(ans);
        } else{
            ((Admin) user).Dialog(ans);
        }
    }

}
