package lesson0201;

public class MainApp0201 {

    public static void main(String[] args) {

        Duothlon[] participants = {
                new Human("Bob"),
                new Human("John"),
                new Cat("Tom"),
                new Robot("R2B2"),
                new Cat("Jerry"),
                new Human("Paul"),
                new Robot("Harris2000"),
                new Cat("Falk"),
                new Robot("6$8#")
        };

        Obstacle[] obstacles = {
                new Wall(1),
                new Treadmill(10000),
                new Wall(2),
                new Treadmill(40000),
                new Wall(3),
                new Treadmill(80000),
        };

        for (Obstacle obstacle: obstacles) {

            System.out.println("-------------------------------------------------");
            obstacle.Info();
            System.out.println("");

            for (Duothlon participant: participants) {
                participant.Info();
                if (participant.isOnDistance()) {
                    obstacle.DoIt(participant);
                }
            }

            System.out.println("");
        }
    }
}
