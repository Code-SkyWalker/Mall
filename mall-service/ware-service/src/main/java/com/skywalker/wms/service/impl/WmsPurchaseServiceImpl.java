package com.skywalker.wms.service.impl;
import com.skywalker.wms.dao.WmsPurchaseMapper;
import com.skywalker.wms.pojo.WmsPurchase;
import com.skywalker.wms.service.WmsPurchaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseServiceImpl
 * @Description TODO
 */
@Service
public class WmsPurchaseServiceImpl implements WmsPurchaseService {

    @Autowired
    private WmsPurchaseMapper wmsPurchaseMapper;


    /**
     * WmsPurchase条件+分页查询
     * @param wmsPurchase 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsPurchase> findPage(WmsPurchase wmsPurchase, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wmsPurchase);
        //执行搜索
        return new PageInfo<WmsPurchase>(wmsPurchaseMapper.selectByExample(example));
    }

    /**
     * WmsPurchase分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsPurchase> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WmsPurchase>(wmsPurchaseMapper.selectAll());
    }

    /**
     * WmsPurchase条件查询
     * @param wmsPurchase
     * @return
     */
    @Override
    public List<WmsPurchase> findList(WmsPurchase wmsPurchase){
        //构建查询条件
        Example example = createExample(wmsPurchase);
        //根据构建的条件查询数据
        return wmsPurchaseMapper.selectByExample(example);
    }


    /**
     * WmsPurchase构建查询对象
     * @param wmsPurchase
     * @return
     */
    public Example createExample(WmsPurchase wmsPurchase){
        Example example=new Example(WmsPurchase.class);
        Example.Criteria criteria = example.createCriteria();
        if(wmsPurchase!=null){
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getId())){
                    criteria.andEqualTo("id",wmsPurchase.getId());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getAssigneeId())){
                    criteria.andEqualTo("assigneeId",wmsPurchase.getAssigneeId());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getAssigneeName())){
                    criteria.andEqualTo("assigneeName",wmsPurchase.getAssigneeName());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getPhone())){
                    criteria.andEqualTo("phone",wmsPurchase.getPhone());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getPriority())){
                    criteria.andEqualTo("priority",wmsPurchase.getPriority());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getStatus())){
                    criteria.andEqualTo("status",wmsPurchase.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getWareId())){
                    criteria.andEqualTo("wareId",wmsPurchase.getWareId());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getAmount())){
                    criteria.andEqualTo("amount",wmsPurchase.getAmount());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getCreateTime())){
                    criteria.andEqualTo("createTime",wmsPurchase.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(wmsPurchase.getUpdateTime())){
                    criteria.andEqualTo("updateTime",wmsPurchase.getUpdateTime());
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
        wmsPurchaseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WmsPurchase
     * @param wmsPurchase
     */
    @Override
    public void update(WmsPurchase wmsPurchase){
        wmsPurchaseMapper.updateByPrimaryKey(wmsPurchase);
    }

    /**
     * 增加WmsPurchase
     * @param wmsPurchase
     */
    @Override
    public void add(WmsPurchase wmsPurchase){
        wmsPurchaseMapper.insert(wmsPurchase);
    }

    /**
     * 根据ID查询WmsPurchase
     * @param id
     * @return
     */
    @Override
    public WmsPurchase findById(Long id){
        return  wmsPurchaseMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsPurchase全部数据
     * @return
     */
    @Override
    public List<WmsPurchase> findAll() {
        return wmsPurchaseMapper.selectAll();
    }
}
