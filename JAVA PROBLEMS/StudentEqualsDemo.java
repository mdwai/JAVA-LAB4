class StudentEq
{
    int rollNo;
    String name;
    StudentEq(int rollNo, String name)
    {
        this.rollNo = rollNo;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        StudentEq s = (StudentEq) obj;

        return rollNo == s.rollNo && name.equals(s.name);
    }
}

public class StudentEqualsDemo
{
    public static void main(String[] args)
    {
        StudentEq s1 = new StudentEq(101, "Rahul");
        StudentEq s2 = new StudentEq(101, "Rahul");

        if (s1.equals(s2))
            System.out.println("Both students are equal");
        else
            System.out.println("Students are not equal");
    }
}
