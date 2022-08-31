package com.example.restconsume.Service;
import com.example.restconsume.Entity.Stu.Course;
import com.example.restconsume.Service.Beans.shoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class courService {

    @Autowired
    private shoppingCart sc;

    public  Map<Integer, Course> setshoppingCart(int studentId, int courseIndex,List<Course> c){
        int courseId=c.get(courseIndex).getId();
        Course courseObject=c.get(courseIndex);

        sc.setShoppingCart(studentId,courseId,courseObject);
        Map<Integer, Course> shoppingCart = sc.getList(studentId);
        return shoppingCart;
    }

    public Map<Integer,Course> getCourseFromCart(int studentId){
        Map<Integer, Course> innerMap = sc.getList(studentId);
        return innerMap;
    }

    public void deleteCourseFromCart(int courseId,int studentId){
   sc.deleteCourseFromCart(courseId,studentId);
    }

    public void deleteAllFromCart(int studentId){
        sc.deleteAllFromCart(studentId);
    }

}
