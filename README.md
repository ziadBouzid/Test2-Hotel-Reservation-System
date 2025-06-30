## Design Questions (Bonus)
### 1/- Suppose we put all the functions inside the same service. Is this the recommended approach ?
while placing all logic in a single Service class is acceptable for the scope of this technical test, it is not recommended in real-world applications.
In a scalable and maintainable system, responsibilities shouls be separated .For example, creating separate class like 'UserService','RoomService', and 'BookingService' making testing and debugging easier.
### 2/- In this design, we chose to have a function setRoom(..) that should not impact the previous bookings. What is another way ? What is your recommendation ? Please explain and justify
An alternative approach could be to store a new version of the room every time it is updated(for example, when the type or price changes),and to link each booking to the specific version that existed at the time of the booking.
This ensures historical accuracy, as each booking reflects the exact state of the room when it was made.
However, in this test, I chose a simpler and effective approach by storing a copy of the room data directly in the booking when the reservation is created.
