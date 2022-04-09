package TaskFirst;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayInt {
    private ArrayList<Integer> array;


    public ArrayInt(int size) {
        this.array = new ArrayList<>(size);
    }

    public void create(int n) {
        array.add(n);
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }

    public void removeElement(int num) {
        Iterator<Integer> removeElement = this.array.iterator();
        while (removeElement.hasNext()) {
            if (removeElement.next().equals(num)) {
                removeElement.remove();
            }
        }
    }

    public void IndexRemove(int index) {
        this.array.remove(index);
    }

    public void remove(int num) {
        this.array.remove(this.array.indexOf(num));
    }

    public void removeIfElement(int num) {
        this.array.removeIf(integer -> (integer == num));
    }

    public void replaceElement(int num, int newElement) {
        this.array.set(this.array.indexOf(num), newElement);
    }

    public void replaceElementIndex(int index, int newElement) {
        this.array.set(index, newElement);
    }
    public void size(ArrayList<Integer> integers){
        integers.size();
    }

    @Override
    public String toString() {
        return "{" + array +
                '}';
    }
}
