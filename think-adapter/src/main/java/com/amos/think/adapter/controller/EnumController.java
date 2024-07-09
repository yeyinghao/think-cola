/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.amos.think.adapter.controller;

import com.amos.think.adapter.enums.EnumServiceImpl;
import com.amos.think.common.enums.BaseEnum;
import com.amos.think.common.helper.ResultHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页控制器
 *
 * @author yeyinghao
 * @date 2023/12/15
 */
@RestController
@RequestMapping("/api/enum")
public class EnumController {

	/**
	 * 首页
	 *
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@GetMapping("/{enumName}")
	public ResultHelper<List<BaseEnum>> getEnumByName(@PathVariable("enumName") String enumName) {
		return ResultHelper.of(EnumServiceImpl.getEnumClass(enumName));
	}
}
