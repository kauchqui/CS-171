
public class Student implements Comparable<Student> 
{
public String name;
public int score;
public String id;

	public Student(String id, int score, String name)
	{
		this.id = id;
		this.score = score;
		this.name = name;
	}
	public int compareTo(Student o)
	{
		return this.id.compareTo(o.id);
	}
	public static boolean less(Student v, Student w)
	{
		return v.compareTo(w) < 0;
	}
	public static void exch(Student[] a, int i, int j)
	{
		Student swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	public static void selectionSort(Student[] a)
	{
		int n = a.length;
		for(int i = 0; i < n; i++)
		{
			int min = i;
			for(int j = i+1; j <n; j++)
			{
				if(less(a[j], a[min])){
				min = j;}
			}
			exch(a,i,min);
		}
	}
	public static void bubbleSort(Student[] a){
		int n = a.length;
		for(int i = 0; i < n-1; i++)
		{
			for(int j = 1; j< n; j++)
			{
				if(less(a[i],a[j]))
				{
					exch(a, i, j);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		Student Kyle = new Student("23549", 90, "Kyle");
		Student Alex = new Student("31249", 80, "Alex");
		Student Todd = new Student("25549", 70, "Todd");
		Student Amber = new Student("16549", 100, "Amber");
		Student[] a = new Student[]{Kyle,Alex,Todd,Amber};
		/*selectionSort(a);*/
		bubbleSort(a);
		for(int i = 0; i<4; i++)
		{
			System.out.println(a[i].id);
		}
	}
}
