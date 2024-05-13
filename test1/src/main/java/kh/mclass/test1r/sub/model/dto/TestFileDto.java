package kh.mclass.test1r.sub.model.dto;

import org.springframework.stereotype.Component;

@Component("testFileDto")
public class TestFileDto {
	private String filePath;
	private String fileType;
	@Override
	public String toString() {
		return "TestFileDto [filePath=" + filePath + ", fileType=" + fileType + "]";
	}
	public TestFileDto(String filePath, String fileType) {
		super();
		this.filePath = filePath;
		this.fileType = fileType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public TestFileDto() {
		super();
	}

}
