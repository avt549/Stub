package otusApplication;

import com.github.javafaker.Faker;
import helpers.Helpers;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@SpringBootApplication
public class Controllers extends Helpers {
	public Faker faker = new Faker();

	@RequestMapping( value = "/users/get/1",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUser() {
		Map<String, Object> model = new HashMap<>();
		model.put("id",1);
		model.put("name","Иванов Иван Иванович");
		model.put("grade","Тестировщик ПО");
		model.put("school_name","СПБГУ");
		model.put("city","Санкт-Петербург");
		System.out.println(buildJSONFromObject(model));
		return buildJSONFromObject(model);
	}
	@RequestMapping( value = "/users/get/2",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUser1() {
		Map<String, Object> model = new HashMap<>();
		Faker faker = new Faker();
		String funnyName = faker.funnyName().name();
		String job = faker.job().seniority();
		String school = faker.university().name();
		String cityName = faker.address().cityName();
		model.put("id",1231124312);
		model.put("name",funnyName+ " "+funnyName+ " "+funnyName+ " "+funnyName+ " "+funnyName+ " ");
		model.put("grade",job+ " "+job+ " "+job+ " "+job+ " "+job+ " ");
		model.put("school_name",school+ " "+school+ " "+school+ " "+school+ " "+school+ " ");
		model.put("city",cityName+ " "+cityName+ " "+cityName+ " "+cityName+ " "+cityName+ " ");
		System.out.println(buildJSONFromObject(model));
		return buildJSONFromObject(model);
	}

	@RequestMapping(value = "/users/get/all",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUsers() {
		ArrayList<Object> list = new ArrayList<>();
		list.add(user(1,"Иванов Иван Иванович","Тестировщик ПО"));
		for (int i = 2; i < 30 ; i++) {
			list.add(user(i,faker.funnyName().name(),faker.job().seniority()));
		}
		String response = buildJSONFromObject(list);;
		return response;
	}

		@RequestMapping( value = "/users/get/{id}",method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUser(@PathVariable(value="id") Integer id) {
		Map<String, Object> model = new HashMap<>();
		model.put("id",id);
			model.put("name",faker.funnyName().name());
			model.put("grade",faker.job().seniority());
			model.put("school_name",faker.university().name());
			model.put("city",faker.address().cityName());
		System.out.println(buildJSONFromObject(model));
		return buildJSONFromObject(model);
	}

	@RequestMapping(value = "/ping-pong",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPingPong() {
		return null;
	}

	@RequestMapping( value = "/users/{id}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUserMobile(@PathVariable(value="id") Integer id) {
		Map<String, Object> model = new HashMap<>();
		model.put("id",id);
		model.put("name",faker.funnyName().name());
		model.put("grade",faker.job().seniority());
		model.put("school_name",faker.university().name());
		model.put("city",faker.address().cityName());
		System.out.println(buildJSONFromObject(model));
		return buildJSONFromObject(model);
	}
	@RequestMapping( value = "/users/1",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUserMobile() {
		Map<String, Object> model = new HashMap<>();
		model.put("id",1);
		model.put("name","Иванов Иван Иванович");
		model.put("grade","Тестировщик ПО");
		model.put("school_name","СПБГУ");
		model.put("city","Санкт-Петербург");
		System.out.println(buildJSONFromObject(model));
		return buildJSONFromObject(model);
	}

}
