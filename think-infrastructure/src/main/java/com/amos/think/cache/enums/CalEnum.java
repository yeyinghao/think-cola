/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.amos.think.cache.enums;

import com.amos.think.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 基础常数
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum CalEnum implements BaseEnum {

	/**
	 * 获取对象
	 */
	GET("获取对象"),

	/**
	 * 保存对象
	 */
	SAVE("保存对象"),

	/**
	 * 保存对象,超时
	 */
	SAVE_EXPIRE("保存对象,超时"),

	/**
	 * 尝试保存对象
	 */
	TRY_SAVE("尝试保存对象"),

	/**
	 * 尝试保存对象,超时
	 */
	TRY_SAVE_EXPIRE("尝试保存对象,超时"),

	/**
	 * 删除对象
	 */
	DELETE("删除对象"),

	/**
	 * 判断对象是否存在
	 */
	IS_EXISTS("判断对象是否存在"),

	/**
	 * 获取List
	 */
	GET_LIST("获取List"),

	/**
	 * 获取MapCache
	 */
	GET_MAP_CACHE("获取MapCache"),

	/**
	 * 获取Map
	 */
	GET_MAP("获取Map"),

	/**
	 * 获取Set
	 */
	GET_SET("获取Set"),

	/**
	 * 获取ScoredSortedSet
	 */
	GET_SCORED_SORTED_SET("获取ScoredSortedSet"),

	/**
	 * 获取锁
	 */
	GET_LOCK("获取锁"),

	/**
	 * 获取对象剩余过期时间
	 */
	REMAIN_TIME_TO_LIVE("获取对象剩余过期时间"),
	;

	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
