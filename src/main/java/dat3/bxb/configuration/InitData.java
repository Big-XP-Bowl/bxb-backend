package dat3.bxb.configuration;

import dat3.bxb.activity.Activity;
import dat3.bxb.airhockey.Airhockey;
import dat3.bxb.airhockey.AirhockeyRepository;
import dat3.bxb.bowlinglane.BowlingLane;
import dat3.bxb.bowlinglane.BowlingLaneRepository;
import dat3.bxb.diningtable.DiningTable;
import dat3.bxb.diningtable.DiningTableRepository;
import dat3.bxb.employee.Employee;
import dat3.bxb.employee.EmployeeRepository;
import dat3.bxb.equipment.pin.Pin;
import dat3.bxb.equipment.pin.PinRepository;
import dat3.bxb.product.Product;
import dat3.bxb.product.ProductRepository;
import dat3.bxb.reservation.Reservation;
import dat3.bxb.reservation.ReservationRepository;
import dat3.bxb.schedule.Schedule;
import dat3.bxb.schedule.ScheduleRepository;
import dat3.bxb.equipment.shoe.Shoe;
import dat3.bxb.equipment.shoe.ShoeRepository;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class InitData implements CommandLineRunner {
    private final AirhockeyRepository airhockeyRepository;
    private final BowlingLaneRepository bowlingLaneRepository;
    private final DiningTableRepository diningTableRepository;
    private final ReservationRepository reservationRepository;
    private final UserWithRolesRepository userWithRolesRepository;
    private final EmployeeRepository employeeRepository;
    private final ScheduleRepository scheduleRepository;
    private final ProductRepository productRepository;
    private final PinRepository pinRepository;
    private final ShoeRepository shoeRepository;

    public InitData(AirhockeyRepository airhockeyRepository, BowlingLaneRepository bowlingLaneRepository, ReservationRepository reservationRepository, UserWithRolesRepository userWithRolesRepository, DiningTableRepository diningTableRepository, EmployeeRepository employeeRepository, ScheduleRepository scheduleRepository, ProductRepository productRepository, PinRepository pinRepository, ShoeRepository shoeRepository) {
        this.airhockeyRepository = airhockeyRepository;
        this.bowlingLaneRepository = bowlingLaneRepository;
        this.diningTableRepository = diningTableRepository;
        this.reservationRepository = reservationRepository;
        this.userWithRolesRepository = userWithRolesRepository;
        this.employeeRepository = employeeRepository;
        this.scheduleRepository = scheduleRepository;
        this.productRepository = productRepository;
        this.pinRepository = pinRepository;
        this.shoeRepository = shoeRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello from InitData");
        createAirhockeyTables();
        createBowlingLanes();
        createDiningTables();
        createReservations();
        createEmployees();
        createSchedules();
        createProducts();
        createPins();
        createShoes();
    }

    public void createAirhockeyTables() {
        System.out.println("Creating Airhockey tables");

        List<Airhockey> airhockeyTables = List.of(
                new Airhockey("Airhockey 1", 4, false, 30, true, 1),
                new Airhockey("Airhockey 2", 4, false, 30, true, 2),
                new Airhockey("Airhockey 3", 4, false, 30, true, 3),
                new Airhockey("Airhockey 4", 4, false, 30, true, 4),
                new Airhockey("Airhockey 5", 4, false, 30, true, 5),
                new Airhockey("Airhockey 6", 4, false, 30, true, 6)
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

    public void createReservations(){
        System.out.println("Creating reservations");

        Activity activity = airhockeyRepository.findById(1);
        Activity activity1 = bowlingLaneRepository.findById(7);
        Activity activity2 = diningTableRepository.findById(32);
        Activity activity3 = airhockeyRepository.findById(2);
        Activity activity4 = bowlingLaneRepository.findById(8);
        Activity activity6 = airhockeyRepository.findById(3);
        Activity activity7 = bowlingLaneRepository.findById(9);
        Activity activity9 = airhockeyRepository.findById(4);
        Activity activity10 = bowlingLaneRepository.findById(10);
        Activity activity11 = bowlingLaneRepository.findById(11);
        Activity activity12 = bowlingLaneRepository.findById(12);
        Activity activity13 = bowlingLaneRepository.findById(13);
        Activity activity14 = bowlingLaneRepository.findById(14);
        Activity activity15 = bowlingLaneRepository.findById(15);
        Activity activity16 = bowlingLaneRepository.findById(16);
        Activity activity17 = bowlingLaneRepository.findById(17);
        Activity activity18 = bowlingLaneRepository.findById(18);
        Activity activity19 = bowlingLaneRepository.findById(19);
        Activity activity20 = bowlingLaneRepository.findById(20);
        Activity activity21 = bowlingLaneRepository.findById(21);
        Activity activity22 = bowlingLaneRepository.findById(22);
        Activity activity23 = bowlingLaneRepository.findById(23);
        Activity activity24 = bowlingLaneRepository.findById(24);
        Activity activity25 = bowlingLaneRepository.findById(25);
        Activity activity26 = bowlingLaneRepository.findById(26);
        Activity activity27 = bowlingLaneRepository.findById(27);
        Activity activity28 = bowlingLaneRepository.findById(28);
        Activity activity29 = bowlingLaneRepository.findById(29);
        Activity activity30 = diningTableRepository.findById(33);
        Activity activity31 = diningTableRepository.findById(34);
        Activity activity32 = diningTableRepository.findById(35);
        Activity activity33 = diningTableRepository.findById(36);
        Activity activity34 = diningTableRepository.findById(37);
        Activity activity35 = diningTableRepository.findById(38);
        Activity activity36 = diningTableRepository.findById(39);
        Activity activity37 = diningTableRepository.findById(40);
        Activity activity38 = diningTableRepository.findById(41);
        Activity activity39 = diningTableRepository.findById(42);





        String username1 = "user1";

        UserWithRoles userWithRoles = userWithRolesRepository.findByUsername(username1);

        LocalDateTime startTime = LocalDateTime.of(2024, 6, 8, 10, 0); // Example start time
        LocalDateTime startTime1 = LocalDateTime.of(2024, 6, 8, 11, 0);
        LocalDateTime startTime2 = LocalDateTime.of(2024, 6, 8, 12, 0);
        LocalDateTime startTime3 = LocalDateTime.of(2024, 6, 8, 13, 0);
        LocalDateTime startTime4 = LocalDateTime.of(2024, 6, 8, 14, 0);
        LocalDateTime startTime5 = LocalDateTime.of(2024, 6, 8, 15, 0);
        LocalDateTime startTime6 = LocalDateTime.of(2024, 6, 8, 16, 0);
        LocalDateTime startTime7 = LocalDateTime.of(2024, 6, 8, 17, 0);
        LocalDateTime startTime8 = LocalDateTime.of(2024, 6, 8, 18, 0);
        LocalDateTime startTime9 = LocalDateTime.of(2024, 6, 8, 19, 0);
        LocalDateTime startTime10 = LocalDateTime.of(2024, 6, 8, 20, 0);
        LocalDateTime startTime11 = LocalDateTime.of(2024, 6, 8, 21, 0);
        LocalDateTime startTime12 = LocalDateTime.of(2024, 6, 8, 17, 30);
        LocalDateTime startTime13 = LocalDateTime.of(2024, 6, 8, 20, 30);

        List<Reservation> reservations = List.of(
                new Reservation(activity, startTime, 4, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity3, startTime, 4, userWithRoles, "John Doe", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity6, startTime, 4, userWithRoles, "Jane Smith", "87654321", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity9, startTime, 4, userWithRoles, "Alice Brown", "11223344", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime, 4, userWithRoles, "Bob Johnson", "55667788", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime, 4, userWithRoles, "Charlie Green", "22334455", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime, 4, userWithRoles, "Dave Black", "99887766", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime1, 3, userWithRoles, "Eve White", "44332211", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity3, startTime1, 4, userWithRoles, "Frank Yellow", "66778899", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity6, startTime1, 4, userWithRoles, "Grace Pink", "11002233", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime1, 4, userWithRoles, "Hank Blue", "44556677", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime1, 4, userWithRoles, "Ivy Red", "77889900", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime1, 4, userWithRoles, "Jack Grey", "99001122", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime2, 2, userWithRoles, "Karen Gold", "33221144", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime3, 2, userWithRoles, "Leo Silver", "55443322", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime3, 4, userWithRoles, "Mia Bronze", "77665544", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime3, 4, userWithRoles, "Nina Copper", "99880011", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime3, 4, userWithRoles, "Oscar Platinum", "11220033", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime4, 2, userWithRoles, "Pauline Diamond", "33445566", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime3, 3, userWithRoles, "Quincy Sapphire", "55667700", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime4, 4, userWithRoles, "Rachel Emerald", "77880099", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime4, 4, userWithRoles, "Sam Amber", "99002211", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime4, 4, userWithRoles, "Tina Onyx", "11223355", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity3, startTime4, 4, userWithRoles, "Ursula Jade", "22334466", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity6, startTime5, 4, userWithRoles, "Victor Pearl", "44556688", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime5, 3, userWithRoles, "Wendy Quartz", "66778811", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime6, 4, userWithRoles, "Xander Topaz", "88990022", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime6, 4, userWithRoles, "Yara Opal", "11224455", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime6, 4, userWithRoles, "Zane Ruby", "33446677", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime6, 5, userWithRoles, "Alan Emerald", "55668899", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime7, 6, userWithRoles, "Betty Sapphire", "77880022", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime6, 3, userWithRoles, "Carl Diamond", "99001133", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime7, 4, userWithRoles, "Dana Silver", "11223344", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime7, 4, userWithRoles, "Eli Gold", "22334455", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime7, 4, userWithRoles, "Faith Bronze", "33445566", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity3, startTime7, 4, userWithRoles, "George Copper", "44556677", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity6, startTime8, 4, userWithRoles, "Holly Platinum", "55667788", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime8, 4, userWithRoles, "Ivy Amber", "66778899", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime9, 3, userWithRoles, "Jack Red", "77889900", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity3, startTime9, 4, userWithRoles, "Kara Black", "88990011", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime9, 4, userWithRoles, "Leo White", "99001122", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime9, 4, userWithRoles, "Alice Smith", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime9, 4, userWithRoles, "Bob Johnson", "87654321", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity6, startTime9, 4, userWithRoles, "Carol Davis", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime9, 3, userWithRoles, "David Miller", "98765432", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime10, 4, userWithRoles, "Eva Brown", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime10, 3, userWithRoles, "Frank Wilson", "09876543", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity3, startTime10, 4, userWithRoles, "Grace Moore", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime10, 4, userWithRoles, "Hank Taylor", "10987654", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime10, 4, userWithRoles, "Ivy Anderson", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime10, 4, userWithRoles, "Jack Thomas", "21098765", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity6, startTime10, 4, userWithRoles, "Karen Martinez", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime11, 1, userWithRoles, "Sanne Loeb", "42424242", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime11, 3, userWithRoles, "Leo Harris", "32109876", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity3, startTime11, 4, userWithRoles, "Mona Clark", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity6, startTime11, 4, userWithRoles, "Nina Lewis", "43210987", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime11, 4, userWithRoles, "Oscar Walker", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity4, startTime11, 4, userWithRoles, "Paul King", "54321098", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity7, startTime11, 4, userWithRoles, "Quinn Scott", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity9, startTime11, 4, userWithRoles, "Rita Young", "65432109", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity2, startTime, 2, userWithRoles, "Hannes Bøhl", "42424242", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity2, startTime1, 4, userWithRoles, "Tom Baker", "76543210", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity2, startTime2, 6, userWithRoles, "Uma Perez", "87654321", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity2, startTime3, 8, userWithRoles, "Victor Roberts", "98765432", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity2, startTime4, 2, userWithRoles, "Wendy Nelson", "09876543", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity2, startTime5, 4, userWithRoles, "Xander Lee", "12345678", LocalDateTime.now(), LocalDateTime.now()),

                // New

        new Reservation(activity10, startTime, 4, userWithRoles, "Alice Smith", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity11, startTime1, 4, userWithRoles, "Bob Johnson", "87654321", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity12, startTime2, 4, userWithRoles, "Carol Davis", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity13, startTime3, 4, userWithRoles, "David Miller", "98765432", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity14, startTime4, 4, userWithRoles, "Eva Brown", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity15, startTime5, 4, userWithRoles, "Frank Wilson", "09876543", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity16, startTime6, 4, userWithRoles, "Grace Moore", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity17, startTime7, 4, userWithRoles, "Hank Taylor", "10987654", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity18, startTime8, 4, userWithRoles, "Ivy Anderson", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity19, startTime9, 4, userWithRoles, "Jack Thomas", "21098765", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity20, startTime10, 4, userWithRoles, "Karen Martinez", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity21, startTime11, 4, userWithRoles, "Leo Harris", "32109876", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity22, startTime, 4, userWithRoles, "Mona Clark", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity23, startTime1, 4, userWithRoles, "Nina Lewis", "43210987", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity24, startTime2, 4, userWithRoles, "Oscar Walker", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity25, startTime3, 4, userWithRoles, "Paul King", "54321098", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity26, startTime4, 4, userWithRoles, "Quinn Scott", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity27, startTime5, 4, userWithRoles, "Rita Young", "65432109", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity28, startTime6, 4, userWithRoles, "Tom Baker", "76543210", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity29, startTime7, 4, userWithRoles, "Uma Perez", "87654321", LocalDateTime.now(), LocalDateTime.now()),

                new Reservation(activity10, startTime9, 4, userWithRoles, "Wendy Nelson", "09876543", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity11, startTime10, 4, userWithRoles, "Xander Lee", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity12, startTime11, 4, userWithRoles, "Yara Kim", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity13, startTime, 4, userWithRoles, "Zane Morgan", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity14, startTime1, 4, userWithRoles, "Amy Green", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity15, startTime2, 4, userWithRoles, "Ben White", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity16, startTime3, 4, userWithRoles, "Clara Black", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity17, startTime4, 4, userWithRoles, "Danielle Blue", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity18, startTime5, 4, userWithRoles, "Ethan Grey", "89012345", LocalDateTime.now(), LocalDateTime.now()),

                new Reservation(activity19, startTime6, 4, userWithRoles, "Fiona Gold", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity20, startTime7, 4, userWithRoles, "George Silver", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity21, startTime8, 4, userWithRoles, "Helen Bronze", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity22, startTime9, 4, userWithRoles, "Ian Copper", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity23, startTime10, 4, userWithRoles, "Judy Platinum", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity24, startTime11, 4, userWithRoles, "Karl Mercury", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity25, startTime, 4, userWithRoles, "Lily Tin", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity26, startTime1, 4, userWithRoles, "Mike Steel", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity27, startTime2, 4, userWithRoles, "Nina Iron", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity28, startTime3, 4, userWithRoles, "Oliver Brass", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity29, startTime4, 4, userWithRoles, "Paula Lead", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity10, startTime7, 4, userWithRoles, "Sam Tin", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity11, startTime8, 4, userWithRoles, "Tina Silver", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity12, startTime9, 4, userWithRoles, "Uma Copper", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity13, startTime10, 4, userWithRoles, "Vera Platinum", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity14, startTime11, 4, userWithRoles, "Walt Mercury", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity15, startTime, 4, userWithRoles, "Xena Tin", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity16, startTime1, 4, userWithRoles, "Yvonne Steel", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity17, startTime2, 4, userWithRoles, "Zack Iron", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity18, startTime3, 4, userWithRoles, "Amy Brass", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity19, startTime4, 4, userWithRoles, "Ben Lead", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity20, startTime5, 4, userWithRoles, "Clara Zinc", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity21, startTime6, 4, userWithRoles, "Dan Nickel", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity22, startTime7, 4, userWithRoles, "Eva Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity23, startTime8, 4, userWithRoles, "Frank Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity24, startTime9, 4, userWithRoles, "Grace Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity25, startTime10, 4, userWithRoles, "Hank Platinum", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity26, startTime11, 4, userWithRoles, "Ivy Mercury", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity27, startTime, 4, userWithRoles, "Jack Tin", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity28, startTime1, 4, userWithRoles, "Kara Steel", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity29, startTime2, 4, userWithRoles, "Liam Iron", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity10, startTime5, 4, userWithRoles, "Opal Zinc", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity11, startTime6, 4, userWithRoles, "Paul Nickel", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity12, startTime7, 4, userWithRoles, "Quinn Tin", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity13, startTime8, 4, userWithRoles, "Rose Silver", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity14, startTime9, 4, userWithRoles, "Steve Copper", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity15, startTime10, 4, userWithRoles, "Tina Platinum", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity16, startTime11, 4, userWithRoles, "Uma Mercury", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity17, startTime, 4, userWithRoles, "Victor Tin", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity18, startTime1, 4, userWithRoles, "Wanda Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity19, startTime2, 4, userWithRoles, "Xander Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity20, startTime3, 4, userWithRoles, "Yvonne Brass", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity21, startTime4, 4, userWithRoles, "Zara Lead", "56789012", LocalDateTime.now(), LocalDateTime.now()),

                new Reservation(activity22, startTime9, 2, userWithRoles, "Alice Brown", "09876543", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity23, startTime10, 3, userWithRoles, "Bob Green", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity24, startTime11, 4, userWithRoles, "Carol White", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity25, startTime9, 5, userWithRoles, "David Black", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity26, startTime10, 6, userWithRoles, "Eva Silver", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity27, startTime11, 2, userWithRoles, "Frank Gold", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity28, startTime9, 3, userWithRoles, "Grace Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity29, startTime10, 4, userWithRoles, "Hank Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity10, startTime11, 5, userWithRoles, "Ivy Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity11, startTime9, 6, userWithRoles, "Jack Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity12, startTime10, 2, userWithRoles, "Karen Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity13, startTime11, 3, userWithRoles, "Leo Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity14, startTime9, 4, userWithRoles, "Mona Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity15, startTime10, 5, userWithRoles, "Nina Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity16, startTime11, 6, userWithRoles, "Oscar Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity17, startTime9, 2, userWithRoles, "Paul Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity18, startTime10, 3, userWithRoles, "Quinn Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity19, startTime11, 4, userWithRoles, "Rita Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity20, startTime9, 5, userWithRoles, "Sam Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity21, startTime10, 6, userWithRoles, "Tina Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity22, startTime11, 2, userWithRoles, "Uma Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity23, startTime9, 3, userWithRoles, "Victor Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity24, startTime10, 4, userWithRoles, "Wanda Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity25, startTime11, 5, userWithRoles, "Xander Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity26, startTime9, 6, userWithRoles, "Yvonne Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity27, startTime10, 2, userWithRoles, "Zara Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity28, startTime11, 3, userWithRoles, "Alice Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity29, startTime9, 4, userWithRoles, "Bob Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity10, startTime10, 5, userWithRoles, "Carol Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity11, startTime11, 6, userWithRoles, "David Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity12, startTime9, 2, userWithRoles, "Eva Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity13, startTime10, 3, userWithRoles, "Frank Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity14, startTime11, 4, userWithRoles, "Grace Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity15, startTime9, 5, userWithRoles, "Hank Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity16, startTime10, 6, userWithRoles, "Ivy Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity17, startTime11, 2, userWithRoles, "Jack Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity18, startTime9, 3, userWithRoles, "Karen Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity19, startTime10, 4, userWithRoles, "Leo Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity20, startTime11, 5, userWithRoles, "Mona Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity21, startTime9, 6, userWithRoles, "Nina Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity22, startTime10, 2, userWithRoles, "Oscar Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity23, startTime11, 3, userWithRoles, "Paul Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity24, startTime9, 4, userWithRoles, "Quinn Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity25, startTime10, 5, userWithRoles, "Rita Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity26, startTime11, 6, userWithRoles, "Sam Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),

                new Reservation(activity30, startTime9, 2, userWithRoles, "Ava Brown", "09876543", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity31, startTime12, 3, userWithRoles, "Ben Green", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity32, startTime13, 4, userWithRoles, "Cara White", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity33, startTime9, 5, userWithRoles, "Dylan Black", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity34, startTime12, 6, userWithRoles, "Ella Silver", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity35, startTime13, 2, userWithRoles, "Finn Gold", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity36, startTime9, 3, userWithRoles, "Grace Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity37, startTime12, 4, userWithRoles, "Hank Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity38, startTime13, 5, userWithRoles, "Ivy Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity39, startTime9, 6, userWithRoles, "Jack Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity30, startTime12, 2, userWithRoles, "Karen Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity31, startTime13, 3, userWithRoles, "Leo Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity32, startTime9, 4, userWithRoles, "Mona Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity33, startTime12, 5, userWithRoles, "Nina Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity34, startTime13, 6, userWithRoles, "Oscar Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity35, startTime9, 2, userWithRoles, "Paul Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity36, startTime12, 3, userWithRoles, "Quinn Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity37, startTime13, 4, userWithRoles, "Rita Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity38, startTime9, 5, userWithRoles, "Sam Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity39, startTime12, 6, userWithRoles, "Tina Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity30, startTime13, 2, userWithRoles, "Ulysses Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity31, startTime9, 3, userWithRoles, "Vera Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity32, startTime12, 4, userWithRoles, "Walter Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity33, startTime13, 5, userWithRoles, "Xena Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity34, startTime9, 6, userWithRoles, "Yara Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity35, startTime12, 2, userWithRoles, "Zane Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity36, startTime13, 3, userWithRoles, "Ava Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity37, startTime9, 4, userWithRoles, "Ben Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity38, startTime12, 5, userWithRoles, "Cara Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity39, startTime13, 6, userWithRoles, "Dylan Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity30, startTime9, 2, userWithRoles, "Ella Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity31, startTime12, 3, userWithRoles, "Finn Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity32, startTime13, 4, userWithRoles, "Grace Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity33, startTime9, 5, userWithRoles, "Hank Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity34, startTime12, 6, userWithRoles, "Ivy Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity35, startTime13, 2, userWithRoles, "Jack Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity36, startTime9, 3, userWithRoles, "Karen Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity37, startTime12, 4, userWithRoles, "Leo Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity38, startTime13, 5, userWithRoles, "Mona Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity39, startTime9, 6, userWithRoles, "Nina Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity30, startTime12, 2, userWithRoles, "Oscar Lead", "01234567", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity31, startTime13, 3, userWithRoles, "Paul Brass", "12345678", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity32, startTime9, 4, userWithRoles, "Quinn Steel", "23456789", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity33, startTime12, 5, userWithRoles, "Rita Iron", "34567890", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity34, startTime13, 6, userWithRoles, "Sam Tin", "45678901", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity35, startTime9, 2, userWithRoles, "Tina Silver", "56789012", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity36, startTime12, 3, userWithRoles, "Ulysses Copper", "67890123", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity37, startTime13, 4, userWithRoles, "Vera Mercury", "78901234", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity38, startTime9, 5, userWithRoles, "Walter Zinc", "89012345", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity39, startTime12, 6, userWithRoles, "Xena Nickel", "90123456", LocalDateTime.now(), LocalDateTime.now())
        );

        for (Reservation reservation : reservations) {
            // Check if a reservation for the same activity already exists
            List<Reservation> existingReservations = reservationRepository.findByActivityIdAndStartTime(reservation.getActivity().getId(), reservation.getStartTime());
            if (existingReservations.isEmpty()) {
                // If no such reservation exists, save the new one
                reservationRepository.save(reservation);
            }
        }
    }

    public void createEmployees() {
        System.out.println("Creating employees");

        List<Employee> employees = List.of(
                new Employee(Employee.EmpType.MANAGER, "Tove Ditlevsen", "JD", "https://images.pexels.com/photos/762020/pexels-photo-762020.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" ),
                new Employee(Employee.EmpType.MANAGER, "Abdi Mohammed", "AM", "https://images.pexels.com/photos/1722198/pexels-photo-1722198.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1s"),
                new Employee(Employee.EmpType.BAR, "Hannie Olsen", "HO", "https://images.pexels.com/photos/1181519/pexels-photo-1181519.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
                new Employee(Employee.EmpType.BAR, "Karen Larsen", "KL", "https://images.pexels.com/photos/3786525/pexels-photo-3786525.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
                new Employee(Employee.EmpType.BAR, "Mogens Krogh", "HS", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOxEFysJCpJGiUaKyUnDwZxI14edrFaHe7m5ThU87gNQ&s"),
                new Employee(Employee.EmpType.BAR, "John Faxe", "LL", "https://pbs.twimg.com/profile_images/378800000301376130/581005c77dfaf0e2ff5987209cae3f37_400x400.png"),
                new Employee(Employee.EmpType.MAINTENANCE, "Sanne Sanger", "SS", "https://images.pexels.com/photos/3807770/pexels-photo-3807770.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
                new Employee(Employee.EmpType.MAINTENANCE, "Anne Jensen", "AJ", "https://images.pexels.com/photos/5384445/pexels-photo-5384445.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
                new Employee(Employee.EmpType.CLEANING, "Lone Jensen", "LJ", "https://images.pexels.com/photos/5876695/pexels-photo-5876695.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
                new Employee(Employee.EmpType.CLEANING, "John Smed", "JS", "https://images.pexels.com/photos/3777947/pexels-photo-3777947.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"),
                new Employee(Employee.EmpType.CLEANING, "Craig Larman", "CL", "https://certification.scrumalliance.org/system/members/photos/000/000/056/200x200/craig_larman_-_head_-_square_-_1000_x_1000_-_sept_2017_-_orig_background.png?1543438389"),
                new Employee(Employee.EmpType.CLEANING, "Linux Thorvalds", "LT", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcR2a8LLjkXzYOMMMUVGQES3mrBHRxb5cyHW7DNzxnt7aVRkHItR")
        );

        for (Employee employee : employees) {
            Employee existingEmployee = employeeRepository.findByName(employee.getName());
            if (existingEmployee == null) {
                employeeRepository.save(employee);
            }
        }
    }

    public void createSchedules() {
        System.out.println("Creating schedules");

        List<Integer> employeeIds = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Employee> employees = employeeRepository.findAllById(employeeIds);

        if (employees.size() != employeeIds.size()) {
            System.out.println("Error: One or more employees not found.");
            return;
        }

        List<Schedule> schedules = List.of(
                // Morning shift on June 8, 2024
                new Schedule(LocalDateTime.of(2024, 6, 8, 9, 0), LocalDateTime.of(2024, 6, 8, 16, 0), employees.get(0)), // Manager
                new Schedule(LocalDateTime.of(2024, 6, 8, 9, 0), LocalDateTime.of(2024, 6, 8, 16, 0), employees.get(2)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 8, 9, 0), LocalDateTime.of(2024, 6, 8, 16, 0), employees.get(3)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 8, 9, 0), LocalDateTime.of(2024, 6, 8, 16, 0), employees.get(6)), // Maintenance
                new Schedule(LocalDateTime.of(2024, 6, 8, 9, 0), LocalDateTime.of(2024, 6, 8, 16, 0), employees.get(8)), // Cleaning
                new Schedule(LocalDateTime.of(2024, 6, 8, 9, 0), LocalDateTime.of(2024, 6, 8, 16, 0), employees.get(9)), // Cleaning
                // Evening shift on June 8, 2024
                new Schedule(LocalDateTime.of(2024, 6, 8, 16, 0), LocalDateTime.of(2024, 6, 8, 23, 0), employees.get(1)), // Manager
                new Schedule(LocalDateTime.of(2024, 6, 8, 16, 0), LocalDateTime.of(2024, 6, 8, 23, 0), employees.get(4)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 8, 16, 0), LocalDateTime.of(2024, 6, 8, 23, 0), employees.get(5)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 8, 16, 0), LocalDateTime.of(2024, 6, 8, 23, 0), employees.get(7)), // Maintenance
                new Schedule(LocalDateTime.of(2024, 6, 8, 16, 0), LocalDateTime.of(2024, 6, 8, 23, 0), employees.get(10)), // Cleaning
                new Schedule(LocalDateTime.of(2024, 6, 8, 16, 0), LocalDateTime.of(2024, 6, 8, 23, 0), employees.get(11)), // Cleaning
                // Morning shift on June 9, 2024
                new Schedule(LocalDateTime.of(2024, 6, 9, 9, 0), LocalDateTime.of(2024, 6, 9, 16, 0), employees.get(0)), // Manager
                new Schedule(LocalDateTime.of(2024, 6, 9, 9, 0), LocalDateTime.of(2024, 6, 9, 16, 0), employees.get(2)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 9, 9, 0), LocalDateTime.of(2024, 6, 9, 16, 0), employees.get(3)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 9, 9, 0), LocalDateTime.of(2024, 6, 9, 16, 0), employees.get(6)), // Maintenance
                new Schedule(LocalDateTime.of(2024, 6, 9, 9, 0), LocalDateTime.of(2024, 6, 9, 16, 0), employees.get(8)), // Cleaning
                new Schedule(LocalDateTime.of(2024, 6, 9, 9, 0), LocalDateTime.of(2024, 6, 9, 16, 0), employees.get(9)), // Cleaning
                // Evening shift on June 9, 2024
                new Schedule(LocalDateTime.of(2024, 6, 9, 16, 0), LocalDateTime.of(2024, 6, 9, 23, 0), employees.get(1)), // Manager
                new Schedule(LocalDateTime.of(2024, 6, 9, 16, 0), LocalDateTime.of(2024, 6, 9, 23, 0), employees.get(4)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 9, 16, 0), LocalDateTime.of(2024, 6, 9, 23, 0), employees.get(5)), // Bar
                new Schedule(LocalDateTime.of(2024, 6, 9, 16, 0), LocalDateTime.of(2024, 6, 9, 23, 0), employees.get(7)), // Maintenance
                new Schedule(LocalDateTime.of(2024, 6, 9, 16, 0), LocalDateTime.of(2024, 6, 9, 23, 0), employees.get(10)), // Cleaning
                new Schedule(LocalDateTime.of(2024, 6, 9, 16, 0), LocalDateTime.of(2024, 6, 9, 23, 0), employees.get(11))  // Cleaning
        );

        for (Schedule schedule : schedules) {
            // Check if the same employee is already scheduled for the same shift
            if (!scheduleRepository.existsByEmployee_IdAndStartTime(schedule.getEmployee().getId(), schedule.getStartTime())) {
                // If no such schedule exists, save the new one
                try {
                    scheduleRepository.save(schedule);
                } catch (IllegalArgumentException e) {
                    System.out.println("Validation error: " + e.getMessage());
                }
            }
        }
    }

    public void createProducts() {
        System.out.println("Creating Products");

        List<Product> products = List.of(
                new Product(Product.Category.DRINK, "https://images.pexels.com/photos/7429792/pexels-photo-7429792.jpeg", 25.0, "Coca Cola"),
                new Product(Product.Category.DRINK, "https://images.pexels.com/photos/6223375/pexels-photo-6223375.jpeg", 45.0, "Øl"),
                new Product(Product.Category.DRINK, "https://c.pxhere.com/images/cf/9a/2996322f6e4e1c49c8bdaf67f459-1434971.jpg!d", 20.0, "Mineralvand"),
                new Product(Product.Category.SNACK, "https://live.staticflickr.com/1552/25301746624_8752d4bd1c_b.jpg", 15.0, "Kartoffelchips"),
                new Product(Product.Category.SNACK, "https://images.pexels.com/photos/7234396/pexels-photo-7234396.jpeg", 10.0, "Popcorn"),
                new Product(Product.Category.DRINK, "https://images.pexels.com/photos/8679343/pexels-photo-8679343.jpeg", 30.0, "Appelsinjuice"),
                new Product(Product.Category.SNACK, "https://images.pexels.com/photos/5472169/pexels-photo-5472169.jpeg", 20.0, "Nødder"),
                new Product(Product.Category.SNACK, "https://images.pexels.com/photos/5744302/pexels-photo-5744302.jpeg", 15.0, "Slik"),
                new Product(Product.Category.DRINK, "https://live.staticflickr.com/4392/35968783350_547823ebf1_b.jpg", 60.0, "Rødvin"),
                new Product(Product.Category.DRINK, "https://images.pexels.com/photos/107556/pexels-photo-107556.jpeg", 60.0, "Hvidvin"),
                new Product(Product.Category.DRINK, "https://c.pxhere.com/photos/81/f9/cup_of_coffee_coffee_beans-617211.jpg!d", 20.0, "Kaffe"),
                new Product(Product.Category.DRINK, "https://www.oplevbyen.dk/wp-content/uploads/2018/01/22555104_1892488500769067_7614522938237404698_n-777x437.jpg", 15.0, "Te"),
                new Product(Product.Category.DRINK, "https://www.oplevbyen.dk/wp-content/uploads/2018/01/22555104_1892488500769067_7614522938237404698_n-777x437.jpg", 15.0, "Grøn te")
        );

        for (Product product : products) {
            if (!productRepository.existsByName(product.getName())) {
                productRepository.save(product);
            }
        }
    }

    public void createPins() {
        System.out.println("Creating Pins");
        List<Pin> pins = new ArrayList<>();

        for (int i = 0; i < 240; i++) { // 24 lanes x 10 pins
            pins.add(new Pin());
        }

        // Adding 50 spare pins
        for (int i = 0; i < 50; i++) {
            pins.add(new Pin());
        }

        pinRepository.saveAll(pins);
    }

    private void createShoes() {
        Set<Shoe> existingShoes = new HashSet<>(shoeRepository.findAll());

        // Shoes pr. size
        int shoesPerSize = 10;

        // List of shoes
        List<Integer> sizes = List.of(38, 40, 42, 44, 46);

        List<Shoe> shoes = new ArrayList<>();

        // Create shoes pr. size
        for (Integer size : sizes) {
            for (int i = 0; i < shoesPerSize; i++) {
                Shoe shoe = new Shoe(size);
                shoes.add(shoe);
            }
        }

        // Check if shoes already exist in the database
        if (existingShoes.isEmpty()) {
            shoeRepository.saveAll(shoes);
            System.out.println("Shoes initialized successfully.");
        } else {
            System.out.println("Shoes already exist in the database.");
        }
    }
}