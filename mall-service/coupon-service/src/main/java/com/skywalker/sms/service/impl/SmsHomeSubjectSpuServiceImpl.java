package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsHomeSubjectSpuMapper;
import com.skywalker.sms.pojo.SmsHomeSubjectSpu;
import com.skywalker.sms.service.SmsHomeSubjectSpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectSpuServiceImpl
 * @Description TODO
 */
@Service
public class SmsHomeSubjectSpuServiceImpl implements SmsHomeSubjectSpuService {

    @Autowired
    private SmsHomeSubjectSpuMapper smsHomeSubjectSpuMapper;


    /**
     * SmsHomeSubjectSpu条件+分页查询
     * @param smsHomeSubjectSpu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsHomeSubjectSpu> findPage(SmsHomeSubjectSpu smsHomeSubjectSpu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsHomeSubjectSpu);
        //执行搜索
        return new PageInfo<SmsHomeSubjectSpu>(smsHomeSubjectSpuMapper.selectByExample(example));
    }

    /**
     * SmsHomeSubjectSpu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsHomeSubjectSpu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsHomeSubjectSpu>(smsHomeSubjectSpuMapper.selectAll());
    }

    /**
     * SmsHomeSubjectSpu条件查询
     * @param smsHomeSubjectSpu
     * @return
     */
    @Override
    public List<SmsHomeSubjectSpu> findList(SmsHomeSubjectSpu smsHomeSubjectSpu){
        //构建查询条件
        Example example = createExample(smsHomeSubjectSpu);
        //根据构建的条件查询数据
        return smsHomeSubjectSpuMapper.selectByExample(example);
    }


    /**
     * SmsHomeSubjectSpu构建查询对象
     * @param smsHomeSubjectSpu
     * @return
     */
    public Example createExample(SmsHomeSubjectSpu smsHomeSubjectSpu){
        Example example=new Example(SmsHomeSubjectSpu.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsHomeSubjectSpu!=null){
            // id
            if(!StringUtils.isEmpty(smsHomeSubjectSpu.getId())){
                    criteria.andEqualTo("id",smsHomeSubjectSpu.getId());
            }
            // 专题名字
            if(!StringUtils.isEmpty(smsHomeSubjectSpu.getName())){
                    criteria.andLike("name","%"+smsHomeSubjectSpu.getName()+"%");
            }
            // 专题id
            if(!StringUtils.isEmpty(smsHomeSubjectSpu.getSubjectId())){
                    criteria.andEqualTo("subjectId",smsHomeSubjectSpu.getSubjectId());
            }
            // spu_id
            if(!StringUtils.isEmpty(smsHomeSubjectSpu.getSpuId())){
                    criteria.andEqualTo("spuId",smsHomeSubjectSpu.getSpuId());
            }
            // 排序
            if(!StringUtils.isEmpty(smsHomeSubjectSpu.getSort())){
                    criteria.andEqualTo("sort",smsHomeSubjectSpu.getSort());
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
        smsHomeSubjectSpuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsHomeSubjectSpu
     * @param smsHomeSubjectSpu
     */
    @Override
    public void update(SmsHomeSubjectSpu smsHomeSubjectSpu){
        smsHomeSubjectSpuMapper.updateByPrimaryKey(smsHomeSubjectSpu);
    }

    /**
     * 增加SmsHomeSubjectSpu
     * @param smsHomeSubjectSpu
     */
    @Override
    public void add(SmsHomeSubjectSpu smsHomeSubjectSpu){
        smsHomeSubjectSpuMapper.insert(smsHomeSubjectSpu);
    }

    /**
     * 根据ID查询SmsHomeSubjectSpu
     * @param id
     * @return
     */
    @Override
    public SmsHomeSubjectSpu findById(Long id){
        return  smsHomeSubjectSpuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsHomeSubjectSpu全部数据
     * @return
     */
    @Override
    public List<SmsHomeSubjectSpu> findAll() {
        return smsHomeSubjectSpuMapper.selectAll();
    }
}
