package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsMemberCollectSpuMapper;
import com.skywalker.ums.pojo.UmsMemberCollectSpu;
import com.skywalker.ums.service.UmsMemberCollectSpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSpuServiceImpl
 * @Description TODO
 */
@Service
public class UmsMemberCollectSpuServiceImpl implements UmsMemberCollectSpuService {

    @Autowired
    private UmsMemberCollectSpuMapper umsMemberCollectSpuMapper;


    /**
     * UmsMemberCollectSpu条件+分页查询
     * @param umsMemberCollectSpu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsMemberCollectSpu> findPage(UmsMemberCollectSpu umsMemberCollectSpu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsMemberCollectSpu);
        //执行搜索
        return new PageInfo<UmsMemberCollectSpu>(umsMemberCollectSpuMapper.selectByExample(example));
    }

    /**
     * UmsMemberCollectSpu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsMemberCollectSpu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsMemberCollectSpu>(umsMemberCollectSpuMapper.selectAll());
    }

    /**
     * UmsMemberCollectSpu条件查询
     * @param umsMemberCollectSpu
     * @return
     */
    @Override
    public List<UmsMemberCollectSpu> findList(UmsMemberCollectSpu umsMemberCollectSpu){
        //构建查询条件
        Example example = createExample(umsMemberCollectSpu);
        //根据构建的条件查询数据
        return umsMemberCollectSpuMapper.selectByExample(example);
    }


    /**
     * UmsMemberCollectSpu构建查询对象
     * @param umsMemberCollectSpu
     * @return
     */
    public Example createExample(UmsMemberCollectSpu umsMemberCollectSpu){
        Example example=new Example(UmsMemberCollectSpu.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsMemberCollectSpu!=null){
            // id
            if(!StringUtils.isEmpty(umsMemberCollectSpu.getId())){
                    criteria.andEqualTo("id",umsMemberCollectSpu.getId());
            }
            // 会员id
            if(!StringUtils.isEmpty(umsMemberCollectSpu.getMemberId())){
                    criteria.andEqualTo("memberId",umsMemberCollectSpu.getMemberId());
            }
            // spu_id
            if(!StringUtils.isEmpty(umsMemberCollectSpu.getSpuId())){
                    criteria.andEqualTo("spuId",umsMemberCollectSpu.getSpuId());
            }
            // spu_name
            if(!StringUtils.isEmpty(umsMemberCollectSpu.getSpuName())){
                    criteria.andEqualTo("spuName",umsMemberCollectSpu.getSpuName());
            }
            // spu_img
            if(!StringUtils.isEmpty(umsMemberCollectSpu.getSpuImg())){
                    criteria.andEqualTo("spuImg",umsMemberCollectSpu.getSpuImg());
            }
            // create_time
            if(!StringUtils.isEmpty(umsMemberCollectSpu.getCreateTime())){
                    criteria.andEqualTo("createTime",umsMemberCollectSpu.getCreateTime());
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
        umsMemberCollectSpuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsMemberCollectSpu
     * @param umsMemberCollectSpu
     */
    @Override
    public void update(UmsMemberCollectSpu umsMemberCollectSpu){
        umsMemberCollectSpuMapper.updateByPrimaryKey(umsMemberCollectSpu);
    }

    /**
     * 增加UmsMemberCollectSpu
     * @param umsMemberCollectSpu
     */
    @Override
    public void add(UmsMemberCollectSpu umsMemberCollectSpu){
        umsMemberCollectSpuMapper.insert(umsMemberCollectSpu);
    }

    /**
     * 根据ID查询UmsMemberCollectSpu
     * @param id
     * @return
     */
    @Override
    public UmsMemberCollectSpu findById(Long id){
        return  umsMemberCollectSpuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsMemberCollectSpu全部数据
     * @return
     */
    @Override
    public List<UmsMemberCollectSpu> findAll() {
        return umsMemberCollectSpuMapper.selectAll();
    }
}
