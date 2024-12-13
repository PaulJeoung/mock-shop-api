package project.b.hexaAPI;

import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication(scanBasePackages = "project.b.hexaAPI")
public class Application implements ApplicationRunner {
	final static Logger logger = (Logger) LoggerFactory.getLogger(Application.class); // 이상하면 (Logger) 캐스트 삭제
  public static void main(String[] args) {
	  SpringApplication mockApiApp = new SpringApplication(Application.class);
	  mockApiApp.addListeners(new ApplicationPidFileWriter());
	  mockApiApp.setDefaultProperties(
	            java.util.Collections.singletonMap("server.port", "7882") // build port : 8882, dev port : 7882
	        );
	  mockApiApp.run(args);
	  // maven 빌드 할때, clean package
  }
  @Override
  public void run(ApplicationArguments args) throws Exception {
	  logger.info("Start REST Mock API server!!!");
	  
	  Iterator<String> iter = args.getOptionNames().iterator();
	  while( iter.hasNext() ) {
		  String key = iter.next();
		  Object value = args.getOptionValues(key);
		  logger.info("key = {}"); // logger.info("{}={}", key, value );
	  }
	  
	  
  }
}
