package LinkedList;

public class LinkInteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertAfter("Ivan", 30);
        itr.insertAfter("Mikhail", 22);

        itr.reset();

        itr.insertAfter("Vasiliy", 34);
        itr.insertBefore("Yury", 15);
        itr.insertBefore("Anton", 19);
        list.display();

        System.out.println("");
        itr.atEnd();

        itr.nextLink();

        itr.deleteCurrent();
        list.display();
        System.out.println("");

        itr.insertAfter("Maria", 45);
        itr.nextLink();
        itr.deleteCurrent();
        list.display();


    }
}
