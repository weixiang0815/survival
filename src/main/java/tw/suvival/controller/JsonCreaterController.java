package tw.suvival.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.suvival.model.House;

@Controller
public class JsonCreaterController {

	@GetMapping(path = "/jsoncreate.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processHouseJsonAction(Model m) throws JsonProcessingException {
		House hBean1 = new House(12345, "Great House");

		ObjectMapper om1 = new ObjectMapper();
		String jsonStr = om1.writeValueAsString(hBean1);
		System.out.println("jsonStr1: " + jsonStr);

		House hBean2 = om1.readValue(jsonStr, House.class);
		System.out.println(hBean2.getHouseid() + "：" + hBean2.getHousename());

		return "jsonStr2：" + jsonStr;
	}

	@GetMapping(path = "/jsonaction1.controller", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public House processJsonAction1() {
		House hBean3 = new House(1001, "Happy House");
		return hBean3;
	}

	@GetMapping(path = "/jsonaction2.controller", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<House> processJsonAction2() {
		House hBean4 = new House(1002, "funny House");
		House hBean5 = new House(1003, "Coding House");

		ArrayList<House> list = new ArrayList<House>();
		list.add(hBean4);
		list.add(hBean5);

		return list;
	}
}