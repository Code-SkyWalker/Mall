package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsAttrGroupMapper;
import com.skywalker.pms.pojo.PmsAttrGroup;
import com.skywalker.pms.service.PmsAttrGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsAttrGroupServiceImpl
 * @Description TODO
 */
@Service
public class PmsAttrGroupServiceImpl implements PmsAttrGroupService {

    @Autowired
    private PmsAttrGroupMapper pmsAttrGroupMapper;


    /**
     * PmsAttrGroup条件+分页查询
     * @param pmsAttrGroup 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsAttrGroup> findPage(PmsAttrGroup pmsAttrGroup, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsAttrGroup);
        //执行搜索
        return new PageInfo<PmsAttrGroup>(pmsAttrGroupMapper.selectByExample(example));
    }

    /**
     * PmsAttrGroup分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsAttrGroup> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsAttrGroup>(pmsAttrGroupMapper.selectAll());
    }

    /**
     * PmsAttrGroup条件查询
     * @param pmsAttrGroup
     * @return
     */
    @Override
    public List<PmsAttrGroup> findList(PmsAttrGroup pmsAttrGroup){
        //构建查询条件
        Example example = createExample(pmsAttrGroup);
        //根据构建的条件查询数据
        return pmsAttrGroupMapper.selectByExample(example);
    }


    /**
     * PmsAttrGroup构建查询对象
     * @param pmsAttrGroup
     * @return
     */
    public Example createExample(PmsAttrGroup pmsAttrGroup){
        Example example=new Example(PmsAttrGroup.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsAttrGroup!=null){
            // 分组id
            if(!StringUtils.isEmpty(pmsAttrGroup.getAttrGroupId())){
                    criteria.andEqualTo("attrGroupId",pmsAttrGroup.getAttrGroupId());
            }
            // 组名
            if(!StringUtils.isEmpty(pmsAttrGroup.getAttrGroupName())){
                    criteria.andEqualTo("attrGroupName",pmsAttrGroup.getAttrGroupName());
            }
            // 排序
            if(!StringUtils.isEmpty(pmsAttrGroup.getSort())){
                    criteria.andEqualTo("sort",pmsAttrGroup.getSort());
            }
            // 描述
            if(!StringUtils.isEmpty(pmsAttrGroup.getDescript())){
                    criteria.andEqualTo("descript",pmsAttrGroup.getDescript());
            }
            // 组图标
            if(!StringUtils.isEmpty(pmsAttrGroup.getIcon())){
                    criteria.andEqualTo("icon",pmsAttrGroup.getIcon());
            }
            // 所属分类id
            if(!StringUtils.isEmpty(pmsAttrGroup.getCatelogId())){
                    criteria.andEqualTo("catelogId",pmsAttrGroup.getCatelogId());
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
        pmsAttrGroupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsAttrGroup
     * @param pmsAttrGroup
     */
    @Override
    public void update(PmsAttrGroup pmsAttrGroup){
        pmsAttrGroupMapper.updateByPrimaryKey(pmsAttrGroup);
    }

    /**
     * 增加PmsAttrGroup
     * @param pmsAttrGroup
     */
    @Override
    public void add(PmsAttrGroup pmsAttrGroup){
        pmsAttrGroupMapper.insert(pmsAttrGroup);
    }

    /**
     * 根据ID查询PmsAttrGroup
     * @param id
     * @return
     */
    @Override
    public PmsAttrGroup findById(Long id){
        return  pmsAttrGroupMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsAttrGroup全部数据
     * @return
     */
    @Override
    public List<PmsAttrGroup> findAll() {
        return pmsAttrGroupMapper.selectAll();
    }
}
