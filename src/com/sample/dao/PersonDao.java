package com.sample.dao;

import java.util.ArrayList;
import java.util.List;

import com.sample.model.Person;

public class PersonDao {

	private List<Person> personList = new ArrayList<Person>(); 
	
	public List<Person> initPerson(){
		
		Person person = new Person(); 
		person.setId(1);
		person.setName("Sean");
		person.setFavoriteCity("New York");
		
		personList.add(person); 
		
		System.out.println("init person dao");
		return personList;
	}
	
	public List<Person> getPerson(){
		return personList;
	}
	
	public boolean addPerson(Person person){
		boolean isAdded = false;
		try {
			personList.add(person);
			isAdded = true;
		} catch (Exception e) {
			System.out.println("Cannot add Person to the List: "+e);
		}
		
		return isAdded;
	}
	
	public boolean deletePerson(Person person){
		return deletePerson(person.getId());
	}
	
	public boolean deletePerson(int id){
		boolean isDeleted = false; 
	
		for(int i =0; i<personList.size(); i++){
			if(personList.get(i).getId() == id){
				personList.remove(i);
				isDeleted = true;
			}
		}
		
		return isDeleted; 
	}
	
	public Person getPersonById(int id){
		Person person = new Person(); 
		
		for(int i= 0; i<personList.size(); i++){
			if(personList.get(i).getId()==id)
				person = personList.get(i);
		}
		
        return person;
	}
	
	public boolean editPerson(Person person){
		boolean isEdited = false; 
	
		for(int i =0; i<personList.size(); i++){
			if(personList.get(i).getId() == person.getId()){
				personList.get(i).setFavoriteCity(person.getFavoriteCity());
				personList.get(i).setName(person.getName());
				isEdited = true;
			}
		}
		
		return isEdited; 
	}
	
}
