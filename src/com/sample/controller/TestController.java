package com.sample.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sample.dao.PersonDao;
import com.sample.model.Person;


@Controller
public class TestController {
	private static PersonDao personDao = new PersonDao(); 
	
		
	@RequestMapping(value = "/people", method= RequestMethod.GET)
    public @ResponseBody List<Person> getAllPeople() {
        return personDao.getPerson();
    }
	
	@RequestMapping(value = "/people/{id}", method= RequestMethod.GET)
    public @ResponseBody Person getPeopleById(@PathVariable("id") int id) {
		return personDao.getPersonById(id);
    }
	
	@RequestMapping(value = "/people/{id}", method= RequestMethod.DELETE)
    public @ResponseBody boolean deletePeopleById(@PathVariable("id") int id) {
		return personDao.deletePerson(id);
    }
	
	@RequestMapping(value = "/people", method= RequestMethod.POST)
    public @ResponseBody Map<String, Object> createPerson(@RequestBody String personStr) {
		Map<String, Object> response = new HashMap<String, Object>(); 
		System.out.println(personStr);
		
		try {
			System.out.println(java.net.URLDecoder.decode(personStr, "UTF-8")+"");
			personStr = java.net.URLDecoder.decode(personStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		JsonParser parse = new JsonParser();
		JsonObject json = parse.parse(personStr).getAsJsonObject();
		Gson gson = new Gson(); 
		Person person = (Person) gson.fromJson(json, Person.class);
		boolean isAdded = personDao.addPerson(person);
		
		response.put("status", isAdded);
		
		System.out.println(person);
        return response;
    }
	
	@RequestMapping(value = "/people", method= RequestMethod.PUT)
    public @ResponseBody Map<String, Object> editPerson(@RequestBody String personStr) {
		Map<String, Object> response = new HashMap<String, Object>(); 
		
		System.out.println(personStr);
		
		try {
			System.out.println(java.net.URLDecoder.decode(personStr, "UTF-8")+"");
			personStr = java.net.URLDecoder.decode(personStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		JsonParser parse = new JsonParser();
		JsonObject json = parse.parse(personStr).getAsJsonObject();
		Gson gson = new Gson(); 
		Person person = (Person) gson.fromJson(json, Person.class);
		boolean isEdited = personDao.editPerson(person);
		
		response.put("status", isEdited);
        return response;
    }

}
