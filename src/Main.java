import java.time.LocalDate;
import java.util.*;

public class Main {
    private static void printInfo(Cars car) {
        System.out.print("Информация об авто, участвующем в заезде:" +
                " марка " + car.getBrand() + ", модель " + car.getModel());
        System.out.print(", водитель - ");
        for (Driver<?> driver : car.getDriversForRace()) {
            System.out.print(driver.getName());
        }
        System.out.print(", спонсоры - ");
        for (Sponsor sponsor : car.getSponsorsForRace()) {
            System.out.print(sponsor.getName() + ", ");
        }
        System.out.print("механик - ");
        for (Mechanic<?> mechanic : car.getMechanicsForRace()) {
            System.out.print(mechanic.getName() + " из компании " + mechanic.getCompany());
        }
        System.out.println(".");
    }

    public static double getRandomIntegerBetweenRange(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static void main(String[] args) {

        Auto audi = new Auto("Audi", "A8", 2.7);
        Auto hyundai = new Auto("Hyundai", "Ferrato", 2.3);
        Auto lada = new Auto("Lada", "Grande", 1.6);
        Auto ford = new Auto("Ford", "Focus", -5.0);

        Trucks kamaz = new Trucks("Камаз", "А 30", 18.0);
        Trucks sable = new Trucks("Соболь", "М 333", 11.0);
        Trucks gazelle = new Trucks("Газель", "Г 3", 9.0);
        Trucks zil = new Trucks("ЗИЛ", "З 100", 17.0);

        Bus lion = new Bus("Lion", "City", 10);
        Bus city = new Bus("СитиРитм", "10", 9);
        Bus cursor = new Bus("ЛиАЗ", "4292", 8);
        Bus mercedez = new Bus("Mercedez-Benz", "Sprinter II", 7);

        Sponsor megafon = new Sponsor("Мегафон", 25000.00);
        Sponsor mts = new Sponsor("МТС", 30000.00);
        Sponsor beeline = new Sponsor("Билайн", 20000.00);
        Sponsor tele2 = new Sponsor("TELE2", 33000.00);

        DriverB<Auto> john = new DriverB<>("John", true, 5);
        DriverC<Trucks> philipp = new DriverC<>("Philipp", false, 7);
        DriverD<Bus> elza = new DriverD<>("Elza", true, 10);

        Mechanic<Auto> nikolay = new Mechanic<>("Николай", "Шины и диски");
        Mechanic<Trucks> vasiliy = new Mechanic<>("Василий", "Шины");
        Mechanic<Bus> sergey = new Mechanic<>("Сергей", "Диски");

        audi.addDriver(john);
        audi.addMechanic(nikolay);
        audi.addSponsor(megafon, beeline);

        gazelle.addDriver(philipp);
        gazelle.addMechanic(vasiliy);
        gazelle.addSponsor(mts, tele2);

        cursor.addDriver(elza);
        cursor.addMechanic(sergey);
        cursor.addSponsor(mts, megafon);

        System.out.println();
        Set<Cars> carsForRacing = new HashSet<>();
        carsForRacing.add(audi);
        carsForRacing.add(gazelle);
        carsForRacing.add(cursor);

        for (Cars car : carsForRacing) {
            printInfo(car);
        }

        System.out.println();

        int size = 15;
        ArrayList<Integer> numberFirst = new ArrayList<>(size);
        ArrayList<Integer> numberSecond = new ArrayList<>(size);

        int a, b, j = 0;

        for (int i = 0; i < size; i++) {
            a = (int) getRandomIntegerBetweenRange(2, 9);
            b = (int) getRandomIntegerBetweenRange(2, 9);
            for (j = 0; j < numberFirst.size(); j++) {
                if ((a * b == numberFirst.get(j) * numberSecond.get(j)) &&
                        (a == numberFirst.get(j) || a == numberSecond.get(j))) {
                    i--;
                    break;
                }
            }
            if (j == numberFirst.size()) {
                numberFirst.add(a);
                numberSecond.add(b);
            }
        }

        for (int i = 0; i < numberFirst.size(); i++) {
            System.out.println(numberFirst.get(i) + " * " + numberSecond.get(i));
        }

        PassportBuro passportBuro = new PassportBuro();
        Passport firstMan = new Passport(11111111, "Иванов", "Иван", "Иванович",
                LocalDate.of(2000, 1, 1));
        Passport secondMan = new Passport(22222222, "Петров", "Петр", "Петрович",
                LocalDate.of(2000, 2, 2));
        Passport thirdMan = new Passport(33333333, "Cидоров", "Сидр", "Сидрович",
                LocalDate.of(2000, 3, 3));
        Passport fourthMan = new Passport(44444444, "Августов", "Август", "Августович",
                LocalDate.of(2000, 4, 4));

        passportBuro.addPasport(firstMan);
        passportBuro.addPasport(secondMan);
        passportBuro.addPasport(thirdMan);
        passportBuro.addPasport(fourthMan);

        System.out.println();

        for (Passport passport : passportBuro.getHumansInfo()) {
            System.out.println(passport);
        }

        System.out.println();
        passportBuro.findPassport(11111111);

        System.out.println();

    }
}