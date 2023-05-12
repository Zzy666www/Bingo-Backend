package com.bingo.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author 徐志斌
 * @since 2023-03-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bingo_user_statistics")
public class BingoUserStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 粉丝人数
     */
    @TableField("fan_count")
    private Long fanCount;

    /**
     * 关注人数
     */
    @TableField("follow_count")
    private Long followCount;

    /**
     * 点赞人数
     */
    @TableField("like_count")
    private Long likeCount;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 删除标识(未删除:0 已删除:1)
     */
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;

}
