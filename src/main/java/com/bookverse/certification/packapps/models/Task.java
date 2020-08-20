package com.bookverse.certification.packapps.models;

public class Task {

  private String id;
  private String assignment;
  private String title;
  private String description;
  private String points;
  private String created_at;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setAssignment(String assignment) {
    this.assignment = assignment;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPoints(String points) {
    this.points = points;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  @Override
  public String toString() {

    String result = "\nTask{\n";
    result += "   id: "+id+",\n";
    result += "   assignment: "+assignment+",\n";
    result += "   title: "+title+",\n";
    result += "   description: "+description+",\n";
    result += "   points: "+points+",\n";
    result += "   created_at: "+created_at+"\n";
    result += "}";

    return result;
  }
}
