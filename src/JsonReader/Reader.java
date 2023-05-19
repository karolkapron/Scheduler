package JsonReader;

import Model.Meeting;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Reader{

    String filename;

    public Reader(String _filename){
        filename = _filename;

    }

    public List<Meeting> readerCalls() throws IOException {
            String content = Files.readString(Paths.get(this.filename));
            JSONObject obj = new JSONObject(content);
            List<Meeting> calls = new ArrayList<>();
            JSONArray arr = obj.getJSONArray("planned_meeting");
            JSONArray jsonArray = new JSONArray(arr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                String start = json.optString("start");
                String stop = json.optString("end");
                Meeting meet = new Meeting(LocalTime.parse(start), LocalTime.parse(stop));
                calls.add(meet);
            }
            return calls;
    }
    public List<LocalTime> readerWorkingHours() throws IOException {
        String content = Files.readString(Paths.get(this.filename));
        JSONObject obj = new JSONObject(content);
        LocalTime workingHourStart = LocalTime.parse(obj.getJSONObject("working_hours").getString("start"));
        LocalTime workingHourEnd = LocalTime.parse(obj.getJSONObject("working_hours").getString("end"));
        return Arrays.asList(workingHourStart, workingHourEnd);
    }
}
