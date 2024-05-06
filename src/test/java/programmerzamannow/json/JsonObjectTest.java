package programmerzamannow.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {
    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstname", "alvenio",
                "lastname", "farhan",
                "age", 24,
                "married", false,
                "address", Map.of(
                        "street", "Tembalang",
                        "city", "Semarang",
                        "country", "Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "firstName": "Alvenio",
                  "address": {
                    "street": "Tembalang",
                    "city": "Semarang",
                    "country": "Indonesia"
                  },
                  "lastName": "Farhan",
                  "married": false,
                  "age": 24
                }
                                
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("Alvenio", person.get("firstName"));
        Assertions.assertEquals("Farhan", person.get("lastName"));
    }
}
