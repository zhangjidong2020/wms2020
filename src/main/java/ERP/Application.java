package ERP;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ERP.mapper")
public class Application {
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(Application.class,args);
    }
}
