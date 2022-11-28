package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSpuInfoDescMapper;
import com.skywalker.pms.pojo.PmsSpuInfoDesc;
import com.skywalker.pms.service.PmsSpuInfoDescService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoDescServiceImpl
 * @Description TODO
 */
@Service
public class PmsSpuInfoDescServiceImpl implements PmsSpuInfoDescService {

    @Autowired
    private PmsSpuInfoDescMapper pmsSpuInfoDescMapper;


    /**
     * PmsSpuInfoDesc条件+分页查询
     * @param pmsSpuInfoDesc 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsSpuInfoDesc> findPage(PmsSpuInfoDesc pmsSpuInfoDesc, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsSpuInfoDesc);
        //执行搜索
        return new PageInfo<PmsSpuInfoDesc>(pmsSpuInfoDescMapper.selectByExample(example));
    }

    /**
     * PmsSpuInfoDesc分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsSpuInfoDesc> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsSpuInfoDesc>(pmsSpuInfoDescMapper.selectAll());
    }

    /**
     * PmsSpuInfoDesc条件查询
     * @param pmsSpuInfoDesc
     * @return
     */
    @Override
    public List<PmsSpuInfoDesc> findList(PmsSpuInfoDesc pmsSpuInfoDesc){
        //构建查询条件
        Example example = createExample(pmsSpuInfoDesc);
        //根据构建的条件查询数据
        return pmsSpuInfoDescMapper.selectByExample(example);
    }


    /**
     * PmsSpuInfoDesc构建查询对象
     * @param pmsSpuInfoDesc
     * @return
     */
    public Example createExample(PmsSpuInfoDesc pmsSpuInfoDesc){
        Example example=new Example(PmsSpuInfoDesc.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsSpuInfoDesc!=null){
            // 商品id
            if(!StringUtils.isEmpty(pmsSpuInfoDesc.getSpuId())){
                    criteria.andEqualTo("spuId",pmsSpuInfoDesc.getSpuId());
            }
            // 商品介绍
            if(!StringUtils.isEmpty(pmsSpuInfoDesc.getDecript())){
                    criteria.andEqualTo("decript",pmsSpuInfoDesc.getDecript());
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
        pmsSpuInfoDescMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsSpuInfoDesc
     * @param pmsSpuInfoDesc
     */
    @Override
    public void update(PmsSpuInfoDesc pmsSpuInfoDesc){
        pmsSpuInfoDescMapper.updateByPrimaryKey(pmsSpuInfoDesc);
    }

    /**
     * 增加PmsSpuInfoDesc
     * @param pmsSpuInfoDesc
     */
    @Override
    public void add(PmsSpuInfoDesc pmsSpuInfoDesc){
        pmsSpuInfoDescMapper.insert(pmsSpuInfoDesc);
    }

    /**
     * 根据ID查询PmsSpuInfoDesc
     * @param id
     * @return
     */
    @Override
    public PmsSpuInfoDesc findById(Long id){
        return  pmsSpuInfoDescMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsSpuInfoDesc全部数据
     * @return
     */
    @Override
    public List<PmsSpuInfoDesc> findAll() {
        return pmsSpuInfoDescMapper.selectAll();
    }
}
