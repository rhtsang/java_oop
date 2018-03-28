// FibIt iterator class

public class FibIt implements SeqIt {

    private int first1, first2, last; // copy info from Fib sequence
    private int itr; // used to track which part of sequence currently on
                     // currently not really doing much, b/c only values that carry weight are 0 and not 0

    // constructor
    public FibIt(Fib fib) {
        first1 = fib.first1;
        first2 = fib.first2;
        last = fib.last;
        itr = 0;
    }

    // iterator hasNext()
    public boolean hasNext() {
        if (itr == 0 && first1 <= last) {
            return true;
        }
        else if ( (first2) <= last) {
            return true;
        }
        return false;
    }

    // iterator next()
    public int next() throws UsingIteratorPastEndException {
        if (hasNext()) {
            switch (itr) {
                case 0:
                    itr++;
                    return first1;
                default:
                    itr++;
                    int value = first2;
                    int next = first1 + first2;
                    first1 = first2;
                    first2 = next;
                    return value;
            }
        } else {
            throw new UsingIteratorPastEndException();
        }
    }
}