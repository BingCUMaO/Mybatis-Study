package cn.BinGCU.dao;

import cn.BinGCU.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    List<Map<String, Employee>> getNameAndEmployeeByName(@Param("name") String empName);

    /**
     * 通过id来update记录
     *
     * @param values 将需要update的id，put进values，
     *               然后再将需要修改的其他字段也put到values
     */
    void updateById(Map<Object, Object> values);

    Employee getEmloyeeById(@Param("id") int emp_id);

    Map<String, Employee> getIdAndEmloyeeById(@Param("id") int emp_id);

    double getMaxSalary();

    List<Employee> querySalaryGreaterThan4000();

    void batchInsert(List<Employee> list);

    List<Employee> getEmployeeByFuzzySearch(Employee e);

}
