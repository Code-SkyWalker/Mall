package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsProductAttrValueMapper;
import com.skywalker.pms.pojo.PmsProductAttrValue;
import com.skywalker.pms.service.PmsProductAttrValueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsProductAttrValueServiceImpl
 * @Description TODO
 */
@Service
public class PmsProductAttrValueServiceImpl implements PmsProductAttrValueService {

    @Autowired
    private PmsProductAttrValueMapper pmsProductAttrValueMapper;


    /**
     * PmsProductAttrValue条件+分页查询
     * @param pmsProductAttrValue 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsProductAttrValue> findPage(PmsProductAttrValue pmsProductAttrValue, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsProductAttrValue);
        //执行搜索
        return new PageInfo<PmsProductAttrValue>(pmsProductAttrValueMapper.selectByExample(example));
    }

    /**
     * PmsProductAttrValue分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsProductAttrValue> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsProductAttrValue>(pmsProductAttrValueMapper.selectAll());
    }

    /**
     * PmsProductAttrValue条件查询
     * @param pmsProductAttrValue
     * @return
     */
    @Override
    public List<PmsProductAttrValue> findList(PmsProductAttrValue pmsProductAttrValue){
        //构建查询条件
        Example example = createExample(pmsProductAttrValue);
        //根据构建的条件查询数据
        return pmsProductAttrValueMapper.selectByExample(example);
    }


    /**
     * PmsProductAttrValue构建查询对象
     * @param pmsProductAttrValue
     * @return
     */
    public Example createExample(PmsProductAttrValue pmsProductAttrValue){
        Example example=new Example(PmsProductAttrValue.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsProductAttrValue!=null){
            // id
            if(!StringUtils.isEmpty(pmsProductAttrValue.getId())){
                    criteria.andEqualTo("id",pmsProductAttrValue.getId());
            }
            // 商品id
            if(!StringUtils.isEmpty(pmsProductAttrValue.getSpuId())){
                    criteria.andEqualTo("spuId",pmsProductAttrValue.getSpuId());
            }
            // 属性id
            if(!StringUtils.isEmpty(pmsProductAttrValue.getAttrId())){
                    criteria.andEqualTo("attrId",pmsProductAttrValue.getAttrId());
            }
            // 属性名
            if(!StringUtils.isEmpty(pmsProductAttrValue.getAttrName())){
                    criteria.andEqualTo("attrName",pmsProductAttrValue.getAttrName());
            }
            // 属性值
            if(!StringUtils.isEmpty(pmsProductAttrValue.getAttrValue())){
                    criteria.andEqualTo("attrValue",pmsProductAttrValue.getAttrValue());
            }
            // 顺序
            if(!StringUtils.isEmpty(pmsProductAttrValue.getAttrSort())){
                    criteria.andEqualTo("attrSort",pmsProductAttrValue.getAttrSort());
            }
            // 快速展示【是否展示在介绍上；0-否 1-是】
            if(!StringUtils.isEmpty(pmsProductAttrValue.getQuickShow())){
                    criteria.andEqualTo("quickShow",pmsProductAttrValue.getQuickShow());
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
        pmsProductAttrValueMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsProductAttrValue
     * @param pmsProductAttrValue
     */
    @Override
    public void update(PmsProductAttrValue pmsProductAttrValue){
        pmsProductAttrValueMapper.updateByPrimaryKey(pmsProductAttrValue);
    }

    /**
     * 增加PmsProductAttrValue
     * @param pmsProductAttrValue
     */
    @Override
    public void add(PmsProductAttrValue pmsProductAttrValue){
        pmsProductAttrValueMapper.insert(pmsProductAttrValue);
    }

    /**
     * 根据ID查询PmsProductAttrValue
     * @param id
     * @return
     */
    @Override
    public PmsProductAttrValue findById(Long id){
        return  pmsProductAttrValueMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsProductAttrValue全部数据
     * @return
     */
    @Override
    public List<PmsProductAttrValue> findAll() {
        return pmsProductAttrValueMapper.selectAll();
    }
}
