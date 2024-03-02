package com.example.studentdb;

import java.util.Iterator;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import ch.qos.logback.classic.joran.action.ConfigurationAction;

public class StudentMain {
	SessionFactory sessionFactory = (SessionFactory) new ConfigurationAction().configure("hibenate.cnfg.xml").buildSessionFactory();
	Session session = ((org.hibernate.SessionFactory)).openSession(); 
	
	@
}
