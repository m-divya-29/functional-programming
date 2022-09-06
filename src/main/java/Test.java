import java.util.*;

//immutable class
class ImmutableClass{
    private final List<Integer> li;
    ImmutableClass(List<Integer> list){
      //  li = list;
        List<Integer> t = new ArrayList<>();
        for(int i: list){
            t.add(i);
        }
        li = t;
    }
}

class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    Employee(int a, String n){
        id  = a;
        name = n;
    }
    @Override
    public int compareTo(Employee obj){
        if(obj.getId() == id) return 0;
        return id - obj.getId();
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return "id = "+id + " name = "+name;
    }
}
class Parent{
    static {
        System.out.println("par static");
    }
    {
        System.out.println("parent init");
    }

    Parent(){
        System.out.println("pare con");
    }
    void m1(){
        System.out.println("p m1");
    }
    void m2(){
        System.out.println("p m2");
    }
}
class Child extends Parent{
    static {
        System.out.println("Child static");
    }
    {
        System.out.println("Child init");
    }
    Child(){
        System.out.println("Child");
    }
    void m1(){
        System.out.println("c m1");
    }
}
class Singleton{
    private static Singleton obj = null;
    //Map<Class<? extends Singleton>, Singleton>
    private static Set<String> s = new HashSet<>();
     Singleton(){
         System.out.println("Set = "+s);
         if(s.contains(getClass().toString())) throw new IllegalArgumentException();
         s.add(getClass().toString());
         System.out.println("Singleton constructor");
    }

    public static Singleton getInstance(){
        if(obj == null){
            obj = new Singleton();
            return  obj;
        }
        throw new IllegalArgumentException();
    }
}
public class Test  extends Singleton{
    public static void main(String[] args) {
        Parent p = new Child();
        p.m1();
        p.m2();
        System.out.println("one"+p.getClass().toString());
        Employee e1 = new Employee(1, "Vikas");
        Employee e2 = new Employee(2, "Akash");
        List<Employee> li = Arrays.asList(e2, e1);
        Collections.sort(li);
        //  li.sort((Employee o1, Employee o2) -> o1.getId()<o2.getId()?-1:o1.getId()>o2.getId()?1:0);
        //li.sort((Employee o1, Employee o2) -> -o1.getName().compareTo(o2.getName()));
        //Collections.sort(li, (Employee obj1, Employee obj2) -> obj1)
        System.out.println(li);
        Singleton s = new Singleton();
       // Singleton s2 = new Singleton();
        Test t = new Test();
 //       Test t2 = new Test();

        System.out.println("two" + new Child().getClass().toString());

    }
}