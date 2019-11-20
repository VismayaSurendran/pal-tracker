package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    TimeEntryRepository timeEntryRepository(MysqlDataSource dataSource){

        return new JdbcTimeEntryRepository(dataSource);
    }

    @Bean
    TimeEntryRepository timeEntryRepository(){

        return new InMemoryTimeEntryRepository();
    }

}
