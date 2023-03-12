package accountcomparison;

/**
 * Since question asked to implement an incomplete class, making AccountComparison.Account class abstract.
 */
public abstract class Account implements OnlineAccount, Comparable<Account> {
    int noOfRegularMovies;
    int noOfExclusiveMovies;
    String ownerName;

    protected Account(int noOfRegularMovies, int noOfExclusiveMovies, String ownerName) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
    }

    /**
     * In AccountComparison.OnlineAccount interface, I have created pricing fields assuming
     * they can have decimal values as well.
     * The question mention mentions that monthlyCost method as int return type,
     * hence casting double to int.
     * There will not be any lossy conversion if pricing are in int as well.
     *
     * @return - Monthly cost in int
     */
    public int monthlyCost() {
        double monthlyCost = BASE_PRICE
                + noOfRegularMovies * REGULAR_MOVIE_PRICE
                + noOfExclusiveMovies * EXCLUSIVE_MOVIE_PRICE;
        return (int) monthlyCost;
    }


    @Override
    public int compareTo(Account ac) {
        if (this.monthlyCost() > ac.monthlyCost()) {
            return 1;
        } else if (this.monthlyCost() < ac.monthlyCost()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Owner is %s and monthly cost is %d USD.", this.ownerName, this.monthlyCost());
    }


//    public static void main(String[] args) {
//        AccountComparison.Account accountOfAshutosh = new AccountComparison.Account(4, 6, "Ashutosh");
//        AccountComparison.Account accountOfAbhishek = new AccountComparison.Account(3, 6, "Abhishek");
//        System.out.println(accountOfAshutosh);
//        System.out.println(accountOfAbhishek);
//        System.out.println(accountOfAshutosh.compareTo(accountOfAbhishek));
//
//    }
}
