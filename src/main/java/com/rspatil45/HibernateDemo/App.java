package com.rspatil45.HibernateDemo;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        AlienName an = new AlienName();
//        an.setFname("rahul");
//        an.setMname("rajendra");
//        an.setLname("patil");
//    	
//        Alien alien = new Alien();
//        alien.setAid(101);
//        alien.setAname(an);
//        alien.setColor("Green");
////         since we are using default name
//        
//        
//        Configuration con = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(Alien.class);
////        SessionFactory sf = con.buildSessionFactory(); // deprecated
//        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
//        SessionFactory sf = con.buildSessionFactory(reg);
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(alien);
//        tx.commit();
////        Alien a2 = new Alien();
////        a2 = (Alien)session.get(Alien.class, 104);
////        System.out.println(a2);
    	Laptop l1 = new Laptop();
    	l1.setLid(10211);
    	l1.setLname("Dell");
    	Students s1 = new Students();
    	s1.setRollno(1);
    	s1.setName("rahul");
    	s1.setMarks(85);
    	s1.getLaptop().add(l1);
    	l1.getStudent().add(s1);
    	
        Configuration con = new Configuration().configure().addAnnotatedClass(Students.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        
        Session session = sf.openSession();        
        Transaction tx = session.beginTransaction();
//        session.save(l1);
//        session.save(s1);
        Alien a1 = (Alien)session.get(Alien.class, 101);
        System.out.println(a1);
        tx.commit();
        
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        Alien a2 = (Alien)session2.get(Alien.class, 101);
        System.out.println(a2);
        tx2.commit();
        
        tx = session.beginTransaction();
        Query q1 = session.createQuery("from Alien where aid=102");
        q1.setCacheable(true);
        a1 = (Alien)q1.uniqueResult();
        System.out.println(a1);
        tx.commit();
        
        tx2 = session2.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid=102");
        q2.setCacheable(true);
        a1 = (Alien)q1.uniqueResult();
        System.out.println(a1);
        tx2.commit();
        
//        Random r = new Random();
//        tx = session.beginTransaction();
//        for(int i =1;i<=50;i++)
//        {
//        	Students s = new Students();
//        	s.setRollno(i);
//        	s.setName("Name"+i);
//        	s.setMarks(r.nextInt(100));
//        	session.save(s);
//        }
//        tx.commit();
        
        session.beginTransaction();
//        Query q3 = session.createQuery("from Students");
        Query q3 = session.createQuery("from Students where marks = 50");        
        List<Students> slist = q3.list();
        System.out.println(slist);        
        session.getTransaction().commit();
        
        session.beginTransaction();
        Query q4 = session.createQuery("select rollno, name from Students where marks >90");
        List<Object[]> student = (List<Object []>)q4.list();
        for(Object[] obj : student)
        {
        	System.out.println("rollno : "+obj[0]+" name : "+obj[1]);
        }
        
        int mark = 95;
        Query q5 = session.createQuery("from Students where marks > :b");
        q5.setParameter("b", mark);
        slist = (List<Students>)q5.list();
        System.out.println(slist.get(0));

        // using sql query in hibernate, native query
        SQLQuery sq1 = session.createSQLQuery("select * from students where marks>90 limit 1");        
        sq1.addEntity(Students.class);  //direct cast is not available for sql query, also here students is table name not class name
        s1 = (Students)sq1.uniqueResult();
        System.out.println(s1);
        // fetching specific value
        sq1 = session.createSQLQuery("select rollno,name from students where marks>90 limit 1");
        sq1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        Map m1 = (Map)sq1.uniqueResult();
        System.out.println(m1.get("rollno")+" : "+m1.get("name"));        
        session.getTransaction().commit();
        
        // understanding hibernate object states.
        session.beginTransaction();        
        Laptop laptop = new Laptop();
        // object is now in transient state
        laptop.setLid(123);
        laptop.setLname("Nokia");
        session.save(laptop);
        // object is now in persistent state
        laptop.setLname("HP");;  //will update the record in db
        session.get(Laptop.class, 123);
        
        session.delete(laptop);
        session.getTransaction().commit();
        session.close();
        
        
    }
}
