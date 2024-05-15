package dat3.bxb.configuration;

import dat3.bxb.airhockey.Airhockey;
import dat3.bxb.airhockey.AirhockeyRepository;
import dat3.bxb.bowlinglane.BowlingLane;
import dat3.bxb.bowlinglane.BowlingLaneRepository;
import dat3.bxb.diningtable.DiningTable;
import dat3.bxb.diningtable.DiningTableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {
    private final AirhockeyRepository airhockeyRepository;
    private final BowlingLaneRepository bowlingLaneRepository;
    private final DiningTableRepository diningTableRepository;

    public InitData(AirhockeyRepository airhockeyRepository, BowlingLaneRepository bowlingLaneRepository, DiningTableRepository diningTableRepository) {
        this.airhockeyRepository = airhockeyRepository;
        this.bowlingLaneRepository = bowlingLaneRepository;
        this.diningTableRepository = diningTableRepository;
    }

    @Override
        public void run(String... args) throws Exception {
            System.out.println("Hello from InitData");
            createAirhockeyTables();
            createBowlingLanes();
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

            BowlingLane bowlingLane1 = new BowlingLane("Bowling lane 1", 6, false, 60, false, 1);
            BowlingLane bowlingLane2 = new BowlingLane("Bowling lane 2", 6, false, 60, false, 2);
            BowlingLane bowlingLane3 = new BowlingLane("Bowling lane 3", 6, false, 60, false, 3);
            BowlingLane bowlingLane4 = new BowlingLane("Bowling lane 4", 6, false, 60, false, 4);
            BowlingLane bowlingLane5 = new BowlingLane("Bowling lane 5", 6, false, 60, false, 5);
            BowlingLane bowlingLane6 = new BowlingLane("Bowling lane 6", 6, false, 60, false, 6);
            BowlingLane bowlingLane7 = new BowlingLane("Bowling lane 7", 6, false, 60, false, 7);
            BowlingLane bowlingLane8 = new BowlingLane("Bowling lane 8", 6, false, 60, false, 8);
            BowlingLane bowlingLane9 = new BowlingLane("Bowling lane 9", 6, false, 60, false, 9);
            BowlingLane bowlingLane10 = new BowlingLane("Bowling lane 10", 6, false, 60, false, 10);
            BowlingLane bowlingLane11 = new BowlingLane("Bowling lane 11", 6, false, 60, false, 11);
            BowlingLane bowlingLane12 = new BowlingLane("Bowling lane 12", 6, false, 60, false, 12);
            BowlingLane bowlingLane13 = new BowlingLane("Bowling lane 13", 6, false, 60, false, 13);
            BowlingLane bowlingLane14 = new BowlingLane("Bowling lane 14", 6, false, 60, false, 14);
            BowlingLane bowlingLane15 = new BowlingLane("Bowling lane 15", 6, false, 60, false, 15);
            BowlingLane bowlingLane16 = new BowlingLane("Bowling lane 16", 6, false, 60, false, 16);
            BowlingLane bowlingLane17 = new BowlingLane("Bowling lane 17", 6, false, 60, false, 17);
            BowlingLane bowlingLane18 = new BowlingLane("Bowling lane 18", 6, false, 60, false, 18);
            BowlingLane bowlingLane19 = new BowlingLane("Bowling lane 19", 6, false, 60, false, 19);
            BowlingLane bowlingLane20 = new BowlingLane("Bowling lane 20", 6, false, 60, false, 20);
            BowlingLane bowlingLane21 = new BowlingLane("Bowling lane 21", 6, false, 60, false, 21);
            BowlingLane bowlingLane22 = new BowlingLane("Bowling lane 22", 6, false, 60, false, 22);
            BowlingLane bowlingLane23 = new BowlingLane("Bowling lane 23", 6, false, 60, false, 23);
            BowlingLane bowlingLane24 = new BowlingLane("Bowling lane 24", 6, false, 60, false, 24);
            bowlingLaneRepository.saveAll(List.of(bowlingLane1, bowlingLane2, bowlingLane3, bowlingLane4, bowlingLane5, bowlingLane6, bowlingLane7, bowlingLane8, bowlingLane9, bowlingLane10, bowlingLane11, bowlingLane12, bowlingLane13, bowlingLane14, bowlingLane15, bowlingLane16, bowlingLane17, bowlingLane18, bowlingLane19, bowlingLane20, bowlingLane21, bowlingLane22, bowlingLane23, bowlingLane24));
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
