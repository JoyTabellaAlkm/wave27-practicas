package ar.com.linktracker.demo.exceptions;

public class LinkNeedsAuthorizationException extends RuntimeException{
    public LinkNeedsAuthorizationException() {
        super("Link needs authorization");
    }
}
