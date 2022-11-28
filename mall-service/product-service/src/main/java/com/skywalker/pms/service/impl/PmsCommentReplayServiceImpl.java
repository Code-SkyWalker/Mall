package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsCommentReplayMapper;
import com.skywalker.pms.pojo.PmsCommentReplay;
import com.skywalker.pms.service.PmsCommentReplayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsCommentReplayServiceImpl
 * @Description TODO
 */
@Service
public class PmsCommentReplayServiceImpl implements PmsCommentReplayService {

    @Autowired
    private PmsCommentReplayMapper pmsCommentReplayMapper;


    /**
     * PmsCommentReplay条件+分页查询
     * @param pmsCommentReplay 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsCommentReplay> findPage(PmsCommentReplay pmsCommentReplay, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsCommentReplay);
        //执行搜索
        return new PageInfo<PmsCommentReplay>(pmsCommentReplayMapper.selectByExample(example));
    }

    /**
     * PmsCommentReplay分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsCommentReplay> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsCommentReplay>(pmsCommentReplayMapper.selectAll());
    }

    /**
     * PmsCommentReplay条件查询
     * @param pmsCommentReplay
     * @return
     */
    @Override
    public List<PmsCommentReplay> findList(PmsCommentReplay pmsCommentReplay){
        //构建查询条件
        Example example = createExample(pmsCommentReplay);
        //根据构建的条件查询数据
        return pmsCommentReplayMapper.selectByExample(example);
    }


    /**
     * PmsCommentReplay构建查询对象
     * @param pmsCommentReplay
     * @return
     */
    public Example createExample(PmsCommentReplay pmsCommentReplay){
        Example example=new Example(PmsCommentReplay.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsCommentReplay!=null){
            // id
            if(!StringUtils.isEmpty(pmsCommentReplay.getId())){
                    criteria.andEqualTo("id",pmsCommentReplay.getId());
            }
            // 评论id
            if(!StringUtils.isEmpty(pmsCommentReplay.getCommentId())){
                    criteria.andEqualTo("commentId",pmsCommentReplay.getCommentId());
            }
            // 回复id
            if(!StringUtils.isEmpty(pmsCommentReplay.getReplyId())){
                    criteria.andEqualTo("replyId",pmsCommentReplay.getReplyId());
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
        pmsCommentReplayMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsCommentReplay
     * @param pmsCommentReplay
     */
    @Override
    public void update(PmsCommentReplay pmsCommentReplay){
        pmsCommentReplayMapper.updateByPrimaryKey(pmsCommentReplay);
    }

    /**
     * 增加PmsCommentReplay
     * @param pmsCommentReplay
     */
    @Override
    public void add(PmsCommentReplay pmsCommentReplay){
        pmsCommentReplayMapper.insert(pmsCommentReplay);
    }

    /**
     * 根据ID查询PmsCommentReplay
     * @param id
     * @return
     */
    @Override
    public PmsCommentReplay findById(Long id){
        return  pmsCommentReplayMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsCommentReplay全部数据
     * @return
     */
    @Override
    public List<PmsCommentReplay> findAll() {
        return pmsCommentReplayMapper.selectAll();
    }
}
