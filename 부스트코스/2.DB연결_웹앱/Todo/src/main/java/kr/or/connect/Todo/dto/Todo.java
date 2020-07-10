package kr.or.connect.Todo.dto;

public class Todo {
	private Integer TodoId;
	private String title;
	private String name;
	private Integer sequence;
	private String type;
	private String datetime;
	public Integer getTodoId() {
		return TodoId;
	}
	public void setTodoId(Integer todoId) {
		TodoId = todoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Todo [getTodoId()=" + getTodoId() + ", getTitle()=" + getTitle() + ", getName()=" + getName()
				+ ", getSequence()=" + getSequence() + ", getType()=" + getType() + ", getDatetime()=" + getDatetime()
				+ "]";
	}
	
	

}
