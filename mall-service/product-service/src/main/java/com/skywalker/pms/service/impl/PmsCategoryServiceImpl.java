package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsCategoryMapper;
import com.skywalker.pms.pojo.PmsCategory;
import com.skywalker.pms.service.PmsCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryServiceImpl
 * @Description TODO
 */
@Service
public class PmsCategoryServiceImpl implements PmsCategoryService {

    @Autowired
    private PmsCategoryMapper pmsCategoryMapper;


    /**
     * PmsCategory条件+分页查询
     * @param pmsCategory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsCategory> findPage(PmsCategory pmsCategory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsCategory);
        //执行搜索
        return new PageInfo<PmsCategory>(pmsCategoryMapper.selectByExample(example));
    }

    /**
     * PmsCategory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsCategory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsCategory>(pmsCategoryMapper.selectAll());
    }

    /**
     * PmsCategory条件查询
     * @param pmsCategory
     * @return
     */
    @Override
    public List<PmsCategory> findList(PmsCategory pmsCategory){
        //构建查询条件
        Example example = createExample(pmsCategory);
        //根据构建的条件查询数据
        return pmsCategoryMapper.selectByExample(example);
    }


    /**
     * PmsCategory构建查询对象
     * @param pmsCategory
     * @return
     */
    public Example createExample(PmsCategory pmsCategory){
        Example example=new Example(PmsCategory.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsCategory!=null){
            // 分类id
            if(!StringUtils.isEmpty(pmsCategory.getCatId())){
                    criteria.andEqualTo("catId",pmsCategory.getCatId());
            }
            // 分类名称
            if(!StringUtils.isEmpty(pmsCategory.getName())){
                    criteria.andLike("name","%"+pmsCategory.getName()+"%");
            }
            // 父分类id
            if(!StringUtils.isEmpty(pmsCategory.getParentCid())){
                    criteria.andEqualTo("parentCid",pmsCategory.getParentCid());
            }
            // 层级
            if(!StringUtils.isEmpty(pmsCategory.getCatLevel())){
                    criteria.andEqualTo("catLevel",pmsCategory.getCatLevel());
            }
            // 是否显示[0-不显示，1显示]
            if(!StringUtils.isEmpty(pmsCategory.getShowStatus())){
                    criteria.andEqualTo("showStatus",pmsCategory.getShowStatus());
            }
            // 排序
            if(!StringUtils.isEmpty(pmsCategory.getSort())){
                    criteria.andEqualTo("sort",pmsCategory.getSort());
            }
            // 图标地址
            if(!StringUtils.isEmpty(pmsCategory.getIcon())){
                    criteria.andEqualTo("icon",pmsCategory.getIcon());
            }
            // 计量单位
            if(!StringUtils.isEmpty(pmsCategory.getProductUnit())){
                    criteria.andEqualTo("productUnit",pmsCategory.getProductUnit());
            }
            // 商品数量
            if(!StringUtils.isEmpty(pmsCategory.getProductCount())){
                    criteria.andEqualTo("productCount",pmsCategory.getProductCount());
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
        pmsCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsCategory
     * @param pmsCategory
     */
    @Override
    public void update(PmsCategory pmsCategory){
        pmsCategoryMapper.updateByPrimaryKey(pmsCategory);
    }

    /**
     * 增加PmsCategory
     * @param pmsCategory
     */
    @Override
    public void add(PmsCategory pmsCategory){
        pmsCategoryMapper.insert(pmsCategory);
    }

    /**
     * 根据ID查询PmsCategory
     * @param id
     * @return
     */
    @Override
    public PmsCategory findById(Long id){
        return  pmsCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsCategory全部数据
     * @return
     */
    @Override
    public List<PmsCategory> findAll() {
        return pmsCategoryMapper.selectAll();
    }
}
