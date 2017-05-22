import lt.itakademija.exam.*;

public class CurrencyConverterImplementation implements CurrencyConverter {

    private CurrencyRatesProvider currencyRatesProvider;

    public CurrencyConverterImplementation(CurrencyRatesProvider currencyRatesProvider) {
        this.currencyRatesProvider = currencyRatesProvider;
    }

    @Override
    public Money convert(Currency currency, Currency currency1, Money money) {
        if (currencyRatesProvider.getRate(currency, currency1) == null) {
            throw new CurrencyConversionException("Cannot convert currency!");
        }
        return money.multiply(currencyRatesProvider.getRate(currency, currency1));
    }
}
