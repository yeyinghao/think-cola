package com.amos.think.dal.gateway;

import com.amos.think.common.gateway.Gateway;
import com.amos.think.common.model.BaseDP;
import com.amos.think.common.model.PageReq;
import com.amos.think.common.model.PageRes;
import com.amos.think.dal.convert.DataConvert;
import com.amos.think.dal.model.BasePO;
import com.amos.think.dal.util.PageUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * 网关实现
 *
 * @author yeyinghao
 * @date 2024/04/19
 */
@SuppressWarnings("unused")
public abstract class GatewayImpl<PO extends BasePO, DP extends BaseDP, M extends BaseMapper<PO>> extends ServiceImpl<M, PO> implements Gateway<DP>, DataConvert<PO, DP> {

	@Override
	public void save(DP entity) {
		PO po = convertToPO(entity);
		save(po);
		entity.setId(po.getId());
	}

	@Override
	public void saveOrUpdate(DP entity) {
		PO po = convertToPO(entity);
		saveOrUpdate(po);
		entity.setId(po.getId());
	}

	@Override
	public void saveBatch(List<DP> entities) {
		saveBatch(convertToPOs(entities));
	}

	@Override
	public void deleteById(Long id) {
		removeById(id);
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		removeByIds(ids);
	}

	@Override
	public void updateById(DP entity) {
		updateById(convertToPO(entity));
	}

	@Override
	public DP findById(Long id) {
		return convertToDO(getById(id));
	}

	@Override
	public List<DP> findAll() {
		return convertToDOs(list());
	}

	@Override
	public List<DP> findByIds(List<Long> ids) {
		return convertToDOs(listByIds(ids));
	}

	@Override
	public PageRes<DP> listByPage(PageReq req) {
		Page<PO> page = page(new Page<>(req.getPageIndex(), req.getPageSize()));
		return PageUtil.buildPage(page, convertToDOs(page.getRecords()));
	}
}
