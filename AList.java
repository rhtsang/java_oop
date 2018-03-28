// AList class

import java.util.ArrayList;
import java.lang.Integer;

public class AList extends MyObject {

    // ArrayList of Seq, AList, Integer objects
    private ArrayList<MyObject> list;

    // constructor
    public AList() {
        list = new ArrayList<MyObject>();
    }

    // add a Seq object
    public void add(Seq s) {
        list.add(s);
    }

    // add an AList object
    public void add(AList a) {
        list.add(a);
    }

    // add an Integer object
    public void add(int i) {
        list.add(new MyInteger(i));
    }

    // override from interface MyInterface
    public void add(MyObject object, AList list) {
        AList inner_expand = expand();
        list.add(inner_expand);
    }

    // override toString() from Object class
    public String toString() {
        String string = "[ ";
        if (list.isEmpty()) {
            string = string + " ]";
            return string;
        } else {
            for (Object obj : list) {
                string = string + obj.toString() + " ";
            }
            string = string + "]";
            return string;
        }
    }

    // expand() all the sequences in this.list and return new AList
    AList expand() {
        AList expandedList = new AList();
        for (MyObject object : this.list) {
            object.add(object, expandedList);
        }
        return expandedList;
    }

    // flatten() all lists in this.list and return new AList
    public AList flatten() {
        AList flattenedList = new AList();
        for (MyObject object : this.list) {
            for (MyObject inner_obj : object.flatten().list) {
                flattenedList.list.add(inner_obj);
            }
        }
        return flattenedList;
    }
}