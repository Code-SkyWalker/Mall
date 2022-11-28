package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsMemberMapper;
import com.skywalker.ums.pojo.UmsMember;
import com.skywalker.ums.service.UmsMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberServiceImpl
 * @Description TODO
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;


    /**
     * UmsMember条件+分页查询
     * @param umsMember 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsMember> findPage(UmsMember umsMember, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsMember);
        //执行搜索
        return new PageInfo<UmsMember>(umsMemberMapper.selectByExample(example));
    }

    /**
     * UmsMember分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsMember> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsMember>(umsMemberMapper.selectAll());
    }

    /**
     * UmsMember条件查询
     * @param umsMember
     * @return
     */
    @Override
    public List<UmsMember> findList(UmsMember umsMember){
        //构建查询条件
        Example example = createExample(umsMember);
        //根据构建的条件查询数据
        return umsMemberMapper.selectByExample(example);
    }


    /**
     * UmsMember构建查询对象
     * @param umsMember
     * @return
     */
    public Example createExample(UmsMember umsMember){
        Example example=new Example(UmsMember.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsMember!=null){
            // id
            if(!StringUtils.isEmpty(umsMember.getId())){
                    criteria.andEqualTo("id",umsMember.getId());
            }
            // 会员等级id
            if(!StringUtils.isEmpty(umsMember.getLevelId())){
                    criteria.andEqualTo("levelId",umsMember.getLevelId());
            }
            // 用户名
            if(!StringUtils.isEmpty(umsMember.getUsername())){
                    criteria.andLike("username","%"+umsMember.getUsername()+"%");
            }
            // 密码
            if(!StringUtils.isEmpty(umsMember.getPassword())){
                    criteria.andEqualTo("password",umsMember.getPassword());
            }
            // 昵称
            if(!StringUtils.isEmpty(umsMember.getNickname())){
                    criteria.andLike("nickname","%"+umsMember.getNickname()+"%");
            }
            // 手机号码
            if(!StringUtils.isEmpty(umsMember.getMobile())){
                    criteria.andEqualTo("mobile",umsMember.getMobile());
            }
            // 邮箱
            if(!StringUtils.isEmpty(umsMember.getEmail())){
                    criteria.andEqualTo("email",umsMember.getEmail());
            }
            // 头像
            if(!StringUtils.isEmpty(umsMember.getHeader())){
                    criteria.andEqualTo("header",umsMember.getHeader());
            }
            // 性别
            if(!StringUtils.isEmpty(umsMember.getGender())){
                    criteria.andEqualTo("gender",umsMember.getGender());
            }
            // 生日
            if(!StringUtils.isEmpty(umsMember.getBirth())){
                    criteria.andEqualTo("birth",umsMember.getBirth());
            }
            // 所在城市
            if(!StringUtils.isEmpty(umsMember.getCity())){
                    criteria.andEqualTo("city",umsMember.getCity());
            }
            // 职业
            if(!StringUtils.isEmpty(umsMember.getJob())){
                    criteria.andEqualTo("job",umsMember.getJob());
            }
            // 个性签名
            if(!StringUtils.isEmpty(umsMember.getSign())){
                    criteria.andEqualTo("sign",umsMember.getSign());
            }
            // 用户来源
            if(!StringUtils.isEmpty(umsMember.getSourceType())){
                    criteria.andEqualTo("sourceType",umsMember.getSourceType());
            }
            // 积分
            if(!StringUtils.isEmpty(umsMember.getIntegration())){
                    criteria.andEqualTo("integration",umsMember.getIntegration());
            }
            // 成长值
            if(!StringUtils.isEmpty(umsMember.getGrowth())){
                    criteria.andEqualTo("growth",umsMember.getGrowth());
            }
            // 启用状态
            if(!StringUtils.isEmpty(umsMember.getStatus())){
                    criteria.andEqualTo("status",umsMember.getStatus());
            }
            // 注册时间
            if(!StringUtils.isEmpty(umsMember.getCreateTime())){
                    criteria.andEqualTo("createTime",umsMember.getCreateTime());
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
        umsMemberMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsMember
     * @param umsMember
     */
    @Override
    public void update(UmsMember umsMember){
        umsMemberMapper.updateByPrimaryKey(umsMember);
    }

    /**
     * 增加UmsMember
     * @param umsMember
     */
    @Override
    public void add(UmsMember umsMember){
        umsMemberMapper.insert(umsMember);
    }

    /**
     * 根据ID查询UmsMember
     * @param id
     * @return
     */
    @Override
    public UmsMember findById(Long id){
        return  umsMemberMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsMember全部数据
     * @return
     */
    @Override
    public List<UmsMember> findAll() {
        return umsMemberMapper.selectAll();
    }
}
