package Package;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Question {
    void display();
    boolean checkAnswer(String response);
}

class MultipleChoiceQuestion implements Question {
    private String prompt;
    private List<String> options;
    private int correctOption;

    public MultipleChoiceQuestion(String prompt, List<String> options, int correctOption) {
        this.prompt = prompt;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void display() {
        System.out.println(prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(String response) {
        int selectedOption = Integer.parseInt(response);
        return selectedOption == correctOption;
    }
}

class TrueFalseQuestion implements Question {
    private String prompt;
    private boolean correctAnswer;

    public TrueFalseQuestion(String prompt, boolean correctAnswer) {
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
    }

    public void display() {
        System.out.println(prompt + " (True/False)");
    }

    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(Boolean.toString(correctAnswer));
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void conduct() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            question.display();
            System.out.print("Your answer: ");
            String userResponse = scanner.nextLine();

            if (question.checkAnswer(userResponse)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect.\n");
            }
        }

        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
        System.out.println("Thanks for attending.");
        {
        	if(score==5)
        	{
        		System.out.println("Congratulations!");
        	}
        	else if(score>=2)
        	{
        		System.out.println("Good");
        	}
        	else         	{
        		System.out.println("Better luck next time");
        	}
        }
      
    }
}

public class QuizPlatform {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new MultipleChoiceQuestion("What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"), 3));

        quiz.addQuestion(new TrueFalseQuestion("Java is a programming language.", true));
        
    quiz.addQuestion(new MultipleChoiceQuestion("In which year India got Independence?",
    		List.of("1234","1974","1957","1947"),4));
    
    quiz.addQuestion(new TrueFalseQuestion("Puducherry is a state", false));
    
    quiz.addQuestion(new MultipleChoiceQuestion("What is the Jersey Number of Thala Dhoni",
    		List.of("5","7","2","17"),2));
    
        quiz.conduct();
    }
}