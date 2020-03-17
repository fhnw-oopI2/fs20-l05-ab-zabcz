package ch.fhnw.oop2.module05.transactions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements a list of transactions performed by the traders over time.
 *
 */
public final class TransactionList {
	
	private final List<Transaction> allTransactions = new ArrayList<>();

	public void addTransaction(Transaction transaction) {
		allTransactions.add(transaction);
	}

	public int size() {
		return allTransactions.size();
	}

	// AB02 - done
	/**
	 * Returns the transactions done in the year specified.
	 * The transactions are sorted by value (small to high).
	 * 
	 * @param year The year
	 * @return All transactions made in this year
	 */
	public List<Transaction> transactionsInYear(int year) {
        return this.allTransactions.stream().filter(transaction -> transaction.getYear() == year)
				.sorted(Comparator.comparingInt(Transaction::getValue))
				.collect(Collectors.toList());
    }

	// AB03 - done
	/**
	 * Returns all the cities in which traders work.
	 * 
	 * @return The cities
	 */
	public List<String> cities() {
        return this.allTransactions.stream().map(transaction -> transaction.getTrader().getCity())
				.distinct()
				.collect(Collectors.toList());
    }

	// AB04 - done
	/**
	 * Returns all traders from a given city sorted by name.
	 * 
	 * @param city The trader's city
	 * @return All traders from given city sorted by name
	 */
	public List<Trader> traders(String city) {
        return this.allTransactions.stream().filter(transaction -> transaction.getTrader().getCity().equals(city))
				.map(Transaction::getTrader)
				.distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
    }

	// AB05 done
	/**
	 * True if there are traders in the city, false otherwise.
	 * 
	 * @param city The city
	 * @return True if there are any trader based in given city
	 */
	public boolean traderInCity(String city) {
		if (
			this.allTransactions.stream().filter(transaction -> transaction.getTrader().getCity().equals(city))
				.count()
		> 0){
			return true;
		} else{
			return false;
		}
	}

	// AB06 - done
	/**
	 * Moves all traders from their city to the city specified.
	 * 
	 * @param from the trader's current city
	 * @param to   the trader's new city
	 */
	public void relocateTraders(String from, String to) {
		this.allTransactions.stream().filter(transaction -> transaction.getTrader().getCity().equals(from))
				.map(Transaction::getTrader)
				.forEach(trader -> trader.setCity(to));
	}

	// TODO: AB07
	/**
	 * Returns the highest value of all transactions.
	 * 
	 * @return the highest value in all the transactions
	 */
	public int highestValue() {
		return this.allTransactions.stream()
				.map(Transaction::getValue)
				.max(Comparator.comparingInt(n -> n)).get();
	}
}
