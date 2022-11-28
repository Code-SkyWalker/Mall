package com.skywalker.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author Code SkyWalker
 * @Classname WmsWareInfo
 * @Description TODO
 */
@Table(name="wms_ware_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WmsWareInfo implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // id

    @Column(name = "name")
	private String name; // 仓库名

    @Column(name = "address")
	private String address; // 仓库地址

    @Column(name = "areacode")
	private String areacode; // 区域编码



}
