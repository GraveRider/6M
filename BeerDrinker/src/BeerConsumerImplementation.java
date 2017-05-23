import itadesign.beerdrinker.BeerBottle;
import itadesign.beerdrinker.BeerConsumer;
import itadesign.beerdrinker.DefaultBeerBottle;

public class BeerConsumerImplementation extends BeerConsumer {

    @Override
    protected boolean shouldConsumeBeer(BeerBottle beerBottle) {
        if (beerBottle.getVolumeInLiters() <= 0.5
                && beerBottle.getAlcoholContentInPercent() <= 6
                && getBloodAlcoholContentInLiters() <= 0.12) {
            return true;
        }
        return false;
    }

    @Override
    public BeerBottle showBeerBottleToAStranger(BeerBottle beerBottle, boolean mightBeAPoliceman) {
        if (!mightBeAPoliceman) {
            return new DefaultBeerBottle(beerBottle.getVolumeInLiters(), beerBottle.getAlcoholContentInPercent());
        }
        return new NonAlcocholicBeverage(beerBottle);
    }
}
