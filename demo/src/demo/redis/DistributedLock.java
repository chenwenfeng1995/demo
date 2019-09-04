package demo.redis;

import java.util.List;
import java.util.UUID;

import com.sun.org.glassfish.gmbal.ManagedObjectManager.RegistrationDebugLevel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisException;

public class DistributedLock {

	private final JedisPool jedisPool;
	public DistributedLock(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

	 /**
       *����
     * @param lockName       ����key
     * @param acquireTimeout ��ȡ��ʱʱ��
     * @param timeout        ���ĳ�ʱʱ��
     * @return ����ʶ
     */
	public String lockWithTimeout(String lockName,long  acquireTimeout,long timeout) {
		Jedis conn=null;
		String retindetifier=null;
		try {
			//��ȡ����
			conn=jedisPool.getResource();
			// �������һ��value
			String  indetifier=UUID.randomUUID().toString();
			// ��������keyֵ
			String lockKey ="lock"+lockName;
			// ��ʱʱ�䣬�����󳬹���ʱ�����Զ��ͷ���
			int lockExpire =(int) (timeout/1000);
			// ��ȡ���ĳ�ʱʱ�䣬�������ʱ���������ȡ��
			long end=System.currentTimeMillis()+acquireTimeout;
			while(System.currentTimeMillis() < end) {
				if(conn.setnx(lockKey,indetifier)==1) {
					conn.expire(lockKey, lockExpire);
					 // ����valueֵ�������ͷ���ʱ��ȷ��
					retindetifier=indetifier;
					return retindetifier;
				}
				 // ����-1����keyû�����ó�ʱʱ�䣬Ϊkey����һ����ʱʱ��
                if (conn.ttl(lockKey) == -1) {
                    conn.expire(lockKey, lockExpire);
                }

				try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

			}
		}catch(JedisException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
            	conn.quit();
            }
        }
     	return retindetifier;
		
	}
	/**
     * �ͷ���
     * @param lockName   ����key
     * @param identifier �ͷ����ı�ʶ
     * @return
     */
    public boolean releaseLock(String lockName, String identifier) {
        Jedis conn = null;
        String lockKey = "lock:" + lockName;
        boolean retFlag = false;
        try {
            conn = jedisPool.getResource();
            while (true) {
                // ����lock��׼����ʼ����
                conn.watch(lockKey);
                // ͨ��ǰ�淵�ص�valueֵ�ж��ǲ��Ǹ��������Ǹ�������ɾ�����ͷ���
                if (identifier.equals(conn.get(lockKey))) {
                    Transaction transaction = conn.multi();
                    transaction.del(lockKey);
                    List<Object> results = transaction.exec();
                    if (results == null) {
                        continue;
                    }
                    retFlag = true;
                }
                conn.unwatch();
                break;
            }
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.quit();
            }
        }
        return retFlag;
    }
}

