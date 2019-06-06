
import java.io.PrintWriter;
import java.util.Scanner;

public class MCSAQuestion extends MCQuestion {
	
	private int ansNum;
	
	protected MCSAQuestion(String question, double val)
	{
		super(question,val);
	}
	
	protected MCSAQuestion(Scanner scanner)
	{
		super(scanner);
		
		ansNum = scanner.nextInt();
		int i;
		for(i = 0; i < ansNum; i++)
		{
			MCSAAnswer answer = new MCSAAnswer(scanner);
			answers.add(answer);
		}
	}

	
	public Answer getNewAnswer() 
	{
		
		MCSAAnswer answer = new MCSAAnswer(questions, maxValue);
		return answer;
	}
	
	public Answer getNewAnswer(String ans, double credit) 
	{
		
		MCSAAnswer answer = new MCSAAnswer(ans, credit);
		return answer;
	}

	public void selectRightAnswer(Answer answer) 
	{
		rightAnswer = answer;
	}
	
	public void getAnswerFromStudent() 
	{
		super.print();
		
		Scanner scanner = new Scanner(System.in);
		String text=scanner.nextLine();
		
		text = text.toLowerCase();
		
		if(text.equals("a")){
			studentAnswer = answers.get(0);
		}else if(text.equals("b")){
			studentAnswer = answers.get(1);
		}else if(text.equals("c")){
			studentAnswer = answers.get(2);
		}else if(text.equals("d")){
			studentAnswer = answers.get(3);
		}else if(text.equals("e")){
			studentAnswer = answers.get(4);
		}
		
		System.out.print("You selected: ");
		studentAnswer.print();
		
	}
	
	@Override
	public void getAnswerFromStudent(String studentAnswerText) {
		for(MCAnswer answer : answers){
			if(answer.answers.equals(studentAnswerText)){
				studentAnswer = answer;
				break;
			}
		}
	}
    
	public void save(PrintWriter write) 
	{
		// TODO Auto-generated method stub
		write.println("MCSAQuestion");
		write.println(maxValue);
		write.println(questions);
		write.println(ansNum);
		super.save(write);
	}
	
	
	public double getValue() 
	{
		return super.getValue((MCSAAnswer)studentAnswer);
	}

	

}
