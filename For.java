// derived class Seq

public class For extends Seq {

    // ints to define the For sequence
    protected int first, last, step;

    // counter for how many For objects created
    private static int forCount;

    // constructor
    public For(int first, int last, int step) {
        seqCount++; forCount++;
        this.first = first;
        this.last = last;
        this.step = step;
    }

    // override toString() from Object class
    public String toString() {
        return ("{ " + first + " to " + last + " by " + step + " }");
    }

    // overridden upperBound() from Seq class
    public int upperBound() {
        if (step > 0) {
            return last;
        } else {
            return first;
        }
    }

    // see how many For objects have been created
    public static int getCount() { return forCount; }

    // create a general Seq iterator
    SeqIt createSeqIt() {
        return new ForIt(this);
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
        AList ForList = new AList();
        ForList.add(this);
        return ForList;
    }
}