package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsMemberLevelMapper;
import com.skywalker.ums.pojo.UmsMemberLevel;
import com.skywalker.ums.service.UmsMemberLevelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberLevelServiceImpl
 * @Description TODO
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {

    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;


    /**
     * UmsMemberLevel条件+分页查询
     * @param umsMemberLevel 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsMemberLevel> findPage(UmsMemberLevel umsMemberLevel, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsMemberLevel);
        //执行搜索
        return new PageInfo<UmsMemberLevel>(umsMemberLevelMapper.selectByExample(example));
    }

    /**
     * UmsMemberLevel分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsMemberLevel> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsMemberLevel>(umsMemberLevelMapper.selectAll());
    }

    /**
     * UmsMemberLevel条件查询
     * @param umsMemberLevel
     * @return
     */
    @Override
    public List<UmsMemberLevel> findList(UmsMemberLevel umsMemberLevel){
        //构建查询条件
        Example example = createExample(umsMemberLevel);
        //根据构建的条件查询数据
        return umsMemberLevelMapper.selectByExample(example);
    }


    /**
     * UmsMemberLevel构建查询对象
     * @param umsMemberLevel
     * @return
     */
    public Example createExample(UmsMemberLevel umsMemberLevel){
        Example example=new Example(UmsMemberLevel.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsMemberLevel!=null){
            // id
            if(!StringUtils.isEmpty(umsMemberLevel.getId())){
                    criteria.andEqualTo("id",umsMemberLevel.getId());
            }
            // 等级名称
            if(!StringUtils.isEmpty(umsMemberLevel.getName())){
                    criteria.andLike("name","%"+umsMemberLevel.getName()+"%");
            }
            // 等级需要的成长值
            if(!StringUtils.isEmpty(umsMemberLevel.getGrowthPoint())){
                    criteria.andEqualTo("growthPoint",umsMemberLevel.getGrowthPoint());
            }
            // 是否为默认等级[0->不是；1->是]
            if(!StringUtils.isEmpty(umsMemberLevel.getDefaultStatus())){
                    criteria.andEqualTo("defaultStatus",umsMemberLevel.getDefaultStatus());
            }
            // 免运费标准
            if(!StringUtils.isEmpty(umsMemberLevel.getFreeFreightPoint())){
                    criteria.andEqualTo("freeFreightPoint",umsMemberLevel.getFreeFreightPoint());
            }
            // 每次评价获取的成长值
            if(!StringUtils.isEmpty(umsMemberLevel.getCommentGrowthPoint())){
                    criteria.andEqualTo("commentGrowthPoint",umsMemberLevel.getCommentGrowthPoint());
            }
            // 是否有免邮特权
            if(!StringUtils.isEmpty(umsMemberLevel.getPriviledgeFreeFreight())){
                    criteria.andEqualTo("priviledgeFreeFreight",umsMemberLevel.getPriviledgeFreeFreight());
            }
            // 是否有会员价格特权
            if(!StringUtils.isEmpty(umsMemberLevel.getPriviledgeMemberPrice())){
                    criteria.andEqualTo("priviledgeMemberPrice",umsMemberLevel.getPriviledgeMemberPrice());
            }
            // 是否有生日特权
            if(!StringUtils.isEmpty(umsMemberLevel.getPriviledgeBirthday())){
                    criteria.andEqualTo("priviledgeBirthday",umsMemberLevel.getPriviledgeBirthday());
            }
            // 备注
            if(!StringUtils.isEmpty(umsMemberLevel.getNote())){
                    criteria.andEqualTo("note",umsMemberLevel.getNote());
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
        umsMemberLevelMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsMemberLevel
     * @param umsMemberLevel
     */
    @Override
    public void update(UmsMemberLevel umsMemberLevel){
        umsMemberLevelMapper.updateByPrimaryKey(umsMemberLevel);
    }

    /**
     * 增加UmsMemberLevel
     * @param umsMemberLevel
     */
    @Override
    public void add(UmsMemberLevel umsMemberLevel){
        umsMemberLevelMapper.insert(umsMemberLevel);
    }

    /**
     * 根据ID查询UmsMemberLevel
     * @param id
     * @return
     */
    @Override
    public UmsMemberLevel findById(Long id){
        return  umsMemberLevelMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsMemberLevel全部数据
     * @return
     */
    @Override
    public List<UmsMemberLevel> findAll() {
        return umsMemberLevelMapper.selectAll();
    }
}
