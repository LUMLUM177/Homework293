import java.util.HashSet;
import java.util.Set;

public class PassportBuro {

    private Set<Passport> humansInfo = new HashSet<>();

    public Set<Passport> getHumansInfo() {
        return humansInfo;
    }
    public void findPassport(Integer number) {
        for (Passport pasport : humansInfo) {
            if (pasport.getNumberID().equals(number)) {
                System.out.print("Паспорт найден! ");
                System.out.println(pasport);
                return;
            }
        }
        System.out.println("Паспорта с таким номером не найдено!");
    }
    public void addPasport(Passport passport) {
        for (Passport pasport : humansInfo) {
            if (pasport.getNumberID().equals(passport.getNumberID())) {
                pasport.setSurname(passport.getSurname());
                pasport.setName(passport.getName());
                pasport.setPatronymic(passport.getPatronymic());
                pasport.setDate(passport.getDate());
                return;
            }
        }
        humansInfo.add(passport);
    }
}
