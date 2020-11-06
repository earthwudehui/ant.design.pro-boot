package com.sdm.auth.model.query;

import lombok.Data;

/**
 * 分页信息
 */

@Data
public class PageInfoQuery {

    /**
     * 第几页
     */
    private int current;

    /**
     * 每页几条
     */
    private int pageSize;
}
