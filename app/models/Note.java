package models;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long id;

    public String title;

    public String description;

    public String content;

    public static Note fromJson(JsonNode jsonNode) {
        ObjectMapper mapper = new ObjectMapper();

        Note note = null;
        try
        {
            note = mapper.readValue(jsonNode.toString(), Note.class);
        } catch (JsonGenerationException | JsonMappingException | JsonParseException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return note;
    }
}
