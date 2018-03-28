// my own Integer wrapper class to appease AList and MyInterface

public class MyInteger extends MyObject {

    private int i;

    public MyInteger(int i) {
        this.i = i;
    }

    public void add(MyObject object, AList list) {
        list.add(i);
    }

    public AList flatten() {
        AList IntList = new AList();
        IntList.add(i);
        return IntList;
    }

    public String toString() {
        return (""+i);
    }
}