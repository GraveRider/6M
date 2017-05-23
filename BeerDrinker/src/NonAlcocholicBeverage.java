import itadesign.beerdrinker.BeerBottle;

public class NonAlcocholicBeverage implements BeerBottle {

    private BeerBottle beerBottle;

    public NonAlcocholicBeverage(BeerBottle beerBottle) {
        this.beerBottle = beerBottle;
    }

    @Override
    public double getAlcoholContentInPercent() {
        return 0;
    }

    @Override
    public double getVolumeInLiters() {
        return beerBottle.getVolumeInLiters();
    }

    @Override
    public void takeASip(double volumeInLiters) {
        beerBottle.takeASip(volumeInLiters);
    }
}
