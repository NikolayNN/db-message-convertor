package by.db.convert.script;

import by.db.convert.script.gelios.domain.GMessage;
import by.db.convert.script.gelios.repo.GMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private GMessageRepository geliosMessageRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args){
		List<GMessage> gMessages = geliosMessageRepository.findAllByUnitId("353386060734957");
		System.out.println(gMessages);
	}
}
