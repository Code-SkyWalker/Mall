package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsSeckillSessionMapper;
import com.skywalker.sms.pojo.SmsSeckillSession;
import com.skywalker.sms.service.SmsSeckillSessionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSessionServiceImpl
 * @Description TODO
 */
@Service
public class SmsSeckillSessionServiceImpl implements SmsSeckillSessionService {

    @Autowired
    private SmsSeckillSessionMapper smsSeckillSessionMapper;


    /**
     * SmsSeckillSession条件+分页查询
     * @param smsSeckillSession 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsSeckillSession> findPage(SmsSeckillSession smsSeckillSession, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsSeckillSession);
        //执行搜索
        return new PageInfo<SmsSeckillSession>(smsSeckillSessionMapper.selectByExample(example));
    }

    /**
     * SmsSeckillSession分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsSeckillSession> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsSeckillSession>(smsSeckillSessionMapper.selectAll());
    }

    /**
     * SmsSeckillSession条件查询
     * @param smsSeckillSession
     * @return
     */
    @Override
    public List<SmsSeckillSession> findList(SmsSeckillSession smsSeckillSession){
        //构建查询条件
        Example example = createExample(smsSeckillSession);
        //根据构建的条件查询数据
        return smsSeckillSessionMapper.selectByExample(example);
    }


    /**
     * SmsSeckillSession构建查询对象
     * @param smsSeckillSession
     * @return
     */
    public Example createExample(SmsSeckillSession smsSeckillSession){
        Example example=new Example(SmsSeckillSession.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsSeckillSession!=null){
            // id
            if(!StringUtils.isEmpty(smsSeckillSession.getId())){
                    criteria.andEqualTo("id",smsSeckillSession.getId());
            }
            // 场次名称
            if(!StringUtils.isEmpty(smsSeckillSession.getName())){
                    criteria.andLike("name","%"+smsSeckillSession.getName()+"%");
            }
            // 每日开始时间
            if(!StringUtils.isEmpty(smsSeckillSession.getStartTime())){
                    criteria.andEqualTo("startTime",smsSeckillSession.getStartTime());
            }
            // 每日结束时间
            if(!StringUtils.isEmpty(smsSeckillSession.getEndTime())){
                    criteria.andEqualTo("endTime",smsSeckillSession.getEndTime());
            }
            // 启用状态
            if(!StringUtils.isEmpty(smsSeckillSession.getStatus())){
                    criteria.andEqualTo("status",smsSeckillSession.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(smsSeckillSession.getCreateTime())){
                    criteria.andEqualTo("createTime",smsSeckillSession.getCreateTime());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        smsSeckillSessionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsSeckillSession
     * @param smsSeckillSession
     */
    @Override
    public void update(SmsSeckillSession smsSeckillSession){
        smsSeckillSessionMapper.updateByPrimaryKey(smsSeckillSession);
    }

    /**
     * 增加SmsSeckillSession
     * @param smsSeckillSession
     */
    @Override
    public void add(SmsSeckillSession smsSeckillSession){
        smsSeckillSessionMapper.insert(smsSeckillSession);
    }

    /**
     * 根据ID查询SmsSeckillSession
     * @param id
     * @return
     */
    @Override
    public SmsSeckillSession findById(Long id){
        return  smsSeckillSessionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsSeckillSession全部数据
     * @return
     */
    @Override
    public List<SmsSeckillSession> findAll() {
        return smsSeckillSessionMapper.selectAll();
    }
}
