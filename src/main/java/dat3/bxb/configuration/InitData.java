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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void run(String... args) throws Exception {
        System.out.println("Hello from InitData");
        createAirhockeyTables();
        createBowlingLanes();
        createReservations();
        createDiningTables();
    }
    public void createAirhockeyTables() {
        System.out.println("Creating Airhockey tables");
        Set<Airhockey> existingAirhockeyTables = new HashSet<>();
        existingAirhockeyTables.addAll(airhockeyRepository.findAll());

        Airhockey airhockey1 = new Airhockey("Airhockey 1", 4, false, 30, false, 1);
        Airhockey airhockey2 = new Airhockey("Airhockey 2", 4, false, 30, false, 2);
        Airhockey airhockey3 = new Airhockey("Airhockey 3", 4, false, 30, false, 3);
        Airhockey airhockey4 = new Airhockey("Airhockey 4", 4, false, 30, false, 4);
        Airhockey airhockey5 = new Airhockey("Airhockey 5", 4, false, 30, false, 5);
        Airhockey airhockey6 = new Airhockey("Airhockey 6", 4, false, 30, false, 6);
        airhockeyRepository.saveAll(List.of(airhockey1, airhockey2, airhockey3, airhockey4, airhockey5, airhockey6));
    }

    public void createBowlingLanes(){
        System.out.println("Creating Bowling lanes");
        Set<BowlingLane> existingBowlingLanes = new HashSet<>();
        existingBowlingLanes.addAll(bowlingLaneRepository.findAll());


        BowlingLane bowlingLane1 = new BowlingLane("Bowling lane 1", 6, false, 60, false, 1, false);
        BowlingLane bowlingLane2 = new BowlingLane("Bowling lane 2", 6, false, 60, false, 2, false);
        BowlingLane bowlingLane3 = new BowlingLane("Bowling lane 3", 6, false, 60, false, 3, false);
        BowlingLane bowlingLane4 = new BowlingLane("Bowling lane 4", 6, false, 60, false, 4, false);
        BowlingLane bowlingLane5 = new BowlingLane("Bowling lane 5", 6, false, 60, false, 5, false);
        BowlingLane bowlingLane6 = new BowlingLane("Bowling lane 6", 6, false, 60, false, 6, false);
        BowlingLane bowlingLane7 = new BowlingLane("Bowling lane 7", 6, false, 60, false, 7, false);
        BowlingLane bowlingLane8 = new BowlingLane("Bowling lane 8", 6, false, 60, false, 8, false);
        BowlingLane bowlingLane9 = new BowlingLane("Bowling lane 9", 6, false, 60, false, 9, false);
        BowlingLane bowlingLane10 = new BowlingLane("Bowling lane 10", 6, false, 60, false, 10, false);
        BowlingLane bowlingLane11 = new BowlingLane("Bowling lane 11", 6, false, 60, false, 11, false);
        BowlingLane bowlingLane12 = new BowlingLane("Bowling lane 12", 6, false, 60, false, 12, false);
        BowlingLane bowlingLane13 = new BowlingLane("Bowling lane 13", 6, false, 60, false, 13, false);
        BowlingLane bowlingLane14 = new BowlingLane("Bowling lane 14", 6, false, 60, false, 14, false);
        BowlingLane bowlingLane15 = new BowlingLane("Bowling lane 15", 6, false, 60, false, 15, false);
        BowlingLane bowlingLane16 = new BowlingLane("Bowling lane 16", 6, false, 60, false, 16, false);
        BowlingLane bowlingLane17 = new BowlingLane("Bowling lane 17", 6, false, 60, false, 17, false);
        BowlingLane bowlingLane18 = new BowlingLane("Bowling lane 18", 6, false, 60, false, 18, false);
        BowlingLane bowlingLane19 = new BowlingLane("Bowling lane 19", 6, false, 60, false, 19, false);
        BowlingLane bowlingLane20 = new BowlingLane("Bowling lane 20", 6, false, 60, false, 20, false);
        BowlingLane bowlingLane21 = new BowlingLane("Bowling lane 21", 6, false, 60, false, 21, true);
        BowlingLane bowlingLane22 = new BowlingLane("Bowling lane 22", 6, false, 60, false, 22, true);
        BowlingLane bowlingLane23 = new BowlingLane("Bowling lane 23", 6, false, 60, false, 23, true);
        BowlingLane bowlingLane24 = new BowlingLane("Bowling lane 24", 6, false, 60, false, 24, true);
        bowlingLaneRepository.saveAll(List.of(bowlingLane1, bowlingLane2, bowlingLane3, bowlingLane4, bowlingLane5, bowlingLane6, bowlingLane7, bowlingLane8, bowlingLane9, bowlingLane10, bowlingLane11, bowlingLane12, bowlingLane13, bowlingLane14, bowlingLane15, bowlingLane16, bowlingLane17, bowlingLane18, bowlingLane19, bowlingLane20, bowlingLane21, bowlingLane22, bowlingLane23, bowlingLane24));
    }

    public void createReservations(){
        System.out.println("Creating reservations");
        Set<Reservation> existingReservations = new HashSet<>();
        existingReservations.addAll(reservationRepository.findAll());

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


        Reservation reservation1 = new Reservation(activity, startTime, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation2 = new Reservation(activity, startTime1, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation3 = new Reservation(activity, startTime2, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation4 = new Reservation(activity, startTime3, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation5 = new Reservation(activity1, startTime4, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation6 = new Reservation(activity1, startTime5, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation7 = new Reservation(activity1, startTime6, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation8 = new Reservation(activity1, startTime7, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation9 = new Reservation(activity1, startTime8, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());
        Reservation reservation10 = new Reservation(activity1, startTime9, 1, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now());

        reservationRepository.saveAll(List.of(reservation1 , reservation2, reservation3, reservation4, reservation5, reservation6, reservation7, reservation8, reservation9, reservation10));
    }

    public void createDiningTables() {
        System.out.println("Creating dining tables");
        Set<DiningTable> existingDiningTable = new HashSet<>();
        existingDiningTable.addAll(diningTableRepository.findAll());

        DiningTable diningTable1 = new DiningTable("Dining table 1", 8, false, 90, false, 1);
        DiningTable diningTable2 = new DiningTable("Dining table 2", 8, false, 90, false, 2);
        DiningTable diningTable3 = new DiningTable("Dining table 3", 8, false, 90, false, 3);
        DiningTable diningTable4 = new DiningTable("Dining table 4", 8, false, 90, false, 4);
        DiningTable diningTable5 = new DiningTable("Dining table 5", 8, false, 90, false, 5);
        DiningTable diningTable6 = new DiningTable("Dining table 6", 8, false, 90, false, 6);
        DiningTable diningTable7 = new DiningTable("Dining table 7", 8, false, 90, false, 7);
        DiningTable diningTable8 = new DiningTable("Dining table 8", 8, false, 90, false, 8);
        DiningTable diningTable9 = new DiningTable("Dining table 9", 8, false, 90, false, 9);
        DiningTable diningTable10 = new DiningTable("Dining table 10", 8, false, 90, false, 10);
        DiningTable diningTable11 = new DiningTable("Dining table 11", 8, false, 90, false, 11);
        DiningTable diningTable12 = new DiningTable("Dining table 12", 8, false, 90, false, 12);
        diningTableRepository.saveAll(List.of(diningTable1, diningTable2, diningTable3, diningTable4, diningTable5, diningTable6, diningTable7, diningTable8, diningTable9, diningTable10, diningTable11, diningTable12));
    }
}