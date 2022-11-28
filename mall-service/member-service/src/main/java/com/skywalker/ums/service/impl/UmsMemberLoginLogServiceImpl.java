package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsMemberLoginLogMapper;
import com.skywalker.ums.pojo.UmsMemberLoginLog;
import com.skywalker.ums.service.UmsMemberLoginLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLoginLogServiceImpl
 * @Description TODO
 */
@Service
public class UmsMemberLoginLogServiceImpl implements UmsMemberLoginLogService {

    @Autowired
    private UmsMemberLoginLogMapper umsMemberLoginLogMapper;


    /**
     * UmsMemberLoginLog条件+分页查询
     * @param umsMemberLoginLog 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsMemberLoginLog> findPage(UmsMemberLoginLog umsMemberLoginLog, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsMemberLoginLog);
        //执行搜索
        return new PageInfo<UmsMemberLoginLog>(umsMemberLoginLogMapper.selectByExample(example));
    }

    /**
     * UmsMemberLoginLog分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsMemberLoginLog> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsMemberLoginLog>(umsMemberLoginLogMapper.selectAll());
    }

    /**
     * UmsMemberLoginLog条件查询
     * @param umsMemberLoginLog
     * @return
     */
    @Override
    public List<UmsMemberLoginLog> findList(UmsMemberLoginLog umsMemberLoginLog){
        //构建查询条件
        Example example = createExample(umsMemberLoginLog);
        //根据构建的条件查询数据
        return umsMemberLoginLogMapper.selectByExample(example);
    }


    /**
     * UmsMemberLoginLog构建查询对象
     * @param umsMemberLoginLog
     * @return
     */
    public Example createExample(UmsMemberLoginLog umsMemberLoginLog){
        Example example=new Example(UmsMemberLoginLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsMemberLoginLog!=null){
            // id
            if(!StringUtils.isEmpty(umsMemberLoginLog.getId())){
                    criteria.andEqualTo("id",umsMemberLoginLog.getId());
            }
            // member_id
            if(!StringUtils.isEmpty(umsMemberLoginLog.getMemberId())){
                    criteria.andEqualTo("memberId",umsMemberLoginLog.getMemberId());
            }
            // 创建时间
            if(!StringUtils.isEmpty(umsMemberLoginLog.getCreateTime())){
                    criteria.andEqualTo("createTime",umsMemberLoginLog.getCreateTime());
            }
            // ip
            if(!StringUtils.isEmpty(umsMemberLoginLog.getIp())){
                    criteria.andEqualTo("ip",umsMemberLoginLog.getIp());
            }
            // city
            if(!StringUtils.isEmpty(umsMemberLoginLog.getCity())){
                    criteria.andEqualTo("city",umsMemberLoginLog.getCity());
            }
            // 登录类型[1-web，2-app]
            if(!StringUtils.isEmpty(umsMemberLoginLog.getLoginType())){
                    criteria.andEqualTo("loginType",umsMemberLoginLog.getLoginType());
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
        umsMemberLoginLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsMemberLoginLog
     * @param umsMemberLoginLog
     */
    @Override
    public void update(UmsMemberLoginLog umsMemberLoginLog){
        umsMemberLoginLogMapper.updateByPrimaryKey(umsMemberLoginLog);
    }

    /**
     * 增加UmsMemberLoginLog
     * @param umsMemberLoginLog
     */
    @Override
    public void add(UmsMemberLoginLog umsMemberLoginLog){
        umsMemberLoginLogMapper.insert(umsMemberLoginLog);
    }

    /**
     * 根据ID查询UmsMemberLoginLog
     * @param id
     * @return
     */
    @Override
    public UmsMemberLoginLog findById(Long id){
        return  umsMemberLoginLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsMemberLoginLog全部数据
     * @return
     */
    @Override
    public List<UmsMemberLoginLog> findAll() {
        return umsMemberLoginLogMapper.selectAll();
    }
}
