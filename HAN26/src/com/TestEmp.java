package com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Author:Fanleilei
 * Created:2019/3/28 0028
 */
public class TestEmp {
    public static void main(String[] args) {

        //1.指定字符串的格式
        //emp.ename:Jack|emp.job:软件工程师|emp.age:23

        String content="emp.ename:Tom|emp.job:软件工程师|emp.age:23";
        Emp emp=new Emp();
        ObjectUtil objectUtil=new ObjectUtil();
        Map<String,Object> list=objectUtil.SplitVaule(content);
        Set<Map.Entry<String, Object>> set=list.entrySet();
        for(Map.Entry<String,Object> k:set){
            objectUtil.SetVaule(emp,k.getKey(),k.getValue());

        }
        System.out.println(emp);


    }
}
class ObjectUtil{

    //将字符串进行拆分
       public Map<String,Object>  SplitVaule(String content){

           Map<String,Object> map=new HashMap<>();

           //将给的内容进行拆分
           if(content!=null|| content.length() > 0){
               String[] Stringvaule=content.split("\\|");
               for(int i=0;i<Stringvaule.length;i++){
                   String[] attributeVaule=Stringvaule[i].split(":");//emp.ename    Jack
                  /* String Xattribute=attributeVaule[0];//emp.ename
                   int index=Xattribute.indexOf(".");
                   String attribute=Xattribute.substring(index+1);//ename*/

                  String attribute=attributeVaule[0].split("\\.")[1];//ename
                   String value=attributeVaule[1];//Jack
                   String Attribute=attribute.substring(0,1).toUpperCase()+attribute.substring(1);

                   map.put(Attribute,value);
               }

           }

           return  map;

       }

       //set方法赋值
    public void SetVaule(Object object,String Attribue,Object vaule){
           Class classes=object.getClass();
           Method[] methods=classes.getMethods();
           Method method=null;
           for(Method p:methods){
               try {
                   if(p.getName().equals("set"+Attribue)){
                       method=p;


                       //Integer要单独处理
                       Parameter parameter = method.getParameters()[0];//返回一个参数对象数组，该数组表示该方法对象的所有参数
                       if (parameter.getType() == Integer.class) {
                           method.invoke(object, Integer.parseInt(String.valueOf(vaule)));
                       } else {
                           method.invoke(object, vaule);
                       }

                   }
               } catch (IllegalAccessException | InvocationTargetException e) {
                   e.printStackTrace();
               }

           }

    }



    public void GetValue(Object object, String Attribute) {
        Class classes = object.getClass();
        try {
            //获取getXxx
            Method method = classes.getMethod("get" + Attribute);
            //调用getXxx
            System.out.println(method.invoke(object));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }



}
