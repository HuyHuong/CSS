package model;

public class Survey {
	private int id;
	private String name;
	private int numberOfQuestion;
	private String description;

	public Survey(String name, int numberOfQuestion, String description) {
		super();
		this.name = name;
		this.numberOfQuestion = numberOfQuestion;
		this.description = description;
	}
	
	public Survey(int id, String name, int numberOfQuestion, String description) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfQuestion = numberOfQuestion;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}
}
