import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiseMock implements LocalizationService {
    private String value;

    public void setValue(String value){

        this.value = value;
    }
    @Override
    public String locale(Country country) {
        switch (country) {
            case RUSSIA:
                return "Добро пожаловать";
            default:
                return "Welcome";
        }
    }
}
