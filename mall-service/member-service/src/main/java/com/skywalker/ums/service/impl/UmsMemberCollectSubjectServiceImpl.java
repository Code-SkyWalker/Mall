package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsMemberCollectSubjectMapper;
import com.skywalker.ums.pojo.UmsMemberCollectSubject;
import com.skywalker.ums.service.UmsMemberCollectSubjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberCollectSubjectServiceImpl
 * @Description TODO
 */
@Service
public class UmsMemberCollectSubjectServiceImpl implements UmsMemberCollectSubjectService {

    @Autowired
    private UmsMemberCollectSubjectMapper umsMemberCollectSubjectMapper;


    /**
     * UmsMemberCollectSubject条件+分页查询
     * @param umsMemberCollectSubject 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsMemberCollectSubject> findPage(UmsMemberCollectSubject umsMemberCollectSubject, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsMemberCollectSubject);
        //执行搜索
        return new PageInfo<UmsMemberCollectSubject>(umsMemberCollectSubjectMapper.selectByExample(example));
    }

    /**
     * UmsMemberCollectSubject分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsMemberCollectSubject> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsMemberCollectSubject>(umsMemberCollectSubjectMapper.selectAll());
    }

    /**
     * UmsMemberCollectSubject条件查询
     * @param umsMemberCollectSubject
     * @return
     */
    @Override
    public List<UmsMemberCollectSubject> findList(UmsMemberCollectSubject umsMemberCollectSubject){
        //构建查询条件
        Example example = createExample(umsMemberCollectSubject);
        //根据构建的条件查询数据
        return umsMemberCollectSubjectMapper.selectByExample(example);
    }


    /**
     * UmsMemberCollectSubject构建查询对象
     * @param umsMemberCollectSubject
     * @return
     */
    public Example createExample(UmsMemberCollectSubject umsMemberCollectSubject){
        Example example=new Example(UmsMemberCollectSubject.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsMemberCollectSubject!=null){
            // id
            if(!StringUtils.isEmpty(umsMemberCollectSubject.getId())){
                    criteria.andEqualTo("id",umsMemberCollectSubject.getId());
            }
            // subject_id
            if(!StringUtils.isEmpty(umsMemberCollectSubject.getSubjectId())){
                    criteria.andEqualTo("subjectId",umsMemberCollectSubject.getSubjectId());
            }
            // subject_name
            if(!StringUtils.isEmpty(umsMemberCollectSubject.getSubjectName())){
                    criteria.andEqualTo("subjectName",umsMemberCollectSubject.getSubjectName());
            }
            // subject_img
            if(!StringUtils.isEmpty(umsMemberCollectSubject.getSubjectImg())){
                    criteria.andEqualTo("subjectImg",umsMemberCollectSubject.getSubjectImg());
            }
            // 活动url
            if(!StringUtils.isEmpty(umsMemberCollectSubject.getSubjectUrll())){
                    criteria.andEqualTo("subjectUrll",umsMemberCollectSubject.getSubjectUrll());
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
        umsMemberCollectSubjectMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsMemberCollectSubject
     * @param umsMemberCollectSubject
     */
    @Override
    public void update(UmsMemberCollectSubject umsMemberCollectSubject){
        umsMemberCollectSubjectMapper.updateByPrimaryKey(umsMemberCollectSubject);
    }

    /**
     * 增加UmsMemberCollectSubject
     * @param umsMemberCollectSubject
     */
    @Override
    public void add(UmsMemberCollectSubject umsMemberCollectSubject){
        umsMemberCollectSubjectMapper.insert(umsMemberCollectSubject);
    }

    /**
     * 根据ID查询UmsMemberCollectSubject
     * @param id
     * @return
     */
    @Override
    public UmsMemberCollectSubject findById(Long id){
        return  umsMemberCollectSubjectMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsMemberCollectSubject全部数据
     * @return
     */
    @Override
    public List<UmsMemberCollectSubject> findAll() {
        return umsMemberCollectSubjectMapper.selectAll();
    }
}
