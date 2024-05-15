package dat3.bxb.configuration;

import dat3.bxb.activity.Activity;
import dat3.bxb.airhockey.Airhockey;
import dat3.bxb.airhockey.AirhockeyRepository;
import dat3.bxb.bowlinglane.BowlingLane;
import dat3.bxb.bowlinglane.BowlingLaneRepository;
import dat3.bxb.diningtable.DiningTable;
import dat3.bxb.diningtable.DiningTableRepository;
import dat3.bxb.reservation.Reservation;
import dat3.bxb.reservation.ReservationRepository;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class InitData implements CommandLineRunner {
    private final AirhockeyRepository airhockeyRepository;
    private final BowlingLaneRepository bowlingLaneRepository;
    private final ReservationRepository reservationRepository;
    private final UserWithRolesRepository userWithRolesRepository;
    private final DiningTableRepository diningTableRepository;

    public InitData(AirhockeyRepository airhockeyRepository, BowlingLaneRepository bowlingLaneRepository, ReservationRepository reservationRepository, UserWithRolesRepository userWithRolesRepository, DiningTableRepository diningTableRepository) {
        this.airhockeyRepository = airhockeyRepository;
        this.bowlingLaneRepository = bowlingLaneRepository;
        this.reservationRepository = reservationRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.diningTableRepository = diningTableRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello from InitData");
        createAirhockeyTables();
        createBowlingLanes();
        createReservations();
        createDiningTables();
    }

    public void createAirhockeyTables() {
        System.out.println("Creating Airhockey tables");

        List<Airhockey> airhockeyTables = List.of(
                new Airhockey("Airhockey 1", 4, false, 30, false, 1),
                new Airhockey("Airhockey 2", 4, false, 30, false, 2),
                new Airhockey("Airhockey 3", 4, false, 30, false, 3),
                new Airhockey("Airhockey 4", 4, false, 30, false, 4),
                new Airhockey("Airhockey 5", 4, false, 30, false, 5),
                new Airhockey("Airhockey 6", 4, false, 30, false, 6)
        );

        for (Airhockey airhockey : airhockeyTables) {
            // Check if a table with the same number already exists
            Airhockey existingTable = airhockeyRepository.findByTableNumber(airhockey.getTableNumber());
            if (existingTable == null) {
                // If not, save the new table
                airhockeyRepository.save(airhockey);
            }
        }
    }

    public void createBowlingLanes() {
        System.out.println("Creating Bowling lanes");

        List<BowlingLane> bowlingLanes = List.of(
                new BowlingLane("Bowling lane 1", 6, false, 60, false, 1, false),
                new BowlingLane("Bowling lane 2", 6, false, 60, false, 2, false),
                new BowlingLane("Bowling lane 3", 6, false, 60, false, 3, false),
                new BowlingLane("Bowling lane 4", 6, false, 60, false, 4, false),
                new BowlingLane("Bowling lane 5", 6, false, 60, false, 5, false),
                new BowlingLane("Bowling lane 6", 6, false, 60, false, 6, false),
                new BowlingLane("Bowling lane 7", 6, false, 60, false, 7, false),
                new BowlingLane("Bowling lane 8", 6, false, 60, false, 8, false),
                new BowlingLane("Bowling lane 9", 6, false, 60, false, 9, false),
                new BowlingLane("Bowling lane 10", 6, false, 60, false, 10, false),
                new BowlingLane("Bowling lane 11", 6, false, 60, false, 11, false),
                new BowlingLane("Bowling lane 12", 6, false, 60, false, 12, false),
                new BowlingLane("Bowling lane 13", 6, false, 60, false, 13, false),
                new BowlingLane("Bowling lane 14", 6, false, 60, false, 14, false),
                new BowlingLane("Bowling lane 15", 6, false, 60, false, 15, false),
                new BowlingLane("Bowling lane 16", 6, false, 60, false, 16, false),
                new BowlingLane("Bowling lane 17", 6, false, 60, false, 17, false),
                new BowlingLane("Bowling lane 18", 6, false, 60, false, 18, false),
                new BowlingLane("Bowling lane 19", 6, false, 60, false, 19, false),
                new BowlingLane("Bowling lane 20", 6, false, 60, false, 20, false),
                new BowlingLane("Bowling lane 21", 6, false, 60, false, 21, true),
                new BowlingLane("Bowling lane 22", 6, false, 60, false, 22, true),
                new BowlingLane("Bowling lane 23", 6, false, 60, false, 23, true),
                new BowlingLane("Bowling lane 24", 6, false, 60, false, 24, true)
        );

        for (BowlingLane bowlingLane : bowlingLanes) {
            // Check if a lane with the same number already exists
            BowlingLane existingLane = bowlingLaneRepository.findByLaneNumber(bowlingLane.getLaneNumber());
            if (existingLane == null) {
                // If not, save the new lane
                bowlingLaneRepository.save(bowlingLane);
            }
        }
    }

    public void createReservations(){
        System.out.println("Creating reservations");

        Activity activity = airhockeyRepository.findById(1);
        Activity activity1 = bowlingLaneRepository.findById(7);

        String username1 = "user1";

        UserWithRoles userWithRoles = userWithRolesRepository.findByUsername(username1);

        LocalDateTime startTime = LocalDateTime.of(2021, 12, 24, 12, 0); // Example start time
        LocalDateTime startTime1 = LocalDateTime.of(2021, 12, 24, 13, 0);
        LocalDateTime startTime2 = LocalDateTime.of(2021, 12, 24, 14, 0);
        LocalDateTime startTime3 = LocalDateTime.of(2021, 12, 24, 15, 0);
        LocalDateTime startTime4 = LocalDateTime.of(2021, 12, 24, 16, 0);
        LocalDateTime startTime5 = LocalDateTime.of(2021, 12, 24, 17, 0);
        LocalDateTime startTime6 = LocalDateTime.of(2021, 12, 24, 18, 0);
        LocalDateTime startTime7 = LocalDateTime.of(2021, 12, 24, 19, 0);
        LocalDateTime startTime8 = LocalDateTime.of(2021, 12, 24, 20, 0);
        LocalDateTime startTime9 = LocalDateTime.of(2021, 12, 24, 21, 0);
        LocalDateTime startTime10 = LocalDateTime.of(2021, 12, 24, 22, 0);

        List<Reservation> reservations = List.of(
                new Reservation(activity, startTime, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime1, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime2, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime3, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime4, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime5, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime6, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime7, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime8, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime9, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime10, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime, 1, userWithRoles, "Sanne Loeb", "42424242", LocalDateTime.now(), LocalDateTime.now())

        );

        for (Reservation reservation : reservations) {
            // Check if a reservation for the same activity already exists
            Optional<Reservation> existingReservation = reservationRepository.findByActivityAndStartTime(reservation.getActivity(), reservation.getStartTime());
            if (existingReservation.isEmpty()) {
                // If no such reservation exists, save the new one
                reservationRepository.save(reservation);
            }
        }
    }

    public void createDiningTables() {
        System.out.println("Creating dining tables");

        List<DiningTable> diningTables = List.of(
                new DiningTable("Dining table 1", 8, false, 90, false, 1),
                new DiningTable("Dining table 2", 8, false, 90, false, 2),
                new DiningTable("Dining table 3", 8, false, 90, false, 3),
                new DiningTable("Dining table 4", 8, false, 90, false, 4),
                new DiningTable("Dining table 5", 8, false, 90, false, 5),
                new DiningTable("Dining table 6", 8, false, 90, false, 6),
                new DiningTable("Dining table 7", 8, false, 90, false, 7),
                new DiningTable("Dining table 8", 8, false, 90, false, 8),
                new DiningTable("Dining table 9", 8, false, 90, false, 9),
                new DiningTable("Dining table 10", 8, false, 90, false, 10),
                new DiningTable("Dining table 11", 8, false, 90, false, 11),
                new DiningTable("Dining table 12", 8, false, 90, false, 12)
        );

        for (DiningTable diningTable : diningTables) {
            // Check if a table with the same number already exists
            DiningTable existingTable = diningTableRepository.findByDiningTableNumber(diningTable.getDiningTableNumber());
            if (existingTable == null) {
                // If not, save the new table
                diningTableRepository.save(diningTable);
            }
        }
    }
}