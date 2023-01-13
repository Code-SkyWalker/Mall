package com.skywalker.pms.pojo;

import com.skywalker.valid.NumberValid;
import com.skywalker.valid.ValidAdd;
import com.skywalker.valid.ValidUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname PmsBrand
 * @Description TODO
 */
@Table(name="pms_brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsBrand implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    @Null(groups = {ValidAdd.class})
    @NotNull(groups = {ValidUpdate.class})
	private Long brandId;//品牌id

    @Column(name = "name")
    @NotBlank(message = "品牌名称不能为空", groups = {ValidAdd.class, ValidUpdate.class})
	private String name;//品牌名

    @Column(name = "logo")
	private String logo;//品牌logo地址

    @Column(name = "descript")
	private String descript;//介绍

    @Column(name = "show_status")
    @NumberValid(values = {0, 1}, message = "必须提交指定的数字", groups = {ValidAdd.class, ValidUpdate.class})
	private Integer showStatus;//显示状态[0-不显示；1-显示]

    @Column(name = "first_letter")
    @Pattern(regexp = "^[a-zA-Z]$", message = "必须是字母", groups = {ValidAdd.class, ValidUpdate.class})
    private String firstLetter;//检索首字母

    @Column(name = "sort")
    @Min(value = 0, message = "排序必须大于0", groups = {ValidAdd.class, ValidUpdate.class})
	private Integer sort;//排序
}
