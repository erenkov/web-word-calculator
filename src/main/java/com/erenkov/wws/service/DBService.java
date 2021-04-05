package com.erenkov.wws.service;

import com.erenkov.wws.data.dao.StatisticsDAO;
import com.erenkov.wws.model.entity.StatisticsDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBService {
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "create";

    private final SessionFactory sessionFactory;

    public DBService() {
        Configuration configuration = getH2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }

    //todo HARDCODE - в настоящем проекте так делать нельзя, конечно, но..))
    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(StatisticsDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./statistics");
        configuration.setProperty("hibernate.connection.username", "Simbirsoft");
        configuration.setProperty("hibernate.connection.password", "Simbirsoft");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }

    public StatisticsDataSet getStatistics(String word) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            StatisticsDAO dao = new StatisticsDAO(session);
            StatisticsDataSet dataSet = dao.get(word);
            session.close();
            return dataSet;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    //записать в таблицу
    public long addStatistics(String word, Long count) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            StatisticsDAO dao = new StatisticsDAO(session);
            long id = dao.insertStatistics(word, count);
            transaction.commit();
            session.close();
            return id;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    //записать в таблицу
    public void updateStatistics(String word, Long count) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            StatisticsDAO dao = new StatisticsDAO(session);
            dao.updateStatistics(word, count);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
