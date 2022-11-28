package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsGrowthChangeHistoryMapper;
import com.skywalker.ums.pojo.UmsGrowthChangeHistory;
import com.skywalker.ums.service.UmsGrowthChangeHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsGrowthChangeHistoryServiceImpl
 * @Description TODO
 */
@Service
public class UmsGrowthChangeHistoryServiceImpl implements UmsGrowthChangeHistoryService {

    @Autowired
    private UmsGrowthChangeHistoryMapper umsGrowthChangeHistoryMapper;


    /**
     * UmsGrowthChangeHistory条件+分页查询
     * @param umsGrowthChangeHistory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsGrowthChangeHistory> findPage(UmsGrowthChangeHistory umsGrowthChangeHistory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsGrowthChangeHistory);
        //执行搜索
        return new PageInfo<UmsGrowthChangeHistory>(umsGrowthChangeHistoryMapper.selectByExample(example));
    }

    /**
     * UmsGrowthChangeHistory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsGrowthChangeHistory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsGrowthChangeHistory>(umsGrowthChangeHistoryMapper.selectAll());
    }

    /**
     * UmsGrowthChangeHistory条件查询
     * @param umsGrowthChangeHistory
     * @return
     */
    @Override
    public List<UmsGrowthChangeHistory> findList(UmsGrowthChangeHistory umsGrowthChangeHistory){
        //构建查询条件
        Example example = createExample(umsGrowthChangeHistory);
        //根据构建的条件查询数据
        return umsGrowthChangeHistoryMapper.selectByExample(example);
    }


    /**
     * UmsGrowthChangeHistory构建查询对象
     * @param umsGrowthChangeHistory
     * @return
     */
    public Example createExample(UmsGrowthChangeHistory umsGrowthChangeHistory){
        Example example=new Example(UmsGrowthChangeHistory.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsGrowthChangeHistory!=null){
            // id
            if(!StringUtils.isEmpty(umsGrowthChangeHistory.getId())){
                    criteria.andEqualTo("id",umsGrowthChangeHistory.getId());
            }
            // member_id
            if(!StringUtils.isEmpty(umsGrowthChangeHistory.getMemberId())){
                    criteria.andEqualTo("memberId",umsGrowthChangeHistory.getMemberId());
            }
            // create_time
            if(!StringUtils.isEmpty(umsGrowthChangeHistory.getCreateTime())){
                    criteria.andEqualTo("createTime",umsGrowthChangeHistory.getCreateTime());
            }
            // 改变的值（正负计数）
            if(!StringUtils.isEmpty(umsGrowthChangeHistory.getChangeCount())){
                    criteria.andEqualTo("changeCount",umsGrowthChangeHistory.getChangeCount());
            }
            // 备注
            if(!StringUtils.isEmpty(umsGrowthChangeHistory.getNote())){
                    criteria.andEqualTo("note",umsGrowthChangeHistory.getNote());
            }
            // 积分来源[0-购物，1-管理员修改]
            if(!StringUtils.isEmpty(umsGrowthChangeHistory.getSourceType())){
                    criteria.andEqualTo("sourceType",umsGrowthChangeHistory.getSourceType());
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
        umsGrowthChangeHistoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsGrowthChangeHistory
     * @param umsGrowthChangeHistory
     */
    @Override
    public void update(UmsGrowthChangeHistory umsGrowthChangeHistory){
        umsGrowthChangeHistoryMapper.updateByPrimaryKey(umsGrowthChangeHistory);
    }

    /**
     * 增加UmsGrowthChangeHistory
     * @param umsGrowthChangeHistory
     */
    @Override
    public void add(UmsGrowthChangeHistory umsGrowthChangeHistory){
        umsGrowthChangeHistoryMapper.insert(umsGrowthChangeHistory);
    }

    /**
     * 根据ID查询UmsGrowthChangeHistory
     * @param id
     * @return
     */
    @Override
    public UmsGrowthChangeHistory findById(Long id){
        return  umsGrowthChangeHistoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsGrowthChangeHistory全部数据
     * @return
     */
    @Override
    public List<UmsGrowthChangeHistory> findAll() {
        return umsGrowthChangeHistoryMapper.selectAll();
    }
}
