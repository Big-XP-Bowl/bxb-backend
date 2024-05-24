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

        List<Reservation> reservations = List.of(
                new Reservation(activity, startTime, 4, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime1, 3, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime2, 2, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity, startTime3, 2, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime4, 2, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime5, 3, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime6, 5, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime7, 6, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime8, 4, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime9, 3, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime10, 4, userWithRoles, "Hanne Boel", "24242424", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity1, startTime11, 1, userWithRoles, "Sanne Loeb", "42424242", LocalDateTime.now(), LocalDateTime.now()),
                new Reservation(activity2, startTime, 2, userWithRoles, "Hannes Bøhl", "42424242", LocalDateTime.now(), LocalDateTime.now())

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
                new Employee(Employee.EmpType.MANAGER, "Tove Ditlevsen", "JD", "https://www.shutterstock.com/da/image-photo/headshot-close-portrait-latin-hispanic-confident-2343004129" ),
                new Employee(Employee.EmpType.MANAGER, "Abdi Mohammed", "AM", "https://www.shutterstock.com/da/image-photo/headshot-portrait-young-adult-confident-smiling-2115297218"),
                new Employee(Employee.EmpType.BAR, "Hannie Olsen", "HO", "https://www.shutterstock.com/da/image-photo/headshot-portrait-happy-indian-millennial-girl-1529381102"),
                new Employee(Employee.EmpType.BAR, "Karen Larsen", "KL", "https://www.shutterstock.com/da/image-photo/stylish-confident-adult-50-years-old-1972000787"),
                new Employee(Employee.EmpType.BAR, "Mogens Krogh", "HS", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOxEFysJCpJGiUaKyUnDwZxI14edrFaHe7m5ThU87gNQ&s"),
                new Employee(Employee.EmpType.BAR, "John Faxe", "LL", "https://pbs.twimg.com/profile_images/378800000301376130/581005c77dfaf0e2ff5987209cae3f37_400x400.png"),
                new Employee(Employee.EmpType.MAINTENANCE, "Sanne Sanger", "SS", "https://www.shutterstock.com/da/image-photo/head-shot-portrait-smart-confident-smiling-1721092123"),
                new Employee(Employee.EmpType.MAINTENANCE, "Anne Jensen", "AJ", "https://www.shutterstock.com/da/image-photo/happy-millennial-business-woman-glasses-posing-2103373409"),
                new Employee(Employee.EmpType.CLEANING, "Lone Jensen", "LJ", "https://www.shutterstock.com/da/image-photo/headshot-portrait-happy-ginger-girl-freckles-623804987"),
                new Employee(Employee.EmpType.CLEANING, "John Smed", "JS", "https://www.shutterstock.com/da/image-photo/black-athlete-fitness-trainer-portrait-muscular-1506106214"),
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