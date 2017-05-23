import itadesign.beerdrinker.BeerFactory;
import itadesign.beerdrinker.DefaultBeerBottle;
import itadesign.beerdrinker.NoMoreMaltException;

public class BeerFactoryImplementation implements BeerFactory {

    private double maltAmount;

    public BeerFactoryImplementation() {
        this.maltAmount = 1000;
    }

    @Override
    public void receiveMaltShippment(double amount) {
        this.maltAmount += amount * 1000;
    }

    @Override
    public DefaultBeerBottle produceNextBeerBottle() throws NoMoreMaltException {
        if (this.maltAmount >= 25) {
            this.maltAmount -= 25;
            return new DefaultBeerBottle(0.33, 4.5);
        }
        throw new NoMoreMaltException("No more malt! Production halted!");
    }
}
