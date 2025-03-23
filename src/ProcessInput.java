import java.util.Date;
import java.util.HashMap;
import java.util.Calendar;

public class ProcessInput{
    private HashMap<String, String> triggers;
    private HashMap<String, String> responses;

    public String getTime(){
    Date date = Calendar.getInstance().getTime();
    return "It's " + date;
    }

    public ProcessInput(){
        triggers = new HashMap<>();
        triggers.put("hi", "greet");
        triggers.put("hello", "greet");
        triggers.put("time", "ask time");
        triggers.put("bye", "goodbye");

        responses = new HashMap<>();
        responses.put("greet", "Hi, how are you doing?");
        responses.put("ask time", getTime());
        responses.put("goodbye", "Catch you later!");
    }

    public String learnNewWord (String teachingSentence, String unknownWord){
        String response = "";
//        String[] words = teachingSentence.split(" ");
        StringBuilder remainingStrings = new StringBuilder();
//        if(words[0].equals("say")){
            for(int i = 0; i < teachingSentence.length(); i++){
                remainingStrings.append(teachingSentence.charAt(i));
//            }
            triggers.put(unknownWord, unknownWord);
            responses.put(unknownWord, remainingStrings.toString());
        }
        response = responses.get(unknownWord);
        return response;
    }

    public String checkInput(String input){
        String response = "";
//        String[] words = input.split(" ");
//        for(String word : words){
            if(!triggers.containsKey(input)){
                response = "Teach me: " + input;
            } else if(input.equals("time")){
                response = getTime();
            }
            else {
            String intent = triggers.get(input);
            response = responses.get(intent);
//            break;
            }
//        }

        return response;
    }
}
