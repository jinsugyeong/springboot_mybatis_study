package ksmart42.mybatis.dto;

public class MemberLevel {
	private String LevelNum;
	private String LevelName;
	private String LevelRegDate;
	public String getLevelNum() {
		return LevelNum;
	}
	public void setLevelNum(String levelNum) {
		LevelNum = levelNum;
	}
	public String getLevelName() {
		return LevelName;
	}
	public void setLevelName(String levelName) {
		LevelName = levelName;
	}
	public String getLevelRegDate() {
		return LevelRegDate;
	}
	public void setLevelRegDate(String levelRegDate) {
		LevelRegDate = levelRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberLevel [LevelNum=");
		builder.append(LevelNum);
		builder.append(", LevelName=");
		builder.append(LevelName);
		builder.append(", LevelRegDate=");
		builder.append(LevelRegDate);
		builder.append("]");
		return builder.toString();
	}
}
