
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


       Service service = new Service();
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        // Create rooms
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.SUITE, 3000);


        // Create Users
        try {
            service.setUser(1,5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            service.setUser(2,10000);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }


        // Bookings
        try {
            Date checkIn = sdf.parse("30/06/2026");
            Date checkOut = sdf.parse("07/07/2026");
            service.bookRoom(1, 2, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Date checkIn = sdf.parse("07/07/2026");
            Date checkOut = sdf.parse("30/06/2026");
            service.bookRoom(1, 2, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Date checkIn = sdf.parse("07/07/2026");
            Date checkOut = sdf.parse("08/07/2026");
            service.bookRoom(1, 1, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Date checkIn = sdf.parse("07/07/2026");
            Date checkOut = sdf.parse("09/07/2026");
            service.bookRoom(2, 1, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Date checkIn = sdf.parse("07/07/2026");
            Date checkOut = sdf.parse("08/07/2026");
            service.bookRoom(2, 3, checkIn, checkOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        service.setRoom(1, RoomType.SUITE, 10000);

        service.printAll();

        service.printAllUsers();


    }
}