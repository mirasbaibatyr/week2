import Gym_system.Member;
import Gym_system.Trainers;
import Gym_system.FitnessClass;
import Gym_system.Equipment;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to MIKO's GYM System");

        Member m1 = new Member(1, "MIko", 18, true);
        System.out.println(m1.renewMembership());
        System.out.println("Rate: " + m1.calculateDiscountCategory());

        Trainers t1 = new Trainers(101, "Arnold", "Bodybuilding", 10);
        System.out.println("Trainer Level: " + t1.checkExpertiseLevel());
        System.out.println("Can teach Yoga? " + t1.matchSpecialization("Yoga"));

        FitnessClass c1 = new FitnessClass(201, "HIIT", t1, 2);
        c1.bookSpot();
        c1.bookSpot();
        c1.bookSpot();
        System.out.println("Spots left: " + c1.getVacancyCount());

        Equipment e1 = new Equipment(301, "Treadmill", "Good", true);
        e1.reportDamage();
        System.out.println("Is Treadmill available? " + e1.isAvailable());
        e1.performMaintenance();
    }
}
