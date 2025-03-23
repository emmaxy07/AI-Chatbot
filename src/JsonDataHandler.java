import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.util.HashMap;

public class JsonDataHandler {
    public static void saveToJson(String triggers, String responses) {
        HashMap<String, String> data = new HashMap<>();
        data.put("triggers", triggers);
        data.put("responses", responses);

        String jsonData = new Gson().toJson(data);

        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("chatbot_data.json"));
        writer.write(jsonData);
        writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public HashMap loadFromJson(File file){
        String readFile = "";
        HashMap <String, String> jsonFile = new HashMap<>();
        if (file.exists()){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(file));
                readFile = reader.readLine();
                 jsonFile = new Gson().fromJson(readFile, HashMap.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonFile;
    }
}
