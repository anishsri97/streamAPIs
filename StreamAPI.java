package streamAPIs;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class StreamAPI {
    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));



        //grouping the employee by city

       Map<String,List<Employee>> mapCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
       System.out.println("map by city "+mapCity);

       //grouping employee by age

       Map<Integer,List<Employee>> mapAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
       System.out.println("map by city "+mapAge);


       //count of male and female employees present in the organization.

       Map<String ,Long> countGenders = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
      System.out.println("map by gender "+countGenders);

      //names of all departments in the organization.

      List<String> listEmp = empList.stream().map(emp->emp.getDeptName()).distinct().collect(Collectors.toList());


     // youngest female employee.

      Optional<Employee> youngest=     empList.stream().sorted((emp1,emp2)->emp1.getAge()-emp2.getAge()).findFirst();
      
      System.out.println("youngestEmployee "+youngest.get());

     // department name which has the highest number of employees.


    // Map<String,Long> map=    empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();

     Map<String,Long> map1=    empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
                               
     for(Entry<String ,Long> entry:map1.entrySet()){
        System.out.println("key "+entry.getKey()+"value "+entry.getValue());
     }
    
    
    
     Entry<String,Long> entry=               map1.entrySet().stream().max(Map.Entry.comparingByValue()).get();

     System.out.println("key "+entry.getKey()+ "value "+entry.getValue());


    }
}