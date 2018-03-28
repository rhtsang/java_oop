// derived class Fib

public class Fib extends Seq {

    // ints to define the Fib sequence
    protected int first1, first2, last;

    // counter for number of Fib objects created
    private static int fibCount;

    // constructor
    public Fib(int first1, int first2, int last) {
        seqCount++; fibCount++;
        this.first1 = first1;
        this.first2 = first2;
        this.last = last;
    }

    // override toString() from Object class
    public String toString() {
        return ("< " + first1 + ", " + first2 + " to " + last + " >");
    }

    // overridden upperBound() from Seq class
    public int upperBound() {
        return last;
    }

    // see how many Fib objects have been created
    public static int getCount() { return fibCount; }

    // create a general Seq iterator
    SeqIt createSeqIt() {
        return new FibIt(this);
    }

    // override from MyInterface
    public void add(MyObject object, AList list) {
        SeqIt itr = createSeqIt();
        while (true) {
            try {
                list.add(itr.next());
            } catch (UsingIteratorPastEndException e) {
                break;
            }
        }
    }

    // override from MyInterface
    public AList flatten() {
        AList FibList = new AList();
        FibList.add(this);
        return FibList;
    }
}