package com.amos.think.adapter.model.file.req;

import com.amos.think.common.enums.FileTypeEnum;
import lombok.Data;

@Data
public class GetUploadFileUrlReq {

	private String fileName;

	private FileTypeEnum fileType;

}
