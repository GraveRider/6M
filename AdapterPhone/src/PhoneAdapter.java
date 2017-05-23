import itaphones.phone.MobilePhone;
import itaphones.phone.Phone;

public class PhoneAdapter implements Phone {

    private MobilePhone mobilePhone;

    public PhoneAdapter(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public void dial(String number) {
        mobilePhone.dial(number);
    }

    @Override
    public String getReponse() {
        return "Hello?";
    }
}
