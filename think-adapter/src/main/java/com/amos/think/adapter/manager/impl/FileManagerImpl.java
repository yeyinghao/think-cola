package com.amos.think.adapter.manager.impl;

import com.amos.think.adapter.manager.FileManager;
import com.amos.think.adapter.model.file.req.GetFileDownloadUrlReq;
import com.amos.think.adapter.model.file.req.GetUploadFileUrlReq;
import com.amos.think.adapter.model.file.req.UploadFileReq;
import com.amos.think.adapter.model.file.vo.GetUploadFileUrlVO;
import com.amos.think.file.FileService;
import com.amos.think.file.config.FileConfig;
import com.amos.think.file.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * 文件manager实现
 *
 * @author yeyinghao
 * @date 2023/10/22
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class FileManagerImpl implements FileManager {

	/**
	 * 文件服务
	 */
	private final FileService fileService;

	/**
	 * minio配置
	 */
	private final FileConfig fileConfig;

	@Override
	public String uploadFile(String fileName, InputStream inputStream, UploadFileReq req) {
		String fileKey = FileUtil.createObjectName(req.getFileType(), fileName);
		fileService.uploadFile(fileName, fileKey, inputStream);
		return fileKey;
	}

	@Override
	public GetUploadFileUrlVO getUploadFileUrl(GetUploadFileUrlReq req) {
		String fileKey = FileUtil.createObjectName(req.getFileType(), req.getFileName());
		String uploadFileUrl = fileService.getUploadFileUrl(fileKey);
		return GetUploadFileUrlVO.buildGetUploadFileUrlRes(fileKey, uploadFileUrl);
	}

	@Override
	public String getObjectFileUrl(GetFileDownloadUrlReq req) {
		String objectFileUrl = fileService.getObjectFileUrl(req.getFileKey(), fileConfig.expirySecond());
		// 本地直接返回就好了
		if (fileConfig.isHttp()) {
			return objectFileUrl;
		}
		return objectFileUrl.replace("http", "https");
	}
}
