package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsIntegrationChangeHistoryMapper;
import com.skywalker.ums.pojo.UmsIntegrationChangeHistory;
import com.skywalker.ums.service.UmsIntegrationChangeHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsIntegrationChangeHistoryServiceImpl
 * @Description TODO
 */
@Service
public class UmsIntegrationChangeHistoryServiceImpl implements UmsIntegrationChangeHistoryService {

    @Autowired
    private UmsIntegrationChangeHistoryMapper umsIntegrationChangeHistoryMapper;


    /**
     * UmsIntegrationChangeHistory条件+分页查询
     * @param umsIntegrationChangeHistory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsIntegrationChangeHistory> findPage(UmsIntegrationChangeHistory umsIntegrationChangeHistory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsIntegrationChangeHistory);
        //执行搜索
        return new PageInfo<UmsIntegrationChangeHistory>(umsIntegrationChangeHistoryMapper.selectByExample(example));
    }

    /**
     * UmsIntegrationChangeHistory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsIntegrationChangeHistory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsIntegrationChangeHistory>(umsIntegrationChangeHistoryMapper.selectAll());
    }

    /**
     * UmsIntegrationChangeHistory条件查询
     * @param umsIntegrationChangeHistory
     * @return
     */
    @Override
    public List<UmsIntegrationChangeHistory> findList(UmsIntegrationChangeHistory umsIntegrationChangeHistory){
        //构建查询条件
        Example example = createExample(umsIntegrationChangeHistory);
        //根据构建的条件查询数据
        return umsIntegrationChangeHistoryMapper.selectByExample(example);
    }


    /**
     * UmsIntegrationChangeHistory构建查询对象
     * @param umsIntegrationChangeHistory
     * @return
     */
    public Example createExample(UmsIntegrationChangeHistory umsIntegrationChangeHistory){
        Example example=new Example(UmsIntegrationChangeHistory.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsIntegrationChangeHistory!=null){
            // id
            if(!StringUtils.isEmpty(umsIntegrationChangeHistory.getId())){
                    criteria.andEqualTo("id",umsIntegrationChangeHistory.getId());
            }
            // member_id
            if(!StringUtils.isEmpty(umsIntegrationChangeHistory.getMemberId())){
                    criteria.andEqualTo("memberId",umsIntegrationChangeHistory.getMemberId());
            }
            // create_time
            if(!StringUtils.isEmpty(umsIntegrationChangeHistory.getCreateTime())){
                    criteria.andEqualTo("createTime",umsIntegrationChangeHistory.getCreateTime());
            }
            // 变化的值
            if(!StringUtils.isEmpty(umsIntegrationChangeHistory.getChangeCount())){
                    criteria.andEqualTo("changeCount",umsIntegrationChangeHistory.getChangeCount());
            }
            // 备注
            if(!StringUtils.isEmpty(umsIntegrationChangeHistory.getNote())){
                    criteria.andEqualTo("note",umsIntegrationChangeHistory.getNote());
            }
            // 来源[0->购物；1->管理员修改;2->活动]
            if(!StringUtils.isEmpty(umsIntegrationChangeHistory.getSourceTyoe())){
                    criteria.andEqualTo("sourceTyoe",umsIntegrationChangeHistory.getSourceTyoe());
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
        umsIntegrationChangeHistoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsIntegrationChangeHistory
     * @param umsIntegrationChangeHistory
     */
    @Override
    public void update(UmsIntegrationChangeHistory umsIntegrationChangeHistory){
        umsIntegrationChangeHistoryMapper.updateByPrimaryKey(umsIntegrationChangeHistory);
    }

    /**
     * 增加UmsIntegrationChangeHistory
     * @param umsIntegrationChangeHistory
     */
    @Override
    public void add(UmsIntegrationChangeHistory umsIntegrationChangeHistory){
        umsIntegrationChangeHistoryMapper.insert(umsIntegrationChangeHistory);
    }

    /**
     * 根据ID查询UmsIntegrationChangeHistory
     * @param id
     * @return
     */
    @Override
    public UmsIntegrationChangeHistory findById(Long id){
        return  umsIntegrationChangeHistoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsIntegrationChangeHistory全部数据
     * @return
     */
    @Override
    public List<UmsIntegrationChangeHistory> findAll() {
        return umsIntegrationChangeHistoryMapper.selectAll();
    }
}
