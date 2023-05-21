package Logic;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonValidation {
    public boolean isValidJson(final String json){
        boolean valid = false;
        try{
            final JsonParser parser = new ObjectMapper().getFactory().createParser(json);
            while(parser.nextToken() != null){
            }
            valid =true;
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valid;
    }
}
