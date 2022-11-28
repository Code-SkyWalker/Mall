package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsHomeSubjectMapper;
import com.skywalker.sms.pojo.SmsHomeSubject;
import com.skywalker.sms.service.SmsHomeSubjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsHomeSubjectServiceImpl
 * @Description TODO
 */
@Service
public class SmsHomeSubjectServiceImpl implements SmsHomeSubjectService {

    @Autowired
    private SmsHomeSubjectMapper smsHomeSubjectMapper;


    /**
     * SmsHomeSubject条件+分页查询
     * @param smsHomeSubject 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsHomeSubject> findPage(SmsHomeSubject smsHomeSubject, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsHomeSubject);
        //执行搜索
        return new PageInfo<SmsHomeSubject>(smsHomeSubjectMapper.selectByExample(example));
    }

    /**
     * SmsHomeSubject分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsHomeSubject> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsHomeSubject>(smsHomeSubjectMapper.selectAll());
    }

    /**
     * SmsHomeSubject条件查询
     * @param smsHomeSubject
     * @return
     */
    @Override
    public List<SmsHomeSubject> findList(SmsHomeSubject smsHomeSubject){
        //构建查询条件
        Example example = createExample(smsHomeSubject);
        //根据构建的条件查询数据
        return smsHomeSubjectMapper.selectByExample(example);
    }


    /**
     * SmsHomeSubject构建查询对象
     * @param smsHomeSubject
     * @return
     */
    public Example createExample(SmsHomeSubject smsHomeSubject){
        Example example=new Example(SmsHomeSubject.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsHomeSubject!=null){
            // id
            if(!StringUtils.isEmpty(smsHomeSubject.getId())){
                    criteria.andEqualTo("id",smsHomeSubject.getId());
            }
            // 专题名字
            if(!StringUtils.isEmpty(smsHomeSubject.getName())){
                    criteria.andLike("name","%"+smsHomeSubject.getName()+"%");
            }
            // 专题标题
            if(!StringUtils.isEmpty(smsHomeSubject.getTitle())){
                    criteria.andLike("title","%"+smsHomeSubject.getTitle()+"%");
            }
            // 专题副标题
            if(!StringUtils.isEmpty(smsHomeSubject.getSubTitle())){
                    criteria.andEqualTo("subTitle",smsHomeSubject.getSubTitle());
            }
            // 显示状态
            if(!StringUtils.isEmpty(smsHomeSubject.getStatus())){
                    criteria.andEqualTo("status",smsHomeSubject.getStatus());
            }
            // 详情连接
            if(!StringUtils.isEmpty(smsHomeSubject.getUrl())){
                    criteria.andEqualTo("url",smsHomeSubject.getUrl());
            }
            // 排序
            if(!StringUtils.isEmpty(smsHomeSubject.getSort())){
                    criteria.andEqualTo("sort",smsHomeSubject.getSort());
            }
            // 专题图片地址
            if(!StringUtils.isEmpty(smsHomeSubject.getImg())){
                    criteria.andEqualTo("img",smsHomeSubject.getImg());
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
        smsHomeSubjectMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsHomeSubject
     * @param smsHomeSubject
     */
    @Override
    public void update(SmsHomeSubject smsHomeSubject){
        smsHomeSubjectMapper.updateByPrimaryKey(smsHomeSubject);
    }

    /**
     * 增加SmsHomeSubject
     * @param smsHomeSubject
     */
    @Override
    public void add(SmsHomeSubject smsHomeSubject){
        smsHomeSubjectMapper.insert(smsHomeSubject);
    }

    /**
     * 根据ID查询SmsHomeSubject
     * @param id
     * @return
     */
    @Override
    public SmsHomeSubject findById(Long id){
        return  smsHomeSubjectMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsHomeSubject全部数据
     * @return
     */
    @Override
    public List<SmsHomeSubject> findAll() {
        return smsHomeSubjectMapper.selectAll();
    }
}
