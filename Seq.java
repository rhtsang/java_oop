// the Seq base class

public abstract class Seq extends MyObject {

    // counter for number of Seq objects created
    protected static int seqCount;

    // abstract method to return a sequence's upperBound
    public abstract int upperBound();

    // see how many Seq objects have been created
    public static int getCount() { return seqCount; }

    // to create a general iterator over a Seq
    abstract SeqIt createSeqIt();
}
