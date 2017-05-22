import lt.itakademija.exam.*;

import java.util.ArrayList;

public class BankImplementation implements Bank {

    private CurrencyConverter currencyConverter;
    private Account account;
    private Customer customer;
    private SequenceGenerator customerIdGenerator = new SequenceGenerator();
    private SequenceGenerator accountIdGenerator = new SequenceGenerator();
    private SequenceGenerator operationIdGenerator = new SequenceGenerator();
    private ArrayList<PersonCode> codeList = new ArrayList<PersonCode>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public BankImplementation(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public Customer createCustomer(PersonCode personCode, PersonName personName) {
        if (personCode == null || personName == null) {
            throw new NullPointerException();
        } else if (codeList.contains(personCode)) {
            throw new CustomerCreateException("Customer with this person code exists!");
        }
        customer = new Customer(customerIdGenerator.getNext(), personCode, personName);
        customers.add(customer);
        codeList.add(personCode);
        return customer;
    }

    @Override
    public Account createAccount(Customer customer, Currency currency) {
        if (!codeList.contains(customer.getPersonCode())) {
            throw new AccountCreateException("Cannot create account!");
        } else if (customer == null || currency == null) {
            throw new NullPointerException();
        }
        account = new Account(accountIdGenerator.getNext(), customer, currency, new Money(0));
        customer.addAccount(account);
        return account;
    }

    @Override
    public Operation transferMoney(Account account, Account account1, Money money) {
        if (account.getBalance().isLessThan(money)) {
            throw new InsufficientFundsException("Insufficient funds!");
        }
        Money amount = currencyConverter.convert(account.getCurrency(), account1.getCurrency(), money);
        account.setBalance(account.getBalance().substract(money));
        account1.setBalance(account1.getBalance().add(amount));
        return new Operation(operationIdGenerator.getNext(), account, account1, money);
    }

    @Override
    public Money getBalance(Currency currency) {
        Money amount = account.getBalance().substract(account.getBalance());
        for (Customer customer : customers) {
            for (Account account : customer.getAccounts()) {
                amount = amount.add(currencyConverter.convert(account.getCurrency(), currency, account.getBalance()));
            }
        }
        return amount;
    }
}
