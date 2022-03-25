package lxz.tutorial.dateformat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;

/**
 * @author Guilin Liang
 * @since 2.0.0
 */
public class Java8TimeTest {

  @Data
  public static class Flight {

    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    private LocalDateTime createdTime;
    private Instant createdTimestamp;
  }

  public static void main(String[] args) throws JsonProcessingException {
//    JavaTimeModule javaTimeModule=new JavaTimeModule();
//    // Hack time module to allow 'Z' at the end of string (i.e. javascript json's)
//    javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(
//        DateTimeFormatter.ISO_DATE_TIME));

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new ParameterNamesModule())
        .registerModule(new Jdk8Module())
        .registerModule(new JavaTimeModule())
//        .registerModule(javaTimeModule)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    Flight f = new Flight();
    f.setStartTime(OffsetDateTime.now());
    f.setEndTime(OffsetDateTime.now());
    f.setCreatedTime(LocalDateTime.now());
    f.setCreatedTimestamp(Instant.now());
    String json = objectMapper.writeValueAsString(f);
    // {"startTime":"2021-12-10T15:22:54.152+08:00","endTime":"2021-12-10T15:22:54.152+08:00","createdTime":"2021-12-10T15:22:54.152"}
    System.out.println(json);
    Flight read = objectMapper.readValue(json, Flight.class);
    //Java8TimeTest.Flight(startTime=2021-12-10T07:24:08.314Z, endTime=2021-12-10T07:24:08.314Z, createdTime=2021-12-10T15:24:08.330)
    System.out.println(read);
    String utcJson = "{\"startTime\":\"2021-12-10T17:15:00.619+08:00\",\"endTime\":\"2021-12-10T17:15:00.619+08:00\",\"createdTime\":\"2021-12-10T17:15:00.625\",\"createdTimestamp\":\"2021-12-10T09:15:00.625Z\"}";
    Flight readUtc = objectMapper.readValue(utcJson, Flight.class);

    System.out.println(readUtc);
  }
}
