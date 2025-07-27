package design.lld;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestMeetingRoom {
    public static void main(String[] args) {

    }
}

class BookingController {

    // POST book

    Booking createBooking(BookingRequest request) {
        // create a transaction
        // put pessimistic lock
        // create booking
        // end transaction
        return new Booking();
    }

    boolean isRoomAvailable(int roomId, LocalDateTime newStartTime, LocalDateTime newEndTime) {
        boolean isConflictFound = false;
        /*
        select 1 from Booking
        where roomId = :roomId AND (b.startTime < :newEndTime And b.endTime > :newStartTime)
        LIMIT 1
         */
        return isConflictFound;
    }

    List<Room> getAvailableRooms(LocalDateTime newStartTime, LocalDateTime newEndTime, int buildingId) {
        /*
        select * from Room r
        left join Booking b on r.roomId = b.roomId And
        b.startTime < :newEndTime && b.endTime > :newStartTime
        And b.bookingId is NULL
        And r.buildingId = :buildingId
         */
        return new ArrayList<>();
    }


}

enum RecurrenceType {
    DAILY, WEEKLY, MONTHLY
}

class RecurrenceBooking {
    int bookingId;
    int recurrenceId;
    RecurrenceType recurrenceType;
    LocalDate startDate;
    LocalDate endDate;
    LocalTime startTime;
    LocalTime endTime;
}

class BookingRequest {
    int userId;
    int roomId;
    LocalDateTime newStartTime;
    LocalDateTime newEndTime;
}

class User {
    int userId;
    String name;
}

class Room {
    int roomId;
    int buildingId;
}

class Building {
    int buildingId;
    List<Room> rooms;
}

class Booking {
    int roomId;
    int userId;
    int recurrenceId; // if null then it is not recurring booking
    LocalDateTime startTime;
    LocalDateTime endTime;
    LocalDateTime createdAt;
}
