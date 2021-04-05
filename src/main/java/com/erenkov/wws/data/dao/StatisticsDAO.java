package com.erenkov.wws.data.dao;

import com.erenkov.wws.model.entity.StatisticsDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class StatisticsDAO {

    private final Session session; //todo поправить конструкторы с ддвумя параметрами

    public StatisticsDAO(Session session) {
        this.session = session;
    }

    public StatisticsDataSet get(String word) throws HibernateException {
        return (StatisticsDataSet) session.get(StatisticsDataSet.class, word);
    }

    public long getStatisticsId(String word) throws HibernateException {
        Criteria criteria = session.createCriteria(StatisticsDataSet.class);
        return ((StatisticsDataSet) criteria.add(Restrictions.eq("word", word)).uniqueResult()).getId();
    }

    public long insertStatistics(String word, Long count) throws HibernateException {
        return (Long) session.save(new StatisticsDataSet(word, count));
    }

    public void updateStatistics(String word, Long count) throws HibernateException {
        session.update(new StatisticsDataSet(word, count));
    }
}
