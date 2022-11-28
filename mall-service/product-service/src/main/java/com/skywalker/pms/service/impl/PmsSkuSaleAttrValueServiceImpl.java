package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSkuSaleAttrValueMapper;
import com.skywalker.pms.pojo.PmsSkuSaleAttrValue;
import com.skywalker.pms.service.PmsSkuSaleAttrValueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSkuSaleAttrValueServiceImpl
 * @Description TODO
 */
@Service
public class PmsSkuSaleAttrValueServiceImpl implements PmsSkuSaleAttrValueService {

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;


    /**
     * PmsSkuSaleAttrValue条件+分页查询
     * @param pmsSkuSaleAttrValue 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsSkuSaleAttrValue> findPage(PmsSkuSaleAttrValue pmsSkuSaleAttrValue, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsSkuSaleAttrValue);
        //执行搜索
        return new PageInfo<PmsSkuSaleAttrValue>(pmsSkuSaleAttrValueMapper.selectByExample(example));
    }

    /**
     * PmsSkuSaleAttrValue分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsSkuSaleAttrValue> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsSkuSaleAttrValue>(pmsSkuSaleAttrValueMapper.selectAll());
    }

    /**
     * PmsSkuSaleAttrValue条件查询
     * @param pmsSkuSaleAttrValue
     * @return
     */
    @Override
    public List<PmsSkuSaleAttrValue> findList(PmsSkuSaleAttrValue pmsSkuSaleAttrValue){
        //构建查询条件
        Example example = createExample(pmsSkuSaleAttrValue);
        //根据构建的条件查询数据
        return pmsSkuSaleAttrValueMapper.selectByExample(example);
    }


    /**
     * PmsSkuSaleAttrValue构建查询对象
     * @param pmsSkuSaleAttrValue
     * @return
     */
    public Example createExample(PmsSkuSaleAttrValue pmsSkuSaleAttrValue){
        Example example=new Example(PmsSkuSaleAttrValue.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsSkuSaleAttrValue!=null){
            // id
            if(!StringUtils.isEmpty(pmsSkuSaleAttrValue.getId())){
                    criteria.andEqualTo("id",pmsSkuSaleAttrValue.getId());
            }
            // sku_id
            if(!StringUtils.isEmpty(pmsSkuSaleAttrValue.getSkuId())){
                    criteria.andEqualTo("skuId",pmsSkuSaleAttrValue.getSkuId());
            }
            // attr_id
            if(!StringUtils.isEmpty(pmsSkuSaleAttrValue.getAttrId())){
                    criteria.andEqualTo("attrId",pmsSkuSaleAttrValue.getAttrId());
            }
            // 销售属性名
            if(!StringUtils.isEmpty(pmsSkuSaleAttrValue.getAttrName())){
                    criteria.andEqualTo("attrName",pmsSkuSaleAttrValue.getAttrName());
            }
            // 销售属性值
            if(!StringUtils.isEmpty(pmsSkuSaleAttrValue.getAttrValue())){
                    criteria.andEqualTo("attrValue",pmsSkuSaleAttrValue.getAttrValue());
            }
            // 顺序
            if(!StringUtils.isEmpty(pmsSkuSaleAttrValue.getAttrSort())){
                    criteria.andEqualTo("attrSort",pmsSkuSaleAttrValue.getAttrSort());
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
        pmsSkuSaleAttrValueMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsSkuSaleAttrValue
     * @param pmsSkuSaleAttrValue
     */
    @Override
    public void update(PmsSkuSaleAttrValue pmsSkuSaleAttrValue){
        pmsSkuSaleAttrValueMapper.updateByPrimaryKey(pmsSkuSaleAttrValue);
    }

    /**
     * 增加PmsSkuSaleAttrValue
     * @param pmsSkuSaleAttrValue
     */
    @Override
    public void add(PmsSkuSaleAttrValue pmsSkuSaleAttrValue){
        pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
    }

    /**
     * 根据ID查询PmsSkuSaleAttrValue
     * @param id
     * @return
     */
    @Override
    public PmsSkuSaleAttrValue findById(Long id){
        return  pmsSkuSaleAttrValueMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsSkuSaleAttrValue全部数据
     * @return
     */
    @Override
    public List<PmsSkuSaleAttrValue> findAll() {
        return pmsSkuSaleAttrValueMapper.selectAll();
    }
}
