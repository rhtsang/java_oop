// ForIt iterator class

public class ForIt implements SeqIt {

    private For fr; // copy For info
    private int itr; // iterator

    // constructor
    public ForIt(For fr) {
        this.fr = fr;
        itr = 0;
    }

    // iterator hasNext()
    public boolean hasNext() {
        if (fr.step > 0) {
            if ( (fr.first + (itr)*(fr.step)) <= fr.last) {
                return true;
            }
        } else if (fr.step < 0) {
            if ( (fr.first + (itr)*(fr.step)) >= fr.last) {
                return true;
            }
        } else if (fr.step == 0) {
            return true;
        }
        return false;
    }

    // iterator next()
    public int next() throws UsingIteratorPastEndException {
        int value = (fr.first + (itr)*(fr.step));
        if (hasNext()) {
            itr++;
            return value;
        } else {
            throw new UsingIteratorPastEndException();
        }
    }
}