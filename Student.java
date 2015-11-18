
public class Student {
	private final int Size=4;
	private String name;
	private double [][]assignments=new double[Size][2];
	private double gpa;
	public Student (){
		name="";
		for (int i=0;i<assignments.length;)
		{
			assignments[i][1]=0;
			assignments[i][0]=0;
		}
			gpa=0;
	}
	public Student(String name, double[][] assignments) {
		super();
		this.name = name;
		this.assignments = assignments;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[][] getAssignments() {
		return assignments;
	}
	public void setAssignments(double[][] assignments) {
		this.assignments = assignments;
	}
	public double getGpa() {
		return calculateAVGScore();
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	private double calculateAVGScore(){
		double sum = 0;
		if (this.assignments!=null)
		{for (int i=0;i<assignments.length;i++){
			sum+=assignments[i][0]*assignments[i][1];
		}
		int grade =(int)sum;
		switch(grade/10){
		case 10:
		case 9 :this.gpa=4.0;
		break;
		case 8:this.gpa=3.0;
		break;
		case 7:this.gpa=2.0;
		break;
		case 6:this.gpa=1.0;
		break;
		default: this.gpa=0;
		}
		}
		return this.gpa;
	}
	public String toString(){
		String info="";
		info ="Welcome: "+this.name;
		for (int i=0;i<assignments.length;i++){
			info+="\nAssignment "+(i+1)+": "+"\t"+assignments[i][0]+"\nWeighted percentage: "+assignments[i][1]+"\n";
		} info+="GPA: "+getGpa();
	return info.toString();
	}
}
