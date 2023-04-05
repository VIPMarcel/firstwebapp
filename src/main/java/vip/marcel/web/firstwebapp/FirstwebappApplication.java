package vip.marcel.web.firstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FirstwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstwebappApplication.class, args);
	}

	@PostMapping("/apply")
	public String read(@RequestParam("name") String name,
					   @RequestParam("email") String email,
					   @RequestParam("discordTag") String discordTag,
					   @RequestParam("birthday") String birthday,
					   @RequestParam("text") String text) {

		System.out.println(">> " + name + " |> + " + text);

		return "";
	}

}
