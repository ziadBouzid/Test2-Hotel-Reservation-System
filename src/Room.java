public class Room {

    private int number;
    private RoomType type;
    private int pricePerNight;

    public Room(int number, RoomType type, int pricePerNight) {
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public int getNumber() {
        return number;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public RoomType getType() {
        return type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
