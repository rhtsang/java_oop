// ForUser class

public class ForUser {

    // use hasNext() to sum up a For sequence
    public static int sum1(For r) {
        int sum = 0;
        ForIt fi = new ForIt(r);
        while (fi.hasNext()) {
            try {
                sum += fi.next();
            } catch (UsingIteratorPastEndException e) {
                break;
            }
        }
        return sum;
    }

    // use next() and UsingIteratorPastEndException to sum up a For sequence
    public static int sum2(For r) {
        int sum = 0;
        ForIt fi = new ForIt(r);
        while (true) {
            try {
                sum += fi.next();
            } catch (UsingIteratorPastEndException e) {
                break;
            }
        }
        return sum;
    }
}