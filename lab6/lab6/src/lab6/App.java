package lab6;

public class App {
    interface Data extends Comparable<Data> {
        public String getName();
        public void print();

        public int getIdx();
    }

    public static void main(String[] args) throws Exception {
        Shelf<? super Data> shelf = new Shelf<Data>();

        shelf.add(new Album("album 1", 5));
        shelf.add(new Album("album 2", 10));
        shelf.add(new Book("book 1", 4));
        shelf.add(new Book("book 2", 3));

        Data res = shelf.findMin();

        System.out.print("lowest data is: ");
        res.print();
    }
}
