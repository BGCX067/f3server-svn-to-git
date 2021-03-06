package info.knightrcom.data.metadata;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see info.knightrcom.data.metadata.LogInfo
 * @author MyEclipse Persistence Tools
 */

public class LogInfoDAO extends BaseHibernateDAO {
    private static final Log log = LogFactory.getLog(LogInfoDAO.class);

    // property constants
    public static final String NUMBER = "number";

    public static final String CAPTION = "caption";

    public static final String KEY_CAUSE1 = "keyCause1";

    public static final String KEY_CAUSE2 = "keyCause2";

    public static final String KEY_CAUSE3 = "keyCause3";

    public static final String INFO = "info";

    public static final String TYPE = "type";

    public static final String STATUS = "status";

    public static final String CREATE_BY = "createBy";

    public static final String UPDATE_BY = "updateBy";

    public void save(LogInfo transientInstance) {
        log.debug("saving LogInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(LogInfo persistentInstance) {
        log.debug("deleting LogInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public LogInfo findById(java.lang.String id) {
        log.debug("getting LogInfo instance with id: " + id);
        try {
            LogInfo instance = (LogInfo) getSession().get("info.knightrcom.data.metadata.LogInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
	public List<LogInfo> findByExample(LogInfo instance) {
        log.debug("finding LogInfo instance by example");
        try {
            List<LogInfo> results = (List<LogInfo>) getSession().createCriteria("info.knightrcom.data.metadata.LogInfo").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
	public List<LogInfo> findByProperty(String propertyName, Object value) {
        log.debug("finding LogInfo instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from LogInfo as model where model." + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List<LogInfo> findByNumber(Object number) {
        return findByProperty(NUMBER, number);
    }

    public List<LogInfo> findByCaption(Object caption) {
        return findByProperty(CAPTION, caption);
    }

    public List<LogInfo> findByKeyCause1(Object keyCause1) {
        return findByProperty(KEY_CAUSE1, keyCause1);
    }

    public List<LogInfo> findByKeyCause2(Object keyCause2) {
        return findByProperty(KEY_CAUSE2, keyCause2);
    }

    public List<LogInfo> findByKeyCause3(Object keyCause3) {
        return findByProperty(KEY_CAUSE3, keyCause3);
    }

    public List<LogInfo> findByInfo(Object info) {
        return findByProperty(INFO, info);
    }

    public List<LogInfo> findByType(Object type) {
        return findByProperty(TYPE, type);
    }

    public List<LogInfo> findByStatus(Object status) {
        return findByProperty(STATUS, status);
    }

    public List<LogInfo> findByCreateBy(Object createBy) {
        return findByProperty(CREATE_BY, createBy);
    }

    public List<LogInfo> findByUpdateBy(Object updateBy) {
        return findByProperty(UPDATE_BY, updateBy);
    }

    @SuppressWarnings("unchecked")
	public List<LogInfo> findAll() {
        log.debug("finding all LogInfo instances");
        try {
            String queryString = "from LogInfo";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public LogInfo merge(LogInfo detachedInstance) {
        log.debug("merging LogInfo instance");
        try {
            LogInfo result = (LogInfo) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LogInfo instance) {
        log.debug("attaching dirty LogInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(LogInfo instance) {
        log.debug("attaching clean LogInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
