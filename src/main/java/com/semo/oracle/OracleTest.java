package com.semo.oracle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Slf4j
public class OracleTest {

    private final JdbcTemplate jdbcTemplate;

    public OracleTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public static void main(String[] args) {
        SpringApplication.run(OracleTest.class, args);
    }
    @Bean
    public ApplicationRunner runner() {
        return args -> {
            jdbcTemplate.execute("""
            CREATE TABLE TEST (
                ID VARCHAR2(50),
                NAME VARCHAR2(50)
            )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID1', 'NAME1' )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID2', 'NAME2' )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID3', 'NAME3' )
            """.stripIndent());

            jdbcTemplate.update("""
            INSERT INTO TEST (ID ,NAME) VALUES( 'ID4', 'NAME4' )
            """.stripIndent());
        };
    }
}
