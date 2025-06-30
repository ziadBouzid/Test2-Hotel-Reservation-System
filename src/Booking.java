import java.util.Date;

public class Booking {
    private Users bookingUser;
    private Room bookedRoom;
    private Date checkIn;
    private Date checkOut;


    public Booking(Users user, Room room, Date checkIn, Date checkOut) {
        this.bookingUser = new Users(user.getId(), user.getBalance()); // snapshot at booking
        this.bookedRoom = new Room(room.getNumber(), room.getType(), room.getPricePerNight());
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Users getBookingUser() {
        return bookingUser;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
