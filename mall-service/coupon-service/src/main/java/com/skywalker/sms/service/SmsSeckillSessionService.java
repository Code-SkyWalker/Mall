package com.skywalker.sms.service;
import com.skywalker.sms.pojo.SmsSeckillSession;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSessionService
 * @Description TODO
 */
public interface SmsSeckillSessionService {

    /***
     * SmsSeckillSession多条件分页查询
     * @param smsSeckillSession
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillSession> findPage(SmsSeckillSession smsSeckillSession, int page, int size);

    /***
     * SmsSeckillSession分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SmsSeckillSession> findPage(int page, int size);

    /***
     * SmsSeckillSession多条件搜索方法
     * @param smsSeckillSession
     * @return
     */
    List<SmsSeckillSession> findList(SmsSeckillSession smsSeckillSession);

    /***
     * 删除SmsSeckillSession
     * @param id
     */
    void delete(Long id);

    /***
     * 修改SmsSeckillSession数据
     * @param smsSeckillSession
     */
    void update(SmsSeckillSession smsSeckillSession);

    /***
     * 新增SmsSeckillSession
     * @param smsSeckillSession
     */
    void add(SmsSeckillSession smsSeckillSession);

    /**
     * 根据ID查询SmsSeckillSession
     * @param id
     * @return
     */
     SmsSeckillSession findById(Long id);

    /***
     * 查询所有SmsSeckillSession
     * @return
     */
    List<SmsSeckillSession> findAll();
}
