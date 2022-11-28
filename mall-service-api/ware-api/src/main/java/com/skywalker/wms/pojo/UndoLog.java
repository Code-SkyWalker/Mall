package com.skywalker.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @Author Code SkyWalker
 * @Classname UndoLog
 * @Description TODO
 */
@Table(name="undo_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UndoLog implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id; // 

    @Column(name = "branch_id")
	private Long branchId; // 

    @Column(name = "xid")
	private String xid; // 

    @Column(name = "context")
	private String context; // 

    @Column(name = "rollback_info")
	private String rollbackInfo; // 

    @Column(name = "log_status")
	private Integer logStatus; // 

    @Column(name = "log_created")
	private LocalDate logCreated; //

    @Column(name = "log_modified")
	private LocalDate logModified; //

    @Column(name = "ext")
	private String ext; // 



}
