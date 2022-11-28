package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSpuCommentMapper;
import com.skywalker.pms.pojo.PmsSpuComment;
import com.skywalker.pms.service.PmsSpuCommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuCommentServiceImpl
 * @Description TODO
 */
@Service
public class PmsSpuCommentServiceImpl implements PmsSpuCommentService {

    @Autowired
    private PmsSpuCommentMapper pmsSpuCommentMapper;


    /**
     * PmsSpuComment条件+分页查询
     * @param pmsSpuComment 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsSpuComment> findPage(PmsSpuComment pmsSpuComment, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsSpuComment);
        //执行搜索
        return new PageInfo<PmsSpuComment>(pmsSpuCommentMapper.selectByExample(example));
    }

    /**
     * PmsSpuComment分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsSpuComment> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsSpuComment>(pmsSpuCommentMapper.selectAll());
    }

    /**
     * PmsSpuComment条件查询
     * @param pmsSpuComment
     * @return
     */
    @Override
    public List<PmsSpuComment> findList(PmsSpuComment pmsSpuComment){
        //构建查询条件
        Example example = createExample(pmsSpuComment);
        //根据构建的条件查询数据
        return pmsSpuCommentMapper.selectByExample(example);
    }


    /**
     * PmsSpuComment构建查询对象
     * @param pmsSpuComment
     * @return
     */
    public Example createExample(PmsSpuComment pmsSpuComment){
        Example example=new Example(PmsSpuComment.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsSpuComment!=null){
            // id
            if(!StringUtils.isEmpty(pmsSpuComment.getId())){
                    criteria.andEqualTo("id",pmsSpuComment.getId());
            }
            // sku_id
            if(!StringUtils.isEmpty(pmsSpuComment.getSkuId())){
                    criteria.andEqualTo("skuId",pmsSpuComment.getSkuId());
            }
            // spu_id
            if(!StringUtils.isEmpty(pmsSpuComment.getSpuId())){
                    criteria.andEqualTo("spuId",pmsSpuComment.getSpuId());
            }
            // 商品名字
            if(!StringUtils.isEmpty(pmsSpuComment.getSpuName())){
                    criteria.andEqualTo("spuName",pmsSpuComment.getSpuName());
            }
            // 会员昵称
            if(!StringUtils.isEmpty(pmsSpuComment.getMemberNickName())){
                    criteria.andEqualTo("memberNickName",pmsSpuComment.getMemberNickName());
            }
            // 星级
            if(!StringUtils.isEmpty(pmsSpuComment.getStar())){
                    criteria.andEqualTo("star",pmsSpuComment.getStar());
            }
            // 会员ip
            if(!StringUtils.isEmpty(pmsSpuComment.getMemberIp())){
                    criteria.andEqualTo("memberIp",pmsSpuComment.getMemberIp());
            }
            // 创建时间
            if(!StringUtils.isEmpty(pmsSpuComment.getCreateTime())){
                    criteria.andEqualTo("createTime",pmsSpuComment.getCreateTime());
            }
            // 显示状态[0-不显示，1-显示]
            if(!StringUtils.isEmpty(pmsSpuComment.getShowStatus())){
                    criteria.andEqualTo("showStatus",pmsSpuComment.getShowStatus());
            }
            // 购买时属性组合
            if(!StringUtils.isEmpty(pmsSpuComment.getSpuAttributes())){
                    criteria.andEqualTo("spuAttributes",pmsSpuComment.getSpuAttributes());
            }
            // 点赞数
            if(!StringUtils.isEmpty(pmsSpuComment.getLikesCount())){
                    criteria.andEqualTo("likesCount",pmsSpuComment.getLikesCount());
            }
            // 回复数
            if(!StringUtils.isEmpty(pmsSpuComment.getReplyCount())){
                    criteria.andEqualTo("replyCount",pmsSpuComment.getReplyCount());
            }
            // 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
            if(!StringUtils.isEmpty(pmsSpuComment.getResources())){
                    criteria.andEqualTo("resources",pmsSpuComment.getResources());
            }
            // 内容
            if(!StringUtils.isEmpty(pmsSpuComment.getContent())){
                    criteria.andEqualTo("content",pmsSpuComment.getContent());
            }
            // 用户头像
            if(!StringUtils.isEmpty(pmsSpuComment.getMemberIcon())){
                    criteria.andEqualTo("memberIcon",pmsSpuComment.getMemberIcon());
            }
            // 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
            if(!StringUtils.isEmpty(pmsSpuComment.getCommentType())){
                    criteria.andEqualTo("commentType",pmsSpuComment.getCommentType());
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
        pmsSpuCommentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsSpuComment
     * @param pmsSpuComment
     */
    @Override
    public void update(PmsSpuComment pmsSpuComment){
        pmsSpuCommentMapper.updateByPrimaryKey(pmsSpuComment);
    }

    /**
     * 增加PmsSpuComment
     * @param pmsSpuComment
     */
    @Override
    public void add(PmsSpuComment pmsSpuComment){
        pmsSpuCommentMapper.insert(pmsSpuComment);
    }

    /**
     * 根据ID查询PmsSpuComment
     * @param id
     * @return
     */
    @Override
    public PmsSpuComment findById(Long id){
        return  pmsSpuCommentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsSpuComment全部数据
     * @return
     */
    @Override
    public List<PmsSpuComment> findAll() {
        return pmsSpuCommentMapper.selectAll();
    }
}
