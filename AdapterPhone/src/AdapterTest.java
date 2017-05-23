import itaphones.phone.AutomaticDialer;
import itaphones.phone.MobilePhone;

public class AdapterTest {

    public static void main(String[] args) {
        PhoneAdapter adapter = new PhoneAdapter(new MobilePhone());

        System.out.println(AutomaticDialer.dial(adapter));

    }
}
