
class SolutionTest {
    public static void testEmpty(){
        TreeList list = new TreeList();
        System.out.println(list.isEmpty() == true);
        list.add(10);
        System.out.println(list.isEmpty() == false);
    }

    public static void testSize(){
        TreeList list = new TreeList();
        list.add(10);
        System.out.println(list.size()== 1);
    }

    public static void testAscending(){
        TreeList list = new TreeList();
        list.add(10);
        list.add(5);
        list.add(30);
        list.add(20);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.print("\nshould print in ascending order"); 
        list.print(OrderType.ASCENDING);
    }
    public static void testDescending(){
        TreeList list = new TreeList();
        list.add(10);
        list.add(5);
        list.add(30);
        list.add(20);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.print("\nshould print in descending order");
        list.print(OrderType.DESCENDING);
    }
    public static void main(String[] args) throws Exception {
        testEmpty();
        testSize();
        testAscending();
        testDescending();
    }
}