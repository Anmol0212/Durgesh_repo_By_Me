package com.question.Question.Service.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException()
    {
        super("Resource not found on Server");
    }
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
