package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsBrandMapper;
import com.skywalker.pms.pojo.PmsBrand;
import com.skywalker.pms.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsBrandServiceImpl
 * @Description TODO
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;


    /**
     * PmsBrand条件+分页查询
     * @param pmsBrand 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsBrand> findPage(PmsBrand pmsBrand, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsBrand);
        //执行搜索
        return new PageInfo<PmsBrand>(pmsBrandMapper.selectByExample(example));
    }

    /**
     * PmsBrand分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsBrand> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsBrand>(pmsBrandMapper.selectAll());
    }

    /**
     * PmsBrand条件查询
     * @param pmsBrand
     * @return
     */
    @Override
    public List<PmsBrand> findList(PmsBrand pmsBrand){
        //构建查询条件
        Example example = createExample(pmsBrand);
        //根据构建的条件查询数据
        return pmsBrandMapper.selectByExample(example);
    }


    /**
     * PmsBrand构建查询对象
     * @param pmsBrand
     * @return
     */
    public Example createExample(PmsBrand pmsBrand){
        Example example=new Example(PmsBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsBrand!=null){
            // 品牌id
            if(!StringUtils.isEmpty(pmsBrand.getBrandId())){
                    criteria.andEqualTo("brandId",pmsBrand.getBrandId());
            }
            // 品牌名
            if(!StringUtils.isEmpty(pmsBrand.getName())){
                    criteria.andLike("name","%"+pmsBrand.getName()+"%");
            }
            // 品牌logo地址
            if(!StringUtils.isEmpty(pmsBrand.getLogo())){
                    criteria.andEqualTo("logo",pmsBrand.getLogo());
            }
            // 介绍
            if(!StringUtils.isEmpty(pmsBrand.getDescript())){
                    criteria.andEqualTo("descript",pmsBrand.getDescript());
            }
            // 显示状态[0-不显示；1-显示]
            if(!StringUtils.isEmpty(pmsBrand.getShowStatus())){
                    criteria.andEqualTo("showStatus",pmsBrand.getShowStatus());
            }
            // 检索首字母
            if(!StringUtils.isEmpty(pmsBrand.getFirstLetter())){
                    criteria.andEqualTo("firstLetter",pmsBrand.getFirstLetter());
            }
            // 排序
            if(!StringUtils.isEmpty(pmsBrand.getSort())){
                    criteria.andEqualTo("sort",pmsBrand.getSort());
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
        pmsBrandMapper.deleteByPrimaryKey(id);
    }

    /***
     * 批量删除PmsBrand
     * @param ids
     */
    @Override
    public void deleteByIds(List<Long> ids) {
        Example example = new Example(PmsBrand.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("brandId", ids);

        pmsBrandMapper.deleteByExample(example);
    }

    /**
     * 修改PmsBrand
     * @param pmsBrand
     */
    @Override
    public void update(PmsBrand pmsBrand){
        pmsBrandMapper.updateByPrimaryKey(pmsBrand);
    }

    /**
     * 增加PmsBrand
     * @param pmsBrand
     */
    @Override
    public void add(PmsBrand pmsBrand){
        pmsBrandMapper.insert(pmsBrand);
    }

    /**
     * 根据ID查询PmsBrand
     * @param id
     * @return
     */
    @Override
    public PmsBrand findById(Long id){
        return  pmsBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsBrand全部数据
     * @return
     */
    @Override
    public List<PmsBrand> findAll() {
        return pmsBrandMapper.selectAll();
    }

    /**
     * 根据 categoryID 查询 品牌
     *
     * @param categoryId 商品分类ID
     * @param page
     * @param size
     * @return /
     */
    @Override
    public List<PmsBrand> findBrandByCategoryId(Long categoryId, int page, int size) {
        page = (page - 1) * size;
        return pmsBrandMapper.findBrandByCategoryId(categoryId, page, size);
    }

    /**
     * 根据 categoryID 查询 品牌 获取总数
     *
     * @param categoryId 商品分类ID
     * @return /
     */
    @Override
    public int findBrandByCategoryIdCount(Long categoryId) {
        return pmsBrandMapper.findBrandByCategoryIdCount(categoryId);
    }
}
