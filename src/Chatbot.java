import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        System.out.println("Hey, I am your chatbot");
        Scanner scanner = new Scanner(System.in);

        ProcessInput processInput =  new ProcessInput();
        String input = "";
        String response = "";
        String newInput = "";
        String newWord = "";
        while(!input.equals("bye")){
            newInput = "";
            System.out.print("User: ");
            input = scanner.nextLine().toLowerCase().replaceAll("\\p{Punct}", "");
            response = processInput.checkInput(input);
            if(response.startsWith("Teach me: ")){
                String unknownWord = response.substring(10);
                System.out.println("AI bot: What should I say for " + unknownWord);
                System.out.print("User: " + newInput);
                newInput = scanner.nextLine().toLowerCase();
                newWord = processInput.learnNewWord(newInput, unknownWord);
                System.out.println("AI bot: " + newWord);
            } else {
                System.out.println("AI bot: " + response);
            }
        }
    }
}


