package org.linktracker.exceptions;

public class LinkNeedsAuthorization extends Exception {
    public LinkNeedsAuthorization() {
        super("Authorization failed for the link.");
    }
}
