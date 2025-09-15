package Assessment.AutoRABIT_indiaJavaTalentHunt.Problem2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //test cases

    }
}
class Employee{
    private String name;
    private int salary;
    public Employee(String name,int salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSalary(){
        return this.salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

}

class EmployeeInfo{
    enum SortingMethod{
        BYNAME,BYSALARY
    }
public List<Employee> sort(List<Employee> emps,final SortingMethod method){
        if(method == SortingMethod.BYNAME) sortByName(emps);
        else sortBySalary(emps);
return emps;
}
    private void sortByName(List<Employee> emps){
    Collections.sort(emps, Comparator.comparing(Employee::getName));
    }
    private void sortBySalary(List<Employee> emps){
        Collections.sort(emps, Comparator.comparing(Employee::getSalary));
    }

    public boolean isCharacterPresentInAllNames(Collection<Employee> entities, String character){


         for(Employee emp : entities){
            if(!emp.getName().toLowerCase().startsWith(character.toLowerCase())) return false;

         }return true;

    }

}


