package com.amos.think.adapter.model.file.req;

import com.amos.think.common.enums.FileTypeEnum;
import lombok.Data;

@Data
public class UploadFileReq {

	private FileTypeEnum fileType;

}
