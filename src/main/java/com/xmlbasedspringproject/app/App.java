package com.xmlbasedspringproject.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./resources/spring.xml");
        
        /*
         * Singleton Scope Beans
         * For every getBean() invocation it refers to same object
         * Objects created when we load container
         */
        System.out.println("Singleton Scope Beans");
        HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld1.show();
        System.out.println("hashcode: "+ helloWorld1.hashCode());
        
        HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld2.show();
        System.out.println("hashcode: "+ helloWorld2.hashCode());
        
        
        /*
         * Prototype Scope Beans
         * For every getBean() invocation it create new objects
         * Objects got created with the explicit getBean() invocation.
         */
        System.out.println();
        System.out.println("Prototype Scope Beans");
        JavaWorld javaWorld1 = (JavaWorld) applicationContext.getBean("javaWorld");
        javaWorld1.show();
        System.out.println("hashcode: "+ javaWorld1.hashCode());
        
        JavaWorld javaWorld2 = (JavaWorld) applicationContext.getBean("javaWorld");
        javaWorld2.show();
        System.out.println("hashcode: "+ javaWorld2.hashCode());
        
        
        /*
         * Setter Injection
         * Which mandatory require the setters methods for all the variables in the class
         */
        System.out.println();
        System.out.println("Setter Injection");
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student.getId());
        student.getHelloWorld().show();
        student.getJavaWorld().show();
        
        
        /*
         * Constructor Injection| Following Order
         * Which mandatory require the setters methods for all the variables, allargs constructor, noargs constructor in the class
         */
        System.out.println();
        System.out.println("Constructor Injection| Following Order");
        Student student1 = (Student)applicationContext.getBean("student1");
        System.out.println(student1.getId());
        student1.getHelloWorld().show();
        student1.getJavaWorld().show();
        
        
        /*
         * Constructor Injection| Specifying type
         * Which mandatory require the setters methods for all the variables, allargs constructor, noargs constructor in the class
         */
        System.out.println();
        System.out.println("Constructor Injection| Specifying type");
        Student student2 = (Student)applicationContext.getBean("student2");
        System.out.println(student2.getId());
        student2.getHelloWorld().show();
        student2.getJavaWorld().show();
        
        
        /*
         * Constructor Injection| Specifying type
         * Which mandatory require the setters methods for all the variables, allargs constructor, noargs constructor in the class
         */
        System.out.println();
        System.out.println("Constructor Injection| Specifying index");
        Student student3 = (Student)applicationContext.getBean("student3");
        System.out.println(student3.getId());
        student3.getHelloWorld().show();
        student3.getJavaWorld().show();
        
        
        /*
         * Constructor Injection| Specifying @ConstructorProperties annotation
         * Upon Parameters Constructor: @ConstructorProperties({"Id","HelloWorld","JavaWorld"})
         * Which mandatory require the setters methods for all the variables, allArgs constructor, noArgs constructor in the class
         */
        System.out.println();
        System.out.println("Constructor Injection| Specifying @ConstructorProperties annotation");
        StudentInvoke student4 = (StudentInvoke)applicationContext.getBean("student4");
        System.out.println(student4.getId());
        student4.getHelloWorld().show();
        student4.getJavaWorld().show();
        
        
        /*
         * Using autowire| byName
         * Set any one bean name as same as the variable name in the callable class
         * Explicit mention property, has the highest priority 
         */
        System.out.println();
        System.out.println("Using autowire| byName");
        Stud stud = (Stud) applicationContext.getBean("stud");
        System.out.println(stud.getId());
        stud.getComputer().show();
        
        
        /*
         * Using autowire| byType
         * Only work when we have one bean of required type, else throw error
         * Solve multiple beans of same type , mention any one bean as primary
         * Especially helpful during database connection.
         * Explicit mention property, has the highest priority 
         */
        System.out.println();
        System.out.println("Using autowire| byType");
        Wheeler wheeler = (Wheeler) applicationContext.getBean("wheeler");
        System.out.println(wheeler.getId());
        wheeler.getVehicle().show();
        
        /*
         * Lazy-init
         */
        System.out.println();
        System.out.println("Lazy-init");
        System.out.println("Application context loaded");
        // it will not created by default when we call ApplicationContext is created
        // created when we actually use it
        Holiday holiday = (Holiday) applicationContext.getBean("holiday");
        // by default all beans are created when ApplicationContext is created.
        Workday workday = (Workday) applicationContext.getBean("workday");
        
        /*
         * remove Typecasting in main class
         * getBean() by the Type
         * Note: for Interfaces it's good to getBean() by Name
         */
        System.out.println();
        System.out.println("getBean() by the Type| remove Typecasting in main class");
        HelloWorld hw = (HelloWorld) applicationContext.getBean("helloWorld",HelloWorld.class);
        hw.show();
        
        //We can remove id property in bean
        JavaWorld jw = (JavaWorld) applicationContext.getBean(JavaWorld.class);
        jw.show();
        
        /*
         * Inner Bean
         */
        System.out.println();
        System.out.println("Inner Bean");
        Student student5 = (Student) applicationContext.getBean("student5");
        System.out.println(student5.getId());
        student5.getHelloWorld().show();
        student5.getJavaWorld().show();
        
        /*
        		******** Inner Beans ********
        		<property name="com">
        			<bean id="com1" class="com.xmlbasedspringproject.app.Laptop" primary="true"></bean>
        		</property>
        */
    }
}
