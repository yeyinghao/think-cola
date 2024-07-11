package com.amos.think.integration.dal.convert;

import cn.hutool.core.collection.CollectionUtil;
import com.amos.think.integration.dal.model.BaseDP;
import com.amos.think.integration.dal.model.BasePO;

import java.util.List;
import java.util.stream.Collectors;

public interface DataConvert<P extends BasePO, D extends BaseDP> {

	/**
	 * 转换成Po
	 *
	 * @param d 域对象
	 * @return {@link P}
	 */
	P convertToPO(D d);

	/**
	 * 转换来DO
	 *
	 * @param p 持久化对象
	 * @return {@link D}
	 */
	D convertToDP(P p);

	/**
	 * 转换为DOs
	 *
	 * @param ps 持久化对象
	 * @return {@link List}<{@link D}>
	 */
	default List<D> convertToDPs(List<P> ps) {
		if (CollectionUtil.isEmpty(ps)) {
			return CollectionUtil.newArrayList();
		}
		return ps.stream().map(this::convertToDP).collect(Collectors.toList());
	}

	/**
	 * 转换为POs
	 *
	 * @param ds 域对象
	 * @return {@link List}<{@link P}>
	 */
	default List<P> convertToPOs(List<D> ds) {
		if (CollectionUtil.isEmpty(ds)) {
			return CollectionUtil.newArrayList();
		}
		return ds.stream().map(this::convertToPO).collect(Collectors.toList());
	}
}
