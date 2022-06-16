class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        // write your code here
        String p1name = p1.name;
        int p1age = p1.age;

        String p2name = p2.name;
        int p2age = p2.age;

        p1.name = p2name;
        p1.age = p2age;

        p2.name = p1name;
        p2.age  = p1age;
    }
}