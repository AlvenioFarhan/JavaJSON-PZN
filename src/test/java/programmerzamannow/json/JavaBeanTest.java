package programmerzamannow.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {
    @Test
    void createJsonFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Alvenio");
        person.setHobbies(List.of("Coding", "Traveling", "Jogging"));

        Address address = new Address();
        address.setStreet("Tembalang");
        address.setCity("Semarang");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
                {
                  "id": "1",
                  "name": "Alvenio",
                  "hobbies": [
                    "Coding",
                    "Traveling",
                    "Jogging"
                  ],
                  "address": {
                    "street": "Tembalang",
                    "city": "Semarang",
                    "country": "Indonesia"
                  }
                }
                              
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Alvenio", person.getName());
        Assertions.assertEquals("Tembalang", person.getAddress().getStreet());
        Assertions.assertEquals("Semarang", person.getAddress().getCity());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
    }
}
