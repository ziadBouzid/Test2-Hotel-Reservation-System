import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Service {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Users> users = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {

        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                // Update type and price
                room.setType(roomType);
                room.setPricePerNight(roomPricePerNight);
                return;
            }
        }
        rooms.add(0,new Room(roomNumber, roomType, roomPricePerNight));

    }

    public void setUser(int userId, int balance) {
        for(Users user : users) {
            if(user.getId() == userId){
                throw new IllegalArgumentException("User id " + userId + " already exists");
            }
        }
        users.add(0,new Users(userId, balance));
    }


    public void printAllUsers() {
        System.out.println("\n--- All Users ---");
        for (Users u : users) {
            System.out.println("ID : " + u.getId() + " Balance : " + u.getBalance());
        }
    }

    private int calculateTotalCost(Date checkIn, Date checkOut, int pricePerNight) {
        long diffMillis = checkOut.getTime() - checkIn.getTime();
        long nights = diffMillis / (1000 * 60 * 60 * 24);
        return (int) nights * pricePerNight;
    }

   public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {

       Room selectedRoom = null;
       Users selectedUser = null;

   for(Users u:users){
       if(u.getId() == userId){
          selectedUser = u;
          break;
       }
   }
   for(Room r:rooms){
       if(r.getNumber() == roomNumber){
           selectedRoom = r;
           break;
       }
   }
   if(selectedRoom == null || selectedUser == null) {
       throw new IllegalStateException("User or Room not found.");
   }

   int totalCost = calculateTotalCost(checkIn, checkOut, selectedRoom.getPricePerNight());

       // Check for overlapping bookings
       for (Booking b : bookings) {
           if (b.getBookedRoom().getNumber() == roomNumber && !(checkOut.before(b.getCheckIn()) || checkIn.after(b.getCheckOut()))) {
               throw new IllegalStateException("Room "+b.getBookedRoom().getNumber()+" is already booked during this period. by user "+b.getBookingUser().getId());

           }
       }

       if (selectedUser.getBalance() < totalCost) {
           throw new IllegalStateException("Insufficient balance.");

       } else if(checkIn.after(checkOut)){
           throw new IllegalStateException("Invalid date range.");
           } else {
           selectedUser.setBalance(selectedUser.getBalance() - totalCost);
           bookings.add(0, new Booking(selectedUser, selectedRoom, checkIn, checkOut));
           System.out.println("Booking successful.");
       }


    }


   public void printAll() {
       System.out.println("\n--- All Rooms ---");
       for (Room r : rooms) {
           System.out.println("ID: "+r.getNumber()+"|| Type: "+r.getType()+"|| Price Per Night: "+r.getPricePerNight());
       }
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       System.out.println("\n--- All Bookings ---");
       for (Booking b : bookings) {
           String checkIn = sdf.format(b.getCheckIn());
           String checkOut = sdf.format(b.getCheckOut());
           System.out.println("booking user :"+b.getBookingUser().getId()+" ||Booked Room :"+b.getBookedRoom().getNumber() +" ||CheckIn:"+checkIn+" ||CheckOut:"+checkOut+"\n");
       }
    }

}
