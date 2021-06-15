package com.google.sps.data;

public final class ContactMe {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String title;
    private final String subject;
    private final long timestamp;

    public ContactMe(long id, String title, long timestamp, String firstname, String lastName, String subject) {
    this.id = id;
    this.title = title;
    this.timestamp = timestamp;
    this.firstName = firstname;
    this.lastName = lastName;
    this.subject = subject;
  }
}