package test.深度优先搜索.easy;

import java.util.List;

/**
 * Created by mengyue on 2018/9/23.
 */
public class 员工的重要性 {


    public static void main(String[] args) {

    }

    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        for (Employee employee : employees) {
            if (employee.id == id) {
                result += employee.importance;
                for (Integer subordinate : employee.subordinates) {
                    result += getImportance(employees, subordinate);
                }
            }
        }
        return result;
    }


    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
