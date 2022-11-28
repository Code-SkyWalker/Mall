package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsOrderReturnReasonMapper;
import com.skywalker.oms.pojo.OmsOrderReturnReason;
import com.skywalker.oms.service.OmsOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnReasonServiceImpl
 * @Description TODO
 */
@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {

    @Autowired
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;


    /**
     * OmsOrderReturnReason条件+分页查询
     * @param omsOrderReturnReason 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsOrderReturnReason> findPage(OmsOrderReturnReason omsOrderReturnReason, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsOrderReturnReason);
        //执行搜索
        return new PageInfo<OmsOrderReturnReason>(omsOrderReturnReasonMapper.selectByExample(example));
    }

    /**
     * OmsOrderReturnReason分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsOrderReturnReason> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsOrderReturnReason>(omsOrderReturnReasonMapper.selectAll());
    }

    /**
     * OmsOrderReturnReason条件查询
     * @param omsOrderReturnReason
     * @return
     */
    @Override
    public List<OmsOrderReturnReason> findList(OmsOrderReturnReason omsOrderReturnReason){
        //构建查询条件
        Example example = createExample(omsOrderReturnReason);
        //根据构建的条件查询数据
        return omsOrderReturnReasonMapper.selectByExample(example);
    }


    /**
     * OmsOrderReturnReason构建查询对象
     * @param omsOrderReturnReason
     * @return
     */
    public Example createExample(OmsOrderReturnReason omsOrderReturnReason){
        Example example=new Example(OmsOrderReturnReason.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsOrderReturnReason!=null){
            // id
            if(!StringUtils.isEmpty(omsOrderReturnReason.getId())){
                    criteria.andEqualTo("id",omsOrderReturnReason.getId());
            }
            // 退货原因名
            if(!StringUtils.isEmpty(omsOrderReturnReason.getName())){
                    criteria.andLike("name","%"+omsOrderReturnReason.getName()+"%");
            }
            // 排序
            if(!StringUtils.isEmpty(omsOrderReturnReason.getSort())){
                    criteria.andEqualTo("sort",omsOrderReturnReason.getSort());
            }
            // 启用状态
            if(!StringUtils.isEmpty(omsOrderReturnReason.getStatus())){
                    criteria.andEqualTo("status",omsOrderReturnReason.getStatus());
            }
            // create_time
            if(!StringUtils.isEmpty(omsOrderReturnReason.getCreateTime())){
                    criteria.andEqualTo("createTime",omsOrderReturnReason.getCreateTime());
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
        omsOrderReturnReasonMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsOrderReturnReason
     * @param omsOrderReturnReason
     */
    @Override
    public void update(OmsOrderReturnReason omsOrderReturnReason){
        omsOrderReturnReasonMapper.updateByPrimaryKey(omsOrderReturnReason);
    }

    /**
     * 增加OmsOrderReturnReason
     * @param omsOrderReturnReason
     */
    @Override
    public void add(OmsOrderReturnReason omsOrderReturnReason){
        omsOrderReturnReasonMapper.insert(omsOrderReturnReason);
    }

    /**
     * 根据ID查询OmsOrderReturnReason
     * @param id
     * @return
     */
    @Override
    public OmsOrderReturnReason findById(Long id){
        return  omsOrderReturnReasonMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsOrderReturnReason全部数据
     * @return
     */
    @Override
    public List<OmsOrderReturnReason> findAll() {
        return omsOrderReturnReasonMapper.selectAll();
    }
}
